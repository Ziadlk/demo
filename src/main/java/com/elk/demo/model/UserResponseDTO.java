package com.elk.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {

    private long id;
    private String name;
    private String email;
    private Organisation org;

}
