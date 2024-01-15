package com.club.subject.application.convert;

import com.club.subject.application.dto.SubjectCategoryDTO;
import com.club.subject.application.dto.SubjectInfoDTO;
import com.club.subject.domain.entity.SubjectCategoryBO;
import com.club.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoDTOConverter {

    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);


    SubjectInfoBO convertDTOToBO(SubjectInfoDTO subjectInfoDTO);
}
