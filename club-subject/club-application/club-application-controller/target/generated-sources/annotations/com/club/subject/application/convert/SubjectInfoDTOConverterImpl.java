package com.club.subject.application.convert;

import com.club.subject.application.dto.SubjectInfoDTO;
import com.club.subject.domain.entity.SubjectInfoBO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-16T19:01:37+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class SubjectInfoDTOConverterImpl implements SubjectInfoDTOConverter {

    @Override
    public SubjectInfoBO convertDTOToBO(SubjectInfoDTO subjectInfoDTO) {
        if ( subjectInfoDTO == null ) {
            return null;
        }

        SubjectInfoBO subjectInfoBO = new SubjectInfoBO();

        return subjectInfoBO;
    }

    @Override
    public SubjectInfoDTO convertBOToDTO(SubjectInfoBO subjectInfoBO) {
        if ( subjectInfoBO == null ) {
            return null;
        }

        SubjectInfoDTO subjectInfoDTO = new SubjectInfoDTO();

        return subjectInfoDTO;
    }
}
