package com.feaa.project.main.service;

import com.feaa.project.main.model.Client;
import com.feaa.project.main.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void addClientToDB(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClientFromDB(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client getClientById(Integer id) {
        return clientRepository.getOne(id);
    }


    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }
}
