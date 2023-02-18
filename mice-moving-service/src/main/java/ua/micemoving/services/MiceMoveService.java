package ua.micemoving.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.micemoving.model.Mouse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static ua.micemoving.services.Constants.*;

@Service
@RequiredArgsConstructor
public class MiceMoveService {
    @Autowired
    MiceLocation miceLocation;

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

    public Optional<Collection<Mouse>> spottedMice(Optional<Collection<Mouse>> mice) {
        //ToDo: Make method for get cat position
        int catLatitude = 50;
        int catLongitude = 50;
        List<Mouse> miceSetPositions = mice.get().stream().toList();
        for (Mouse mouse : miceSetPositions) {
            mouse.setLatitude(miceLocation.getMousePosition().x);
            mouse.setLongitude(miceLocation.getMousePosition().y);
        }

        List<Mouse> aliveMice = miceSetPositions.stream().filter(mice1 -> !mice1.getIsDead()).toList();
        List<Mouse> spottedMice = new ArrayList<>();
        for (Mouse mouse : aliveMice) {
            if (mouse.getLatitude() <= catLatitude + 20 && mouse.getLatitude() >= catLatitude - 20
                    || mouse.getLongitude() <= catLongitude + 20 && mouse.getLongitude() >= catLongitude - 20) {
                spottedMice.add(mouse);
            }
        }
        Optional<Collection<Mouse>> spottedMiceOptional = Optional.of(spottedMice);
        return spottedMiceOptional;
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
    public Optional<Mouse> setMouseKiller(Long mouseId,Long killerId) {
        String url = String.format(SET_MOUSE_KILLER, mouseId,killerId);
        Type collectionType = new TypeToken<Mouse>() {
        }.getType();
        Mouse mouse = okHttpPut(url, collectionType);
        Optional<Mouse> mouseOptional = Optional.of(mouse);
        return mouseOptional;
    }
}
