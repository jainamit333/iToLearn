package com.amit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.linkedin.connect.LinkedInConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import javax.sql.DataSource;

/**
 * Created by amit on 19/6/16.
 */
@EnableSocial
@Configuration
@Import(SpringConfig.class)
public class SpringSocialSecurity implements SocialConfigurer {


    @Autowired
    DataSource dataSource;

    @Bean
    public ConnectController connectController(
            ConnectionFactoryLocator connectionFactoryLocator,
            ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connFact, Environment env) {
            connFact.addConnectionFactory(new FacebookConnectionFactory(env.getProperty("fb.api-key"),env.getProperty("fb.api-secret")));
            connFact.addConnectionFactory(new GoogleConnectionFactory(env.getProperty("google.app-key"),env.getProperty("google.app-secret")));
            connFact.addConnectionFactory(new TwitterConnectionFactory(env.getProperty("twitter.client-id"),env.getProperty("twitter.client-secret")));
            connFact.addConnectionFactory(new LinkedInConnectionFactory(env.getProperty("linkendin.api-key"),env.getProperty("linkendin.api-secret")));

    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
    }
}
