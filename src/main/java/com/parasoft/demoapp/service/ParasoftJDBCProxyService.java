package com.parasoft.demoapp.service;

import com.parasoft.demoapp.config.datasource.DataSourceConfigurationProperties;
import com.parasoft.demoapp.config.datasource.DataSourceConfigurationProperties.*;
import com.parasoft.demoapp.config.datasource.IndustryDataSourceConfig;
import com.parasoft.demoapp.config.datasource.IndustryRoutingDataSource;
import com.parasoft.demoapp.exception.ParameterException;
import com.parasoft.demoapp.exception.VirtualizeServerUrlException;
import com.parasoft.demoapp.messages.GlobalPreferencesMessages;
import com.parasoft.demoapp.util.UrlUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.parasoft.demoapp.config.ParasoftJDBCProxyConfig.*;
import static com.parasoft.demoapp.config.datasource.IndustryRoutingDataSource.*;

@Service
@DependsOn("demoBugService")
public class ParasoftJDBCProxyService {
}
