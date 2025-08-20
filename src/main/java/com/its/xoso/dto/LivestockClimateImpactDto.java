package com.its.xoso.dto;

import lombok.Data;

@Data
public class LivestockClimateImpactDto {
    private String weatherType;                     // Loại hình thời tiết
    private String field;                           // Lĩnh vực
    private String livestockObject;                 // Đối tượng vật nuôi
    private Integer reportYear;                     // Năm báo cáo
    private String province;                        // Tỉnh

    private Double impactFoodChainPercent;          // % mức độ tác động do ảnh hưởng chuỗi thức ăn tự nhiên
    private String impactFoodChainDesc;             // Mô tả tác động (chuỗi thức ăn tự nhiên)

    private Double impactDiseasePercent;            // % mức độ tác động do gia tăng dịch bệnh
    private String impactDiseaseDesc;               // Mô tả tác động (dịch bệnh)

    private Double impactYieldPercent;              // % mức độ tác động do suy giảm năng suất, sản lượng
    private String impactYieldDesc;                 // Mô tả tác động (năng suất, sản lượng)

    private Double impactEconomicLossPercent;       // % mức độ tác động do thiệt hại kinh tế
    private String impactEconomicLossDesc;          // Mô tả tác động (kinh tế)

    private String reportingUnit;                   // Đơn vị thực hiện báo cáo
}

