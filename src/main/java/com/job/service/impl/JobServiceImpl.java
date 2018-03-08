package com.job.service.impl;

import com.job.entity.JobEntity;
import com.job.mapper.JobMapper;
import com.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Daejong on 2017/10/20.
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<JobEntity> findAll() {
        return jobMapper.getAll();
    }

    @Override
    public List<JobEntity> findByCondition(String condition) {
        return jobMapper.fingByCondition(condition);
    }
}
