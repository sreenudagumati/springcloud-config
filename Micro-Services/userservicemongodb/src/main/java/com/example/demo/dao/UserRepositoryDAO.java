package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.UserDO;

@Repository
public interface UserRepositoryDAO  extends MongoRepository<UserDO, String>{

}
