package com.calculator.price.service;


import com.calculator.price.model.ItemInfo;
import com.calculator.price.model.LoanInfo;
import com.calculator.price.model.LoanInfoCalculated;
import com.calculator.price.repository.ItemInfoRepository;
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
    private final ItemInfoRepository itemInfoRepository;

    @Autowired
    public LoanInfoServiceImpl(LoanInfoRepository loanInfoRepository,
                               LoanInfoCalculatedRepository loanInfoCalculatedRepository,
                               ItemInfoRepository itemInfoRepository) {
        this.loanInfoRepository = loanInfoRepository;
        this.loanInfoCalculatedRepository = loanInfoCalculatedRepository;
        this.itemInfoRepository = itemInfoRepository;
    }

    @Override
    public Optional<LoanInfo> get(String id) {
        return Optional.empty();
    }

    @Override
    public List<LoanInfo> getAll() {
        return null;
    }

    @Override
    public void save(LoanInfo entity) {
    }

    @Override
    public void delete(String id) {
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
    public ItemInfo createItemInfo(ItemInfo itemInfo) {
        return itemInfoRepository.save(itemInfo);

    }
}
