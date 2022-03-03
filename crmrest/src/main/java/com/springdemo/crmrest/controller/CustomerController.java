package com.springdemo.crmrest.controller;

import com.springdemo.crmrest.service.CustomerService;
import com.springdemo.crmrest.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {

        List<Customer> customerList=customerService.getCustomers();

        model.addAttribute("customerList",customerList);

        return "list-customers";
    }

    @GetMapping("/showFormToAdd")
    public String showFormToAdd(Model theModel){

        Customer theCustomer = new Customer();
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormToUpdate")
    public String showFormToUpdate(@RequestParam("customerId") int id,
                                   Model model) {

        Customer customer=customerService.getCustomer(id);
        model.addAttribute("customer",customer);

        return "customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int id){

        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

}
