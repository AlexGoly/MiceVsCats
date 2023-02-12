package ua.micehunt.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.micehunt.models.Mouse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Optional;

import static ua.micehunt.services.Constants.*;

@Service
@RequiredArgsConstructor
public class HuntService {
    public Optional<Collection<Mouse>> searchForAllMice() {
        Type collectionType = new TypeToken<Collection<Mouse>>() {
        }.getType();
        Collection<Mouse> mice = okHttpGet(HTTP_LOCALHOST_8093_MICE, collectionType);
        Optional<Collection<Mouse>> mouseListOptional = Optional.of(mice);
        return mouseListOptional;
    }

    public Optional<Mouse> catchMouse(Long mouseId) {
        String str = String.format(HTTP_LOCALHOST_8093_MOUSE_BY_ID + mouseId);
        Type collectionType = new TypeToken<Mouse>() {
        }.getType();
        Mouse mice = okHttpGetMouse(str, collectionType);
        Optional<Mouse> mouseListOptional = Optional.of(mice);
        return mouseListOptional;
    }

    public Optional<Mouse> killMouse(Long mouseId) {
        String url = String.format(HTTP_LOCALHOST_8093_MOUSE_BY_ID + mouseId);
        Type collectionType = new TypeToken<Mouse>() {
        }.getType();
        Mouse mouse = okHttpPut(url, collectionType);
        Optional<Mouse> mouseOptional = Optional.of(mouse);
        return mouseOptional;
    }

    public Collection<Mouse> okHttpGet(String url, Type collectionType) {
        Collection<Mouse> collection;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            Gson gson = new Gson();
            collection = gson.fromJson(responseBody, collectionType);
        } catch (IOException e) {
            //ToDo:Handle
            throw new RuntimeException(e);
        }
        return collection;
    }


    public Mouse okHttpGetMouse(String url, Type collectionType) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Mouse mouse;
        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            Gson gson = new Gson();
            mouse = gson.fromJson(responseBody, collectionType);
        } catch (IOException e) {
            //ToDo:Handle
            throw new RuntimeException(e);
        }
        return mouse;
    }

    public Mouse okHttpPost(String url, Type collectionType) {
        Mouse mice;
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("text/plain");
        String requestBody = String.valueOf(Mouse.class);
        RequestBody body = RequestBody.create(mediaType, requestBody);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            Gson gson = new Gson();
            mice = gson.fromJson(responseBody, collectionType);
        } catch (IOException e) {
            //ToDo:Handle
            throw new RuntimeException(e);
        }
        return mice;
    }

    public Mouse okHttpPut(String url, Type collectionType) {
        String responseBody;
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(url)
                .method("PUT", body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        return gson.fromJson(responseBody, collectionType);
    }
}
