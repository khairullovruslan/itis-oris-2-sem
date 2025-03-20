package ru.itis.khairullovruslan.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.khairullovruslan.dto.request.UserGeneralInfoRequest;
import ru.itis.khairullovruslan.dto.request.UserRequest;
import ru.itis.khairullovruslan.dto.response.UserResponse;
import ru.itis.khairullovruslan.model.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "hashPassword", source = "password")
    UserEntity toEntity(UserRequest userExtendedRequest);

    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "hashPassword", ignore = true)
    UserEntity toEntity(UserGeneralInfoRequest userGeneralInfoRequest);

    UserResponse toResponse(UserEntity userEntity);


}
