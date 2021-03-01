package com.kbox.snapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kbox.snapi.model.UserKbx;

/**
* Repository interface for User db operations.
*
* @author  Omer Yusufoglu
* @version 1.0
* @since   2021-02-28 
*/
@Repository
public interface UserRepository extends JpaRepository<UserKbx, Long> {

    /**
     * Get views of user by userId
     * @param userId         
     * @return List of UserKbx
     */
    @Query("select s from UserKbx s where s.userId = :userId")
    List<UserKbx> findViewsByUserId(@Param("userId") Long userId);
    
}
