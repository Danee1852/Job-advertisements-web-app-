package com.example.job.advertisements.web.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.job.advertisements.web.app.DTO.CompanyDto;
import com.example.job.advertisements.web.app.mapper.CompanyMapper;
import com.example.job.advertisements.web.app.model.Company;

@SpringBootTest
public class CompanyMapperTest {
	
	


    @Test
    public void shouldMapCompanyToDto() {
        //given
    	
        Company company = new Company( "SimpleDev", "Global aplication development company",100,"Warsaw",false );
     
        //when
        CompanyDto companyDto = CompanyMapper.COMPANY_DTO_MAPPER.companyToCompanyDto( company );
     
        //then
        assertThat( companyDto ).isNotNull();
        assertThat( companyDto.getName() ).isEqualTo( "SimpleDev" );
        assertThat( companyDto.getDescription() ).isEqualTo("Global aplication development company");
        assertThat( companyDto.getLocation() ).isEqualTo( "Warsaw" );
        assertThat( companyDto.getSize() ).isEqualTo(100);
        
    }



}
