package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.SubjectInfoTypeEnum;
import com.club.subject.domain.entity.SubjectInfoBO;
import org.springframework.stereotype.Component;

/**
 * 单选题目的策略类
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {

    }
}
