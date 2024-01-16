package com.club.subject.domain.convert;

import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.domain.entity.SubjectOptionBO;
import com.club.subject.infra.basic.entity.SubjectInfo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-16T19:01:36+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class SubjectInfoConverterImpl implements SubjectInfoConverter {

    @Override
    public SubjectInfo convertBOToInfo(SubjectInfoBO subjectInfoBO) {
        if ( subjectInfoBO == null ) {
            return null;
        }

        SubjectInfo subjectInfo = new SubjectInfo();

        return subjectInfo;
    }

    @Override
    public SubjectInfoBO convertOptionToBo(SubjectOptionBO subjectOptionBO) {
        if ( subjectOptionBO == null ) {
            return null;
        }

        SubjectInfoBO subjectInfoBO = new SubjectInfoBO();

        return subjectInfoBO;
    }

    @Override
    public SubjectInfoBO convertOptionAndInfoToBo(SubjectOptionBO subjectOptionBO, SubjectInfo subjectInfo) {
        if ( subjectOptionBO == null && subjectInfo == null ) {
            return null;
        }

        SubjectInfoBO subjectInfoBO = new SubjectInfoBO();

        return subjectInfoBO;
    }
}
