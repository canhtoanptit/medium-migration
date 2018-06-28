package com.canhtoanptit.ums.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {
    @Id
    private String id;

    private String email;

    private String name;

    private String avatarPath;
}
