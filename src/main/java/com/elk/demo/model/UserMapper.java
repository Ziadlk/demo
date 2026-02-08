package com.elk.demo.model;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toDto(User user);
    List<UserResponseDTO> toDtoList(List<User> users);
}
