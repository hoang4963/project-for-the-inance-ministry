package com.its.xoso.controller;


import com.its.xoso.entity.DanhMuc;
import com.its.xoso.entity.LinhVuc;
import com.its.xoso.entity.LoaiHinh;
import com.its.xoso.entity.TieuChi;
import com.its.xoso.entity.Tinh;
import com.its.xoso.repository.DanhMucRepository;
import com.its.xoso.repository.LinhVucRepository;
import com.its.xoso.repository.LoaiHinhRepository;
import com.its.xoso.repository.TieuChiRepository;
import com.its.xoso.repository.TinhRepository;
import com.its.xoso.service.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/common")
public class CommonController {

    private final CommonService commonSearchService;

    private final TinhRepository tinhRepository;

    private final TieuChiRepository tieuChiRepository;

    private final DanhMucRepository danhMucRepository;

    private final LoaiHinhRepository loaiHinhRepository;

    private final LinhVucRepository linhVucRepository;

    @GetMapping("/search")
    public ResponseEntity<Page<?>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer type,
            @RequestParam(required = false) String linhVuc,
            @RequestParam(required = false) String loaiHinh,
            @RequestParam(required = false) String danhMuc,
            @RequestParam(required = false) String tieuChi,
            @RequestParam(required = false) String tinh,
            @RequestParam(required = false) Integer nam,
            @RequestParam(required = false) String donVi,
            @RequestParam(required = false) String nguonTacDong,
            @RequestParam(defaultValue = "0") int page,          // số trang (mặc định 0)
            @RequestParam(defaultValue = "10") int size          // số bản ghi mỗi trang (mặc định 10)
    ) {

        Page<?> result = commonSearchService.commonSearch(
                name, type, linhVuc, loaiHinh, danhMuc, tieuChi, tinh, nam, donVi, nguonTacDong, page, size
        );
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-all-tinh")
    public ResponseEntity<List<?>> getTinh() {
        return ResponseEntity.ok(tinhRepository.findAll());
    }

    @GetMapping("/get-all-linhVuc")
    public ResponseEntity<List<?>> getLinhVuc() {
        return ResponseEntity.ok(linhVucRepository.findAll());
    }

    @GetMapping("/get-all-tieuChi")
    public ResponseEntity<List<?>> getTieuChi() {
        return ResponseEntity.ok(tieuChiRepository.findAll());
    }

    @GetMapping("/get-all-danhMuc")
    public ResponseEntity<List<?>> getDanhMuc() {
        return ResponseEntity.ok(danhMucRepository.findAll());
    }

    @GetMapping("/get-all-loaiHinh")
    public ResponseEntity<List<?>> getLoaiHinh() {
        return ResponseEntity.ok(loaiHinhRepository.findAll());
    }


    @GetMapping("/get-tinh/{id}")
    public ResponseEntity<Tinh> getTinhById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(tinhRepository.findById(id).orElse(null));
    }

    @GetMapping("/get-linhVuc/{id}")
    public ResponseEntity<LinhVuc> getLinhVucById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(linhVucRepository.findById(id).orElse(null));
    }

    @GetMapping("/get-tieuChi/{id}")
    public ResponseEntity<TieuChi> getTieuChiById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(tieuChiRepository.findById(id).orElse(null));
    }

    @GetMapping("/get-danhMuc/{id}")
    public ResponseEntity<DanhMuc> getDanhMucById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(danhMucRepository.findById(id).orElse(null));
    }

    @GetMapping("/get-loaiHinh/{id}")
    public ResponseEntity<LoaiHinh> getLoaiHinhById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(loaiHinhRepository.findById(id).orElse(null));
    }
}
