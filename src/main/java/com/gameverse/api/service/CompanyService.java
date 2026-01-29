package com.gameverse.api.service;

import com.gameverse.api.entity.Company;
import com.gameverse.api.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // POST
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    // GET
    public List<Company> listCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    // PUT
    public Company updateCompany(Long id, Company companyDetalles) {
        Optional<Company> companyOpcional = companyRepository.findById(id);
        if (companyOpcional.isPresent()) {
            Company companyExistente = companyOpcional.get();
            companyExistente.setNombre(companyDetalles.getNombre());
            return companyRepository.save(companyExistente);
        } else {
            return null;
        }
    }

    // DELETE
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
