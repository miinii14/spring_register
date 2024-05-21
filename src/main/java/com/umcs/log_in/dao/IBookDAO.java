package com.umcs.log_in.dao;

import com.umcs.log_in.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookDAO {
    Optional<Book> getById(int id);
    List<Book> getAll();
    void saveOrUpdate(Book book);
    void delete(int id);
}
