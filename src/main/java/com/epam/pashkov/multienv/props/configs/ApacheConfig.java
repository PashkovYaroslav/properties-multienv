package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import static com.epam.pashkov.multienv.props.Constants.*;

/**
 * User: Yaroslav_Pashkov
 * Date: 25.11.2015
 * Time: 11:44
 */
public class ApacheConfig {
    private String path;

    public ApacheConfig(String path) {
        this.path = path;
    }

    public CurrentConf getConfig() {
        PropertiesConfiguration propertiesConfiguration = null;
        try {
            propertiesConfiguration = new PropertiesConfiguration(path);
        }
        catch (ConfigurationException e) {
            e.printStackTrace();
        }
        String[] apacheUsers = propertiesConfiguration.getStringArray(ParamNames.TEST_USERS_PARAM);
        return new CurrentConf(propertiesConfiguration.getString(ParamNames.TEST_LOGIN_PARAM), propertiesConfiguration
                .getInt(ParamNames.TEST_PRODCOUNT_PARAM),  apacheUsers);
    }
}
