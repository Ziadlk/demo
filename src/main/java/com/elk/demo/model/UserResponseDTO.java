package com.elk.demo.model;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {

    private long id;
    private String name;
    private String email;
    private Organisation org;
    private Set<Role> roles;

}
