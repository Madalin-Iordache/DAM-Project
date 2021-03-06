package com.feaa.project.main.repository;

import com.feaa.project.main.model.Contract;
import com.feaa.project.main.model.Licence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    List<Contract> findByClient_IdClient(Integer id);

}
