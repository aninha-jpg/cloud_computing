package com.pucpr.cloudcomputing.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AzureService {

    private final RestClient restClient;

    public AzureService() {
        this.restClient = RestClient.create();
    }

    public String enviarConfirmacao() {

        return restClient.get()
                .uri("https://funcaojava-a8fvg8b4hjfhg6a9.brazilsouth-01.azurewebsites.net/api/EnviarConfirmacao")
                .retrieve()
                .body(String.class);
    }
}