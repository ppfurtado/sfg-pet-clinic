package com.ppfurtado.sfgpetclinic.controller;

import com.ppfurtado.sfgpetclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

//    private final VetService vetService;
//
//    public VetController(VetService vetService) {
//        this.vetService = vetService;
//    }

    @RequestMapping({"/vets","vets/index","vets/index.html"})
    public String listVets(){

        return "vets/index";
    }
}
