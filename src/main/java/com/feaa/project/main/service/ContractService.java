package com.feaa.project.main.service;

import com.feaa.project.main.model.Client;
import com.feaa.project.main.model.Contract;

public interface ContractService {

    void createContract(Contract contract);

    void assignClientToContract(String idClient);

    void terminateContract(Contract contract);

    void updateContract(Contract contract);

}
