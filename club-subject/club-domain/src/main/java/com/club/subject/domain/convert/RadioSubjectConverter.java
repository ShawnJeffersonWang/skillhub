package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectAnswerBO;
import com.club.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RadioSubjectConverter {

    RadioSubjectConverter INSTANCE = Mappers.getMapper(RadioSubjectConverter.class);

    SubjectRadio convertBOToEntity(SubjectAnswerBO subjectAnswerBO);

}
