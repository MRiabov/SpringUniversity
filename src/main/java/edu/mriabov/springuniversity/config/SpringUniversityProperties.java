package edu.mriabov.springuniversity.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "springuniversity")
@Validated
public class SpringUniversityProperties {

    @Min(value=5, message = "Must be between 5 and 25")
    @Max(value = 25, message = "Must be between and 25")
    private int pageSize;

    private Map<String,String> contact;
    private List<String> branches;
}
