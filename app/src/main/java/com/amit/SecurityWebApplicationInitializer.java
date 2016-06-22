package com.amit;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by amit on 2/6/16.
 */
@Order(value = 2)
public class SecurityWebApplicationInitializer
    extends AbstractSecurityWebApplicationInitializer {

}
