package ua.micehunt.services;

import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.micehunt.models.Cat;
import ua.micehunt.models.Mouse;
import ua.micehunt.services.okhttp.OkHttpCatsImpl;
import ua.micehunt.services.okhttp.OkHttpMiceImpl;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Optional;

import static ua.micehunt.services.Constants.*;

@Service
@RequiredArgsConstructor
public class HuntService {
    @Autowired
    OkHttpMiceImpl okHttpMice;
    @Autowired
    OkHttpCatsImpl okHttpCats;

    public Optional<Collection<Mouse>> searchForAllMice() {
        Type collectionType = new TypeToken<Collection<Mouse>>() {
        }.getType();
        Collection<Mouse> mice = okHttpMice.okHttpGetCollection(GET_ALL_MICE, collectionType);
        Optional<Collection<Mouse>> mouseListOptional = Optional.of(mice);
        return mouseListOptional;
    }

    public Optional<Mouse> getMouse(Long mouseId) {
        String url = String.format(GET_MOUSE_BY_ID + mouseId + "/catch");
        Type collectionType = new TypeToken<Mouse>() {
        }.getType();
        Mouse mice = okHttpMice.okHttpGet(url, collectionType);
        Optional<Mouse> mouseOptional = Optional.of(mice);
        return mouseOptional;
    }

    public Optional<Mouse> killMouse(Long mouseId) {
        String url = String.format(GET_MOUSE_BY_ID + mouseId + "/kill");
        Type collectionType = new TypeToken<Mouse>() {
        }.getType();
        Mouse mouse = okHttpMice.okHttpPut(url, collectionType);
        Optional<Mouse> mouseOptional = Optional.of(mouse);
        return mouseOptional;
    }
    public Optional<Collection<Cat>> searchForAllCats() {
        Type collectionType = new TypeToken<Collection<Cat>>() {
        }.getType();
        Collection<Cat> cats = okHttpCats.okHttpGetCollection(GET_ALL_CATS, collectionType);
        Optional<Collection<Cat>> catsListOptional = Optional.of(cats);
        return catsListOptional;
    }
    public Optional<Cat> selectCat(Long catId) {
        String url = String.format(GET_CAT_BY_ID + catId);
        Type collectionType = new TypeToken<Cat>() {
        }.getType();
        Cat cat = okHttpCats.okHttpGet(url, collectionType);
        Optional<Cat> catOptional = Optional.of(cat);
        return catOptional;
    }

    public Optional<Collection<Mouse>> searchSpottedMice(Long catId) {
        String url = String.format(GET_SPOTTED_MICE_ + catId + SPOTTED_MICE);
        Type collectionType = new TypeToken<Collection<Mouse>>() {
        }.getType();
        Collection<Mouse> spottedMice = okHttpMice.okHttpGetCollection(url, collectionType);
        Optional<Collection<Mouse>> miceSpottedOptional = Optional.of(spottedMice);
        return miceSpottedOptional;
    }

    public boolean catchSelectedMouse(Optional<Cat> cat, Mouse selectedMouse) {
        return true;
    }

    public Optional<Mouse> setMouseKiller(Long selectedMouseId, Long catId) {
        String url = String.format(SET_MOUSE_KILLER_, selectedMouseId, catId);
        Type collectionType = new TypeToken<Mouse>() {
        }.getType();
        Mouse mouse = okHttpMice.okHttpPost(url, collectionType);
        Optional<Mouse> mouseOptional = Optional.of(mouse);
        return mouseOptional;

    }
}
