package com.epul.controlleur;

import com.epul.dao.ServiceGame;
import com.epul.metier.JeuEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sacha on 15/05/2017.
 */
@Controller
@RequestMapping("/games")
public class gameController {

    private static String INSERER_JEU = "/games/insert/";

    private ServiceGame service = new ServiceGame();

    @RequestMapping(value = "/")
    public ModelAndView getAllGames(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Liste des Jeux");
        request.setAttribute("list", service.getAll());
        return new ModelAndView("/jeu/listGames");
    }

    @RequestMapping("/add/")
    public ModelAndView getGamesForm(HttpServletRequest request) {
        request.setAttribute("actionSubmit", INSERER_JEU);
        return new ModelAndView("/jeu/formGames");
    }

    @RequestMapping("/insert/")
    public ModelAndView insertGame(HttpServletRequest request) {
        try {
            JeuEntity jeu = new JeuEntity();
            jeu.setLibellejeu(request.getParameter("txtlibelle"));
            service.save(jeu);
            return getAllGames(request);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("messageErreur", "Impossible de sauvegarder le jeu");
        }
        return errorPage();
    }

    /***
     * Return Error ModalAndView
     * @return
     */
    public ModelAndView errorPage() {
        return new ModelAndView("erreur");
    }
}
