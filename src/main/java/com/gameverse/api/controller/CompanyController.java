package com.gameverse.api.controller;

import com.gameverse.api.entity.Company;
import com.gameverse.api.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private CompanyService companyService;

    public  CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> listar() {
        return this.companyService.listCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Company> buscar(@PathVariable Long id) {
        return this.companyService.getCompanyById(id);
    }

    @PostMapping
    public Company crear(@RequestBody Company company) {
        return this.companyService.createCompany(company);
    }

    @PutMapping("/{id}")
    public Company actualizar(@PathVariable Long id ,@RequestBody Company company) {
        return this.companyService.updateCompany(id, company);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.companyService.deleteCompany(id);
    }
}
