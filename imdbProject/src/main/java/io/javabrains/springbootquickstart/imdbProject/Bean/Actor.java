package io.javabrains.springbootquickstart.imdbProject.Bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Actor {
	
	@Id @GeneratedValue
	private int actor_Id;
	private String name;
	private String sex;
	private Date dob;
	private String bio;
	
	
	public Actor(){
		
	}
	
	public Actor(int actorId, String name, String sex, Date dob, String bio) {
		super();
		this.actor_Id = actorId;
		this.name = name;
		this.sex = sex;
		this.dob = dob;
		this.bio = bio;
	}
	public int getActorId() {
		return actor_Id;
	}
	public void setActorId(int actorId) {
		this.actor_Id = actorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = Date.valueOf(dob);
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
	

}
