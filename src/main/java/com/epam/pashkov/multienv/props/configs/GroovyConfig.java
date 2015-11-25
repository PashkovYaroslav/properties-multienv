package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
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
public class GroovyConfig {

    private String path;

    public GroovyConfig(String path) {
        this.path = path;
    }

    public CurrentConf getConfig() {
        ConfigObject config = null;
        try {
            config = new ConfigSlurper().parse(new File(path).toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Map flattenedConfig = config.flatten();
        String[] users = ((String) flattenedConfig.get(ParamNames.TEST_USERS_PARAM)).split(", ");

        return new CurrentConf((String) flattenedConfig.get(ParamNames.TEST_LOGIN_PARAM), (Integer) flattenedConfig.get(ParamNames.TEST_PRODCOUNT_PARAM), users);
    }
}
