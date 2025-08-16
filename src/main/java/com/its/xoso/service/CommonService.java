package com.its.xoso.service;


import com.its.xoso.entity.BaoVeTangOdon;
import com.its.xoso.entity.BieuHienBDKH;
import com.its.xoso.entity.DanhGiaDeXuat;
import com.its.xoso.entity.DanhMuc;
import com.its.xoso.entity.DonVi;
import com.its.xoso.entity.GiamNheThichUng;
import com.its.xoso.entity.HopTacQuocTe;
import com.its.xoso.entity.LinhVuc;
import com.its.xoso.entity.LoaiHinh;
import com.its.xoso.entity.NghienCuuKHCN;
import com.its.xoso.entity.NguonLucBDKH;
import com.its.xoso.entity.NguonTacDongKNK;
import com.its.xoso.entity.PhatThaiKNK;
import com.its.xoso.entity.TacDongBDKH;
import com.its.xoso.entity.TieuChi;
import com.its.xoso.entity.Tinh;
import com.its.xoso.entity.VanBanPhapLuat;
import com.its.xoso.repository.BaoVeTangOdonRepository;
import com.its.xoso.repository.BieuHienBDKHRepository;
import com.its.xoso.repository.DanhGiaDeXuatRepository;
import com.its.xoso.repository.DanhMucRepository;
import com.its.xoso.repository.DonViRepository;
import com.its.xoso.repository.GiamNheThichUngRepository;
import com.its.xoso.repository.HopTacQuocTeRepository;
import com.its.xoso.repository.LinhVucRepository;
import com.its.xoso.repository.LoaiHinhRepository;
import com.its.xoso.repository.NghienCuuKHCNRepository;
import com.its.xoso.repository.NguonLucBDKHRepository;
import com.its.xoso.repository.NguonTacDongKNKRepository;
import com.its.xoso.repository.PhatThaiKNKRepository;
import com.its.xoso.repository.TacDongBDKHRepository;
import com.its.xoso.repository.TieuChiRepository;
import com.its.xoso.repository.TinhRepository;
import com.its.xoso.repository.VanBanPhapLuatRepository;
import com.its.xoso.type.TableName;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommonService {


    private final VanBanPhapLuatRepository vanBanPhapLuatRepository;

    private final NguonTacDongKNKRepository nguonTacDongKNKRepository;

    private final TacDongBDKHRepository tacDongBDKHRepository;

    private final PhatThaiKNKRepository phatThaiKNKRepository;

    private final GiamNheThichUngRepository giamNheThichUngRepository;

    private final BaoVeTangOdonRepository baoVeTangOdonRepository;

    private final NghienCuuKHCNRepository nghienCuuKHCNRepository;

    private final NguonLucBDKHRepository nguonLucBDKHRepository;

    private final HopTacQuocTeRepository hopTacQuocTeRepository;

    private final DanhGiaDeXuatRepository danhGiaDeXuatRepository;

    private final BieuHienBDKHRepository bieuHienBDKHRepository;

    private final LoaiHinhRepository loaiHinhRepository;

    private final DanhMucRepository danhMucRepository;

    private final TieuChiRepository tieuChiRepository;

    private final TinhRepository tinhRepository;

    private final LinhVucRepository linhVucRepository;

    private final DonViRepository donViRepository;

    public List<?> commonSearch(String name, Integer type, String linhVuc, String loaiHinh, String danhMuc,
                                String tieuChi, String tinh, Integer nam, String donVi, String nguonTacDong) {
        TableName table = TableName.fromCode(type);
        log.info("commonSearch start with params: name={}, type={}, linhVuc={}, loaiHinh={}, danhMuc={}, tieuChi={}, tinh={}, nam={}, donVi={}, nguonTacDong={}",
                name, type, linhVuc, loaiHinh, danhMuc, tieuChi, tinh, nam, donVi, nguonTacDong);

        return switch (table) {
            case VanBanPhapLuat -> {
                log.info("Searching in table: VanBanPhapLuat");
                yield vanBanPhapLuatSearch(name, nam, tinh, linhVuc, donVi);
            }
            case TacDongBDKH -> {
                log.info("Searching in table: TacDongBDKH");
                yield tacDongBDKHSearch(nam, tinh, linhVuc, donVi, loaiHinh);
            }
            case PhatThaiKNK -> {
                log.info("Searching in table: PhatThaiKNK");
                yield phatThaiKNKSearch(nam, tinh, linhVuc, donVi, nguonTacDong);
            }
            case GiamNheThichUng -> {
                log.info("Searching in table: GiamNheThichUng");
                yield giamNheThichUngSearch(nam, tinh, linhVuc, donVi, loaiHinh, danhMuc);
            }
            case BaoVeTangOdon -> {
                log.info("Searching in table: BaoVeTangOdon");
                yield baoVeTangOdonSearch(nam, tinh, linhVuc, donVi);
            }
            case NghienCuuKHCN -> {
                log.info("Searching in table: NghienCuuKHCN");
                yield nghienCuuKHCNSearch(nam, tinh, linhVuc, donVi);
            }
            case NguonLucBDKH -> {
                log.info("Searching in table: NguonLucBDKH");
                yield nguonLucBDKHSearch(nam, tinh, linhVuc, donVi, tieuChi);
            }
            case HopTacQuocTe -> {
                log.info("Searching in table: HopTacQuocTe");
                yield hopTacQuocTe(nam, tinh, linhVuc, donVi, tieuChi);
            }
            case DanhGiaDeXuat -> {
                log.info("Searching in table: DanhGiaDeXuat");
                yield danhGiaDeXuatSearch(nam, tinh, linhVuc);
            }
            case BieuHienBDKH -> {
                log.info("Searching in table: BieuHienBDKH");
                yield bieuHienBDKHSearch(nam, tinh, linhVuc, donVi, loaiHinh);
            }
            default -> {
                log.error("Không tìm thấy TableName phù hợp với type={}", type);
                throw new IllegalArgumentException("Không tìm thấy TableName phù hợp: " + type);
            }
        };
    }


    private List<VanBanPhapLuat> vanBanPhapLuatSearch(String name, Integer year, String tinh, String linhVuc, String coQuanBanHanh) {
        return vanBanPhapLuatRepository.findAllByConditions(name, year, getTinh(tinh), getLinhVuc(linhVuc), coQuanBanHanh);
    }

    private List<NguonTacDongKNK> nguonTacDongKNKSearch(String linhVuc) {
        return nguonTacDongKNKRepository.findAllByLinhVuc(getLinhVuc(linhVuc));
    }

    private List<TacDongBDKH> tacDongBDKHSearch(Integer year, String tinh, String linhVuc, String donVi, String loaiHinh) {
        return tacDongBDKHRepository.findAllByConditions(getLinhVuc(linhVuc), getLoaiHinh(loaiHinh), getTinh(tinh) , getDonVi(donVi), year);
    }

    private List<PhatThaiKNK> phatThaiKNKSearch(Integer year, String tinh, String linhVuc, String donVi, String nguonTacDong) {
        return phatThaiKNKRepository.findAllByConditions(getLinhVuc(linhVuc), getTinh(tinh), year, getNguonTacDongKNK(linhVuc, nguonTacDong), getDonVi(donVi));
    }

    private List<GiamNheThichUng> giamNheThichUngSearch(Integer year, String tinh, String linhVuc, String donVi, String loaiHinh, String danhMuc) {
        return giamNheThichUngRepository.findByConditions(getLinhVuc(linhVuc), getTinh(tinh), year, getLoaiHinh(loaiHinh), getDonVi(donVi), getDanhMuc(danhMuc));
    }

    private List<BaoVeTangOdon> baoVeTangOdonSearch(Integer year, String tinh, String linhVuc, String donVi) {
        return baoVeTangOdonRepository.findByTinhAndLinhVucAndDonVi(getTinh(tinh), getLinhVuc(linhVuc), year, getDonVi(donVi));
    }

    private List<NghienCuuKHCN> nghienCuuKHCNSearch(Integer year, String tinh, String linhVuc, String donVi) {
        return nghienCuuKHCNRepository.search(getTinh(tinh), getLinhVuc(linhVuc), year, getDonVi(donVi));
    }

    private List<HopTacQuocTe> hopTacQuocTe(Integer year, String tinh, String linhVuc, String donVi, String tieuChi) {
        return hopTacQuocTeRepository.searchHopTacQuocTe(getTinh(tinh), getLinhVuc(linhVuc), getDonVi(donVi), year, getTieuChi(tieuChi));
    }

    private List<NguonLucBDKH> nguonLucBDKHSearch(Integer year, String tinh, String linhVuc, String donVi, String tieuChi) {
        return nguonLucBDKHRepository.searchNguonLuc(getTinh(tinh), getLinhVuc(linhVuc), year, getDonVi(donVi), getTieuChi(tieuChi));
    }

    private List<DanhGiaDeXuat> danhGiaDeXuatSearch(Integer year, String tinh, String linhVuc) {
        return danhGiaDeXuatRepository.searchDanhGiaDeXuat(getTinh(tinh), getLinhVuc(linhVuc), year);
    }

    private List<BieuHienBDKH> bieuHienBDKHSearch(Integer year, String tinh, String linhVuc, String donVi, String loaiHinh) {
        return bieuHienBDKHRepository.searchBieuHienBDKH(getTinh(tinh), getLinhVuc(linhVuc), year, getDonVi(donVi), getLoaiHinh(loaiHinh));
    }

    private Integer getTinh(String name) {
        return Optional.ofNullable(tinhRepository.findByTenTinh(name))
                .map(Tinh::getId)
                .orElse(0);
    }

    private Integer getLinhVuc(String name) {
        return Optional.ofNullable(linhVucRepository.findByTen(name))
                .map(LinhVuc::getId)
                .orElse(0);
    }

    private Integer getTieuChi(String name) {
        return Optional.ofNullable(tieuChiRepository.findByDanhMuc(name))
                .map(TieuChi::getId)
                .orElse(0);
    }

    private Integer getDanhMuc(String name) {
        return Optional.ofNullable(danhMucRepository.findByTen(name))
                .map(DanhMuc::getId)
                .orElse(0);
    }

    private Integer getLoaiHinh(String name) {
        return Optional.ofNullable(loaiHinhRepository.findByTen(name))
                .map(LoaiHinh::getId)
                .orElse(0);
    }

    private Integer getDonVi(String name) {
        return Optional.ofNullable(donViRepository.findByTen(name))
                .map(DonVi::getId)
                .orElse(0);
    }

    private Integer getNguonTacDongKNK(String linhVuc, String nguonTacDong) {
        return Optional.ofNullable(nguonTacDongKNKRepository.findByNguonTacDong(getLinhVuc(linhVuc), nguonTacDong))
                .map(NguonTacDongKNK::getId)
                .orElse(0);
    }
}
