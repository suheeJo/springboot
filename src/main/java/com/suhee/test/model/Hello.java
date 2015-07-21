package com.suhee.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // DB의 데이터 모델은 JPA에서 Entity로 표현된다.
public class Hello {
	@Id // primarykey
	@GeneratedValue // Id 값의 생성 방법을 정의한다. 
	int id;
	
	String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
