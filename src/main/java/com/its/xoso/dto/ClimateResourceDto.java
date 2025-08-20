package com.its.xoso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClimateResourceDto {

    private String tinh;                  // Tỉnh
    private String linhVuc;               // Lĩnh vực
    private Integer namBaoCao;            // Năm báo cáo
    private Double kinhPhi;               // Kinh phí (triệu đồng)
    private Integer soLuongChuyenTrach;   // Số lượng chuyên trách
    private Integer soLuongKiemNhiem;     // Số lượng kiêm nhiệm
    private String noiDung;               // Nội dung
    private String quyMo;                 // Quy mô
    private String thoiGian;              // Thời gian
    private String diaDiem;               // Địa điểm
    private String hieuQua;               // Hiệu quả
    private String donViThucHien;         // Đơn vị thực hiện
    private String donViBaoCao;           // Đơn vị báo cáo
    private String khoKhanCanThaoGo;      // Khó khăn cần tháo gỡ
}

