package com.example.job.advertisements.web.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.job.advertisements.web.app.DTO.CompanyDto;
import com.example.job.advertisements.web.app.model.Company;






public interface CompanyService {
	
	public Company saveCompany(CompanyDto companydto);

	public Page<CompanyDto> getAllCompanies(Pageable pageable);

	public CompanyDto getCompanyById(Long id);
	
	public CompanyDto updateCompany(CompanyDto companydto);
	
	public boolean deleteCompanyById(Long id);

	
}
