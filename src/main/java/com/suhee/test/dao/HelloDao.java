package com.suhee.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suhee.test.model.Hello;

public interface HelloDao extends JpaRepository<Hello, Integer>{

}
