<h2>吾心吾行澄如明镜，所作所为皆属正义</h2>
感觉到自己的能力不够，皆因自身平时不够努力，积累甚少。这个项目主要用来映照自身，勉励自己前行。

<h3>集成</h3> 
  这个项目目前集成了 mybatis,lombok,swagger2,tar文件下载依赖(org.apache.ant/ant),redis,easyexcel,junit4,等一系列依赖。
  
<h3>目前效果</h3>
echartsController     可以在 echarts.html 页面看到，定义一些简单的数据，显示一个简单的饼图

githubLogin           可以在 login.html 页面看到，github登录，我的知乎文章：https://zhuanlan.zhihu.com/p/402969800

ImageController       可以在uploading.html页面看到，admin_category_add，简单图片上传，图片会保存到 E:\img 的位置        

menuController        查出菜单表数据，getAll 单纯的查出数据，getTree 将查出的数据进行递归处理，方便树的形式

redisController       通过引入redis依赖，使用java管理redis,redisUtils 是工具类 redis部署在本地，简单实现，添加，修改，删除，查询等功能

studentController     对学生表一些最基础的操作

yewuController        当时没有用到redis,保证访问访问业务B之前先去访问业务A,用到 map，现在可以用redis代替

CrawlerDouYin         下载抖音视频，只需更改url的 sec_uid，sec_uid手机分享用户主题url，电脑浏览起打开user/后面的就是sec_uid    下载文件存放位置 E:\douyinvid 

downfile/Down         下载服务器文件，在同目录 test 文件启动，当初测试的服务器，目前已经过期了

javaMeinv/SougouImgProcessor  java爬取美女图片，直接启动，我的文件放在  E:\pipeline\sougou\美女 目录下

test/Java8Lambda      Lambda 表达式

test/MyCalc           文件内直接执行，一个计算器

test/simpleRead       文件内直接执行，easyexcel依赖的简单读，读的时候要注意对应位置要有文件

test/simpleWrite      文件内直接执行，easyexcel依赖的简单写

src/test/java/com/wzb/test/Testsimple  juint 测试，测试简单读，简单写


<h3>特别注意</h3>
downfile/Down        ch.ethz.ssh2 使用一个比较老的jar包，我们可以通过这个链接去查看：http://www.ganymed.ethz.ch/ssh2/ 。
我们大致能了解到，他是一个用纯 Java 实现 SSH-2 协议的库，允许从 Java 程序中连接到 SSH 服务器。
而且已经很久不在维护了，我们下载 2006 年 10 月 6 日 这个版本的就行。
下载之后，我们能看到，几个文件夹放的是项目源码，还有jar包，他都已经提供了，我们先不管源码。先将jar包做成maven依赖，引入项目。
windows+r,然后cmd，输入 
mvn install:install-file -Dfile=C:\Users\Administrator\Desktop\ganymed-ssh2-build210.jar -DgroupId=ch.ethz -DartifactId=ssh2 -Dversion=1.0  -Dpackaging=jar
这句话的意思是将jar包生成maven可以引入的依赖，并收到你的本地maven仓库，-Dfile 对应的是解压jar包的地址，-DgroupId 对应的是pom.xml的groupId(组织名)，
-DartifactId对应的是pom.xml的artifactId(工程名)，-Dversion对应的是pom.xml的version(版本号)，-Dpackaging 的意思是打包方式。
回车，文件生成成功。就可以在项目中引入依赖了。我已经将我下载的压缩文件放入 resources/compress文件夹。感兴趣可以试一下。
