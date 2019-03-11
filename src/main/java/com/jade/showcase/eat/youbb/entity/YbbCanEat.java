package com.jade.showcase.eat.youbb.entity;

import com.jade.showcase.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jade
 * @since 2019-03-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class YbbCanEat extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String category;

    private String title;

    private String img;

    private String icon;

    private String sort;

    private String pregnantNotice;

    private String pregnantComment;

    private String puerperaNotice;

    private String puerperaComment;

    private String babyNotice;

    private String babyComment;

    private String lactationNotice;

    private String lactationComment;

    private String nutrition;

    private String friendlyTips;

    private String tabooIngredient;

    private String strategy;

    private String titleAlias;

    private Integer id;


}
