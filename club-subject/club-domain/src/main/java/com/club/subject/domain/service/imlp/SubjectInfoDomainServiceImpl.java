package com.club.subject.domain.service.imlp;

import com.alibaba.fastjson2.JSON;
import com.club.subject.domain.convert.SubjectInfoConverter;
import com.club.subject.domain.convert.SubjectLabelConverter;
import com.club.subject.domain.entity.SubjectInfoBO;
import com.club.subject.domain.handler.subject.SubjectTypeHandler;
import com.club.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.club.subject.domain.service.SubjectInfoDomainService;
import com.club.subject.infra.basic.entity.SubjectInfo;
import com.club.subject.infra.basic.entity.SubjectMapping;
import com.club.subject.infra.basic.service.SubjectInfoService;
import com.club.subject.infra.basic.service.SubjectMappingService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBOToInfo(subjectInfoBO);
        subjectInfoService.insert(subjectInfo);
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        handler.add(subjectInfoBO);
        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelId();
        List<SubjectMapping> mappingList = new LinkedList<>();
        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setCategoryId(categoryId.longValue());
                subjectMapping.setLabelId(labelId.longValue());
                mappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInsert(mappingList);
    }
}
