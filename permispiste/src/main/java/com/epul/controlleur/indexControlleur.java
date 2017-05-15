package com.epul.controlleur;

import com.epul.dao.ServiceAction;
import com.epul.metier.ActionEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lafay on 03/05/2017.
 */
@Controller
public class indexControlleur {

    @RequestMapping("/")
    public String hello(Model model, @RequestParam(value="name",required =false, defaultValue = "world") String name){

        ServiceAction service = new ServiceAction();

        model.addAttribute("name", service.getAll().get(0).getLibaction());
        return "home";
    }
}
