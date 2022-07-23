package edu.mriabov.springuniversity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Holiday {
    private final String day;
    private final String reason;
    private final Type type;

    public enum Type{
        FEDERAL,
        FESTIVAL
    }
}
