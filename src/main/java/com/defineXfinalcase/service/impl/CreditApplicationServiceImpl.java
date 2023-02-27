package com.defineXfinalcase.service.impl;

import com.defineXfinalcase.api.request.CreditApplicationPost;
import com.defineXfinalcase.api.response.DataResponse;
import com.defineXfinalcase.api.response.SuccessDataResponse;
import com.defineXfinalcase.constant.CreditApplicationConstant;
import com.defineXfinalcase.constant.EntityConstant;
import com.defineXfinalcase.dto.CreditApplicationDto;
import com.defineXfinalcase.dto.CreditDto;
import com.defineXfinalcase.enums.CreditResult;
import com.defineXfinalcase.model.CreditApplication;
import com.defineXfinalcase.model.Customer;
import com.defineXfinalcase.repository.CreditApplicationRepository;
import com.defineXfinalcase.service.CreditApplicationService;
import com.defineXfinalcase.util.CreditUtil;
import com.defineXfinalcase.util.GlobalHelper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CreditApplicationServiceImpl implements CreditApplicationService {
    private final CustomerServiceImpl customerService;
    private final CreditServiceImpl creditService;
    private final ModelMapper modelMapper;
    private final CreditApplicationRepository creditApplicationRepository;

    public CreditApplicationServiceImpl(
            CustomerServiceImpl customerService,
            CreditServiceImpl creditService,
            ModelMapper modelMapper,
            CreditApplicationRepository creditApplicationRepository) {
        this.customerService = customerService;
        this.creditService = creditService;
        this.modelMapper = modelMapper;
        this.creditApplicationRepository = creditApplicationRepository;
    }

    @Override
    public DataResponse<CreditApplicationDto> createByCustomerId(
            CreditApplicationPost creditApplicationPost) {
        final CreditApplication creditApplication = new CreditApplication();
        final Customer customer = customerService.findById(creditApplicationPost.getCustomerId().toString());

        creditApplication.setCustomer(customer);
        creditApplication.setMonthlyIncome(customer.getMonthlyIncome());

        CreditDto creditDto = CreditUtil.getCreditResultByCustomerScoreAndSalary(customer.
                        getCreditScore(), customer.getMonthlyIncome(), customer.getAssurance(), creditService);

        creditApplication.setCreditResult(creditDto.getCreditResult());

        creditApplicationRepository.save(creditApplication);

        CreditApplicationDto creditApplicationDto = modelMapper.map(creditApplication, CreditApplicationDto.class);
        creditApplicationDto.setCreditDto(creditDto);

        return new SuccessDataResponse<>(creditApplicationDto,
               CreditApplicationConstant.SUCCESS_CREDIT_APPLICATION
        );
    }

    @Override
    public DataResponse<List<CreditApplicationDto>> getByIdAndDateOfBirth(String id, LocalDate birthOfDate) {
        final Customer customer = customerService.findByIdAndBirthOfDate(id, birthOfDate);

        final List<CreditApplicationDto> creditApplicationDtos =
                GlobalHelper.listDtoConverter(modelMapper,
                        customer.getCreditApplications(), CreditApplicationDto.class);

        return new SuccessDataResponse<>(creditApplicationDtos, EntityConstant.EMPTY);
    }
}
