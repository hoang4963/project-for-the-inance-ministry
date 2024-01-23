package com.its.karaoke.request;

import com.its.karaoke.aop.KaraSpecialLog;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Setter
@Getter
@KaraSpecialLog
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KaraLoginRequest {
    @NotEmpty(message = "Thông tin đăng nhập không được để trống")
    private String username;
    @NotEmpty(message = "Thông tin mật không không được để trống")
    private String password;
}
