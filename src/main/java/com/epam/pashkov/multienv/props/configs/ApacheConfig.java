package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
import com.epam.pashkov.multienv.props.Environments;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import static com.epam.pashkov.multienv.props.Constants.*;

/**
 * User: Yaroslav_Pashkov
 * Date: 25.11.2015
 * Time: 11:44
 */
public class ApacheConfig implements Config {
    private String path;

    public ApacheConfig(String path) {
        this.path = path;
    }

    public CurrentConf getConfig(Environments envVersion) {
        PropertiesConfiguration propertiesConfiguration = null;
        try {
            propertiesConfiguration = new PropertiesConfiguration(path);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        String[] users = propertiesConfiguration.getStringArray(String.format(Patterns.USERS_PARAM_X, envVersion.toString()));
        return new CurrentConf(propertiesConfiguration.getString(String.format(Patterns.LOGIN_PARAM_X, envVersion.toString())),
                propertiesConfiguration.getInt(String.format(Patterns.COUNT_PARAM_X, envVersion.toString())), users);
    }
}
