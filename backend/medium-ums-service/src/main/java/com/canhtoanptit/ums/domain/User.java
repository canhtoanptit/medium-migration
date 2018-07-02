package com.canhtoanptit.ums.domain;

import lombok.Data;

@Data
public class User {
    private String id;

    private String email;

    private String name;

    private String description;

    private String avatarPath;
}
