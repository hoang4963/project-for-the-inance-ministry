package com.its.xoso.service;


import com.its.xoso.dto.AquacultureClimateImpactDto;
import com.its.xoso.dto.BieuHienBDKHDTO;
import com.its.xoso.dto.ClimateImpactRiceDto;
import com.its.xoso.dto.ClimateResourceDto;
import com.its.xoso.dto.CraftVillageClimateImpactDto;
import com.its.xoso.dto.CropClimateImpactDto;
import com.its.xoso.dto.DanhGiaDeXuatDTO;
import com.its.xoso.dto.DocumentDto;
import com.its.xoso.dto.ForestryClimateImpactDto;
import com.its.xoso.dto.IrrigationForestryEmissionDto;
import com.its.xoso.dto.LivestockAquacultureEmissionDto;
import com.its.xoso.dto.LivestockClimateImpactDto;
import com.its.xoso.dto.MitigationActivityDto1;
import com.its.xoso.dto.MitigationActivityDto2;
import com.its.xoso.dto.MitigationActivityDto3;
import com.its.xoso.dto.OzoneControlMeasureDto;
import com.its.xoso.dto.OzoneImpactActivityDto;
import com.its.xoso.dto.ResearchTechnologyDto;
import com.its.xoso.dto.TacDongBDKHThuyLoi;
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

    public Page<?> commonSearch(String loaiVB, Integer type, String linhVuc, String loaiHinh, String danhMuc,
                                String tieuChi, String tinh, Integer nam, String donVi, String nguonTacDong,
                                int page, int size) {
        TableName table = TableName.fromCode(type);
        log.info("commonSearch start with params: loaiVB={}, type={}, linhVuc={}, loaiHinh={}, danhMuc={}, tieuChi={}, tinh={}, nam={}, donVi={}, nguonTacDong={}, page={}, size={}",
                loaiVB, type, linhVuc, loaiHinh, danhMuc, tieuChi, tinh, nam, donVi, nguonTacDong, page, size);

        return switch (table) {
            case VanBanPhapLuat -> {
                log.info("Searching in table: VanBanPhapLuat");
                yield vanBanPhapLuatSearch(loaiVB, nam, tinh, linhVuc, donVi, page, size);
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
                yield baoVeTangOdonSearch(danhMuc,nam, tinh, linhVuc, donVi, page, size);
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

    private Page<?> vanBanPhapLuatSearch(
            String loaiVB,
            Integer year,
            String tinh,
            String linhVuc,
            String coQuanBanHanh,
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("nam").descending());
        Page<VanBanPhapLuat> resultPage = vanBanPhapLuatRepository.findAllByConditions(
                loaiVB, year, getTinh(tinh), getLinhVuc(linhVuc), coQuanBanHanh, pageable);

        // map thủ công để truyền thêm 2 tham số
        if ("1".equals(loaiVB)) return resultPage.map(entity -> mapToDocumentDto(entity, tinh, linhVuc));
        else return resultPage.map(entity -> mapToDGDXDto(entity, tinh, linhVuc, year));
    }

    private DanhGiaDeXuatDTO mapToDGDXDto(VanBanPhapLuat entity, String tinh, String linhVuc, Integer nam) {
        DanhGiaDeXuatDTO dto = new DanhGiaDeXuatDTO();
        dto.setNam(nam.toString());
        dto.setTinh(tinh);
        dto.setLinhVuc(linhVuc);
        dto.setTonTai(entity.getCoQuanBanHanh());
        return dto;
    }

    private DocumentDto mapToDocumentDto(VanBanPhapLuat entity, String tinh, String linhVuc) {
        DocumentDto dto = new DocumentDto();
        dto.setDocumentName(entity.getTen());
        dto.setDocumentNumber(entity.getSoHieu());
        dto.setDocumentType(entity.getLoaiVanBan());
        dto.setIssuedYear(entity.getNam());
        dto.setIssuingAgency(entity.getCoQuanBanHanh());
        dto.setProvince(tinh);
        dto.setField(linhVuc);
        dto.setIssuingOrganization(entity.getCoQuanBanHanh());
        dto.setProviderOrCopyright(entity.getDonViCungCap());
        dto.setDataScope(entity.getPhamViDuLieu());
        dto.setImplementationInfo(entity.getThongTinTrienKhai());
        dto.setClimateChangeAdaptation(entity.getThichUngGiamNhe());
        return dto;
    }

    private Page<?> tacDongBDKHSearch(
            Integer year, String tinh, String linhVuc, String donVi, String loaiHinh, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Integer linhVucId = getLinhVuc(linhVuc);

        Page<TacDongBDKH> tacDongBDKHPage = tacDongBDKHRepository.findAllByConditions(
                getLinhVuc(linhVuc), getLoaiHinh(loaiHinh), getTinh(tinh), getDonVi(donVi), year, pageable);

        switch (linhVucId) {
            case 1: // lĩnh vực cây trồng
                return tacDongBDKHPage.map(entity -> mapToCropClimateImpactDto(entity, tinh, linhVuc, loaiHinh, year, donVi));
            case 2: // Chăn nuôi
                return tacDongBDKHPage.map(entity -> mapToLivestockClimateImpactDto(entity, tinh, linhVuc, loaiHinh, year, donVi));
            case 3: // Thủy sản
                return tacDongBDKHPage.map(entity -> mapToAquacultureClimateImpactDto(entity, tinh, linhVuc, loaiHinh, year, donVi));
            case 4: // Lâm nghiệp
                return tacDongBDKHPage.map(entity -> mapToForestryClimateImpactDto(entity, tinh, linhVuc, loaiHinh, year, donVi));
            case 5: // Làng nghề
                return tacDongBDKHPage.map(entity -> mapToCraftVillageClimateImpactDto(entity, tinh, linhVuc, loaiHinh, year, donVi));
            case 6: // Lúa / nông nghiệp (Rice)
                return tacDongBDKHPage.map(entity -> mapToClimateImpactRiceDto(entity, tinh, linhVuc, loaiHinh, year, donVi));
            case 7: // Thủy lợi
                return tacDongBDKHPage.map(entity -> mapToTacDongBDKHThuyLoi(entity, tinh, loaiHinh, donVi));
            default:
                // TODO: xử lý các lĩnh vực khác
                return Page.empty(pageable);
        }
    }

    private TacDongBDKHThuyLoi mapToTacDongBDKHThuyLoi(
            TacDongBDKH entity, String tinh, String loaiHinh, String donVi) {

        TacDongBDKHThuyLoi dto = new TacDongBDKHThuyLoi();
        dto.setTinh(tinh);
        dto.setLoaiHinh(loaiHinh);

        dto.setMucDoTacDongThoiVu(entity.getMoTa1());
        dto.setMucDoSuyGiamNangSuat(entity.getMoTa2());
        dto.setMucDoTacDongKinhTe(entity.getMoTa3());

        dto.setDonVi(donVi);

        return dto;
    }


    private ClimateImpactRiceDto mapToClimateImpactRiceDto(
            TacDongBDKH entity, String tinh, String linhVuc, String loaiHinh, Integer year, String donVi) {

        ClimateImpactRiceDto dto = new ClimateImpactRiceDto();
        dto.setLoaiHinhThoiTiet(loaiHinh);
        dto.setLinhVuc(linhVuc);
        dto.setNamBaoCao(year);
        dto.setTinh(tinh);

        dto.setMucDoAnhHuongLichThuV(entity.getPhanTram1() != null ? entity.getPhanTram1().doubleValue() : null);
        dto.setMoTaAnhHuongLichThuV(entity.getMoTa1());

        dto.setMucDoSuyGiamNangSuat(entity.getPhanTram2() != null ? entity.getPhanTram2().doubleValue() : null);
        dto.setMoTaSuyGiamNangSuat(entity.getMoTa2());

        dto.setMucDoThietHaiKinhTe(entity.getPhanTram3() != null ? entity.getPhanTram3().doubleValue() : null);
        dto.setMoTaThietHaiKinhTe(entity.getMoTa3());

        dto.setDonViThucHienBaoCao(donVi);

        return dto;
    }


    private CraftVillageClimateImpactDto mapToCraftVillageClimateImpactDto(
            TacDongBDKH entity, String tinh, String linhVuc, String loaiHinh, Integer year, String donVi) {

        CraftVillageClimateImpactDto dto = new CraftVillageClimateImpactDto();
        dto.setWeatherType(loaiHinh);
        dto.setField(linhVuc);
        dto.setReportYear(year);
        dto.setProvince(tinh);

        dto.setImpactProductionTimePercent(entity.getPhanTram1() != null ? entity.getPhanTram1().doubleValue() : null);
        dto.setImpactProductionTimeDesc(entity.getMoTa1());

        dto.setImpactScalePercent(entity.getPhanTram2() != null ? entity.getPhanTram2().doubleValue() : null);
        dto.setImpactScaleDesc(entity.getMoTa2());

        dto.setImpactEconomicLossPercent(entity.getPhanTram3() != null ? entity.getPhanTram3().doubleValue() : null);
        dto.setImpactEconomicLossDesc(entity.getMoTa3());

        dto.setReportingUnit(donVi);

        return dto;
    }


    private ForestryClimateImpactDto mapToForestryClimateImpactDto(
            TacDongBDKH entity, String tinh, String linhVuc, String loaiHinh, Integer year, String donVi) {

        ForestryClimateImpactDto dto = new ForestryClimateImpactDto();
        dto.setWeatherType(loaiHinh);
        dto.setField(linhVuc);
        dto.setReportYear(year);
        dto.setProvince(tinh);

        // 1) Ảnh hưởng sinh trưởng cây
        dto.setImpactGrowthProcessPercent(entity.getPhanTram1() != null ? entity.getPhanTram1().doubleValue() : null);
        dto.setImpactGrowthProcessDesc(entity.getMoTa1());

        // 2) Tăng lây lan sâu bệnh hại rừng
        dto.setImpactPestSpreadPercent(entity.getPhanTram2() != null ? entity.getPhanTram2().doubleValue() : null);
        dto.setImpactPestSpreadDesc(entity.getMoTa2());

        // 3) Nguy cơ cháy rừng / thiệt hại tài nguyên rừng
        // (Nếu dữ liệu của bạn dùng cặp phanTram4/moTa4 cho "cháy rừng", chỉ cần đổi sang getPhanTram4()/getMoTa4())
        dto.setImpactForestFirePercent(entity.getPhanTram3() != null ? entity.getPhanTram3().doubleValue() : null);
        dto.setImpactForestFireDesc(entity.getMoTa3());

        dto.setReportingUnit(donVi);

        return dto;
    }

    private AquacultureClimateImpactDto mapToAquacultureClimateImpactDto(
            TacDongBDKH entity, String tinh, String linhVuc, String loaiHinh, Integer year, String donVi) {

        AquacultureClimateImpactDto dto = new AquacultureClimateImpactDto();
        dto.setWeatherType(loaiHinh);
        dto.setField(linhVuc);
        dto.setAffectedGroup(entity.getDoiTuongNhom());
        dto.setReportYear(year);
        dto.setProvince(tinh);

        dto.setImpactFoodChainPercent(entity.getPhanTram1() != null ? entity.getPhanTram1().doubleValue() : null);
        dto.setImpactFoodChainDesc(entity.getMoTa1());

        dto.setImpactDiseasePercent(entity.getPhanTram2() != null ? entity.getPhanTram2().doubleValue() : null);
        dto.setImpactDiseaseDesc(entity.getMoTa2());

        dto.setImpactYieldPercent(entity.getPhanTram3() != null ? entity.getPhanTram3().doubleValue() : null);
        dto.setImpactYieldDesc(entity.getMoTa3());

        dto.setImpactEconomicLossPercent(entity.getPhanTram4() != null ? entity.getPhanTram4().doubleValue() : null);
        dto.setImpactEconomicLossDesc(entity.getMoTa4());

        dto.setReportingUnit(donVi);

        return dto;
    }


    private LivestockClimateImpactDto mapToLivestockClimateImpactDto(
            TacDongBDKH entity, String tinh, String linhVuc, String loaiHinh, Integer year, String donVi) {

        LivestockClimateImpactDto dto = new LivestockClimateImpactDto();
        dto.setWeatherType(loaiHinh);
        dto.setField(linhVuc);
        dto.setLivestockObject(entity.getDoiTuongNhom());
        dto.setReportYear(year);
        dto.setProvince(tinh);

        dto.setImpactFoodChainPercent(entity.getPhanTram1() != null ? entity.getPhanTram1().doubleValue() : null);
        dto.setImpactFoodChainDesc(entity.getMoTa1());

        dto.setImpactDiseasePercent(entity.getPhanTram2() != null ? entity.getPhanTram2().doubleValue() : null);
        dto.setImpactDiseaseDesc(entity.getMoTa2());

        dto.setImpactYieldPercent(entity.getPhanTram3() != null ? entity.getPhanTram3().doubleValue() : null);
        dto.setImpactYieldDesc(entity.getMoTa3());

        dto.setImpactEconomicLossPercent(entity.getPhanTram4() != null ? entity.getPhanTram4().doubleValue() : null);
        dto.setImpactEconomicLossDesc(entity.getMoTa4());

        dto.setReportingUnit(donVi);

        return dto;
    }


    private CropClimateImpactDto mapToCropClimateImpactDto(
            TacDongBDKH entity, String tinh, String linhVuc, String loaiHinh, Integer year, String donVi) {

        CropClimateImpactDto dto = new CropClimateImpactDto();
        dto.setWeatherType(loaiHinh);
        dto.setField(linhVuc);
        dto.setCropGroup(entity.getDoiTuongNhom());
        dto.setReportYear(year);
        dto.setProvince(tinh);

        dto.setImpactGrowthCyclePercent(entity.getPhanTram1() != null ? entity.getPhanTram1().doubleValue() : null);
        dto.setImpactGrowthCycleDesc(entity.getMoTa1());

        dto.setImpactPestPercent(entity.getPhanTram2() != null ? entity.getPhanTram2().doubleValue() : null);
        dto.setImpactPestDesc(entity.getMoTa2());

        dto.setImpactYieldPercent(entity.getPhanTram3() != null ? entity.getPhanTram3().doubleValue() : null);
        dto.setImpactYieldDesc(entity.getMoTa3());

        dto.setImpactEconomicLossPercent(entity.getPhanTram4() != null ? entity.getPhanTram4().doubleValue() : null);
        dto.setImpactEconomicLossDesc(entity.getMoTa4());

        dto.setReportingUnit(donVi);

        return dto;
    }


    private Page<?> phatThaiKNKSearch(
            Integer year, String tinh, String linhVuc, String donVi, String nguonTacDong, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Integer linhVucId = getLinhVuc(linhVuc);

        Page<PhatThaiKNK> pageData = phatThaiKNKRepository.findAllByConditions(
                linhVucId,
                getTinh(tinh),
                year,
                getNguonTacDongKNK(linhVuc, nguonTacDong),
                getDonVi(donVi),
                pageable
        );

        if (linhVucId == 2 || linhVucId == 8) {
            return pageData.map(entity -> mapToLivestockAquacultureEmissionDto(entity, tinh, linhVuc, year, donVi));
        } else if (linhVucId == 4 || linhVucId == 7) {
            return pageData.map(entity -> mapToIrrigationForestryEmissionDto(entity, tinh, linhVuc, year, donVi));
        } else {
            return Page.empty(pageable);
        }
    }

    private IrrigationForestryEmissionDto mapToIrrigationForestryEmissionDto(
            PhatThaiKNK entity, String tinh, String linhVuc, Integer year, String donVi) {

        IrrigationForestryEmissionDto dto = new IrrigationForestryEmissionDto();
        dto.setSpecificSource(entity.getNguonTacDong());
        dto.setField(linhVuc);
        dto.setReportYear(year);
        dto.setProvince(tinh);

        dto.setEmissionMechanism(entity.getMoTaHoatDong());
        dto.setActivityDescription(entity.getMoTaBienDong());

        dto.setLocation(entity.getDiaDiem());
        dto.setAppliedArea(entity.getDienTich() != null ? entity.getDienTich().doubleValue() : null);
        dto.setTime(entity.getThoiGian());

        dto.setReportingUnit(donVi);

        return dto;
    }



    private LivestockAquacultureEmissionDto mapToLivestockAquacultureEmissionDto(
            PhatThaiKNK entity, String tinh, String linhVuc, Integer year, String donVi) {

        LivestockAquacultureEmissionDto dto = new LivestockAquacultureEmissionDto();
        dto.setSpecificSource(entity.getNguonTacDong());
        dto.setField(linhVuc);
        dto.setReportYear(year);
        dto.setProvince(tinh);

        dto.setEmissionMechanism(entity.getMoTaHoatDong());
        dto.setVariationDescription(entity.getMoTaBienDong());

        dto.setCh4ChangePercent(entity.getPhanTramCh4() != null ? entity.getPhanTramCh4().doubleValue() : null);
        dto.setCh4IncreaseDesc(entity.getMoTaCh4());

        dto.setN2oChangePercent(entity.getPhanTramN2o() != null ? entity.getPhanTramN2o().doubleValue() : null);
        dto.setN2oIncreaseDesc(entity.getMoTaN2o());

        dto.setCo2ChangePercent(entity.getPhanTramCo2() != null ? entity.getPhanTramCo2().doubleValue() : null);
        dto.setCo2IncreaseDesc(entity.getMoTaCo2());

        dto.setLocation(entity.getDiaDiem());
        dto.setTime(entity.getThoiGian());
        dto.setReportingUnit(donVi);

        return dto;
    }


    private Page<?> giamNheThichUngSearch(
            Integer year, String tinh, String linhVuc, String donVi, String loaiHinh, String danhMuc, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Integer danhMucId = getDanhMuc(danhMuc);

        Page<GiamNheThichUng> pageData = giamNheThichUngRepository.findByConditions(
                getLinhVuc(linhVuc),
                getTinh(tinh),
                year,
                getLoaiHinh(loaiHinh),
                getDonVi(donVi),
                danhMucId,
                pageable
        );

        if (danhMucId != null && (danhMucId >= 1 && danhMucId <= 4)) {
            return pageData.map(entity -> mapToMitigationActivityDto1(entity, danhMuc, tinh, linhVuc, year, donVi));
        } else if (danhMucId != null && danhMucId >= 5 && danhMucId <= 10) {
            return pageData.map(entity -> mapToMitigationActivityDto2(entity, tinh, linhVuc, year, donVi));
        } else if (danhMucId == 11) {
            return pageData.map(entity -> mapToMitigationActivityDto3(entity, tinh, linhVuc, year, donVi));
        } else  {
            return Page.empty(pageable);
        }
    }


    private MitigationActivityDto2 mapToMitigationActivityDto2(
            GiamNheThichUng entity, String tinh, String linhVuc, Integer year, String donVi) {

        MitigationActivityDto2 dto = new MitigationActivityDto2();
        dto.setTinh(tinh);
        dto.setLinhVuc(linhVuc);
        dto.setNamBaoCao(year);

        dto.setHoatDongCuThe(entity.getTenGiaiPhap());
        dto.setMoTaNoiDung(entity.getMoTa());
        dto.setHieuQua(entity.getHieuQua());

        dto.setDonViThucHien(donVi);
        dto.setDonViBaoCao(donVi);

        // Các trường còn lại không có dữ liệu từ entity, để tạm null
        dto.setPhuongPhapTiepCan(null);
        dto.setPhamViThongTin(null);
        dto.setTanSuatPhatHanh(null);
        dto.setThoiLuongThongTin(null);
        dto.setDiaDiem(null);
        dto.setDoiTuongDuocBiet(null);
        dto.setDangThongTinDuLieu(null);

        return dto;
    }

    private MitigationActivityDto3 mapToMitigationActivityDto3(
            GiamNheThichUng entity, String tinh, String linhVuc, Integer year, String donVi) {

        MitigationActivityDto3 dto = new MitigationActivityDto3();
        dto.setTinh(tinh);
        dto.setLinhVuc(linhVuc);
        dto.setNamBaoCao(year);

        dto.setTenMoHinh(entity.getTenGiaiPhap());
        dto.setBienPhap(entity.getMoTa());
        dto.setHieuQua(entity.getHieuQua());

        dto.setDonViThucHien(donVi);
        dto.setDonViCungCap(donVi);

        // Các trường khác không có dữ liệu từ entity, tạm set null
        dto.setQuyMo(null);
        dto.setTanSuatThucHien(null);
        dto.setThoiGian(null);
        dto.setDiaDiem(null);
        dto.setNguonTrichDan(null);

        return dto;
    }
    private MitigationActivityDto1 mapToMitigationActivityDto1(
            GiamNheThichUng entity, String danhMuc, String tinh, String linhVuc, Integer year, String donVi) {

        MitigationActivityDto1 dto = new MitigationActivityDto1();
        dto.setCategoryName(danhMuc);
        dto.setProvince(tinh);
        dto.setField(linhVuc);
        dto.setReportYear(year);

        dto.setDetailName(entity.getTenGiaiPhap());
        dto.setEffectiveness(entity.getHieuQua());
        dto.setImplementingUnit(donVi);
        dto.setReportingUnit(donVi);

        // Nếu các trường khác như systemScale, monitoringFrequency,... có trong entity thì map thêm
        dto.setSystemScale(null);
        dto.setMonitoringFrequency(null);
        dto.setImplementationDuration(null);
        dto.setMonitoringLocation(null);
        dto.setStatus(null);
        dto.setStartTime(null);
        dto.setDataFormat(null);

        return dto;
    }


    private Page<?> baoVeTangOdonSearch(
            String danhMuc, Integer year, String tinh, String linhVuc, String donVi, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Integer danhMucId = getDanhMuc(danhMuc);

        Page<BaoVeTangOdon> pageData = baoVeTangOdonRepository.findByTinhAndLinhVucAndDonVi(
                getTinh(tinh),
                getLinhVuc(linhVuc),
                danhMucId,
                year,
                getDonVi(donVi),
                pageable
        );

        if (danhMucId != null) {
            switch (danhMucId) {
                case 12:
                    return pageData.map(entity -> mapToOzoneImpactActivityDto(entity, tinh, linhVuc, year, donVi));
                case 13:
                    return pageData.map(entity -> mapToOzoneControlMeasureDto(entity, tinh, linhVuc, year, donVi));
                default:
                    return Page.empty(pageable);
            }
        } else {
            return Page.empty(pageable);
        }
    }

    private OzoneControlMeasureDto mapToOzoneControlMeasureDto(
            BaoVeTangOdon entity, String tinh, String linhVuc, Integer year, String donVi) {

        OzoneControlMeasureDto dto = new OzoneControlMeasureDto();
        dto.setTinh(tinh);
        dto.setLinhVuc(linhVuc);
        dto.setNamBaoCao(year);

        dto.setCacBienPhap(entity.getBien_phap());
        dto.setDaApDung(entity.getDaApDungChua() != null && entity.getDaApDungChua().equalsIgnoreCase("có"));
        dto.setTanSuatXuatHien(entity.getTanSuat());
        dto.setQuyMoSoLuong(entity.getQuyMo());
        dto.setThoiGianGhiNhan(entity.getDuocGhiNhan());
        dto.setDiaDiem(entity.getDiaDiem());
        dto.setKhaNangAnhHuong(entity.getKhaNangAnhHuong());
        dto.setDonViQuanLyThucHien(donVi);

        // Nếu có nguồn trích dẫn, set thêm, hiện tạm null
        dto.setNguonTrichDan(null);

        return dto;
    }

    private OzoneImpactActivityDto mapToOzoneImpactActivityDto(
            BaoVeTangOdon entity, String tinh, String linhVuc, Integer year, String donVi) {

        OzoneImpactActivityDto dto = new OzoneImpactActivityDto();
        dto.setTinh(tinh);
        dto.setLinhVuc(linhVuc);
        dto.setNamBaoCao(year);

        dto.setChatSuyGiamTangOzon(entity.getChatSuyGiam());
        dto.setHoatDongPhatSinh(entity.getHoatDong());
        dto.setTanSuatXuatHien(entity.getTanSuat());
        dto.setQuyMoSoLuong(entity.getQuyMo());
        dto.setThoiGianGhiNhan(entity.getDuocGhiNhan());
        dto.setDiaDiem(entity.getDiaDiem());
        dto.setKhaNangAnhHuong(entity.getKhaNangAnhHuong());
        dto.setDonViQuanLyThucHien(donVi);

        // Nếu có nguồn trích dẫn, set thêm, hiện tạm null
        dto.setNguonTrichDan(null);

        return dto;
    }

    private Page<ResearchTechnologyDto> nghienCuuKHCNSearch(
            Integer year, String tinh, String linhVuc, String donVi, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<NghienCuuKHCN> pageData = nghienCuuKHCNRepository.search(
                getTinh(tinh),
                getLinhVuc(linhVuc),
                year,
                getDonVi(donVi),
                pageable
        );

        return pageData.map(entity -> mapToResearchTechnologyDto(entity, tinh, linhVuc, year, donVi));
    }

    private ResearchTechnologyDto mapToResearchTechnologyDto(
            NghienCuuKHCN entity, String tinh, String linhVuc, Integer year, String donVi) {

        ResearchTechnologyDto dto = new ResearchTechnologyDto();
        dto.setTinh(tinh);
        dto.setLinhVuc(linhVuc);
        dto.setNamBaoCao(year);

        dto.setDanhMucCongNghe(entity.getTenDeTai());
        dto.setMoTaCongNghe(entity.getMoTa());
        dto.setHieuQua(entity.getKetQua());
        dto.setDonViThucHien(entity.getDonViChuTri());
        dto.setDonViBaoCao(donVi);

        // Trường số lượng, quy mô, thời gian, địa điểm chưa có dữ liệu, set tạm null
        dto.setSoLuongDaTrienKhai(null);
        dto.setQuyMoApDung(null);
        dto.setThoiGianApDung(null);
        dto.setDiaDiemApDung(null);

        // Các trường Boolean tạm set null
        dto.setThuocChuongTrinhKhcn(null);
        dto.setSangCheGiaiPhap(null);
        dto.setDaNhanRong(null);

        return dto;
    }

    private Page<HopTacQuocTe> hopTacQuocTe(Integer year, String tinh, String linhVuc, String donVi, String tieuChi, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return hopTacQuocTeRepository.searchHopTacQuocTe(getTinh(tinh), getLinhVuc(linhVuc), getDonVi(donVi), year, getTieuChi(tieuChi), pageable);
    }

    private Page<ClimateResourceDto> nguonLucBDKHSearch(
            Integer year, String tinh, String linhVuc, String donVi, String tieuChi, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<NguonLucBDKH> pageData = nguonLucBDKHRepository.searchNguonLuc(
                getTinh(tinh),
                getLinhVuc(linhVuc),
                year,
                getDonVi(donVi),
                getTieuChi(tieuChi),
                pageable
        );

        return pageData.map(entity -> mapToClimateResourceDto(entity, tinh, linhVuc, year, donVi));
    }

    private ClimateResourceDto mapToClimateResourceDto(
            NguonLucBDKH entity, String tinh, String linhVuc, Integer year, String donVi) {

        ClimateResourceDto dto = new ClimateResourceDto();
        dto.setTinh(tinh);
        dto.setLinhVuc(linhVuc);
        dto.setNamBaoCao(year);
        dto.setKinhPhi(entity.getKinhPhi());
        dto.setDonViBaoCao(donVi);

        // Các trường chưa có dữ liệu trong entity, tạm set null
        dto.setSoLuongChuyenTrach(null);
        dto.setSoLuongKiemNhiem(null);
        dto.setNoiDung(null);
        dto.setQuyMo(null);
        dto.setThoiGian(null);
        dto.setDiaDiem(null);
        dto.setHieuQua(null);
        dto.setDonViThucHien(null);
        dto.setKhoKhanCanThaoGo(null);

        dto.setKinhPhi(entity.getKinhPhi());
        dto.setDonViBaoCao(donVi);

        return dto;
    }

    private Page<DanhGiaDeXuatDTO> danhGiaDeXuatSearch(Integer year, String tinh, String linhVuc, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DanhGiaDeXuat> resultPage = danhGiaDeXuatRepository.searchDanhGiaDeXuat(
                getTinh(tinh), getLinhVuc(linhVuc), year, pageable);

        return resultPage.map(entity -> mapToDanhGiaDeXuatDTO(entity, tinh, linhVuc, year));
    }

    private DanhGiaDeXuatDTO mapToDanhGiaDeXuatDTO(DanhGiaDeXuat entity, String tinh, String linhVuc, Integer year) {
        DanhGiaDeXuatDTO dto = new DanhGiaDeXuatDTO();
        dto.setTinh(tinh);
        dto.setNam(year != null ? year.toString() : null);
        dto.setLinhVuc(linhVuc);

        // Map các field khác từ entity sang dto
        dto.setTonTai(entity.getTonTai());
        dto.setHienTrangCSDL(entity.getHienTrang());
        dto.setKhoKhanThachThuc(entity.getKhoKhan());
        dto.setDeXuatKienNghiGiaiPhap(entity.getGiaiPhap());

        return dto;
    }

    private Page<BieuHienBDKHDTO> bieuHienBDKHSearch(
            Integer year, String tinh, String linhVuc, String donVi, String loaiHinh, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Integer linhVucId = getLinhVuc(linhVuc);
        Page<BieuHienBDKH> resultPage = bieuHienBDKHRepository.searchBieuHienBDKH(
                getTinh(tinh), linhVucId, year, getDonVi(donVi), getLoaiHinh(loaiHinh), pageable);

        return resultPage.map(entity -> mapToBieuHienBDKHDTO(entity, tinh, linhVuc, donVi, loaiHinh, year));
    }

    private BieuHienBDKHDTO mapToBieuHienBDKHDTO(
            BieuHienBDKH entity, String tinh, String linhVuc, String donVi, String loaiHinh, Integer year) {
        BieuHienBDKHDTO dto = new BieuHienBDKHDTO();
        dto.setTinh(tinh);
        dto.setNam(year != null ? year.toString() : null);
        dto.setLoaiHinhThoiTiet(loaiHinh);
        dto.setDonViBaoCao(donVi);

        // Tạm thời map thẳng bieuHien sang "dacTinhBieuHien"
        dto.setDacTinhBieuHien(entity.getBieuHien());

        // Nếu sau này bieuHien là JSON, có thể parse ra để set các trường sau:
        dto.setThoiGianDienRa(entity.getThoiGian());
        dto.setDiaDiemCuThe(entity.getDiaDiem());
        dto.setTanSuatXuatHien(entity.getTanXuat());
        dto.setQuyMoAnhHuong(entity.getQuyMo());

        return dto;
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
