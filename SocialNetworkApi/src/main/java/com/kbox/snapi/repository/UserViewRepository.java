package com.kbox.snapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kbox.snapi.model.UserView;

/**
* Repository interface for UserView db operations.
*
* @author  Omer Yusufoglu
* @version 1.0
* @since   2021-02-28 
*/
@Repository
public interface UserViewRepository extends JpaRepository<UserView, Long>{
    
    /**
     * Get views of user by userId, dateCriteria and rowCount 
     * @param userId, dateCriteria and rowCount          
     * @return List of UserView
     */
    @Query("select s from UserView s where s.viewedId = :userId order by viewDate desc")
    Page<UserView> getViewsByUserId(@Param("userId") Long userId, Pageable page);
    
  
}