package com.e8.entity;

import java.time.LocalDateTime;

public class User {
	private String id;
	private String name;
	private LocalDateTime insertTime;

	// 添加一个无参构造函数，这是JavaBeans的良好实践
	public User() {
	}

	public User(String id, String name, LocalDateTime insertTime) {
		this.id = id;
		this.name = name;
		this.insertTime = insertTime;
	}

	// --- Getters and Setters ---
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public LocalDateTime getInsertTime() { return insertTime; }
	public void setInsertTime(LocalDateTime insertTime) { this.insertTime = insertTime; }
}