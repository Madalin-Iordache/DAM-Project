package com.feaa.project.main.controller;

import com.feaa.project.main.model.Client;
import com.feaa.project.main.model.Contract;
import com.feaa.project.main.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class ContractController {

    @Autowired
    ContractService contractService;

    @PostMapping("/addContract/{id}")
    public ModelAndView addContract(@ModelAttribute("contract") Contract contract, @ModelAttribute("client") Client client, @PathVariable(value="id") final Integer id, Model model){
        // save to db

        client.setIdClient(id);

        contract.setClient(client);
        model.addAttribute(contract);
        Date currentDate = new Date();

        contract.setSignedDate(currentDate);
        System.out.println(contract);
        contractService.createContract(contract);
        return new ModelAndView("redirect:/");
    }

}
