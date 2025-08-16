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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public Page<?> commonSearch(String name, Integer type, String linhVuc, String loaiHinh, String danhMuc,
                                String tieuChi, String tinh, Integer nam, String donVi, String nguonTacDong,
                                int page, int size) {
        TableName table = TableName.fromCode(type);
        log.info("commonSearch start with params: name={}, type={}, linhVuc={}, loaiHinh={}, danhMuc={}, tieuChi={}, tinh={}, nam={}, donVi={}, nguonTacDong={}, page={}, size={}",
                name, type, linhVuc, loaiHinh, danhMuc, tieuChi, tinh, nam, donVi, nguonTacDong, page, size);

        return switch (table) {
            case VanBanPhapLuat -> {
                log.info("Searching in table: VanBanPhapLuat");
                yield vanBanPhapLuatSearch(name, nam, tinh, linhVuc, donVi, page, size);
            }
            case TacDongBDKH -> {
                log.info("Searching in table: TacDongBDKH");
                yield tacDongBDKHSearch(nam, tinh, linhVuc, donVi, loaiHinh, page, size);
            }
            case PhatThaiKNK -> {
                log.info("Searching in table: PhatThaiKNK");
                yield phatThaiKNKSearch(nam, tinh, linhVuc, donVi, nguonTacDong, page, size);
            }
            case GiamNheThichUng -> {
                log.info("Searching in table: GiamNheThichUng");
                yield giamNheThichUngSearch(nam, tinh, linhVuc, donVi, loaiHinh, danhMuc, page, size);
            }
            case BaoVeTangOdon -> {
                log.info("Searching in table: BaoVeTangOdon");
                yield baoVeTangOdonSearch(nam, tinh, linhVuc, donVi, page, size);
            }
            case NghienCuuKHCN -> {
                log.info("Searching in table: NghienCuuKHCN");
                yield nghienCuuKHCNSearch(nam, tinh, linhVuc, donVi, page, size);
            }
            case NguonLucBDKH -> {
                log.info("Searching in table: NguonLucBDKH");
                yield nguonLucBDKHSearch(nam, tinh, linhVuc, donVi, tieuChi, page, size);
            }
            case HopTacQuocTe -> {
                log.info("Searching in table: HopTacQuocTe");
                yield hopTacQuocTe(nam, tinh, linhVuc, donVi, tieuChi, page, size);
            }
            case DanhGiaDeXuat -> {
                log.info("Searching in table: DanhGiaDeXuat");
                yield danhGiaDeXuatSearch(nam, tinh, linhVuc, page, size);
            }
            case BieuHienBDKH -> {
                log.info("Searching in table: BieuHienBDKH");
                yield bieuHienBDKHSearch(nam, tinh, linhVuc, donVi, loaiHinh, page, size);
            }
            default -> {
                log.error("Không tìm thấy TableName phù hợp với type={}", type);
                throw new IllegalArgumentException("Không tìm thấy TableName phù hợp: " + type);
            }
        };
    }

    private Page<VanBanPhapLuat> vanBanPhapLuatSearch(String name, Integer year, String tinh, String linhVuc, String coQuanBanHanh, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("nam").descending());
        return vanBanPhapLuatRepository.findAllByConditions(name, year, getTinh(tinh), getLinhVuc(linhVuc), coQuanBanHanh, pageable);
    }

    private Page<TacDongBDKH> tacDongBDKHSearch(Integer year, String tinh, String linhVuc, String donVi, String loaiHinh, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return tacDongBDKHRepository.findAllByConditions(getLinhVuc(linhVuc), getLoaiHinh(loaiHinh), getTinh(tinh), getDonVi(donVi), year, pageable);
    }

    private Page<PhatThaiKNK> phatThaiKNKSearch(Integer year, String tinh, String linhVuc, String donVi, String nguonTacDong, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return phatThaiKNKRepository.findAllByConditions(getLinhVuc(linhVuc), getTinh(tinh), year, getNguonTacDongKNK(linhVuc, nguonTacDong), getDonVi(donVi), pageable);
    }

    private Page<GiamNheThichUng> giamNheThichUngSearch(Integer year, String tinh, String linhVuc, String donVi, String loaiHinh, String danhMuc, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return giamNheThichUngRepository.findByConditions(getLinhVuc(linhVuc), getTinh(tinh), year, getLoaiHinh(loaiHinh), getDonVi(donVi), getDanhMuc(danhMuc), pageable);
    }

    private Page<BaoVeTangOdon> baoVeTangOdonSearch(Integer year, String tinh, String linhVuc, String donVi, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return baoVeTangOdonRepository.findByTinhAndLinhVucAndDonVi(getTinh(tinh), getLinhVuc(linhVuc), year, getDonVi(donVi), pageable);
    }

    private Page<NghienCuuKHCN> nghienCuuKHCNSearch(Integer year, String tinh, String linhVuc, String donVi, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nghienCuuKHCNRepository.search(getTinh(tinh), getLinhVuc(linhVuc), year, getDonVi(donVi), pageable);
    }

    private Page<HopTacQuocTe> hopTacQuocTe(Integer year, String tinh, String linhVuc, String donVi, String tieuChi, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return hopTacQuocTeRepository.searchHopTacQuocTe(getTinh(tinh), getLinhVuc(linhVuc), getDonVi(donVi), year, getTieuChi(tieuChi), pageable);
    }

    private Page<NguonLucBDKH> nguonLucBDKHSearch(Integer year, String tinh, String linhVuc, String donVi, String tieuChi, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nguonLucBDKHRepository.searchNguonLuc(getTinh(tinh), getLinhVuc(linhVuc), year, getDonVi(donVi), getTieuChi(tieuChi), pageable);
    }

    private Page<DanhGiaDeXuat> danhGiaDeXuatSearch(Integer year, String tinh, String linhVuc, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return danhGiaDeXuatRepository.searchDanhGiaDeXuat(getTinh(tinh), getLinhVuc(linhVuc), year, pageable);
    }

    private Page<BieuHienBDKH> bieuHienBDKHSearch(Integer year, String tinh, String linhVuc, String donVi, String loaiHinh, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bieuHienBDKHRepository.searchBieuHienBDKH(getTinh(tinh), getLinhVuc(linhVuc), year, getDonVi(donVi), getLoaiHinh(loaiHinh), pageable);
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
