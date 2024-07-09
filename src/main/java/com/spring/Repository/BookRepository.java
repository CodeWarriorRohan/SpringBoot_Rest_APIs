package com.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.Entity.Books;

public interface BookRepository extends CrudRepository<Books, Integer>{

	public Books findById(int id);
}
