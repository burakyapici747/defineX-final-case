package com.defineXfinalcase.api;

import com.defineXfinalcase.api.request.CreditApplicationPost;
import com.defineXfinalcase.api.request.CustomerPostRequest;
import com.defineXfinalcase.api.response.BaseResponse;
import com.defineXfinalcase.api.response.DataResponse;
import com.defineXfinalcase.dto.CreditApplicationDto;
import com.defineXfinalcase.dto.CustomerDto;
import com.defineXfinalcase.service.CustomerService;
import com.defineXfinalcase.service.impl.CreditApplicationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CreditApplicationServiceImpl creditApplicationService;

    public CustomerController(CustomerService customerService, CreditApplicationServiceImpl creditApplicationService) {
        this.customerService = customerService;
        this.creditApplicationService = creditApplicationService;
    }

    @GetMapping
    public ResponseEntity<DataResponse<List<CustomerDto>>> getAll(){
        final DataResponse<List<CustomerDto>> response =
                customerService.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<CustomerDto>> getById(@PathVariable String id){
        final DataResponse<CustomerDto> response =
                customerService.getById(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DataResponse<CustomerDto>> createCustomer(
            @RequestBody CustomerPostRequest customerPostRequest){
        final DataResponse<CustomerDto> response =
                customerService.create(customerPostRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable String id){
        return ResponseEntity.ok(customerService.deleteById(id));
    }

}
