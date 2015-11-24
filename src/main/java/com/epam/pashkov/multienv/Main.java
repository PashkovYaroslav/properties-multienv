package com.epam.pashkov.multienv;

import com.epam.pashkov.multienv.props.YProperty;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.ResourceBundle;

/**
 * Created by Yaroslav on 24.11.2015.
 */
public class Main {
    public static void main(String[] args) throws ConfigurationException {
        // Standard Java properties
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        System.out.println(resourceBundle.getString("test.login"));
        System.out.println(resourceBundle.getString("test.password"));
        System.out.println(resourceBundle.getString("prod.login"));
        System.out.println(resourceBundle.getString("prod.password"));

        // Apache Java properties
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration("config.properties");
        System.out.println(propertiesConfiguration.getString("test.login"));
        propertiesConfiguration.setProperty("test.login", "User");
        propertiesConfiguration.save();
        System.out.println(propertiesConfiguration.getString("test.login"));

        // Yandex Properties
        YProperty yandexProp = new YProperty();
        System.out.println("Yandex: " + yandexProp.getTestLogin());
    }
}
