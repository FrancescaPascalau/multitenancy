package com.francesca.pascalau.config;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;

/**
 * It defines an execution point (using the @Pointcut annotation) for when a new Hibernate session is opened.
 * In this execution point (using the @AfterReturning annotation), it injects the required setup to apply
 * the Hibernate Filter
 */
@Aspect
public class TenantFilterAspect {

    @Pointcut("execution (* org.hibernate.internal.SessionFactoryImpl.SessionBuilderImpl.openSession(..))")
    public void openSession() {
    }

    @AfterReturning(pointcut = "openSession()", returning = "session")
    public void afterOpenSession(Object session) {
        if (session != null && Session.class.isInstance(session)) {
            final String tenantId = TenantContext.getCurrentTenant();
            if (tenantId != null) {
                org.hibernate.Filter filter = ((Session) session).enableFilter("tenantFilter");
                filter.setParameter("tenantId", tenantId);
            }
        }
    }
}