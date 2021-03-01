package com.kbox.snapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kbox.snapi.exception.RecordNotFoundException;
import com.kbox.snapi.model.UserKbx;
import com.kbox.snapi.repository.UserRepository;

/**
 * Service class for User db operations
 * 
 * @author  Omer Yusufoglu
 * @version 1.0
 * @since   2021-02-28 
 *
 */

@Service
public class UserService{

    @Autowired
    UserRepository repository;

    public UserKbx getUserById(Long id) throws RecordNotFoundException {
	Optional<UserKbx> user = repository.findById(id);
	if (user.isPresent()) {
	    return user.get();
	} else {
	    throw new RecordNotFoundException("No user record exist for given id");
	}
    }
    
    public UserKbx save(UserKbx user) throws RecordNotFoundException {
	return repository.save(user);
    }

}
