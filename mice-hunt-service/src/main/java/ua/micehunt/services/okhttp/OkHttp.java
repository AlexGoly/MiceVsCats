package ua.micehunt.services.okhttp;

import ua.micehunt.models.Mouse;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Optional;

public interface OkHttp<T> {
    Collection<T> okHttpGetCollection(String url, Type collectionType);
  T okHttpGet(String url, Type collectionType);
}
