# 东北林业大学软件工程专业介绍网站

#这个项目中还包含web实验的内容

这是一个为东北林业大学软件工程专业设计的动态介绍网站。作为Web开发课程设计项目，它采用经典的Java用于后台富文本编辑)
- AOS.js (用于页面滚动动画)
- **后端**:
    - Java 11+
    - Jakarta Servlet 5.0
    - Gson 2.10 (用于JSON处理 Web技术栈（Servlet/JSP模式）构建，并实现了一个功能完善的前后台系统。

为了简化部署与依赖，项目后端用**内存数据存储**替代了传统数据库，所有数据在服务器启动时从代码加载，并在运行时在内存中进行增删改查操作。

## 1. 项目截图

*(建议您在此处替换为自己项目的真实截图)*

| 网站首页 | 教师队伍页面 | 新闻详情)
- **构建工具**:
    - Apache Maven 3.8+
- **Web服务器**:
    - Apache Tomcat 9.0+

## 📂 项目结构

```
NEFUSoftwareWebsite/
├── src/
│   └── main/
│       ├── java/
│       │   └── de/nefu/software/
│       │       ├── bean/             # 实体类 (News.java, Comment.java)
│       │       ├── data/             # 内存数据存储 (InMemoryDataStore.java)
│       │       ├── filter/           # 过滤器 (AuthFilter.java, CharacterEncodingFilter.java)
│       │       └── servlet/          # Servlets (LoginServlet.java, NewsApiServlet.java, etc.)
│       └── webapp/与评论区 |
| :---: | :---: | :---: |
| ![首页截图](https://place
│           ├── images/               # 存放所有图片资源
│           ├── WEB-INF/
│           │   hold.co/800x600/3498db/FFFFFF?text=网站首页截图) | ![教师队伍截图](https://placehold.co/800x600/2ecc71/└── web.xml           # 部署描述文件
│           └── index.html            # 单页面应用入口
│
├──FFFFFF?text=教师队伍截图) | ![新闻详情页截图](https://placehold.co/800 pom.xml                           # Maven 配置文件
└── README.md                         # 项目说明文件
```

## 🚀x600/e67e22/FFFFFF?text=新闻详情与评论区截图) |

## 2. 技术栈 (Technology Stack)

-   **前端 (Frontend)**
    -   HTML5
    -    启动与部署 (本地IntelliJ IDEA环境)

