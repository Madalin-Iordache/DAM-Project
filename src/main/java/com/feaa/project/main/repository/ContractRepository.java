package com.feaa.project.main.repository;

import com.feaa.project.main.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer> {

}