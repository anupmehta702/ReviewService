package com.commerce.product.configuration;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Configuration
public class RestTemplateConfig {


    @Bean("SSLRestTemplate")
    public RestTemplate SSLRestTemplate() throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String password="changeit";
        SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(ResourceUtils.getFile("classpath:addidas.jks"),password.toCharArray())
                .build();
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);

        HttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .build();

        return new RestTemplateBuilder()
                .requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient))
                .build();
    }

    @Primary
    @Bean("httpRestTemplate")
    public RestTemplate httpRestTemplate(){
        return new RestTemplate();
    }
}
