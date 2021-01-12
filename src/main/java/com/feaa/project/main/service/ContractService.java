package com.feaa.project.main.service;

import com.feaa.project.main.model.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> findAllContractsByClientId(Integer id);

    Contract createContract(Contract contract);

    Contract findContractById(Integer id);
}
