package com.its.karaoke.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CalculateFeeByDateRequest {

    @JsonProperty(value = "from_date")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}", message = "Sai định dạng! Định dạng đúng: yyyy-MM-dd HH:mm:ss")
    private String fromDate;

    @JsonProperty(value = "to_date")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}", message = "Sai định dạng! Định dạng đúng: yyyy-MM-dd HH:mm:ss")
    private String toDate;
}

