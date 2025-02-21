package uk.co.sprbootprojs.ai.chatgem.web;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.sprbootprojs.ai.chatgem.service.GeminiChatService;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@AllArgsConstructor
public class GeminiChatController {
    private final GeminiChatService geminiChatService;

    @PostMapping
    public ResponseEntity<String> askQuestion(@RequestBody Map<String, String> payload) {
        String question = payload.getOrDefault("question", "what is google gemini ai?");
        String answer = geminiChatService.getAnswer(question);
        return ResponseEntity.ok(answer);
    }
}