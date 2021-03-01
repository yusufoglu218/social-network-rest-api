package com.kbox.snapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class for USER_KBX db table.
 *
 * @author Omer Yusufoglu
 * @version 1.0
 * @since 2021-02-28
 */
@Entity
@Table(name = "USER_KBX")
public class UserKbx {

    private long userId;
    private String firstName;
    private String lastName;

    public UserKbx(long userId, String firstName, String lastName) {
	super();
	this.userId = userId;
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public UserKbx() {
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
	return userId;
    }

    public void setUserId(long user_id) {
	this.userId = user_id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

}