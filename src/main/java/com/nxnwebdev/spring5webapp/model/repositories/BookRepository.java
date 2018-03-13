package com.nxnwebdev.spring5webapp.model.repositories;

import com.nxnwebdev.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by TN on 03/2018.
 */
public interface BookRepository extends CrudRepository<Book, Long>{
}
