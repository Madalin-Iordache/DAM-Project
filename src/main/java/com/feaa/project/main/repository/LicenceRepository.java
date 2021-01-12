package com.feaa.project.main.repository;

import com.feaa.project.main.model.Licence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenceRepository extends JpaRepository<Licence, Integer> {

    List<Licence> findByContract_IdContract(Integer id);

    Licence findLicenceByIdLicence(Integer id);

}
