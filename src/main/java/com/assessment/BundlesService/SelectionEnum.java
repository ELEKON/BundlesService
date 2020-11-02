package com.assessment.BundlesService;

public enum SelectionEnum {


    ASCENDING("ASCENDING"),
    DISCENDING("DISCENDING");

    private final String choice;

    SelectionEnum(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }
}
