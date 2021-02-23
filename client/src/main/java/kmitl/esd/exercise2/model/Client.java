package kmitl.esd.exercise2.model;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Client used for testing api
 */
@SpringBootApplication
public class Client {

    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Client.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8089"));
        app.run(args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * Main entry point for the client
     * Try calling GET
     */
    @Bean
    public CommandLineRunner runGetAll(RestTemplate restTemplate) throws Exception {
        return args -> {
            String response = callGetAllCustomers(restTemplate);
            log.info(String.format("Get all customers: " + response));
        };
    }

    /**
     * Main entry point for the client
     * Try calling POST
     */
    @Bean
    public CommandLineRunner runCreate(RestTemplate restTemplate) throws Exception {
        return args -> {
            CustomerDTO response = callCreateCustomer(restTemplate, 3L, "yay", 49);
            log.info(String.format("Create customer: " + response));
        };
    }

    /**
     * Main entry point for the client
     * Try calling PUT
     */
    @Bean
    public CommandLineRunner runUpdate(RestTemplate restTemplate) throws Exception {
        return args -> {
            CustomerDTO updatedCustomer = callUpdateCustomer(restTemplate, 1L, "yay", 49);
            String response = callGetAllCustomers(restTemplate);

            log.info(String.format("Updated customer: " + updatedCustomer));
            log.info(String.format("Update and get all customers: " + response));
        };
    }

    /**
     * Main entry point for the client
     * Try calling DELETE
     */
    @Bean
    public CommandLineRunner runDelete(RestTemplate restTemplate) throws Exception {
        return args -> {
            callDeleteCustomer(restTemplate, "1");
            String response = callGetAllCustomers(restTemplate);

            log.info(String.format("Delete and get all customers: " + response));
        };
    }

    /**
     * Call get all customers
     */
    String callGetAllCustomers(RestTemplate restTemplate) {
        StringBuffer url = new StringBuffer("http://localhost:8000/customer");
        String respString = restTemplate.getForObject(
                url.toString(), String.class);

        return respString;
    }

    /**
     * Call create customer
     */
    CustomerDTO callCreateCustomer(RestTemplate restTemplate, Long id, String name, int age) throws JSONException {
        JSONObject data = new JSONObject();
        data.put("id", id);
        data.put("name", name);
        data.put("age", age);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> reqBody = new HttpEntity<>(data.toString(), headers);

        String url = "http://localhost:8000/customer";
        ResponseEntity<CustomerDTO> customer = restTemplate.exchange(url, HttpMethod.POST, reqBody, CustomerDTO.class);

        return customer.getBody();
    }

    /**
     * Call update customer
     */
    CustomerDTO callUpdateCustomer(RestTemplate restTemplate, Long id, String name, int age) throws JSONException {
        JSONObject data = new JSONObject();
        data.put("id", id);
        data.put("name", name);
        data.put("age", age);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> reqBody = new HttpEntity<>(data.toString(), headers);

        String url = "http://localhost:8000/customer";
        ResponseEntity<CustomerDTO> customer = restTemplate.exchange(url, HttpMethod.PUT, reqBody, CustomerDTO.class);

        return customer.getBody();
    }

    /**
     * Call delete customer
     */
    void callDeleteCustomer(RestTemplate restTemplate, String id) {
        String url = "http://localhost:8000/customer/" + id;
        System.out.println(url);
        restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }
}