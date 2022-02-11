package com.SpringMVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.JPA.Entity.Customer;
import  com.service.Layer.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value="/list")
    public String listCustomers(Model theModel) {
        List < Customer > theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
    
	/*
	 * @GetMapping(value="/searchCustomer") public String
	 * searchListCustomers(@RequestParam("mobile") String theMobile, Model theModel)
	 * { List < Customer > theCustomers = customerService.searchCustomer(theMobile);
	 * theModel.addAttribute("customers", theCustomers); return
	 * "redirect:/customer/list"; }
	 */
    @RequestMapping("/searchCustomer")
    public String viewHomePage(Model model, @Param("mobile") String theMobile) {
        List<Customer> listProducts = customerService.searchCustomer(theMobile); //listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("mobile", theMobile);
         
        return "index";
    }
    
    
    
}