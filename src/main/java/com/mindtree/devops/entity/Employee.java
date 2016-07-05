package com.mindtree.devops.entity;

public class Employee {

	String name;
	int age;
	String gender;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}

	



	

}
