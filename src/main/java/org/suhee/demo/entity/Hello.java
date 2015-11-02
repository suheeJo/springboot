package org.suhee.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Hello {
	@Id
	@GeneratedValue
	int id;

	String name;
	
	Date date;
}
