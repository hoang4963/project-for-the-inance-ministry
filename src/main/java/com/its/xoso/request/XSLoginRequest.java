package com.its.xoso.request;

import com.its.xoso.aop.XSSpecialLog;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@XSSpecialLog
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class XSLoginRequest {
    @NotEmpty(message = "Thông tin đăng nhập không được để trống")
    private String username;
    @NotEmpty(message = "Thông tin mật không không được để trống")
    private String password;
}

