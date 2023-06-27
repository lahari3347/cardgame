package com.project.cardgame.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SampleObjectUsingBuilder {
    private int var1;
    private int var2;
    private String var3;
}
