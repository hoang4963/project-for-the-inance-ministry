package com.its.xoso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OzoneImpactActivityDto {
    private String tinh;                       // Tỉnh
    private String linhVuc;                    // Lĩnh vực
    private Integer namBaoCao;                 // Năm báo cáo
    private String chatSuyGiamTangOzon;        // Chất suy giảm tầng ô-dôn
    private String hoatDongPhatSinh;           // Hoạt động phát sinh
    private String tanSuatXuatHien;            // Tần suất xuất hiện
    private String quyMoSoLuong;               // Quy mô/ số lượng
    private String thoiGianGhiNhan;            // Được ghi nhận trong thời gian nào
    private String diaDiem;                    // Địa điểm (xã huyện)
    private String khaNangAnhHuong;            // Khả năng ảnh hưởng
    private String donViQuanLyThucHien;        // Đơn vị quản lý và thực hiện
    private String nguonTrichDan;              // Nguồn trích dẫn
}

