package com.mooremaking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mooremaking.object.Posts;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {

}
