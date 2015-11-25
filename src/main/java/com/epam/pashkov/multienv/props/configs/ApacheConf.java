package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * User: Yaroslav_Pashkov
 * Date: 25.11.2015
 * Time: 11:44
 */
public class ApacheConf {
    private String path;

    public ApacheConf(String path) {
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
        String[] apacheUsers = propertiesConfiguration.getStringArray("test.users");
        return new CurrentConf(propertiesConfiguration.getString("test.login"), propertiesConfiguration.getInt("test.prodcount"),  apacheUsers);
    }
}
