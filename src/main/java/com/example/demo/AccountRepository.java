package com.example.demo;

import java.util.List;

import com.example.demo.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccountRepository extends MongoRepository<Account, String> {
}