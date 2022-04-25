package com.francesca.pascalau.data.entities;

import com.francesca.pascalau.data.entities.tenant.TenantAware;
import com.francesca.pascalau.data.entities.tenant.TenantListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@EntityListeners(TenantListener.class)
@FilterDef(name = "tenantFilter", parameters = {@ParamDef(name = "tenantId", type = "string")})
@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
public abstract class AbstractBaseEntity implements TenantAware, Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 30)
    @Column(name = "tenant_id")
    private String tenantId;

    public AbstractBaseEntity(String tenantId) {
        this.tenantId = tenantId;
    }
}