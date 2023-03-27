package ua.cats.exceptions;

public class CatNotFoundException extends CatsServiceApplicationException{
    public CatNotFoundException(Long id) {

        super(String.format("Cat with Id %d not found", id));
    }
}
