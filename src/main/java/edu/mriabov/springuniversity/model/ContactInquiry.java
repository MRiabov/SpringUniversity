package edu.mriabov.springuniversity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContactInquiry {
    private final String name;
    private final String number;
    private final String email;
    private final String mobileNumber;
    private final String message;
}
