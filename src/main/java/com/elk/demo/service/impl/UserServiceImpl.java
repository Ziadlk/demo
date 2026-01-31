package com.elk.demo.service.impl;

import com.elk.demo.model.*;
import com.elk.demo.repository.UserRepository;
import com.elk.demo.service.contract.UserService;
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
        if (id>userRepository.count() || id<=0){
            return null;
        }
        List<User> users = userRepository.findAll();
        User user = users.get((int)id-1);
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
        return userMapper.toDto(userRepository.patchUser(dto));
    }
}
