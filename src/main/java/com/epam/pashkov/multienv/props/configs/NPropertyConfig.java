package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
import jfork.nproperty.Cfg;
import jfork.nproperty.ConfigParser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static com.epam.pashkov.multienv.props.Constants.*;

/**
 * User: Yaroslav_Pashkov
 * Date: 25.11.2015
 * Time: 12:12
 */
@Cfg
public class NPropertyConfig {
    private String path;

    @Cfg(ParamNames.TEST_LOGIN_PARAM)
    private static String login;

    @Cfg(ParamNames.TEST_PRODCOUNT_PARAM)
    private static int prodCount;

    @Cfg(value = ParamNames.TEST_USERS_PARAM, splitter = ", ")
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
