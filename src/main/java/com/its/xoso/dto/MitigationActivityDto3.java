package com.its.xoso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MitigationActivityDto3 {
    private String tinh; // Tỉnh
    private String linhVuc; // Lĩnh vực
    private Integer namBaoCao; // Năm báo cáo
    private String tenMoHinh; // Tên mô hình
    private String bienPhap; // Biện pháp giảm nhẹ/ thích ứng trong mô hình
    private String quyMo; // Quy mô mô hình
    private String tanSuatThucHien; // Tần suất thực hiện
    private String thoiGian; // Thời gian
    private String diaDiem; // Địa điểm (xã huyện)
    private String hieuQua; // Hiệu quả mang lại
    private String donViThucHien; // Đơn vị thực hiện
    private String donViCungCap; // Đơn vị cung cấp
    private String nguonTrichDan; // Nguồn trích dẫn
}

