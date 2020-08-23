package com.calculator.price;

import com.calculator.price.model.transfer.ItemInfoDto;
import com.calculator.price.model.transfer.LoanCalculatedDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoanInfoResponse implements Serializable {

    private static final long serialVersionUID = -7127381540816398390L;

    private LoanCalculatedDto calculatedDto;
    private List<ItemInfoDto> itemsInfos;
}
