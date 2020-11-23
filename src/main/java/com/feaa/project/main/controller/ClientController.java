package com.feaa.project.main.controller;

import com.feaa.project.main.model.Client;
import com.feaa.project.main.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/")
    public String home(Model model){
        List<Client> listOfCLients = clientService.getAllClients();
        model.addAttribute("listOfClients", listOfCLients);
        return "MainPage";
    }

    @GetMapping("/showClientForm")
    public String navigateToClientForm(Model model){
        model.addAttribute("client", new Client());
        return "Client";
    }

    @PostMapping("/addClient")
    public String addClient(@ModelAttribute("client") Client client){
        // save to db
        clientService.addClientToDB(client);
        return "redirect:/";
    }

}
