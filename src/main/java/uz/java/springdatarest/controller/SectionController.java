package uz.java.springdatarest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.java.springdatarest.dto.filter.SectionFilter;
import uz.java.springdatarest.dto.reponse.SectionResponse;
import uz.java.springdatarest.dto.request.SectionRequest;
import uz.java.springdatarest.service.SectionService;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    private final SectionService service;

    public SectionController(SectionService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SectionResponse>> getAllSections(SectionFilter filter) {
        return ResponseEntity.ok(service.getAll(filter));
    }

    @PostMapping
    public ResponseEntity<Long> create(SectionRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, SectionRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOne(id));
    }

}
