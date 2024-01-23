package com.its.karaoke.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KaraPushSingRequest {
    @NotNull(message = "request_id không được để trống")
    @JsonProperty(value = "request_id")
    private String requestId;

    @NotNull(message = "cp_code không được để trống")
    @JsonProperty(value = "cp_code")
    private String cpCode;

    @NotNull(message = "header_code không được để trống")
    @JsonProperty(value = "header_code")
    private String headerCode;

    @NotNull(message = "Thiếu thông tin mã bài hát")
    @JsonProperty(value = "code_song")
    private String codeSong;


    @NotNull(message = "Thiếu thông tin tác giả")
    @JsonProperty(value = "author")
    private String author;

    @NotNull(message = "Thiếu thông tin ca sĩ")
    @JsonProperty(value = "singer")
    private String singer;

    @NotNull(message = "event bắt buộc nhập")
    @JsonProperty(value = "event")
    private Integer event;


    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}", message = "Sai định dạng! Định dạng đúng: yyyy-MM-dd HH:mm:ss")
    @JsonProperty(value = "time")
    private String time;

}
