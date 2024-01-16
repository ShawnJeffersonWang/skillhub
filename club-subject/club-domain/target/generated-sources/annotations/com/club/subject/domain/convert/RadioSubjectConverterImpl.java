package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectAnswerBO;
import com.club.subject.infra.basic.entity.SubjectRadio;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-16T19:01:36+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class RadioSubjectConverterImpl implements RadioSubjectConverter {

    @Override
    public SubjectRadio convertBOToEntity(SubjectAnswerBO subjectAnswerBO) {
        if ( subjectAnswerBO == null ) {
            return null;
        }

        SubjectRadio subjectRadio = new SubjectRadio();

        return subjectRadio;
    }
}
