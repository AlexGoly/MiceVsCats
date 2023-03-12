package ua.cats.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.cats.dtos.CatDto;
import ua.cats.persistance.entities.Cat;

@Mapper(componentModel = "spring")
public interface CatMapper {

    CatMapper INSTANCE = Mappers.getMapper(CatMapper.class);

    CatDto toDto(Cat cat);

}
