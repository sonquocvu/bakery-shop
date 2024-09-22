package com.sonvu.springboot.bakeryshop.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class AdminService {

	@Value("${imgur.client-id}")
	private String clientId;
	
	@Value("${imgur.client-secret}")
	private String clientSecret;
	
	private String accessToken;
	
	private final String IMGUR_API_URL = "https://api.imgur.com/3/image";
	private final String IMGUR_TOKEN_URL = "https://api.imgur.com/oauth2/token";
	
	public String getAccessToken() throws Exception
	{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
        // Prepare the body as a URL-encoded string
//        String body = "client_id=" + URLEncoder.encode(clientId, StandardCharsets.UTF_8) +
//                      "&client_secret=" + URLEncoder.encode(clientSecret, StandardCharsets.UTF_8) +
//                      "&grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8);
        
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("grant_type", "client_credentials");
		
        //HttpEntity<String> requestEntity = new HttpEntity<>(body, httpHeaders);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, httpHeaders);

        ResponseEntity<Map> responseEntity = restTemplate.exchange(
                IMGUR_TOKEN_URL, HttpMethod.POST, requestEntity, Map.class);

        Map<String, Object> responseBody = responseEntity.getBody();

        // Extract access token from the response
        if (responseBody != null && responseBody.containsKey("access_token"))
        {
            this.accessToken = responseBody.get("access_token").toString();
        }
        else 
        {
            throw new Exception("Failed to obtain access token from Imgur");
        }    

        return accessToken;
	}
	
    public String uploadImage(MultipartFile imageFile) throws Exception 
    {
        if (accessToken == null || accessToken.isEmpty()) 
        {
            getAccessToken();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken); // Use the access token
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        byte[] imageBytes = imageFile.getBytes();
        String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("image", imageBase64);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                IMGUR_API_URL, HttpMethod.POST, requestEntity, String.class);
        
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> responseBody = objectMapper.readValue(response.getBody(), Map.class);

        Map<String, Object> data = (Map<String, Object>) responseBody.get("data");
        String imageUrl = (String) data.get("link");
        
        return imageUrl;
    }
}
