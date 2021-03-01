package com.kbox.snapi.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kbox.snapi.exception.RecordNotFoundException;
import com.kbox.snapi.model.UserKbx;
import com.kbox.snapi.model.UserView;
import com.kbox.snapi.service.UserService;
import com.kbox.snapi.service.UserViewService;

/**
 * Controller class that is for rest api of KBOX SocialNetwork project.
 *
 * @author Omer Yusufoglu
 * @version 1.0
 * @since 2021-02-28
 */
@RestController
@RequestMapping("/api")
public class UserViewController {

    public static final int rowCount = 20;

    @Autowired
    private UserViewService userViewService;

    @Autowired
    private UserService userService;

    /**
     * Assuming viewerUserId parameter is in header of request.
     * Get viewedId from url path and viewer id from header of request with viewerUserId.
     * Return User and save the view record.
     * 
     * @param userId, viewerUserId
     * @return User
     */
    @GetMapping("/profile/{userId}")
    public UserKbx viewProfile(@PathVariable(value = "userId") Long userId, @RequestHeader("viewerUserId") long viewerUserId) 
	    throws Exception {
	// if user that want to be viewed does not exist throws RecordNotFoundException
	UserKbx userKbx = userService.getUserById(userId);

	UserView userView = new UserView(viewerUserId, userId, new Date());
	userViewService.saveView(userView);

	return userKbx;

    }

    /**
     * Get views of user by userId. Method will work with both pageNumber parameter
     * or without it. If pageNumber is not given, default value(0) is used.
     * 
     * @param userId
     * @return List of UserView
     */
    @GetMapping(value = { "/views/{userId}", "/views/{userId}/{pageNumber}" })
    public ResponseEntity<List<UserView>> getViewsByUserId(@PathVariable(value = "userId") Long userId, @PathVariable(value = "pageNumber") Optional<Integer> pageNumber)
	    throws RecordNotFoundException {
	Pageable paging = PageRequest.of(pageNumber.isPresent() ? pageNumber.get() : 0, rowCount);
	List<UserView> userViews = userViewService.getViewsByUserId(userId, paging);
	return ResponseEntity.ok().body(userViews);
    }

}