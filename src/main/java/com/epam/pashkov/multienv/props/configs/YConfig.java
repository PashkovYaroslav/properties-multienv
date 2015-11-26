package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
import com.epam.pashkov.multienv.props.Environments;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

import static com.epam.pashkov.multienv.props.Constants.*;

/**
 * Created by Yaroslav on 25.11.2015.
 */

@Resource.Classpath(Path.CONFIG_PROPERTIES)
public class YConfig implements Config {

    public YConfig() {
        PropertyLoader.populate(this);
    }

    @Property(ParamNames.PROD_LOGIN_PARAM)
    private String prodLogin;

    @Property(ParamNames.PROD_COUNT_PARAM)
    private int prodCount;

    @Property(ParamNames.PROD_USERS_PARAM)
    private String[] prodUsers;

    @Property(ParamNames.TEST_LOGIN_PARAM)
    private String testLogin;

    @Property(ParamNames.TEST_COUNT_PARAM)
    private int testProdCount;

    @Property(ParamNames.TEST_USERS_PARAM)
    private String[] testUsers;

    public String getTestLogin() {
        return testLogin;
    }

    public int getTestProdCount() {
        return testProdCount;
    }

    public String[] getTestUsers() {
        return testUsers;
    }

    public String getProdLogin() {
        return prodLogin;
    }

    public int getProdCount() {
        return prodCount;
    }

    public String[] getProdUsers() {
        return prodUsers;
    }

    public CurrentConf getConfig(Environments envVersion) {
        if (envVersion.toString().equals(Environments.PROD.toString())) {
            return new CurrentConf(prodLogin, prodCount, prodUsers);
        } else {
            return new CurrentConf(testLogin, testProdCount, testUsers);
        }
    }
}
