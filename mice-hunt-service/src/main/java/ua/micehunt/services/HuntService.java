package ua.micehunt.services;

import com.google.gson.Gson;
import com.squareup.okhttp.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.miceservice.model.Mouse;
import ua.miceservice.services.MiceService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
//@AllArgsConstructor
public class HuntService {
    private final MiceService miceService;


    public Optional<List<Mouse>> searchForAllMice() {
        // ToDo: Get From Mice microservice list of all mice.
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://localhost:8092/api/v1/hunter/mice")
                .method("GET", body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            Gson gson = new Gson();
            gson.fromJson(responseBody, Mouse.class);
        } catch (IOException e) {
            //ToDo:Handle
            throw new RuntimeException(e);
        }
        Optional<List<Mouse>> mouseList = Optional.of(miceService.getAllMice());
        return mouseList;
    }

    public Optional<Mouse> catchMouse(Long mouseId) {
//        ToDo: Get mouse by id from microservice
        Optional<Mouse> mouse = miceService.getMouseById(mouseId);
        return mouse;
    }
}
