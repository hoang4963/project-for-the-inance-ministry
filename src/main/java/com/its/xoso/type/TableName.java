package com.its.xoso.type;

public enum TableName {
    VanBanPhapLuat(1, "VanBanPhapLuat"),
    NguonTacDongKNK(2, "NguonTacDongKNK"),
    TacDongBDKH(3, "TacDongBDKH"),
    PhatThaiKNK(4, "PhatThaiKNK"),
    GiamNheThichUng(5, "GiamNheThichUng"),
    BaoVeTangOdon(6, "BaoVeTangOdon"),
    NghienCuuKHCN(7, "NghienCuuKHCN"),
    NguonLucBDKH(8, "NguonLucBDKH"),
    HopTacQuocTe(9, "HopTacQuocTe"),
    DanhGiaDeXuat(10, "DanhGiaDeXuat"),
    BieuHienBDKH(11, "BieuHienBDKH");

    private final int code;
    private final String name;

    TableName(int code, String moTa) {
        this.code = code;
        this.name = moTa;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static TableName fromCode(int code) {
        for (TableName tt : TableName.values()) {
            if (tt.getCode() == code) {
                return tt;
            }
        }
        throw new IllegalArgumentException("code không hợp lệ: " + code);
    }
}

