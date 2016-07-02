package com.amit.couch.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.util.Collections;
import java.util.List;

/**
 * Created by amit on 24/6/16.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.amit")
@EnableCouchbaseRepositories(basePackages = "com.amit.couch.impl")
public class CouchBaseConfig extends AbstractCouchbaseConfiguration implements TransactionManagementConfigurer {

    @Override
    protected List<String> getBootstrapHosts() {

        return Collections.singletonList("0.0.0.0");
    }

    @Override
    protected String getBucketName() {
        return "default";
    }

    @Override
    protected String getBucketPassword() {
        return "";
    }

    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager();
    }
}
