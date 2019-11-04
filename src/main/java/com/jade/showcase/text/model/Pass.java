package com.jade.showcase.text.model;

import lombok.Data;

import java.util.List;

@Data
public class Pass {

    private double score;
    private List<String> hit;
    private int label;
}
