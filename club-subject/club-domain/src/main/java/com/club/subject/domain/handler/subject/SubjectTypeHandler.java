package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.SubjectInfoTypeEnum;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.domain.entity.SubjectOptionBO;

public interface SubjectTypeHandler {

    /**
     * 枚举身份的识别
     * @return
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目的插入
     * @param subjectInfoBO
     */
    void add(SubjectInfoBO subjectInfoBO);

    SubjectOptionBO query(int subjectId);
}
