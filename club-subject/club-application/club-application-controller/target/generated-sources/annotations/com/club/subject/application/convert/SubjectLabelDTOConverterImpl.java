package com.club.subject.application.convert;

import com.club.subject.application.dto.SubjectLabelDTO;
import com.club.subject.domain.entity.SubjectLabelBO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-16T19:01:37+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class SubjectLabelDTOConverterImpl implements SubjectLabelDTOConverter {

    @Override
    public SubjectLabelBO convertDtoToLabelBO(SubjectLabelDTO subjectLabelDTO) {
        if ( subjectLabelDTO == null ) {
            return null;
        }

        SubjectLabelBO subjectLabelBO = new SubjectLabelBO();

        return subjectLabelBO;
    }
}
