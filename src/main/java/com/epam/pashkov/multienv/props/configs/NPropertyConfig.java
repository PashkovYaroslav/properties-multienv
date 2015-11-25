package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
import jfork.nproperty.Cfg;
import jfork.nproperty.ConfigParser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * User: Yaroslav_Pashkov
 * Date: 25.11.2015
 * Time: 12:12
 */
@Cfg
public class NPropertyConfig {
    private String path;

    @Cfg("test.login")
    private static String login;

    @Cfg("test.prodcount")
    private static int prodCount;

    @Cfg(value = "test.users", splitter = ", ")
    private static String[] users;

    public NPropertyConfig(String path) {
        try {
            ConfigParser.parse(NPropertyConfig.class, path);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CurrentConf getConfig() {
        return new CurrentConf(login, prodCount, users);
    }
}
