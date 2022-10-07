package com.donuscode.domain.repository;

import com.donuscode.domain.entity.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {

   ContaBancaria findByNumeroConta(String conta);

}
