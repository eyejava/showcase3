package com.jade.showcase.baby.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2019-03-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("baby_change")
public class Change extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String description;

    private String motherDesc;

    private String babyInfo;

    private Integer week;

    private Integer day;

    private String height;

    private String weight;

    private String girlheight;

    private String girlweight;


}
