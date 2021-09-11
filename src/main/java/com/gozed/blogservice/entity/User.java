package com.gozed.blogservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@Builder
public class User {

    @Id
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate lastAccessed;

    private Boolean is_staff;
    private Boolean is_admin;
    private Boolean is_mod;

    public User(){
        this.is_admin = false;
        this.is_mod = false;
        this.is_staff = false;
    }


}
