package com.elk.demo.controller;

import com.elk.demo.model.Organisation;
import com.elk.demo.model.UserRequestDTO;
import com.elk.demo.model.UserResponseDTO;
import com.elk.demo.service.contract.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping()
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public UserResponseDTO getUserById(@PathVariable long id) {
        return userService.getByID(id);
    }

    @GetMapping("/filter")
    public List<UserResponseDTO> getUserByOrganisation(@RequestParam String type, @RequestParam String name) {
        return userService.getUserByOrganisation(Organisation.valueOf(type.toUpperCase()), name.toLowerCase());
    }

    @PatchMapping()
    public UserResponseDTO patchUser(@RequestBody UserRequestDTO request) {
        return userService.patchuser(request);
    }

    @GetMapping(value="bytype/{type}")
    public List<UserResponseDTO> getByType(@PathVariable Organisation type) {
        return userService.getByType(type);
    }

    @GetMapping(value="byname/{name}")
    public List<UserResponseDTO> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }


}

