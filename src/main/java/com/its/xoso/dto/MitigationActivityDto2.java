package com.its.xoso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MitigationActivityDto2 {
    private String tinh;                     // Tỉnh
    private String linhVuc;                  // Lĩnh vực
    private Integer namBaoCao;               // Năm báo cáo
    private String hoatDongCuThe;            // Cụ thể từng hoạt động
    private String moTaNoiDung;              // Mô tả nội dung, số lượng, quy mô
    private String phuongPhapTiepCan;        // Phương pháp tiếp cận đến người dân
    private String phamViThongTin;           // Phạm vi thông tin
    private String tanSuatPhatHanh;          // Tần suất phát hành thông tin
    private String thoiLuongThongTin;        // Thời lượng thông tin
    private String diaDiem;                  // Địa điểm
    private String doiTuongDuocBiet;         // Đối tượng được biết
    private String dangThongTinDuLieu;       // Dạng thông tin, dữ liệu nhận được
    private String hieuQua;                  // Hiệu quả mang lại
    private String donViThucHien;            // Đơn vị thực hiện
    private String donViBaoCao;              // Đơn vị báo cáo
}
