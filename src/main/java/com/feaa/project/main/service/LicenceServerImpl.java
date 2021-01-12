package com.feaa.project.main.service;

import com.feaa.project.main.model.Licence;
import com.feaa.project.main.repository.LicenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenceServerImpl  implements LicenceService{

    @Autowired
    LicenceRepository licenceRepository;

    @Override
    public List<Licence> findAllLicenceByContractId(Integer id) {
        return licenceRepository.findByContract_IdContract(id);
    }

    @Override
    public Licence updateLicence(Licence licence) {
        return licenceRepository.save(licence);
    }

    @Override
    public Licence findLicenceById(Integer id) {
        return licenceRepository.findLicenceByIdLicence(id);
    }

    @Override
    public Licence addLicence(Licence licence) {
        return licenceRepository.save(licence);
    }
}
