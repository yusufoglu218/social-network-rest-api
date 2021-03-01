package com.kbox.snapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.kbox.snapi.model.UserKbx;
import com.kbox.snapi.model.UserView;
import com.kbox.snapi.service.UserService;

/**
 * Controller test class for unit test.
 * 
 * @author  Omer Yusufoglu
 * @version 1.0
 * @since   2021-02-28 
 *
 */
public class UserViewControllerTest extends AbstractTest {

    @Autowired
    private UserService userService;

    UserKbx testUserViewer = new UserKbx(303030, "gedson", "alonso");
    UserKbx testUserViewed = new UserKbx(404040, "richard", "bale");

    @Override
    @Before
    public void setUp() {
	super.setUp();
    }

    @Test
    public void testUserProfile() throws Exception {
	userService.save(testUserViewer);
	userService.save(testUserViewed);

	String uri = "/api/profile/" + testUserViewed.getUserId();
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).header("viewerUserId", testUserViewed.getUserId()).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

	int status = mvcResult.getResponse().getStatus();
	assertEquals(200, status);
	String content = mvcResult.getResponse().getContentAsString();
	UserKbx userKbx = super.mapFromJson(content, UserKbx.class);
	assertTrue(userKbx.getFirstName().equals(testUserViewed.getFirstName()));
    }

    @Test
    public void testViewList() throws Exception {
	String uri = "/api/views/" + testUserViewed.getUserId();
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

	int status = mvcResult.getResponse().getStatus();
	assertEquals(200, status);
	String content = mvcResult.getResponse().getContentAsString();
	UserView[] productlist = super.mapFromJson(content, UserView[].class);
	assertTrue(productlist.length > 0);
    }

}