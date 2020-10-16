package com.lb.dbservice.repository;

import com.lb.dbservice.entity.LBUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<LBUser, Integer> {

}
