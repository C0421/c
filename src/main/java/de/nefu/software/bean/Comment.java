package de.nefu.software.bean;

public class Comment {
	private int id;
	private int newsId; // 关联的新闻ID
	private String username;
	private String content;
	private String imageUrl; // 评论图片URL
	private String createTime;

	// Getters and Setters
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public int getNewsId() { return newsId; }
	public void setNewsId(int newsId) { this.newsId = newsId; }
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public String getImageUrl() { return imageUrl; }
	public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
	public String getCreateTime() { return createTime; }
	public void setCreateTime(String createTime) { this.createTime = createTime; }
}