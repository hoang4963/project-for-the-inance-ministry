package com.its.xoso.facade;


import com.its.xoso.entity.XSVendor;
import com.its.xoso.exceptions.XSUnauthenticated;
import com.its.xoso.repository.XSVendorRepository;
import com.its.xoso.request.XSLoginRequest;
import com.its.xoso.service.JwtService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
public class XSLoginFacade {


    @Autowired
    private JwtService jwtService;

    @Value(value = "${expiration}")
    private int expiration;
    @Autowired
    private XSVendorRepository vendorRepository;

    public Map<String, Object> login(@RequestBody @Valid XSLoginRequest loginRequest) {
        XSVendor vendor = vendorRepository.findVendorByUsername(loginRequest.getUsername());
        if (vendor == null) {
            throw new XSUnauthenticated("Không tìm thấy thông tin tài khoản");
        }
        if (vendor.getRevoked() == 1) {
            throw new XSUnauthenticated("Tài khoản này đã bị khóa. Hãy liên hệ administrator để biết thêm thông tin");
        }
        String token = jwtService.generateToken(vendor);
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("expires_in", expiration);

        return result;
    }
}
