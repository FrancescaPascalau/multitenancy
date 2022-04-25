package com.francesca.pascalau.data.entities.tenant;

import com.francesca.pascalau.config.TenantContext;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class TenantListener {

    @PreUpdate
    @PreRemove
    @PrePersist
    public void setTenant(TenantAware entity) {
        final String tenantId = TenantContext.getCurrentTenant();
        entity.setTenantId(tenantId);
    }
}