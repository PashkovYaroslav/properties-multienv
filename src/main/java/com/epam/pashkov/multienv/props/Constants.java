package com.epam.pashkov.multienv.props;

/**
 * User: Yaroslav_Pashkov
 * Date: 25.11.2015
 * Time: 15:43
 */

public class Constants {

    public static class Path {
        public static final String SRC_CONFIG_PROPERTIES = "src/main/resources/config.properties";
        public static final String GROOVY_CONFIG = "src/main/resources/config.groovy";
        public static final String CONFIG_PROPERTIES = "config.properties";
    }

    public static class ParamNames {
        public static final String TEST_LOGIN_PARAM = "test.login";
        public static final String TEST_COUNT_PARAM = "test.prodcount";
        public static final String TEST_USERS_PARAM = "test.users";

        public static final String PROD_LOGIN_PARAM = "prod.login";
        public static final String PROD_COUNT_PARAM = "prod.prodcount";
        public static final String PROD_USERS_PARAM = "prod.users";
    }

    public static class Patterns {
        public static final String LOGIN_PARAM_X = "%s.login";
        public static final String COUNT_PARAM_X = "%s.prodcount";
        public static final String USERS_PARAM_X = "%s.users";
    }
}
