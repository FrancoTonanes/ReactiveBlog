package com.gozed.blogservice.controller;

import com.gozed.blogservice.entity.User;
import com.gozed.blogservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private static final Logger log = LoggerFactory.getLogger(User.class);

    @GetMapping("/{idUser}")
    public Mono<ResponseEntity<Mono<User>>> obtenerUser(@PathVariable Long idUser){

        Mono<User> userMono = userService.getUser(idUser);

        return userMono
                .flatMap(u -> {
                    return Mono.just(ResponseEntity.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(userMono));

                }).defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @GetMapping
    public Mono<ResponseEntity<Flux<User>>> getUsers(){
        return Mono.just(new ResponseEntity<>(userService.getUsers(), HttpStatus.OK));
    }
    @PostMapping
    public Mono<ResponseEntity<Mono<User>>> createUser(@RequestBody User user){
        return Mono.just(new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED));
    }
}
