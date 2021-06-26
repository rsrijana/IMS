package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
