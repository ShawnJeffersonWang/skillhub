package com.club.subject.domain.handler.subject;

import com.club.subject.common.enums.SubjectInfoTypeEnum;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目类型工厂
 */
// 打注解，交给spring容器管理
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {

    // Resource自动注入
    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerList;

    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();

    public SubjectTypeHandler getHandler(int subjectType) {
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getByCode(subjectType);
        return handlerMap.get(subjectInfoTypeEnum);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerList) {
            handlerMap.put(subjectTypeHandler.getHandlerType(), subjectTypeHandler);
        }
    }
}
