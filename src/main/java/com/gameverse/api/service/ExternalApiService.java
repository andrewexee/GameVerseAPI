package com.gameverse.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {

    @Value("${thegamesdb.apiKey}")
    private String apiKey;

    @Value("${thegamesdb.api.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public ExternalApiService() {
        this.restTemplate = new RestTemplate();
    }

    public String getPortadaUrl(String nombreJuego) {
        try {
            // Es vital que baseUrl y apiKey no sean null (ahora Spring los llenará)
            String url = String.format("%s/Games/ByGameName?apikey=%s&name=%s",
                    baseUrl, apiKey, nombreJuego);

            // Aquí deberías hacer la llamada real con restTemplate más adelante
            return "https://cdn.thegamesdb.net/images/medium/boxart/example.jpg";
        } catch (Exception e) {
            return "https://via.placeholder.com/150?text=No+Image";
        }
    }
}