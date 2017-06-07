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
public class IndexController {

    @RequestMapping("/")
    public String hello(){
        return "home";
    }
}
