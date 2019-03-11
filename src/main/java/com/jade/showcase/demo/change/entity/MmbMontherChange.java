package com.jade.showcase.demo.change.entity;

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
 * @since 2019-03-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MmbMontherChange extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer week;

    private String montherChange;

    private String nutritionGuide;

    private String attention;


}
