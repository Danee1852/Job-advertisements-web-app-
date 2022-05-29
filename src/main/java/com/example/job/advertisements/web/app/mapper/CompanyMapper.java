package com.example.job.advertisements.web.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.job.advertisements.web.app.DTO.CompanyDto;
import com.example.job.advertisements.web.app.model.Company;

@Mapper
public interface CompanyMapper {
	
	CompanyMapper COMPANY_DTO_MAPPER = Mappers.getMapper( CompanyMapper.class ); 
	
	CompanyDto companyToCompanyDto( Company company);
	Company CompanyDtoToCompany (CompanyDto companyDto);

}
