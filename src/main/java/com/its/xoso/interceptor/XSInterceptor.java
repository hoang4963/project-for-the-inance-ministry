package com.its.xoso.interceptor;

import com.its.xoso.exceptions.XSUnauthenticated;
import com.its.xoso.security.SecurityContexts;
import com.its.xoso.service.JwtService;
import com.its.xoso.utils.IPHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Log4j2
@Component
public class XSInterceptor implements HandlerInterceptor {

    private JwtService jwtService;

    @Autowired
    public XSInterceptor(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = IPHelper.getIp(request);
        log.info("IP = {} begin for request = {} url = {}", ip, request.getSession().getId(), request.getRequestURL());

        String vendorCode = request.getHeader("Authorization");
        if (Strings.isEmpty(vendorCode)) {
            throw new XSUnauthenticated("Bạn cần đăng nhập trước khi sử dụng API này");
        }
        String[] header = vendorCode.split(" ");
        if (header.length != 2) {
            throw new XSUnauthenticated("Bạn cần đăng nhập trước khi sử dụng API này");
        }
        String token = header[1];
        Map<String, Object> res = jwtService.validateJwt(token);
        int companyId = (int) res.get("COMPANY_ID");
        int userId = (int) res.get("USER_ID");
        request.setAttribute("companyId", companyId);
        SecurityContexts.Context context = new SecurityContexts.Context();
        context.setCompanyId(companyId);
        context.setUserId(userId);
        SecurityContexts.set(context);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        log.info("end for request = {} url = {}", request.getSession().getId(), request.getRequestURL());
        try {
            String url = request.getRequestURL().toString();
        } catch (Exception e) {
            log.error("[postHandle] saveLog", e);
        }
    }
}

