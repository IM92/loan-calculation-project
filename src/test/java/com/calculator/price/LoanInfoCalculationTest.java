package com.calculator.price;

import com.calculator.price.model.LoanInfo;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


import static com.calculator.price.FileUtil.readFileContent;
import static org.assertj.core.api.Assertions.assertThat;

public class LoanInfoCalculationTest extends AbstractApiTest {

    private LoanInfo loanInfo;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        loanInfo = createLoanInfo();
    }

    @Test
    public void should_add_and_delete_loan_info() throws IOException {
        String requestBody = readFileContent("loan-info-dto.json");
        CloseableHttpResponse response =
                httpPOST(currentEnv.getHost() + String.format(API_PUBLIC_V_1_LOAN_INFO),
                        requestBody);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(201);

        String loanInfoDto = extractBodyAsString(response);

        LoanInfoResponse loanInfoResponse = readResponseData(loanInfoDto, LoanInfoResponse.class);

        response.close();
        assertThat(loanInfoResponse.getCalculatedDto()).isNotNull();
    }
}
