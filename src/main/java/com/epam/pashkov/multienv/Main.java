package com.epam.pashkov.multienv;

import com.epam.pashkov.multienv.props.configs.*;

/**
 * Created by Yaroslav on 24.11.2015.
 */
public class Main {

    public static final String SRC_MAIN_RESOURCES_CONFIG_PROPERTIES = "src/main/resources/config.properties";
    public static final String GROOVY_CONFIG = "src/main/resources/config.groovy";
    public static final String CONFIG_PROPERTIES = "config.properties";

    public static void main(String[] args) {
        StandardConfig standardConfig = new StandardConfig(SRC_MAIN_RESOURCES_CONFIG_PROPERTIES);
        System.out.println("===Standard===");
        System.out.println(standardConfig.getConfig());

        ApacheConf apacheConf = new ApacheConf(CONFIG_PROPERTIES);
        System.out.println("===Apache===");
        System.out.println(apacheConf.getConfig());

        YConfig yConfig = new YConfig();
        System.out.println("===Yandex===");
        System.out.println(yConfig.getConfig());

        NPropertyConfig nPropertyConfig = new NPropertyConfig(SRC_MAIN_RESOURCES_CONFIG_PROPERTIES);
        System.out.println("===nProperty===");
        System.out.println(nPropertyConfig.getConfig());

        GroovyConf groovyConf = new GroovyConf(GROOVY_CONFIG);
        System.out.println("===Groovy===");
        System.out.println(groovyConf.getConfig());
    }
}
