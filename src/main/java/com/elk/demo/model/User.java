package com.elk.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private long id;
    private String name;
    private String email;
    private String password;
    private Organisation org;

}