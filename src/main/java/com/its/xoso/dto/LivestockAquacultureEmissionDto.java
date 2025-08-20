package com.its.xoso.dto;

import lombok.Data;

@Data
public class LivestockAquacultureEmissionDto {
    private String specificSource;              // Nguồn tác động cụ thể
    private String field;                       // Lĩnh vực
    private Integer reportYear;                 // Năm báo cáo
    private String province;                    // Tỉnh

    private String emissionMechanism;           // Cơ chế phát sinh
    private String variationDescription;        // Mô tả sự biến động

    private Double ch4ChangePercent;            // % thay đổi phát thải CH4
    private String ch4IncreaseDesc;             // Mô tả sự gia tăng lượng phát thải CH4

    private Double n2oChangePercent;            // % thay đổi phát thải N2O
    private String n2oIncreaseDesc;             // Mô tả sự gia tăng lượng phát thải N2O

    private Double co2ChangePercent;            // % thay đổi phát thải CO2
    private String co2IncreaseDesc;             // Mô tả sự gia tăng lượng phát thải CO2

    private String location;                    // Địa điểm
    private String time;                        // Thời gian
    private String reportingUnit;               // Đơn vị thực hiện báo cáo
}

