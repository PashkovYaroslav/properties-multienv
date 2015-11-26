package com.epam.pashkov.multienv;

import com.epam.pashkov.multienv.props.Environments;
import com.epam.pashkov.multienv.props.configs.*;

import static com.epam.pashkov.multienv.props.Constants.Path.CONFIG_PROPERTIES;
import static com.epam.pashkov.multienv.props.Constants.Path.GROOVY_CONFIG;
import static com.epam.pashkov.multienv.props.Constants.Path.SRC_CONFIG_PROPERTIES;

/**
 * Created by Yaroslav on 24.11.2015.
 */
public class Main {

    public static void main(String[] args) {
        Environments env = Environments.TEST;

        StandardConfig standardConfig = new StandardConfig(SRC_CONFIG_PROPERTIES);
        System.out.println("===Standard===");
        System.out.println(standardConfig.getConfig(env));

        ApacheConfig apacheConfig = new ApacheConfig(CONFIG_PROPERTIES);
        System.out.println("===Apache===");
        System.out.println(apacheConfig.getConfig(env));

        YConfig yConfig = new YConfig();
        System.out.println("===Yandex===");
        System.out.println(yConfig.getConfig(env));

        NPropertyConfig nPropertyConfig = new NPropertyConfig(SRC_CONFIG_PROPERTIES);
        System.out.println("===nProperty===");
        System.out.println(nPropertyConfig.getConfig(env));

        GroovyConfig groovyConfig = new GroovyConfig(GROOVY_CONFIG);
        System.out.println("===Groovy===");
        System.out.println(groovyConfig.getConfig(env));
    }
}
