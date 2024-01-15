package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectInfoConverter {

    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfo convertBOToInfo(SubjectInfoBO subjectInfoBO);

}
