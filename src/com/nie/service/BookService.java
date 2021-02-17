package com.nie.service;/*
 *
 *@auth  wenzhao
 *@date 2021/2/3  18:33
 */

import com.nie.pojo.Book;
import com.nie.pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);


    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
