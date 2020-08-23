package com.calculator.price.service;


import com.calculator.price.model.LoanInfo;
import com.calculator.price.model.LoanInfoCalculated;
import com.calculator.price.repository.LoanInfoCalculatedRepository;
import com.calculator.price.repository.LoanInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanInfoServiceImpl implements LoanInfoService{

    private final Logger logger = LoggerFactory.getLogger(LoanInfoServiceImpl.class);

    private final LoanInfoRepository loanInfoRepository;
    private final LoanInfoCalculatedRepository loanInfoCalculatedRepository;

    @Autowired
    public LoanInfoServiceImpl(LoanInfoRepository loanInfoRepository,
                               LoanInfoCalculatedRepository loanInfoCalculatedRepository) {
        this.loanInfoRepository = loanInfoRepository;
        this.loanInfoCalculatedRepository = loanInfoCalculatedRepository;
    }

    @Override
    public Optional<LoanInfoCalculated> get(String id) {
        return loanInfoCalculatedRepository.findById(id);
    }

    @Override
    public List<LoanInfoCalculated> getAll() {
        return loanInfoCalculatedRepository.findAll();
    }

    @Override
    public void save(LoanInfoCalculated prospect) {
        loanInfoCalculatedRepository.save(prospect);
    }

    @Override
    public void delete(String id) {
        loanInfoCalculatedRepository.deleteById(id);
    }

    @Override
    public LoanInfo createLoanInfo(LoanInfo loanInfo) {
        logger.info("Create loan info");
        return loanInfoRepository.save(loanInfo);
    }

    @Override
    public LoanInfoCalculated createLoanInfoCalculated(LoanInfoCalculated loanInfoCalculated) {
        logger.info("Create loan info calculated");
        return loanInfoCalculatedRepository.save(loanInfoCalculated);
    }
}
