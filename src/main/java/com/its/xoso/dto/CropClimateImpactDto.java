package com.its.xoso.dto;

import lombok.Data;

@Data
public class CropClimateImpactDto {
    private String weatherType;                  // Loại hình thời tiết
    private String field;                        // Lĩnh vực
    private String cropGroup;                    // Nhóm cây trồng
    private Integer reportYear;                  // Năm báo cáo
    private String province;                     // Tỉnh

    private Double impactGrowthCyclePercent;     // % mức độ tác động do ảnh hưởng chu kỳ sinh trưởng
    private String impactGrowthCycleDesc;        // Mô tả tác động (chu kỳ sinh trưởng)

    private Double impactPestPercent;            // % mức độ tác động do dịch hại
    private String impactPestDesc;               // Mô tả tác động (dịch hại)

    private Double impactYieldPercent;           // % mức độ tác động do suy giảm năng suất, sản lượng
    private String impactYieldDesc;              // Mô tả tác động (năng suất, sản lượng)

    private Double impactEconomicLossPercent;    // % mức độ tác động do thiệt hại kinh tế
    private String impactEconomicLossDesc;       // Mô tả tác động (kinh tế)

    private String reportingUnit;                // Đơn vị thực hiện báo cáo
}

