package com.its.xoso.dto;

import lombok.Data;

@Data
public class MitigationActivityDto1 {
    private String categoryName;                 // Tên Danh mục
    private String province;                     // Tỉnh
    private String field;                        // Lĩnh vực
    private Integer reportYear;                  // Năm báo cáo

    private String detailName;                   // Chi tiết tên
    private String systemScale;                  // Quy mô hệ thống/ bản tin/ phạm vi bản đồ
    private String monitoringFrequency;          // Tần suất theo dõi/ đánh giá/ cảnh báo
    private String implementationDuration;       // Thời lượng thực hiện
    private String monitoringLocation;           // Địa điểm theo dõi

    private String status;                       // Tình trạng: Xây mới/ Đang vận hành/ Đang nâng cấp
    private String startTime;                    // Thời điểm địa phương bắt đầu thực hiện theo dõi
    private String dataFormat;                   // Định dạng dữ liệu
    private String effectiveness;                // Hiệu quả

    private String implementingUnit;             // Đơn vị thực hiện
    private String reportingUnit;                // Đơn vị cung cấp báo cáo
}

