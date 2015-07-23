package org.suhee.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suhee.demo.entity.Post;

public interface PostDao extends JpaRepository<Post, Integer> {

}