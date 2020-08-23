package com.calculator.price;

import com.calculator.price.repository.LoanInfoCalculatedRepository;
import com.calculator.price.repository.LoanInfoRepository;
import com.calculator.price.service.LoanInfoService;
import com.calculator.price.service.LoanInfoServiceImpl;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PortConfiguration.class)
@AutoConfigureWireMock
public class LoanInfoServiceTest {

    private LoanInfoCalculatedRepository loanInfoCalculatedRepository;
    private LoanInfoRepository loanInfoRepository;
    private LoanInfoService loanInfoService;

    @Before
    public void setUp() {
        loanInfoRepository = mock(LoanInfoRepository.class);
        loanInfoCalculatedRepository = mock(LoanInfoCalculatedRepository.class);
        loanInfoService = new LoanInfoServiceImpl(
                loanInfoRepository,
                loanInfoCalculatedRepository
        );
    }

//    @Test
//    public void testCreateLoanInfo() {
//        final String userCreationPath = "/loanInfo/installment-plan";
//        WireMock.stubFor(post(userCreationPath).willReturn(created()));
//        this.loanInfoService.createLoanInfoCalculated(LoanInfoData.createLoanInfoCalculated());
//        verify(exactly(1), getRequestedFor(urlPathEqualTo(userCreationPath)));
//    }
//
//    @Test
//    public void exactUrlOnly() {
//        stubFor(post(urlEqualTo("/loanInfo/installment-plan"))
//                .willReturn(aResponse()
//                        .withHeader("Content-Type", "application/json")
//                        .withBody(String.valueOf(LoanInfoData.createLoanInfoCalculated()))));
//
//        verify(exactly(1), postRequestedFor(urlEqualTo("/loanInfo/installment-plan")));
//    }
}
