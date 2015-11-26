package com.epam.pashkov.multienv.props.configs;

import com.epam.pashkov.multienv.props.CurrentConf;
import com.epam.pashkov.multienv.props.Environments;

/**
 * Created by Yaroslav on 26.11.2015.
 */
public interface Config {
    public CurrentConf getConfig(Environments envVersion);
}
