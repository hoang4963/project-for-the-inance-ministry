package com.its.karaoke.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class IPHelper {
    public static final String getIp(final HttpServletRequest request) {
        try {
            //
            String ip = request.getHeader("X-Forwarded-For");
            if (StringUtil.isEmptyOrBlank(ip) || "unknown".equalsIgnoreCase(ip.trim())) {
                ip = request.getHeader("X-Real-IP");
            } else {
                ip = ip.split(",")[0].trim();
            }

            //
            if (StringUtil.isEmptyOrBlank(ip) || "unknown".equalsIgnoreCase(ip.trim())) {
                ip = request.getHeader("Proxy-Client-IP");
            }

            //
            if (StringUtil.isEmptyOrBlank(ip) || "unknown".equalsIgnoreCase(ip.trim())) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }

            //
            if (StringUtil.isEmptyOrBlank(ip) || "unknown".equalsIgnoreCase(ip.trim())) {
                ip = request.getRemoteAddr();
            }

            //
            if (StringUtil.isEmptyOrBlank(ip) || "unknown".equalsIgnoreCase(ip.trim())) {
                final String id = request.getSession().getId();
                log.info("id = {}", id);
            }
            return ip;
        } catch (Exception e) {
            final String id = request.getSession().getId();
            log.info("id = {}", id);
            return "";
        }
    }
}

