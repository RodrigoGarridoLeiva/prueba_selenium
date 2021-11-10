package com.puentedigital.multiposting.dto.mappers;

import com.puentedigital.multiposting.dao.entities.UserEntity;
import com.puentedigital.multiposting.dto.entities.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, UserEntity> {

}
