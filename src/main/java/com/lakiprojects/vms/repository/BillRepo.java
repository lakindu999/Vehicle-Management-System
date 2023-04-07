package com.lakiprojects.vms.repository;

import com.lakiprojects.vms.entity.Bill;
import com.lakiprojects.vms.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BillRepo extends JpaRepository<Bill,Integer> {
}
