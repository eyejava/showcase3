package com.jade.showcase.text.model;

import lombok.Data;

import java.util.List;

@Data
public class Result {

    private int spam;
    private List<String> review;
    private List<String> reject;
    private List<Pass> pass;
}
