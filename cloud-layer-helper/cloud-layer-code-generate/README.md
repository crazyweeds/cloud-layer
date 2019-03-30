# cloud-layer-code-generate

### 为什么造轮子？

    很多代码生成器，为什么偏要自己写个？体验、经历、好玩！
    很多代码生成器是基于Mybatis Generator，虽然可配性较高，但配置起来也很繁琐。
    对于有代码洁癖的人，配置一套出来，，比写一套更难。
    定制化了，自己写，可以结合自己框架，随意搭配。比如Lombok，比如tk.mapper，swagger之类的。


### 生成的内容：

        lombok注解
        tk-mapper
        mybatis的java和xml文件（基于tk-mapper省略某些方法）
        service接口
        service实现
        feign接口(待定)
        controller类（待定）
        
        
### 注意：

    暂时只支持mysql，其他数据库暂时没想法，现在项目不用，也没时间测试。有兴趣可以自己实现,替换 sql-mysql.properties 文件中的SQL即可。
    尝鲜后，剩下了无聊。整体已经完成，就差将注解等信息抽取到配置文件，实现较高的可配制化
    
