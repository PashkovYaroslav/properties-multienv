package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
import com.epam.pashkov.multienv.props.Environments;
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
public class NPropertyConfig implements Config {
    private String path;

    @Cfg(ParamNames.PROD_LOGIN_PARAM)
    private static String prodLogin;

    @Cfg(ParamNames.PROD_COUNT_PARAM)
    private static int prodCount;

    @Cfg(value = ParamNames.PROD_USERS_PARAM, splitter = ", ")
    private static String[] prodUsers;

    @Cfg(ParamNames.TEST_LOGIN_PARAM)
    private static String testLogin;

    @Cfg(ParamNames.TEST_COUNT_PARAM)
    private static int testCount;

    @Cfg(value = ParamNames.TEST_USERS_PARAM, splitter = ", ")
    private static String[] testUsers;

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

    public CurrentConf getConfig(Environments envVerion) {
        if (envVerion.toString().equals(Environments.PROD.toString())) {
            return new CurrentConf(prodLogin, prodCount, prodUsers);
        } else {
            return new CurrentConf(testLogin, testCount, testUsers);
        }
    }
}
