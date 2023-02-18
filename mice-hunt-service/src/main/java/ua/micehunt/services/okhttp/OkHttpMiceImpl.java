package ua.micehunt.services.okhttp;

import com.google.gson.Gson;
import com.squareup.okhttp.*;
import org.springframework.stereotype.Service;
import ua.micehunt.models.Mouse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

@Service
public class OkHttpMiceImpl implements OkHttp<Mouse> {
    @Override
    public Collection<Mouse> okHttpGetCollection(String url, Type collectionType) {
        Collection<Mouse> mice;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
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

    public Mouse okHttpGet(String url, Type collectionType) {
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
        Mouse mouse;
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
            mouse = gson.fromJson(responseBody, collectionType);
        } catch (IOException e) {
            //ToDo:Handle
            throw new RuntimeException(e);
        }
        return mouse;
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
