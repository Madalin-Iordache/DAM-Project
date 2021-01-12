package com.feaa.project.main.service;

import com.feaa.project.main.model.Contract;
import com.feaa.project.main.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {


    @Autowired
    ContractRepository contractRepository;

    public List<Contract> findAllContractsByClientId(Integer idClient) {
        return contractRepository.findByClient_IdClient(idClient);
    }

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract findContractById(Integer id) {
        return contractRepository.getOne(id);
    }


}
