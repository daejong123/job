package com.job.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by Daejong on 2017/10/20.
 */
@Configuration
public class MybatisConfig {

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        //添加配置，也可以指定文件路径
        Properties p = new Properties();
        //会将rowBounds的第一个参数offset当成pageNum的页码使用
        p.setProperty("offsetAsPageNum", "true");
        //使用rowBoun ds分页会进行count查询
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        //如果pageSize = 0 或者 rowBounds的limit为零, 就会查出所有结果
        p.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
