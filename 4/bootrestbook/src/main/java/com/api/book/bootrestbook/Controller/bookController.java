package com.api.book.bootrestbook.Controller;

import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.entities.book;
import com.api.book.bootrestbook.services.BookServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController
public class bookController{

    @Autowired
    private BookServices bookServices;
/*      // METHOD 1)
    // @RequestMapping(value = "/book", method = RequestMethod.GET)
    @GetMapping("/books")
    public List<book> getBooks()
    {

        /*

        book obj = new book();        
        obj.setId(88);
        obj.setTitle("chatt. shivaji maharaj");
        obj.setAuthor("Shivaji desai");
            
        // return "this is testing book project";

        return this.bookServices.getAllBooks();
    }
*/

    @GetMapping("/books")
    public ResponseEntity<List<book>> getBook()
    {
        List<book>  list  = bookServices.getAllBooks();
        if(list.size() <= 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<book> getBook(@PathVariable("id") int id)
    {
        book book = bookServices.getBookByID(id);

        if(book == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //for each
        // return bookServices.getBookByID(id);        old one

        return ResponseEntity.of(Optional.of(book));
    }

    // create
    @PostMapping("/books")
   public ResponseEntity<book> addBook(@RequestBody book book)
   {
        // book b = this.bookServices.addBook(book);

        book b = null;

        try{
             b = this.bookServices.addBook(book);
             System.out.println(book);

             return ResponseEntity.status(HttpStatus.CREATED).build();

        }
        catch(Exception e)
        {
             e.printStackTrace();

             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


        // System.out.println(book);
        // return b;
   }

       // delete book  handeler

       @DeleteMapping("books/{id}")
       public ResponseEntity<Void> delBook(@PathVariable("id") int id)
       {

        try {
            this.bookServices.delBook(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
          
       }


       // update book  handeler

    
    @PutMapping("books/{id}")
    public ResponseEntity<book> updateBook(@RequestBody book book,@PathVariable ("id") int id)
    {

        try {
            this.bookServices.updateBook(book, id);

            return ResponseEntity.ok().body(book);

        } catch (Exception e) {
           
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

            // return book;
    }
} 