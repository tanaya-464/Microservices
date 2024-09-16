package org.library.bookservice.controller;


import org.library.bookservice.response.BookResponse;
import org.library.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/book/{authorId}")
    public ResponseEntity<BookResponse> getBookByAuthor(@PathVariable("authorId")int id){
        BookResponse bookResponse=bookService.findBookByAuthorID(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponse);
    }
}
