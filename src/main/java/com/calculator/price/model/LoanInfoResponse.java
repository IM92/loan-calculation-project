package com.calculator.price.model;

import com.calculator.price.model.transfer.ItemInfoDto;
import com.calculator.price.model.transfer.LoanCalculatedDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanInfoResponse implements Serializable {

    private LoanCalculatedDto calculatedDto;
    private List<ItemInfoDto> itemsInfos;

}
