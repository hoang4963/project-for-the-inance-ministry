package com.its.xoso.dto;

import lombok.Data;

@Data
public class DocumentDto {
    private String documentName;            // Tên văn bản
    private String documentNumber;          // Số hiệu
    private String documentType;            // Loại văn bản
    private Integer issuedYear;             // Năm ban hành
    private String issuingAgency;           // Cơ quan ban hành
    private String province;                // Tỉnh
    private String field;                   // Lĩnh vực
    private String issuingOrganization;     // Cơ quan ban hành (thêm)
    private String providerOrCopyright;     // Đơn vị cung cấp/ bản quyền văn bản
    private String dataScope;               // Phạm vi dữ liệu
    private String implementationInfo;      // Thông tin triển khai thực hiện
    private String climateChangeAdaptation; // Thích ứng/ giảm nhẹ với BĐKH
}
