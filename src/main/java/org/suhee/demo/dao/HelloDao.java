package org.suhee.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suhee.demo.entity.Hello;

public interface HelloDao extends JpaRepository<Hello, Integer>{

}
