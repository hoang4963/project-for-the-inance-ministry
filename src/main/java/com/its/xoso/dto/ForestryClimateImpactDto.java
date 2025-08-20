package com.its.xoso.dto;

import lombok.Data;

@Data
public class ForestryClimateImpactDto {
    private String weatherType;                         // Loại hình thời tiết
    private String field;                               // Lĩnh vực
    private Integer reportYear;                         // Năm báo cáo
    private String province;                            // Tỉnh

    private Double impactGrowthProcessPercent;          // % mức độ tác động do ảnh hưởng đến sự phát triển, quá trình sinh trưởng của cây
    private String impactGrowthProcessDesc;             // Mô tả tác động (sinh trưởng của cây)

    private Double impactPestSpreadPercent;             // % mức độ tác động do tăng lây lan sâu bệnh hại rừng
    private String impactPestSpreadDesc;                // Mô tả tác động (sâu bệnh hại rừng)

    private Double impactForestFirePercent;             // % mức độ tác động do tăng nguy cơ cháy rừng, thiệt hại tài nguyên rừng
    private String impactForestFireDesc;                // Mô tả tác động (cháy rừng, tài nguyên rừng)

    private String reportingUnit;                       // Đơn vị thực hiện báo cáo
}

