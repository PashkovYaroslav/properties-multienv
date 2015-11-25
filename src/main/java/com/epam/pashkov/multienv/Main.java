package com.epam.pashkov.multienv;

import com.epam.pashkov.multienv.props.configs.*;

import static com.epam.pashkov.multienv.props.Constants.Path.CONFIG_PROPERTIES;
import static com.epam.pashkov.multienv.props.Constants.Path.GROOVY_CONFIG;
import static com.epam.pashkov.multienv.props.Constants.Path.SRC_MAIN_RESOURCES_CONFIG_PROPERTIES;

/**
 * Created by Yaroslav on 24.11.2015.
 */
public class Main {

    public static void main(String[] args) {
        StandardConfig standardConfig = new StandardConfig(SRC_MAIN_RESOURCES_CONFIG_PROPERTIES);
        System.out.println("===Standard===");
        System.out.println(standardConfig.getConfig());

        ApacheConfig apacheConfig = new ApacheConfig(CONFIG_PROPERTIES);
        System.out.println("===Apache===");
        System.out.println(apacheConfig.getConfig());

        YConfig yConfig = new YConfig();
        System.out.println("===Yandex===");
        System.out.println(yConfig.getConfig());

        NPropertyConfig nPropertyConfig = new NPropertyConfig(SRC_MAIN_RESOURCES_CONFIG_PROPERTIES);
        System.out.println("===nProperty===");
        System.out.println(nPropertyConfig.getConfig());

        GroovyConfig groovyConfig = new GroovyConfig(GROOVY_CONFIG);
        System.out.println("===Groovy===");
        System.out.println(groovyConfig.getConfig());
    }
}
