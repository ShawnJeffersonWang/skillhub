package com.club.subject.domain.service;

import com.club.subject.common.entity.PageResult;
import com.club.subject.domain.entity.SubjectInfoBO;

/**
 * 题目标签领域服务
 */
public interface SubjectInfoDomainService {

    /**
     * 新增题目
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询
     */
//    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目信息
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
