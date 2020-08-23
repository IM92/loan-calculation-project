package com.calculator.price.controller.facade;

import com.calculator.price.model.LoanInfoCalculated;
import com.calculator.price.model.transfer.ItemInfoDto;
import com.calculator.price.model.transfer.LoanCalculatedDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanInfoResponse {

    private LoanCalculatedDto loanCalculatedDto;
    private List<ItemInfoDto> itemsInfos;

}
