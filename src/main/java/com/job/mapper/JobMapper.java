package com.job.mapper;

import com.job.entity.JobEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Daejong on 2017/10/20.
 */
@Component
public interface JobMapper {

    @Select("select * from tb_job")
    @Results({
            @Result(property = "jobId", column = "id"),
            @Result(property = "jobName", column = "name"),
            @Result(property = "pubTime", column = "time"),
            @Result(property = "urlInfo", column = "link")
    })
    public List<JobEntity> getAll();

    @Select("select * from tb_job where address like concat(concat('%',#{condition}),'%') " +
            "or company like concat(concat('%',#{condition}),'%') " +
            "or name like concat(concat('%',#{condition}),'%') " +
            "or salary like concat(concat('%',#{condition}),'%')")
    @ResultMap("jobMap")
    public List<JobEntity> fingByCondition(String condition);
}
