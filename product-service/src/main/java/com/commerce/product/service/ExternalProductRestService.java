package com.commerce.product.service;

import com.commerce.product.exception.ExternalProductNotFoundException;
import com.commerce.product.model.ExternalProduct;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Component
public class ExternalProductRestService {

    @Value("${externalProduct.api}")
    private String API_PRODUCTS;

    @Autowired
    @Qualifier("sslRestTemplate")
    private RestTemplate sslRestTemplate;


    public ExternalProduct getProduct(String productId) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("accept", "*/*");
            headers.set("accept-encoding", "gzip, deflate, br");
            headers.set("accept-language", "en-US,en;q=0.9");
            headers.set("cache-control", "max-age=0");

            HttpEntity entity = new HttpEntity(headers);
            ResponseEntity<ExternalProduct> responseEntity = sslRestTemplate.exchange(
                    API_PRODUCTS + productId, HttpMethod.GET,
                    entity,
                    ExternalProduct.class, "");
            System.out.println("Response from external product -->" + responseEntity.getStatusCode());
            return responseEntity.getBody();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExternalProductNotFoundException("External product not found -->" + e.getMessage());
        }
    }

}
