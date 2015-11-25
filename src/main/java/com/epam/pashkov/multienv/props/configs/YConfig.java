package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;

/**
 * User: Yaroslav_Pashkov
 * Date: 25.11.2015
 * Time: 11:47
 */
public class YConfig {

    public CurrentConf getConfig() {
        YProperty yandexProp = new YProperty();
        return new CurrentConf(yandexProp.getTestLogin(), yandexProp.getTestProdCount(), yandexProp.getTestUsers());
    }
}
