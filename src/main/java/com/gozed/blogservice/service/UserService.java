package com.gozed.blogservice.service;

import com.gozed.blogservice.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UserService {
    Mono<User> getUser(Long id);
    Mono<User> createUser(User user);
    Flux<User> getUsers();
}
