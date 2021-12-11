package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.book.bootrestbook.entities.book;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Component
public class BookServices {
    
    //database service call  --> not create database

    private static List<book> list = new ArrayList<>();

    static{


        list.add(new book(1, "C programming langugae", "denise ritche"));
        list.add(new book(2,"Unix operating system", "Dr. pavan Nangare"));
        list.add(new book(3,"programming like developer", "Dr.  Nangare - Patil"));
    }

    //get all books handeler

    public List<book> getAllBooks()
    {
        return list;

    }

    // get book by id  handeler

    public book getBookByID(int id)
    {
        // collcetiop new java 8 stream

        book book = null;

        try{
            book = list.stream().filter( 
                e->
               e.getId() ==id ).
               
               findFirst().
               get();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
      

        return book;
    }

    //adding the book   --> get handel by handeler = controller -> POST
    public book addBook(book b)
    {
        list.add(b);

        return b;
    }

// delete book
    public void delBook(int id)
    {
        /*
            list = list.stream().filter(book ->
            {
                if(book.getId() != id)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }).collect(Collectors.toList());
            */

            list =list.stream().filter(book ->book.getId() != id).
            collect(Collectors.toList());
    }

    
    // update the book

    public void updateBook(book  book , int id)
    {
        list = list.stream().map(b ->
        {
            if(b.getId() == id)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());

            }
            return b;

        }).collect(Collectors.toList());

    }

}
