package com.feaa.project.main.controller;

import com.feaa.project.main.model.Contract;
import com.feaa.project.main.model.Licence;
import com.feaa.project.main.service.ContractServiceImpl;
import com.feaa.project.main.service.LicenceServerImpl;
import com.feaa.project.main.service.MetadataServiceImpl;
import com.feaa.project.main.utils.Constants;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class LicenceController {

    @Autowired
    MetadataServiceImpl metadataService;

    @Autowired
    LicenceServerImpl licenceServer;

    @Autowired
    ContractServiceImpl contractService;

    @PostMapping("/showLicence/{id}")
    public String showLicences(@PathVariable Integer id, Model model) {

        List<String> listOfLicenceTableColumn  = metadataService.getTableColumns(Constants.LICENCE);

        List<Licence> licenceList = licenceServer.findAllLicenceByContractId(id);

        model.addAttribute("listOfLicenceTableColumn", listOfLicenceTableColumn);
        model.addAttribute("listOfLicences", licenceList);
        model.addAttribute(contractService.findContractById(id));

        return "Licence";
    }



    public String generateRandomSerialNumber(){
        final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        final Random rng = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        int length = 7;
        while(length > 0){
            length--;
            sb.append(ALPHABET.charAt(rng.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    @GetMapping("/refreshLicence/{id}")
    public String renewSerialNumber(@ModelAttribute("licence") Licence licence, @PathVariable Integer id){

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 2);
            Date nextYear = calendar.getTime();
            Licence currentLicence = licenceServer.findLicenceById(id);
            currentLicence.setSerialNumber(generateRandomSerialNumber());
            currentLicence.setStatus("Active");
            currentLicence.setEndDate(nextYear);
            currentLicence.setStartDate(new Date());

            licenceServer.updateLicence(currentLicence);
            return "redirect:/";

    }

    @GetMapping(value = "/addLicence/{id}")
    public String addLicence(Model model, @PathVariable("id") Integer id){

        Licence licence = new Licence();
        licence.setSerialNumber(generateRandomSerialNumber());
        licence.setStartDate(new Date());

        Contract contract = contractService.findContractById(id);

        licence.setContract(contract);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 2);
        Date nextYear = calendar.getTime();
        licence.setEndDate(nextYear);

        licence.setStatus("Active");

        model.addAttribute(licence);
        licenceServer.addLicence(licence);

        return "redirect:/";
    }

}
