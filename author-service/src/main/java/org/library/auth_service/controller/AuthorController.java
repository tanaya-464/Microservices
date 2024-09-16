package org.library.auth_service.controller;

import org.library.auth_service.response.AuthorResponse;

import org.library.auth_service.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors/{id}")
    public  ResponseEntity<AuthorResponse> getAuthorDetails(@PathVariable("id")int id){
        AuthorResponse authorResponse=authorService.getAuthorById(id);
        return ResponseEntity.status(HttpStatus.OK).body(authorResponse);
    }

}
