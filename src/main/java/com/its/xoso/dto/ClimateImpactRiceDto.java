package com.its.xoso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClimateImpactRiceDto {
    private String loaiHinhThoiTiet;          // Loại hình thời tiết
    private String linhVuc;                   // Lĩnh vực
    private Integer namBaoCao;                // Năm báo cáo
    private String tinh;                      // Tỉnh

    private Double mucDoAnhHuongLichThuV;    // % mức độ tác động do ảnh hưởng đến lịch thời vụ
    private String moTaAnhHuongLichThuV;     // Mô tả tác động

    private Double mucDoSuyGiamNangSuat;     // % mức độ tác động do suy giảm năng suất, sản lượng
    private String moTaSuyGiamNangSuat;      // Mô tả tác động

    private Double mucDoThietHaiKinhTe;      // % mức độ tác động do thiệt hại kinh tế
    private String moTaThietHaiKinhTe;       // Mô tả tác động

    private String donViThucHienBaoCao;      // Đơn vị thực hiện báo cáo
}

