package com.kbox.snapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
* Model class for USER_VIEW db table.
*
* @author  Omer Yusufoglu
* @version 1.0
* @since   2021-02-28 
*/
@Entity
@Table(name = "USER_VIEW")
public class UserView {

    private long id;
    private long viewerId;
    private long viewedId;
    private Date viewDate;

    public UserView() {
    }

    public UserView(long viewerId, long viewedId, Date viewDate) {
	super();
	this.viewerId = viewerId;
	this.viewedId = viewedId;
	this.viewDate = viewDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    @Column(name = "viewer_id", nullable = false)
    public long getViewerId() {
	return viewerId;
    }

    public void setViewerId(long viewerId) {
	this.viewerId = viewerId;
    }

    @Column(name = "viewed_id", nullable = false)
    public long getViewedId() {
	return viewedId;
    }

    public void setViewedId(long viewedId) {
	this.viewedId = viewedId;
    }

    @Column(name = "view_date", nullable = false)
    public Date getViewDate() {
	return viewDate;
    }

    public void setViewDate(Date viewDate) {
	this.viewDate = viewDate;
    }

}