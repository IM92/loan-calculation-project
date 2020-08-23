package com.calculator.price;

import com.calculator.price.model.LoanInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.calculator.price.FileUtil.readFileContent;
import static org.apache.http.impl.client.HttpClients.createDefault;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractApiTest {

    protected CloseableHttpClient client;
    protected ObjectMapper objectMapper = new ObjectMapper();

    protected CurrentEnv currentEnv;
    protected static final String CONTENT_TYPE = "Content-Type";
    protected static final String APPLICATION_JSON = "application/json";
    protected static final String API_PUBLIC_V_1_LOAN_INFO ="/secure/loanInfo/installment-plan";


    @Before
    public void setUp() throws Exception {
        String env = System.getProperty("e2e.env");
        if (env == null) {
            System.out.println("Testing on localhost");
            currentEnv = CurrentEnv.LOCALHOST;
        } else {
            throw new EndToEndTestException("No valid environment found for: " + env);
        }
        client = createDefault();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @After
    public void tearDown() throws Exception {
        client.close();
    }

    protected LoanInfo createLoanInfo() throws IOException {
        String requestBody = readFileContent("loan-info.json");
        HttpPost httpPost = new HttpPost(currentEnv.getHost() + API_PUBLIC_V_1_LOAN_INFO);
        httpPost.setHeader(CONTENT_TYPE, APPLICATION_JSON);
        httpPost.setEntity(new StringEntity(requestBody));

        // when
        CloseableHttpResponse response = client.execute(httpPost);

        // then
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(201);
        response.close();

        return getLoanInfo();
    }

    protected LoanInfo getLoanInfo() throws IOException {

        String url = currentEnv.getHost() + String.format(API_PUBLIC_V_1_LOAN_INFO);
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(CONTENT_TYPE, APPLICATION_JSON);

        CloseableHttpResponse httpResponse = client.execute(httpGet);
        LoanInfo loanInfo = objectMapper.readValue(extractBodyAsString(httpResponse), LoanInfo.class);
        httpResponse.close();
        return loanInfo;
    }

    protected CloseableHttpResponse httpPOST(String uri, String body) throws IOException {
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setHeader(CONTENT_TYPE, APPLICATION_JSON);
        httpPost.setEntity(new StringEntity(body));

        return client.execute(httpPost);
    }

    protected String extractBodyAsString(CloseableHttpResponse response) throws IOException {
        String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        System.out.println(responseString);
        return responseString;
    }

    protected  <T> T readResponseData(String body, Class<T> type) throws IOException {
        return objectMapper.readValue(body, type);
    }

    protected  Object readResponseData(String body, TypeReference t) throws IOException {
        return objectMapper.readValue(body, t);
    }

    protected  <T> T readResponseData(CloseableHttpResponse response, Class<T> type) throws IOException {
        return objectMapper.readValue(extractBodyAsString(response), type);
    }

    protected <T> List<T> readResponseDataList(CloseableHttpResponse response, Class<T> type) throws IOException {
        return objectMapper.readValue(
                extractBodyAsString(response),
                objectMapper.getTypeFactory().constructCollectionType(List.class, type));
    }

    public enum CurrentEnv {
        LOCALHOST(
                "http://localhost:8080",
                new JDBCProperties(
                        "jdbc:mysql://localhost:3306/kdbname?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false",
                        "kdbuser",
                        "kdbpass"));

        private final String host;
        private final JDBCProperties jdbcProperties;

        CurrentEnv(String s, JDBCProperties jdbcProperties) {
            this.host = s;
            this.jdbcProperties = jdbcProperties;
        }

        public String getHost() {
            return host;
        }

        public JDBCProperties getJdbcProperties() {
            return jdbcProperties;
        }

        @AllArgsConstructor
        @Getter
        public static class JDBCProperties {
            private String jdbcUrl;
            private String userName;
            private String password;
        }
    }
}
