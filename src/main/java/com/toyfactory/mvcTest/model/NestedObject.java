package com.toyfactory.mvcTest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class NestedObject {

    private String name;

    private List<SomeResult> someResultList = new ArrayList<>();

    public void addSomeResult(String code, String message) {
        someResultList.add(new SomeResult(code, message));
    }

    @Data
    @NoArgsConstructor
    public static class SomeResult {

        private String resultCode;
        private String resultMessage;

        public SomeResult(String code, String message) {
            resultCode = code;
            resultMessage = message;
        }
    }
}
