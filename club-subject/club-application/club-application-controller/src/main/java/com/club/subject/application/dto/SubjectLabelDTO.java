package com.club.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签dto
 *
 * @author makejava
 * @since 2023-10-03 21:50:30
 */
@Data
public class SubjectLabelDTO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;
}

