package com.nxnwebdev.spring5webapp.model.repositories;

import com.nxnwebdev.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by TN on 03/12/2018
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
