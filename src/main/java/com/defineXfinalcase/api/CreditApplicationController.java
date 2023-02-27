package com.defineXfinalcase.api;

import com.defineXfinalcase.api.request.CreditApplicationPost;
import com.defineXfinalcase.api.response.DataResponse;
import com.defineXfinalcase.dto.CreditApplicationDto;
import com.defineXfinalcase.service.impl.CreditApplicationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/creditApplication")
public class CreditApplicationController {
    private final CreditApplicationServiceImpl creditApplicationService;

    public CreditApplicationController(CreditApplicationServiceImpl creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
    }

    @PostMapping()
    public ResponseEntity<DataResponse<CreditApplicationDto>> submitCreditApplication(
            @RequestBody CreditApplicationPost creditApplicationPost){
        final DataResponse<CreditApplicationDto> response =
                creditApplicationService.createByCustomerId(creditApplicationPost);
        return ResponseEntity.ok(response);
    }
}
