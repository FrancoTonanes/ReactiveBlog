package com.gozed.blogservice.service;

import com.gozed.blogservice.entity.User;
import com.gozed.blogservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<User> getUser(Long id) {

        return userRepository.findById(id);
    }

    @Override
    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Flux<User> getUsers() {
        return userRepository.findAll();
    }
}
