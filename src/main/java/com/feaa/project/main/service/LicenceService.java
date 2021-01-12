package com.feaa.project.main.service;

import com.feaa.project.main.model.Client;
import com.feaa.project.main.model.Contract;
import com.feaa.project.main.model.Licence;

import java.util.List;

public interface LicenceService {

    List<Licence> findAllLicenceByContractId(Integer id);

    Licence updateLicence(Licence Licence);

    Licence findLicenceById(Integer id);

    Licence addLicence(Licence licence);
}
