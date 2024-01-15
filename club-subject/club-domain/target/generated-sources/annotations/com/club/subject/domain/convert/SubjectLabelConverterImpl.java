package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectLabelBO;
import com.club.subject.infra.basic.entity.SubjectLabel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T23:26:26+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class SubjectLabelConverterImpl implements SubjectLabelConverter {

    @Override
    public SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO) {
        if ( subjectLabelBO == null ) {
            return null;
        }

        SubjectLabel subjectLabel = new SubjectLabel();

        return subjectLabel;
    }
}
