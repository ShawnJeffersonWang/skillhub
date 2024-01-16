package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.SubjectInfoTypeEnum;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.domain.entity.SubjectOptionBO;
import org.springframework.stereotype.Component;

/**
 * 单选题目的策略类
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler{
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        return null;
    }
}
