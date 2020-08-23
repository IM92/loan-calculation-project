package com.calculator.price.service;


import com.calculator.price.model.LoanInfo;
import com.calculator.price.model.LoanInfoCalculated;
import com.calculator.price.repository.LoanInfoCalculatedRepository;
import com.calculator.price.repository.LoanInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class LoanInfoServiceImpl implements LoanInfoService{

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
        return loanInfoRepository.save(loanInfo);
    }

    @Override
    public LoanInfoCalculated createLoanInfoCalculated(LoanInfoCalculated loanInfoCalculated) {
        return loanInfoCalculatedRepository.save(loanInfoCalculated);
    }

    @Override
    public Optional<LoanInfo> findById(String id) {
        return loanInfoRepository.findById(id);
    }
}
