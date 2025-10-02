package uz.java.springdatarest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.java.springdatarest.dto.filter.BranchFilter;
import uz.java.springdatarest.dto.reponse.BranchResponse;
import uz.java.springdatarest.dto.request.BranchRequest;
import uz.java.springdatarest.model.Book;
import uz.java.springdatarest.service.BranchService;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    private final BranchService service;

    public BranchController(BranchService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BranchResponse>> getAll(BranchFilter filter) {
        return ResponseEntity.ok(service.getAll(filter));
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody BranchRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody BranchRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOne(id));
    }
}
