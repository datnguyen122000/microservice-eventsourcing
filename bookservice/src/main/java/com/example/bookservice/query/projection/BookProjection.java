package com.example.bookservice.query.projection;

import com.example.bookservice.command.data.Book;
import com.example.bookservice.command.data.BookRepository;
import com.example.bookservice.query.model.BookResponseModel;
import com.example.bookservice.query.queries.GetAllBookQuery;
import com.example.bookservice.query.queries.GetBookDetailQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookProjection {

    @Autowired
    private BookRepository bookRepository;

    @QueryHandler
    public List<BookResponseModel> handle(GetAllBookQuery query){
        List<Book> list = bookRepository.findAll();
        List<BookResponseModel> listBookResponse = new ArrayList<>();
        list.forEach(book ->{
            BookResponseModel model = new BookResponseModel();
            BeanUtils.copyProperties(book, model);
            listBookResponse.add(model);
        });
        return listBookResponse;
    }

    @QueryHandler
    public BookResponseModel handle(GetBookDetailQuery query) throws Exception {
        BookResponseModel model = new BookResponseModel();
//        bookRepository.findById(query.getId()).ifPresent(book -> {
//            BeanUtils.copyProperties(book, model);
//        });
        Book book = bookRepository.findById(query.getId()).orElseThrow(()->new Exception("Not found Book with BookId: "+query.getId()));
        BeanUtils.copyProperties(book, model);
        return model;
    }
}
