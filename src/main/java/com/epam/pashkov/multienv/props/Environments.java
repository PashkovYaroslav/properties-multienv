package com.epam.pashkov.multienv.props;

/**
 * Created by Yaroslav on 26.11.2015.
 */
public enum Environments {
    TEST("test"), PROD("prod");

    private String envName;

    Environments(String envName) {
        this.envName = envName;
    }

    public String toString() {
        return envName;
    }
}
