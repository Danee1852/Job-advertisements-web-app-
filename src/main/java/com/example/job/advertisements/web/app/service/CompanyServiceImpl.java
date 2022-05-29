package com.example.job.advertisements.web.app.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.job.advertisements.web.app.DTO.CompanyDto;
import com.example.job.advertisements.web.app.mapper.CompanyMapper;
import com.example.job.advertisements.web.app.model.Company;
import com.example.job.advertisements.web.app.repository.CompanyRepository;

public class CompanyServiceImpl implements CompanyService {

	public static final Logger LOGGER = Logger.getLogger(CompanyServiceImpl.class.getName());
	private CompanyRepository companyRepository;
	private CompanyMapper companyMapper;

	public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
		LOGGER.info("Creating CompanyService with (" + companyRepository + ", " + companyMapper + ")");
		this.companyRepository = companyRepository;
		this.companyMapper = companyMapper;
	}

	@Override
	public Company saveCompany(CompanyDto companyDto) {
		LOGGER.info("addCompany(" + companyDto + ")");

		Company companyToAdd = companyMapper.CompanyDtoToCompany(companyDto);
		Company savedCompany = companyRepository.save(companyToAdd);
		return savedCompany;
	}

	@Override
	public Page<CompanyDto> getAllCompanies(Pageable pageable) {
		LOGGER.info("getAllCompanies(" + pageable + ")");
		Page<CompanyDto> companiesDto = companyRepository.findAll(pageable).map(companyMapper::companyToCompanyDto);
		LOGGER.info("All founded companies: " + companiesDto.getTotalElements());
		return companiesDto;
	}

	@Override
	public CompanyDto getCompanyById(Long id) {
		LOGGER.info("getCompanyById(" + id + ")");
		CompanyDto company = companyRepository.findById(id).map(companyMapper::companyToCompanyDto).orElse(null);
		return company;
	}

	@Override
	public CompanyDto updateCompany(CompanyDto companyDto) {
		LOGGER.info("updateCompany(" + companyDto + ")");
		if(companyDto.getId() != null && companyRepository.existsById(companyDto.getId())) {
			
			Company company = companyMapper.CompanyDtoToCompany(companyDto);
			companyRepository.save(company);
			LOGGER.info("Company successfully updated");
			return companyMapper.companyToCompanyDto(company);
			
		}
		LOGGER.info("Company update failed");
		return null;

	}

	@Override
	public boolean deleteCompanyById(Long id) {
		LOGGER.info("deleteCompanyById(" + id + ")");

		if(companyRepository.existsById(id)) {
			LOGGER.info("Company with given ID exists");
			Company company = companyRepository.getById(id);
			company.setDeleted(true);
			companyRepository.save(company);
			LOGGER.info("Successful deleted Company with id: "+ id);
			return true;
		}
		LOGGER.info("Company with given id not exist");
		return false;
	}

}
