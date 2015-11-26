package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
import com.epam.pashkov.multienv.props.Environments;

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
public class StandardConfig implements Config {
    private String path;

    public StandardConfig(String path) {
        this.path = path;
    }

    public CurrentConf getConfig(Environments envVersion) {
        Properties props = new Properties();
        String[] users = null;
        try {
            props.load(new FileInputStream(new File(path)));
            users = props.getProperty(String.format(Patterns.USERS_PARAM_X, envVersion.toString())).split(", ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new CurrentConf(props.getProperty(String.format(Patterns.LOGIN_PARAM_X, envVersion.toString())),
                Integer.parseInt(props.getProperty(String.format(Patterns.COUNT_PARAM_X, envVersion.toString()))),
                users);
    }
}
