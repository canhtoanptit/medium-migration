package com.canhtoanptit.ums.repository;

import com.canhtoanptit.ums.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
