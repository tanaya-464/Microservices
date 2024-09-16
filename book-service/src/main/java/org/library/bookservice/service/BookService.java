package org.library.bookservice.service;


import org.library.bookservice.entity.Book;
import org.library.bookservice.repository.BookRepo;
import org.library.bookservice.response.BookResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    private ModelMapper modelMapper;
    public BookResponse findBookByAuthorID(int authorId){
        Book book = bookRepo.findById(authorId).get();
        BookResponse bookResponse = modelMapper.map(book,BookResponse.class);
        return  bookResponse;

    }
}
