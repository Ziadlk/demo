package com.elk.demo.service.contract;

import com.elk.demo.model.Organisation;
import com.elk.demo.model.UserRequestDTO;
import com.elk.demo.model.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getByID(long id);

    List<UserResponseDTO> getUserByOrganisation(Organisation type, String name);

    UserResponseDTO patchuser(UserRequestDTO dto);

    List<UserResponseDTO> getByType(Organisation type);

    List<UserResponseDTO> getByName(String name);
}
