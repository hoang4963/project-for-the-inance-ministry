package com.its.xoso.dto;

import lombok.Data;

@Data
public class IrrigationForestryEmissionDto {
    private String specificSource;          // Nguồn tác động cụ thể
    private String field;                   // Lĩnh vực
    private Integer reportYear;             // Năm báo cáo
    private String province;                // Tỉnh

    private String emissionMechanism;       // Cơ chế phát sinh
    private String activityDescription;     // Mô tả hoạt động

    private String location;                // Địa điểm
    private Double appliedArea;             // Diện tích áp dụng
    private String time;                    // Thời gian

    private String reportingUnit;           // Đơn vị thực hiện báo cáo
}

