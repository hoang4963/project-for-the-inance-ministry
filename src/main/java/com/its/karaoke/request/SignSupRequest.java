package com.its.karaoke.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignSupRequest {

    @JsonProperty("cp_code")
    @NotNull(message = "cp_code không được để trống")
    private String cpCode;

    @JsonProperty("name")
    @NotNull(message = "name không được để trống")
    private String name;

    @JsonProperty("description")
    private String description;
}
