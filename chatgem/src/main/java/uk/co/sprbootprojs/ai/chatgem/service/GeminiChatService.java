package uk.co.sprbootprojs.ai.chatgem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class GeminiChatService {
    @Value("${gemini.api.url}")
    private String geminiAPIUrl;

    @Value("${gemini.api.key}")
    private String geminiAPIKey;

    private final WebClient webClient;

    public GeminiChatService(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    public String getAnswer(String question) {
        Map<String, Object> payload = Map.of("contents", new Object[]{
                Map.of("parts", new Object[]{
                        Map.of("text", question)
                })
        });

        return webClient.post()
                .uri(geminiAPIUrl + geminiAPIKey)
                .header("Content-Type", "application/json")
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

/*
{
    "contents": [
        {
            "parts": [
                {
                    "text": "are eggs vegetarian?"
                }
            ]
        }
    ]
}
 */