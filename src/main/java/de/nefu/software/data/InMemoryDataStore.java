package de.nefu.software.data;

import de.nefu.software.bean.Comment;
import de.nefu.software.bean.News;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryDataStore {

	private static final List<News> newsList = new CopyOnWriteArrayList<>();
	private static final List<Comment> commentList = new CopyOnWriteArrayList<>();
	private static final AtomicInteger newsIdCounter = new AtomicInteger(100);
	private static final AtomicInteger commentIdCounter = new AtomicInteger(100);
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	static {
		// 初始化新闻和公告数据
		initializeNews();
		// 初始化评论数据
		initializeComments();
	}

	private static void initializeNews() {
		newsList.add(createNews(1, "第38次 CCF CSP 认证报名通知", "2025-05-12", "announcement", "images/news/csp.png", "<h3>关于举办第38次CCF CSP认证的通知</h3><p>各相关同学：第38次CCF CSP认证将于...举行，这是检验算法和编程能力的绝佳机会。认证成绩优异者在保研和求职中具有显著优势。请有意参加的同学仔细阅读官网的认证须知，并于截止日期前完成在线报名和缴费。</p>"));
		newsList.add(createNews(2, "关于《东北林业大学本科教育教学审核评估自评报告》公示的通知", "2025-04-25", "announcement", "images/news/nefu-report.png", "<p>根据教育部关于新一轮本科教育教学审核评估工作的统一安排，我校已完成《东北林业大学本科教育教学审核评估自评报告》。现面向全校师生进行公示，广泛征求意见。公示期为...，如有任何意见或建议，请通过...方式反馈。</p>"));
		newsList.add(createNews(3, "关于2025年上半年全国计算机等级考试报名的通知", "2025-02-28", "announcement", "images/news/ncre.png", "<p>2025年上半年全国计算机等级考试（NCRE）报名工作即将开始。本次考试涵盖二级C语言、二级Java、三级网络技术、四级网络工程师等多个科目。请同学们根据个人需求，在规定时间内登录报名系统完成报名。</p>"));
		newsList.add(createNews(4, "第四届高校电气电子工程创新大赛报名通知", "2025-02-28", "news", "images/news/innovation-contest.png", "<p>为激发大学生在电气电子领域的创新潜力，第四届高校电气电子工程创新大赛现已启动。本届大赛设置了“智能硬件设计”和“嵌入式系统应用”等赛道，鼓励跨学科组队。欢迎我院同学积极参与，展示才华。</p>"));
		newsList.add(createNews(5, "2025年第18届中国大学生计算机设计大赛校内选拔赛通知", "2025-01-10", "news", null, "<p>被誉为“计算机奥运会”的中国大学生计算机设计大赛，其校内选拔赛即将拉开帷幕。参赛作品类别包括软件应用与开发、微课与教学辅助、物联网应用等。请各团队做好准备，提交高质量作品。</p>"));
		newsList.add(createNews(6, "计算机与控制工程学院举办学术讲座（有图片评论版）", "2024-12-17", "news", "images/news/lecture.png", "<h4>“探索AIGC的未来”学术讲座成功举办</h4><p>近日，我院特邀业界知名AI专家王教授，在科技楼报告厅举办了主题为“生成式AI的未来与挑战”的学术讲座。讲座深入浅出地讲解了AIGC的核心技术和应用前景，现场座无虚席，师生反响热烈。</p>"));
		// ... 添加了更多新闻 ...
		newsList.add(createNews(7, "关于第十五届全国三创赛校内选拔赛的报名通知", "2024-11-16", "news", null, "<p>全国大学生电子商务“创新、创意及创业”挑战赛（简称“三创赛”）是激发大学生兴趣与潜能，培养创新意识、创意思维、创业能力以及团队协同实战精神的学科性竞赛。校内选拔赛现已开启报名，请各团队登录指定网站提交商业计划书及相关材料。</p>"));
		newsList.add(createNews(8, "计算机与控制工程学院关于开展2024年师生羽毛球比赛的通知", "2024-11-16", "announcement", null, "<p>为丰富师生课余文化生活，增进师生间的交流与友谊，学院工会与学生会决定联合举办2024年度师生羽毛球比赛。比赛分为男单、女单、混双等项目，欢迎全院师生踊跃报名，展现计控风采。</p>"));
		newsList.add(createNews(9, "第36次 CCF CSP 认证报名通知", "2024-11-11", "announcement", "images/news/csp.png", "<p>第36次CCF CSP认证报名通道已开启。CSP认证重点考察实际编程和算法设计能力，成绩获得众多高校和企业的认可。请同学们抓紧时间报名，认真备考。</p>"));
	}

	private static void initializeComments() {
		commentList.add(createComment(1, 1, "张同学", "终于等到CSP报名了，这次一定要冲个好成绩！", null));
		commentList.add(createComment(2, 1, "李老师", "同学们加油，预祝大家取得优异成绩！", null));
		commentList.add(createComment(3, 6, "编程爱好者", "讲座太精彩了，收获满满！希望以后多举办这样的活动。", "images/comments/lecture-photo.png"));
		commentList.add(createComment(4, 6, "Admin", "感谢马教授的精彩分享！", null));
	}

	// --- 新闻相关方法 ---
	public static List<News> getAllNews() {
		return newsList.stream().sorted((o1, o2) -> o2.getCreate_time().compareTo(o1.getCreate_time())).collect(Collectors.toList());
	}
	public static News getNewsById(int id) {
		return newsList.stream().filter(news -> news.getId() == id).findFirst().orElse(null);
	}
	public static void addNews(News news) {
		news.setId(newsIdCounter.getAndIncrement());
		news.setCreate_time(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		newsList.add(news);
	}
	public static void updateNews(News updatedNews) {
		newsList.stream().filter(n -> n.getId() == updatedNews.getId()).findFirst().ifPresent(n -> {
			n.setTitle(updatedNews.getTitle());
			n.setContent(updatedNews.getContent());
			n.setType(updatedNews.getType());
			n.setCoverImage(updatedNews.getCoverImage());
		});
	}
	public static void deleteNews(int id) {
		newsList.removeIf(news -> news.getId() == id);
	}

	// --- 评论相关方法 (新增) ---
	public static List<Comment> getCommentsByNewsId(int newsId) {
		return commentList.stream()
				.filter(comment -> comment.getNewsId() == newsId)
				.sorted((o1, o2) -> o1.getCreateTime().compareTo(o2.getCreateTime()))
				.collect(Collectors.toList());
	}
	public static void addComment(Comment comment) {
		comment.setId(commentIdCounter.getAndIncrement());
		comment.setCreateTime(LocalDateTime.now().format(dtf));
		commentList.add(comment);
	}
	public static void deleteComment(int id) {
		commentList.removeIf(comment -> comment.getId() == id);
	}

	// --- 辅助方法 ---
	private static News createNews(int id, String title, String date, String type, String coverImage, String content) {
		News n = new News();
		n.setId(id);
		n.setTitle(title);
		n.setCreate_time(date);
		n.setType(type);
		n.setCoverImage(coverImage);
		n.setContent(content);
		return n;
	}
	private static Comment createComment(int id, int newsId, String username, String content, String imageUrl) {
		Comment c = new Comment();
		c.setId(id);
		c.setNewsId(newsId);
		c.setUsername(username);
		c.setContent(content);
		c.setImageUrl(imageUrl);
		c.setCreateTime(LocalDateTime.now().minusDays(id).format(dtf)); // 模拟不同时间
		return c;
	}
}