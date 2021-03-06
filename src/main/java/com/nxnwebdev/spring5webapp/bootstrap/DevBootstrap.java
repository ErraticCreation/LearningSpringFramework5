package com.nxnwebdev.spring5webapp.bootstrap;

import com.nxnwebdev.spring5webapp.model.Author;
import com.nxnwebdev.spring5webapp.model.Book;
import com.nxnwebdev.spring5webapp.model.Publisher;
import com.nxnwebdev.spring5webapp.model.repositories.AuthorRepository;
import com.nxnwebdev.spring5webapp.model.repositories.BookRepository;
import com.nxnwebdev.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by TN on 03/2018.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher harperCollins = new Publisher();
        harperCollins.setName("Harper Collins");
        publisherRepository.save(harperCollins);

        Publisher worx = new Publisher();
        worx.setName("Worx");
        publisherRepository.save(worx);

        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","1234" , harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book( "J2EE Development without EJB", "2344", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
