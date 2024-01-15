package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.SubjectInfoTypeEnum;
import com.club.subject.domain.convert.RadioSubjectConverter;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.infra.basic.entity.SubjectRadio;
import com.club.subject.infra.basic.service.SubjectRadioService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * 单选题目的策略类
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectRadioService subjectRadioService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //单选题目的插入
        List<SubjectRadio> subjectRadioList=new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option->{
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBOToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);
    }
}
