package com.digitalrazgrad.consuming_rest_apis;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class CatFactService {

    public String getCatFact() throws IOException {
        String url = "https://catfact.ninja/fact";

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = client.execute(request)) {
                String line;
                StringBuilder result = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(result.toString());
                return jsonNode.get("fact").asText();
            }
        }
    }
    public String postCatFact(CatFact catFact) throws IOException {
        String url = "https://jsonplaceholder.typicode.com/posts";

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(catFact);

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(url);
            StringEntity entity = new StringEntity(jsonData, ContentType.APPLICATION_JSON);
            request.setEntity(entity);
            try (CloseableHttpResponse response = client.execute(request)) {
                if (response.getCode() == 200) {
                    return "You have send your post request successfully!";
                } else {
                    return "Your post request send a message: "
                            + response.getCode() + " " + response.getReasonPhrase();
                }
            }
        }
    }
}
