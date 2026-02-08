package com.elk.demo.service.impl;

import com.elk.demo.model.*;
import com.elk.demo.repository.UserRepository;
import com.elk.demo.service.contract.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> response = userMapper.toDtoList(users);
        return response;
    }

    @Override
    public UserResponseDTO getByID(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserResponseDTO> getUserByOrganisation(Organisation type, String name) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getOrg().equals(type) || user.getName().toLowerCase().contains(name))
                .map(userMapper::toDto).toList();
    }

    @Override
    public UserResponseDTO patchuser(UserRequestDTO dto) {
        //return userMapper.toDto(userRepository.patchUser(dto));
        return null;
    }

}
