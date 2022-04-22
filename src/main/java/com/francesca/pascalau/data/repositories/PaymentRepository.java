package com.francesca.pascalau.data.repositories;

import com.francesca.pascalau.config.TenantContext;
import com.francesca.pascalau.data.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Override
    default List<Payment> findAll() {
        return findByTenantId(TenantContext.getCurrentTenant());
    }

    List<Payment> findByTenantId(String tenantId);
}
