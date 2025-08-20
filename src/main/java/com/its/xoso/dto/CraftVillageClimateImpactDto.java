package com.its.xoso.dto;

import lombok.Data;

@Data
public class CraftVillageClimateImpactDto {
    private String weatherType;                      // Loại hình thời tiết
    private String field;                            // Lĩnh vực
    private Integer reportYear;                      // Năm báo cáo
    private String province;                         // Tỉnh

    private Double impactProductionTimePercent;      // % mức độ tác động do ảnh hưởng đến thời gian sản xuất
    private String impactProductionTimeDesc;         // Mô tả tác động (thời gian sản xuất)

    private Double impactScalePercent;               // % mức độ tác động do suy giảm quy mô hoạt động
    private String impactScaleDesc;                  // Mô tả tác động (quy mô hoạt động)

    private Double impactEconomicLossPercent;        // % mức độ tác động do thiệt hại kinh tế
    private String impactEconomicLossDesc;           // Mô tả tác động (kinh tế)

    private String reportingUnit;                    // Đơn vị thực hiện báo cáo
}

