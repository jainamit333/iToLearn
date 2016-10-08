package com.amit;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import javax.servlet.Filter;
/**
 * Created by amit on 2/6/16.
 */
@Order(value = 1)
public class ApplicationIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringConfig.class ,SecurityConfig.class,SpringSocialSecurity.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/","/itolearn","/itolearn/*"};
    }


    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);

        DelegatingFilterProxy reconnectDelegate = new DelegatingFilterProxy("apiExceptionHandler");

        return new Filter[] { reconnectDelegate, encodingFilter, new HiddenHttpMethodFilter() };
    }

}
