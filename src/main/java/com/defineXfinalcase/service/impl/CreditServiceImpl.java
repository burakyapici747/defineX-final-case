package com.defineXfinalcase.service.impl;


import com.defineXfinalcase.model.Credit;
import com.defineXfinalcase.repository.CreditRepository;
import com.defineXfinalcase.service.CreditService;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {
    private final CreditRepository creditRepository;

    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public Credit createCredit(Credit credit){
        creditRepository.save(credit);

        return credit;
    }
}
