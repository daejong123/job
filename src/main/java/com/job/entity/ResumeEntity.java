package com.job.entity;

import lombok.Data;

/**
 * @author lindazhong
 * @date 2018/4/21 18:13
 */
@Data
public class ResumeEntity {

    //姓名
    private String name;
    //出生19950326
    private String birth;
    //性别
    private String gender;
    //民族
    private String notion;
    //籍贯
    private String province;

    //手机号
    private String phoneNumber;
    //大学
    private String university;
    //专业
    private String profession;
    //电子邮箱
    private String email;
    //求职方向
    private String jobDirection;
    //个人描述(技能，自我评价)
    private String selfDescription;
    //实习经历
    private String partTimeExperience;
    //工作经历
    private String workExperience;
    //获奖情况
    private String awardExperience;
    //其他描述
    private String otherDescription;

}

//头像
//    private MultipartFile photo;