package com.calculator.price;

import com.calculator.price.model.LoanInfo;
import com.calculator.price.model.LoanInfoCalculated;
import com.calculator.price.repository.LoanInfoCalculatedRepository;
import com.calculator.price.repository.LoanInfoRepository;
import com.calculator.price.service.LoanInfoService;
import com.calculator.price.service.LoanInfoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LoanInfoControllerTests{

    @Autowired
    private MockMvc mockMvc;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private LoanInfoService loanInfoService;
    private LoanInfoRepository loanInfoRepository;
    private LoanInfoCalculatedRepository loanInfoCalculatedRepository;
    private LoanInfo loanInfo;

    @Before
    public void setUp() {
        loanInfoRepository = mock(LoanInfoRepository.class);
        loanInfoCalculatedRepository = mock(LoanInfoCalculatedRepository.class);
        loanInfoService = new LoanInfoServiceImpl(
                loanInfoRepository,
                loanInfoCalculatedRepository
        );
        loanInfo = LoanInfoData.createLoanInfo();
    }

    @Test
    public void testLoanInfoCreate() throws Exception {
        String url = "/loanInfo/installment-plan";

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson= ow.writeValueAsString(loanInfo);

        mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isCreated());
    }



    @Test
    public void should_create_new_loan_info() {
        //given
        LoanInfo loanInfo = LoanInfoData.createLoanInfo();
        //when
        loanInfoService.createLoanInfo(loanInfo);
        //then
        verify(loanInfoRepository,times(1)).save(any(LoanInfo.class));
    }

    @Test
    public void should_create_new_loan_info_calculated() {
        //given
        LoanInfoCalculated calculated = LoanInfoData.createLoanInfoCalculated();
        //when
        loanInfoService.createLoanInfoCalculated(calculated);
        //then
        verify(loanInfoCalculatedRepository,times(1)).save(any(LoanInfoCalculated.class));
    }

}
