package com.its.karaoke.service;

import com.google.gson.Gson;
import com.its.karaoke.entity.KaraVendor;

import com.its.karaoke.exceptions.KaraUnauthenticated;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service
public class JwtService {

    public static final String ISS = "iss";
    public static final String ID = "id";
    public static final String EXP = "exp";


    @Value(value = "${secret}")
    private String secretKey;

    @Value(value = "${expiration}")
    private int expiration;

    private final Gson gson = new Gson();

    public String generateToken(KaraVendor ecVendor) {
        long expiredTime = System.currentTimeMillis() + expiration * 1000L;
        Map<String, Object> claims = new HashMap<>();
        claims.put(EXP, expiredTime);
        claims.put("COMPANY_ID", ecVendor.getCompanyId());
        claims.put("USER_ID", ecVendor.getId());

        String token = Jwts.builder().setClaims(claims)
                .setAudience("Kara").setExpiration(new Date(expiredTime))
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes()).compact();

        return token;
    }

    public Map<String, Object> validateJwt(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody();
            String sExp = String.valueOf(claims.get(EXP));
            long exp = Long.valueOf(sExp);
            if (System.currentTimeMillis() <= exp * 1000) {
                Map<String, Object> results = new HashMap<>();
                results.put("COMPANY_ID", (int) claims.get("COMPANY_ID"));
                results.put("USER_ID", (int) claims.get("USER_ID"));
                return results;
            } else {
                log.info("Token expired from {}: {}.\n Current time: {}", exp, token, System.currentTimeMillis());
                throw new KaraUnauthenticated("Phiên đăng nhập hết hạn. Hãy vui lòng đăng nhập lại");
            }
        } catch (ExpiredJwtException eex) {
            log.info("Token expired: {}, {}", token, eex.getMessage());
            throw new KaraUnauthenticated("Bạn không có quyền truy cập hệ thống");

        } catch (Exception e) {
            log.warn("Parse token {}", token, e);
            throw new KaraUnauthenticated("Bạn không có quyền truy cập hệ thống");
        }
    }
}
