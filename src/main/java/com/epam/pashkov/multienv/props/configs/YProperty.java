package com.epam.pashkov.multienv.props.configs;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

/**
 * Created by Yaroslav on 25.11.2015.
 */

@Resource.Classpath("config.properties")
public class YProperty {

    public YProperty() {
        PropertyLoader.populate(this);
    }

    @Property("test.login")
    private String testLogin;

    @Property("test.prodcount")
    private int testProdCount;

    @Property("test.users")
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
}
