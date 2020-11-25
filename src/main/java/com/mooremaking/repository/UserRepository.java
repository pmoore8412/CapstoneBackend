package com.mooremaking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mooremaking.object.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{

}
