package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.*;

/**
 * User: Yaroslav_Pashkov
 * Date: 25.11.2015
 * Time: 14:10
 */
public class GroovyConf {

    private String path;

    public GroovyConf(String path) {
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
        String[] users = ((String) flattenedConfig.get("test.users")).split(", ");

        return new CurrentConf((String) flattenedConfig.get("test.login"), (Integer) flattenedConfig.get("test.prodcount"), users);
    }
}
