package com.epam.pashkov.multienv.props;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

/**
 * Created by Yaroslav on 25.11.2015.
 */
@Resource.Classpath("config.properties")
public class YProperty {

    public YProperty() {
        PropertyLoader.populate(this); //инициализация полей класса значениями из файла
    }

    @Property("test.login")
    private String testLogin;

    @Property("test.password")
    private String testPassword;

    @Property("prod.login")
    private String prodLogin;

    @Property("prod.password")
    private String prodPassword;

    public String getTestLogin() {
        return testLogin;
    }

    public String getTestPassword() {
        return testPassword;
    }

    public String getProdLogin() {
        return prodLogin;
    }

    public String getProdPassword() {
        return prodPassword;
    }
}
