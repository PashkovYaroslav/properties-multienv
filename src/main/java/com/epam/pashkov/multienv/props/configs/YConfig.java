package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.Constants;
import com.epam.pashkov.multienv.props.CurrentConf;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

import static com.epam.pashkov.multienv.props.Constants.*;

/**
 * Created by Yaroslav on 25.11.2015.
 */

@Resource.Classpath(Path.CONFIG_PROPERTIES)
public class YConfig {

    public YConfig() {
        PropertyLoader.populate(this);
    }

    @Property(ParamNames.TEST_LOGIN_PARAM)
    private String testLogin;

    @Property(ParamNames.TEST_PRODCOUNT_PARAM)
    private int testProdCount;

    @Property(ParamNames.TEST_USERS_PARAM)
    private String[] users;

    public String getTestLogin() {
        return testLogin;
    }

    public int getTestProdCount() {
        return testProdCount;
    }

    public String[] getTestUsers() {
        return users;
    }

    public CurrentConf getConfig() {
        YConfig yandexProp = new YConfig();
        return new CurrentConf(yandexProp.getTestLogin(), yandexProp.getTestProdCount(), yandexProp.getTestUsers());
    }
}
