package com.feaa.project.main.controller;

import com.feaa.project.main.model.Client;
import com.feaa.project.main.service.ClientServiceImpl;
import com.feaa.project.main.service.MetadataServiceImpl;
import com.feaa.project.main.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.beans.IntrospectionException;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private MetadataServiceImpl metadataService;

    @GetMapping("/")
    public String home(Model model){
        List<Client> listOfCLients = clientService.getAllClients();
        model.addAttribute("listOfClients", listOfCLients);
        return "MainPage";
    }

    @PostMapping("/goToMainPage")
    public String returnToHomePage(){
        return "redirect:/";
    }

    @GetMapping("/showClientForm")
    public String navigateToClientForm(Model model){
        model.addAttribute("client", new Client());
        return "Client";
    }

    @PostMapping("/updateClient/{id}")
    public String updateClient(@ModelAttribute("client") Client client, @PathVariable Integer id){
        client.setIdClient(id);
        clientService.updateClient(client);
        return "redirect:/";
    }

    @PostMapping("/addClient")
    public String addClient(@ModelAttribute("client") Client client){
        // save to db
        clientService.addClientToDB(client);
        return "redirect:/";
    }

    @PostMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable Integer id){
        // delete from db
        clientService.deleteClientFromDB(id);
        return "redirect:/";

    }

    @PostMapping("/editClient/{id}")
    public String editClient(@PathVariable Integer id,  Model model) throws IntrospectionException {
        List<String> listOfColumns  = metadataService.getTableColumns(Constants.CLIENT);
        Client client = clientService.getClientById(id);
        model.addAttribute("listOfColumns", listOfColumns);
        model.addAttribute("client", client);


        return "EditClient";
    }

}
