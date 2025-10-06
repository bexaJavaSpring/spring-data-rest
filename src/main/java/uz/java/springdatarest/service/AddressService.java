package uz.java.springdatarest.service;

import org.springframework.stereotype.Service;
import uz.java.springdatarest.dto.reponse.AddressResponse;
import uz.java.springdatarest.dto.request.AddressRequest;
import uz.java.springdatarest.model.Address;
import uz.java.springdatarest.repository.AddressRepository;
import uz.java.springdatarest.repository.BranchRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository repository;
    private final BranchRepository branchRepository;

    public AddressService(AddressRepository repository, BranchRepository branchRepository) {
        this.repository = repository;
        this.branchRepository = branchRepository;
    }

    public List<AddressResponse> getAll() {
        return repository.findAll().stream().map(AddressResponse::toDto).toList();
    }

    public Long create(AddressRequest request) {
        Address address = new Address();
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setZip(request.getZip());
        address.setStreet(request.getStreet());
        return repository.save(address).getId();
    }

    public Long update(Long id, AddressRequest request) {
        Address address = repository.findById(id).orElseThrow(() -> new RuntimeException("No such address"));
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setZip(request.getZip());
        address.setStreet(request.getStreet());
        repository.save(address);
        return address.getId();
    }

    public Boolean delete(Long id) {
        Address address = repository.findById(id).orElseThrow(() -> new RuntimeException("No such address"));
        address.setDeleted(true);
        address.setDeletedAt(LocalDateTime.now());
        repository.save(address);
        return true;
    }

    public AddressResponse getOne(Long id) {
        Address address = repository.findById(id).orElseThrow(() -> new RuntimeException("No such address"));
        return AddressResponse.toDto(address);
    }
}
