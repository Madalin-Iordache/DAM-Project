package com.feaa.project.main.service;

import com.feaa.project.main.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    void addClientToDB(Client client);
}
