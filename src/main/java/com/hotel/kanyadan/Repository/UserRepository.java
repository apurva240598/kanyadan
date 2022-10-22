package com.hotel.kanyadan.Repository;

import com.hotel.kanyadan.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

}
