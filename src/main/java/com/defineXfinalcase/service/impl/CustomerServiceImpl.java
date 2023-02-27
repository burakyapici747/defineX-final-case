package com.defineXfinalcase.service.impl;

import com.defineXfinalcase.api.request.CustomerPostRequest;
import com.defineXfinalcase.api.request.CustomerPutRequest;
import com.defineXfinalcase.api.response.BaseResponse;
import com.defineXfinalcase.api.response.DataResponse;
import com.defineXfinalcase.api.response.SuccessDataResponse;
import com.defineXfinalcase.api.response.SuccessResponse;
import com.defineXfinalcase.constant.EntityConstant;
import com.defineXfinalcase.dto.CreditApplicationDto;
import com.defineXfinalcase.dto.CustomerDto;
import com.defineXfinalcase.exception.EntityNotFoundException;
import com.defineXfinalcase.model.Customer;
import com.defineXfinalcase.repository.CustomerRepository;
import com.defineXfinalcase.service.CustomerService;
import com.defineXfinalcase.util.GlobalHelper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResponse<List<CustomerDto>> getAll() {
        final List<CustomerDto> customerDtos =
                GlobalHelper.listDtoConverter(modelMapper, customerRepository.findAll(), CustomerDto.class);
        return new SuccessDataResponse<>(customerDtos, EntityConstant.EMPTY);
    }

    @Override
    public DataResponse<CustomerDto> getById(String id) {
        final Customer customer = findById(id);
        return new SuccessDataResponse<>(modelMapper.map(customer, CustomerDto.class), EntityConstant.EMPTY);
    }


    @Override
    public DataResponse<CreditApplicationDto> submitCreditApplicationById(String id) {
        return null;
    }

    @Override
    public int getCreditScoreById(String id) {
        final Customer customer = findById(id);

        return customer.getCreditScore();
    }

    @Override
    public BaseResponse deleteById(String id) {
        final Customer customer = findById(id);
        customerRepository.delete(customer);
        return new SuccessResponse(EntityConstant.SUCCESS_DELETE);
    }

    @Override
    public DataResponse<CustomerDto> create(final CustomerPostRequest customerPostRequest) {
        final Customer customer = new Customer();

        customer.setName(customerPostRequest.getName());
        customer.setSurname(customerPostRequest.getSurname());
        customer.setMonthlyIncome(customerPostRequest.getMonthlyIncome());
        customer.setPhoneNumber(customerPostRequest.getPhoneNumber());
        customer.setBirthOfDate(customerPostRequest.getBirthOfDate());
        customer.setCreditScore(customerPostRequest.getCreditScore());
        customer.setAssurance(customerPostRequest.getAssurance());

        customerRepository.save(customer);

        return new SuccessDataResponse<>(modelMapper.map(customer, CustomerDto.class), EntityConstant.SUCCESS_CREATE);
    }

    @Override
    public DataResponse<CustomerDto> updateById(String id, CustomerPutRequest customerPutRequest) {
        final Customer customer = findById(id);

        customer.setName(customerPutRequest.getName());
        customer.setSurname(customerPutRequest.getSurname());
        customer.setMonthlyIncome(customerPutRequest.getMonthlyIncome());
        customer.setPhoneNumber(customerPutRequest.getPhoneNumber());
        customer.setAssurance(customerPutRequest.getAssurance());

        customerRepository.save(customer);

        return new SuccessDataResponse<>(modelMapper.map(customer, CustomerDto.class), EntityConstant.SUCCESS_UPDATE);
    }

    protected Customer findById(String id){
        return customerRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException(EntityConstant.NOT_FOUND_DATA));
    }

    protected Customer findByIdAndBirthOfDate(String id, LocalDate birthOfDate){
        return customerRepository.findByIdAndAndBirthOfDate(UUID.fromString(id), birthOfDate)
                .orElseThrow(() -> new EntityNotFoundException(EntityConstant.NOT_FOUND_DATA));
    }
}
