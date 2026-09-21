package com.cofrge.training.hibernateweb.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  private String name;
	  
	  @ElementCollection
	  @CollectionTable(name="user_skills",joinColumns= @JoinColumn(name="user_id"))
	  @Column(name="skill")
	  private List<String> skills=new ArrayList<>();

	  // getters and setters (unchanged)
	  public int getId() { return id; }
	  public String getName() { return name; }
	  public List<String> getSkills() { return skills; }
	  public void setId(int id) { this.id = id; }
	  public void setName(String name) { this.name = name; }
	  public void setSkills(List<String> skills) { this.skills = skills; }
}