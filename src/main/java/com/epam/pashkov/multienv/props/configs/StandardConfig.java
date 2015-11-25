package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.epam.pashkov.multienv.props.Constants.*;

/**
 * User: Yaroslav_Pashkov
 * Date: 25.11.2015
 * Time: 11:36
 */
public class StandardConfig {
    private String path;

    public StandardConfig(String path) {
        this.path = path;
    }

    public CurrentConf getConfig() {
        Properties props = new Properties();
        String[] users = null;
        try {
            props.load(new FileInputStream(new File(path)));
            users = props.getProperty(ParamNames.TEST_USERS_PARAM).split(", ");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new CurrentConf(props.getProperty(ParamNames.TEST_LOGIN_PARAM), Integer.parseInt(props.getProperty(ParamNames.TEST_PRODCOUNT_PARAM)), users);
    }
}
