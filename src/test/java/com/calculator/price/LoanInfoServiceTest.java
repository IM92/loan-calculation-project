package com.calculator.price;

import com.calculator.price.repository.LoanInfoCalculatedRepository;
import com.calculator.price.repository.LoanInfoRepository;
import com.calculator.price.service.LoanInfoService;
import com.calculator.price.service.LoanInfoServiceImpl;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;

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
//    public void exactUrlOnly() throws Exception {
//        stubFor(get(urlEqualTo("/loanInfo/installment-plan"))
//                .withHeader("Accept", equalTo("application/json"))
//                .willReturn(aResponse()
//                        .withStatus(201).withBody(String.valueOf(LoanInfoData.createLoanInfoCalculated()))
//                        .withHeader("Content-Type", "application/json")
//                        .withStatusMessage("Everything was just fine!"))
//                .willReturn(created()));
//
//        String url = "http://localhost:8080/loanInfo/installment-plan";
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpGet request = new HttpGet(url);
//        request.addHeader("Content-Type", "application/json");
//        request.addHeader("Accept", "application/json");
//        HttpResponse response = client.execute(request);
//
//        verify(getRequestedFor(urlPathEqualTo("/loanInfo/installment-plan"))
//                .withHeader("Content-Type", equalTo("application/json")));
//    }
}
