package com.defineXfinalcase.service;

import com.defineXfinalcase.api.request.CreditApplicationPost;
import com.defineXfinalcase.api.response.DataResponse;
import com.defineXfinalcase.dto.CreditApplicationDto;

import java.time.LocalDate;
import java.util.List;

public interface CreditApplicationService {
    DataResponse<CreditApplicationDto> createByCustomerId(CreditApplicationPost creditApplicationPost);
    DataResponse<List<CreditApplicationDto>> getByIdAndDateOfBirth(String id, LocalDate birthOfDate);
}
