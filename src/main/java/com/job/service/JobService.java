package com.job.service;

import com.job.entity.JobEntity;

import java.util.List;

/**
 * Created by Daejong on 2017/10/20.
 */
public interface JobService {

    public List<JobEntity> findAll();

    public List<JobEntity> findByCondition(String condition);

}
