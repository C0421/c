package de.nefu.software.bean;

import java.time.LocalDateTime;

public class News {
	private int id;
	private String title;
	private String content;
	private String type;
	private String create_time; // 使用String以方便JSON传输
	private String coverImage;

	// Getters and Setters
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	public String getCreate_time() { return create_time; }
	public void setCreate_time(String create_time) { this.create_time = create_time; }
	public String getCoverImage() {return coverImage;}
	public void setCoverImage(String coverImage) {this.coverImage = coverImage;}
}