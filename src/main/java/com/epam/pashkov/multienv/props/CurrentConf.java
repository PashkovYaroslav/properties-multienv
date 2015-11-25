package com.epam.pashkov.multienv.props;

import java.util.Arrays;

/**
 * User: Yaroslav_Pashkov
 * Date: 25.11.2015
 * Time: 11:38
 */
public class CurrentConf {
    private String login;
    private int prodCount;
    private String[] arrayOfUsers;

    public CurrentConf(String login, int prodCount, String[] arrayOfUsers) {
        this.login = login;
        this.prodCount = prodCount;
        this.arrayOfUsers = arrayOfUsers;
    }

    @Override
    public String toString() {
        return "CurrentConf{" +
                "login='" + login + '\'' +
                ", prodCount=" + prodCount +
                ", arrayOfUsers=" + Arrays.toString(arrayOfUsers) +
                '}';
    }
}
