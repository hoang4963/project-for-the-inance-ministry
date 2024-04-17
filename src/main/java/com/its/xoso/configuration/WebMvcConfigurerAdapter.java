package com.its.xoso.configuration;


import com.its.xoso.aop.XSTrackLogRequestInterceptor;
import com.its.xoso.interceptor.XSInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy
public class WebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Value("${application.allowed.methods}")
    private String[] allowMethods;

    @Value("${application.allowed.origins}")
    private String[] allowOrigins;

    @Autowired
    private XSInterceptor interceptor;

    @Bean
    public XSTrackLogRequestInterceptor buildTraceLog() {
        return new XSTrackLogRequestInterceptor();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods(allowMethods)
                .allowedOrigins(allowOrigins);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(buildTraceLog()).addPathPatterns("/api/v1/**");
        registry.addInterceptor(interceptor).addPathPatterns("/api/v1/vendor/**")
                .excludePathPatterns("/api/v1/vendor/login","/api/v1/vendor/push_sing");

    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasenames("classpath:messages/common_messages", "classpath:messages/messages");
        messageBundle.setDefaultEncoding("UTF-8");
        return messageBundle;
    }
}

