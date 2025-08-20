package com.its.xoso.dto;

import lombok.Data;

@Data
public class ResearchTechnologyDto {

    private String tinh; // Tỉnh
    private String linhVuc; // Lĩnh vực
    private Integer namBaoCao; // Năm báo cáo

    private String danhMucCongNghe; // Danh mục công nghệ/ giải pháp
    private String moTaCongNghe; // Mô tả công nghệ
    private Integer soLuongDaTrienKhai; // Số lượng đã triển khai
    private String quyMoApDung; // Quy mô áp dụng
    private String hieuQua; // Hiệu quả
    private String thoiGianApDung; // Thời gian áp dụng
    private String diaDiemApDung; // Địa điểm áp dụng

    private Boolean thuocChuongTrinhKhcn; // Thuộc chương trình, nhiệm vụ KHCN?
    private String sangCheGiaiPhap; // Là sáng chế, giải pháp hữu ích (nộp đơn, cấp bằng, ứng dụng)?

    private String donViThucHien; // Đơn vị thực hiện
    private String donViBaoCao; // Đơn vị báo cáo
    private Boolean daNhanRong; // Đã thực hiện nhân rộng?
}

