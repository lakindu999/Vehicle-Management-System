package com.lakiprojects.vms.repository;

import com.lakiprojects.vms.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BillDetailRepo extends JpaRepository<BillDetail,Integer> {
}
