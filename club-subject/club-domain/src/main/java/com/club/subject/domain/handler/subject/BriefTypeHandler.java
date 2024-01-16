package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.SubjectInfoTypeEnum;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.domain.entity.SubjectOptionBO;
import com.club.subject.infra.basic.entity.SubjectBrief;
import com.club.subject.infra.basic.service.SubjectBriefService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 单选题目的策略类
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectBriefService subjectBriefService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectBrief subjectBrief = subjectBriefService.queryById(Long.valueOf(subjectId));
        SubjectOptionBO subjectOptionBO=new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(subjectBrief.getSubjectAnswer());
        return subjectOptionBO;
    }
}
