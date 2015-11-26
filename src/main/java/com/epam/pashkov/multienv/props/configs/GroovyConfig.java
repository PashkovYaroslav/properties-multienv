package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
import com.epam.pashkov.multienv.props.Environments;
import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

import java.io.File;
import java.net.MalformedURLException;
import java.util.*;

import static com.epam.pashkov.multienv.props.Constants.*;

/**
 * User: Yaroslav_Pashkov
 * Date: 25.11.2015
 * Time: 14:10
 */
public class GroovyConfig implements Config {

    private String path;

    public GroovyConfig(String path) {
        this.path = path;
    }

    public CurrentConf getConfig(Environments envVersion) {
        ConfigObject config = null;
        try {
            config = new ConfigSlurper().parse(new File(path).toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Map flattenedConfig = config.flatten();
        String[] users = ((String) flattenedConfig.get(String.format(Patterns.USERS_PARAM_X, envVersion.toString()))).split(", ");

        return new CurrentConf((String) flattenedConfig.get(String.format(Patterns.LOGIN_PARAM_X, envVersion.toString())),
                (Integer) flattenedConfig.get(String.format(Patterns.COUNT_PARAM_X, envVersion.toString())), users);
    }
}
