package com.francesca.pascalau.data.repositories;

import com.francesca.pascalau.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Override
//    default List<Employee> findAll() {
//        return findByTenantId(TenantContext.getCurrentTenant());
//    }
//
//    List<Employee> findByTenantId(String tenantId);
}
