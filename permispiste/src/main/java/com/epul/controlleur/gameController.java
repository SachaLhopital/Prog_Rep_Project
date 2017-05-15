package com.epul.controlleur;

import com.epul.dao.ServiceGame;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sacha on 15/05/2017.
 */
@Controller
@RequestMapping(value = "/games")
public class gameController {

    private ServiceGame service = new ServiceGame();

    @RequestMapping(value = "/")
    public ModelAndView getAllGames(Model model){
        model.addAttribute("pageTitle", "Liste des Jeux");
        model.addAttribute("list", service.getAll());
        return new ModelAndView("listGames");
    }
}
