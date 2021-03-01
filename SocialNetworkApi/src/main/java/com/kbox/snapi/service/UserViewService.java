package com.kbox.snapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kbox.snapi.exception.RecordNotFoundException;
import com.kbox.snapi.model.UserView;
import com.kbox.snapi.repository.UserViewRepository;

/**
 * Service class for UserView db operations
 * 
 * @author  Omer Yusufoglu
 * @version 1.0
 * @since   2021-02-28 
 *
 */

@Service
public class UserViewService{

    @Autowired
    UserViewRepository repository;

    public List<UserView> getViewsByUserId(Long userId, Pageable page) throws RecordNotFoundException {
	Page<UserView> userViewList = repository.getViewsByUserId(userId, page);

	if (!userViewList.isEmpty()) {
	    return userViewList.toList();
	} else {
	    throw new RecordNotFoundException("No view records exist for given userId");
	}
    }

    public UserView saveView(UserView userView) throws Exception {
	userView = repository.save(userView);
	return userView;
    }
    
}