本项目已配置为在本地Tomcat中运行，无需DockerCSS3
-   JavaScript (ES6+)
-   [Bootstrap 5](https://getbootstrap.com/。

### 1. 先决条件

- **JDK 11** 或更高版本。
- **Apache): 用于页面布局和UI组件。
    -   [Bootstrap Icons](https://icons.getbootstrap.com/): 用于 Maven** 已安装并配置好环境变量。
- **Apache Tomcat 9** 或更高版本已下载并解压在界面图标。
    -   [AOS (Animate On Scroll)](https://michalsnik.github.io本地。
- **IntelliJ IDEA** (推荐使用旗舰版，对Web开发支持更好)。

###/aos/): 用于页面滚动时的加载动画。
-   [CKEditor 5](https://ck 2. 数据库配置

**无需任何数据库配置**。本项目使用`InMemoryDataStore.java`在editor.com/): 用于后台管理中的富文本编辑器。

-   **后端 (Backend)**
    -   **Java 11** 或更高版本
    -   **Jakarta Servlet API 5.0**: 项目服务器启动时加载模拟数据，所有操作均在内存中进行。

**注意**: 每次重启Tomcat服务器，所有数据（如新增的新闻、评论）都将恢复到初始状态。

### 3. 在IntelliJ IDEA的核心，处理HTTP请求。
    -   **Apache Tomcat 9/10**: 作为Web服务器和Servlet中配置并运行

1.  **打开项目**: 使用IntelliJ IDEA打开本项目的`pom.xml容器。
    -   **Gson 2.10.1**: 用于在Java对象和JSON字符串之间进行序列化和反序列化。

-   **构建工具 (Build Tool)**
    -   **Apache Maven**:`文件，选择“Open as Project”。
2.  **配置Tomcat服务器**:
    - 在IDEA顶部菜单栏，选择 `Run` -> `Edit Configurations...`。
    - 点击左上角的 **“+ 用于项目构建和依赖管理。

## 3. 主要功能 (Features)

#### 前台功能
-”** 加号，选择 **“Tomcat Server”** -> **“Local”**。
- 在   **响应式设计**: 兼容PC、平板和手机等不同尺寸的设备。
-   **单页面 “Name” 处为服务器命名（例如 `Tomcat 11`）。
    - 点击 “Application应用 (SPA) 风格**: 使用URL哈希（`#`）进行页面导航，无需刷新整个页面。
- Server” 右侧的 **“Configure...”** 按钮，选择您本地Tomcat的解压路径。
  3   **动态内容展示**:
    -   **首页**: 包含轮播图、快速入口和最新的新闻公告.  **部署项目构件 (Artifact) - 关键步骤!**:
    - 在Tomcat配置窗口中，切换列表。
    -   **专业介绍**: 包括“专业简介”和“方向简介”两个子页面。
        到 **“Deployment” (部署)** 标签页。
    - 点击右侧的 **“+”** 加号-   **实验室**: 展示不同实验室的图文介绍。
    -   **教师队伍**: 按职称（，选择 **“Artifact...”**。
    - 在弹出的菜单中，选择 **`nefu-swe教授、副教授、讲师）筛选展示教师信息。
    -   **就业指南**: 图文并茂地-website:war exploded`**。
    - 在下方的 **“Application context” (应用程序上下文)** 输入介绍就业前景、合作企业和校友网络。
-   **新闻公告系统**:
    -   区分框中，将其内容修改为单个斜杠 **`/`**。
4.  **保存并运行**:
    -“新闻中心”和“通知公告”两个列表。
    -   新闻列表项可展示封面图缩略图。 点击 **“Apply” (应用)**，然后点击 **“OK”** 保存配置。
    - 点击IDEA右上
    -   点击可查看图文并茂的新闻详情页。
-   **评论系统**:
    角的绿色“运行”按钮 (▶️)，启动Tomcat服务器。

### 4. 访问网站

当    -   用户可在新闻详情页发表评论（可包含昵称、内容和图片URL）。
-   实时控制台显示“服务器启动”相关信息后，在浏览器中访问以下地址：

- **网站首页**: `展示该新闻下的所有评论。

#### 后台管理功能
-   **管理员安全登录**: 通过固定的用户名localhost:8080`
- **后台管理**: `http://localhost:8080/#admin/login `（`admin`）和密码（`admin`）登录后台。
-   **新闻管理 (CRUD)**:`
- **管理员账户**: `admin`
- **密码**: `admin`

## 🖼️ 图片资源说明
    -   **创建 (Create)**: 使用富文本编辑器发布带封面图的新闻或公告。


本项目的所有图片资源都应放置在 `src/main/webapp/images/` 目录下。为了正常-   **读取 (Read)**: 查看所有新闻公告的列表。
-   **更新 (Update)**:显示网站内容，您需要根据以下结构准备好所有图片：

- `/src/main/webapp/images/LOGO 编辑已存在的新闻内容和封面图。
    -   **删除 (Delete)**: 删除指定的新闻或.png` - 网站Logo
- `/src/main/webapp/images/slide1.jpg`, 公告。
-   **评论管理**:
    -   管理员登录后，在新闻详情页可以看到每个评论旁的`slide2.jpg`, `slide3.jpg` - 首页轮播图
- **`/src/main/webapp“删除”按钮，可以删除不当评论。

## 4. 如何运行 (Getting Started)

本项目/images/general/`**
- `program_intro.png` - 专业介绍配图
  -为标准的Maven Web应用，建议使用IntelliJ IDEA Ultimate进行部署和运行。

#### 4.1. 环境 `career_*.jpg` - 就业指南相关配图
- **`/src/main/webapp/images/labs/准备
-   **JDK**: `11` 或更高版本。
-   **Apache Maven**: `3.6`**
- `lab_*.png` - 各实验室配图
- **`/src/main/webapp/images` 或更高版本。
-   **Apache Tomcat**: `9.x` 或 `10.x/teachers/`**
- 根据`index.html`中`AppData.teachers`数组定义的`photo`路径` 版本。
-   **IDE**: [IntelliJ IDEA Ultimate](https://www.jetbrains.com/idea)，存放所有教师照片。
- **`/src/main/webapp/images/news/`**
    - 根据/) (社区版对Tomcat的支持有限)。

