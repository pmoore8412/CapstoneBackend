package com.mooremaking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mooremaking.object.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {

}
