package com.epul.controlleur;

import com.epul.dao.ServiceGame;
import com.epul.exception.CustomException;
import com.epul.metier.JeuEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sacha on 15/05/2017.
 */
@Controller
@RequestMapping("/games")
public class gameController {

    private static String ERROR_KEY = "messageErreur";
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
            jeu.setNumjeu(service.getNextIdToInsert());
            jeu.setLibellejeu(request.getParameter("txtlibelle"));
            service.save(jeu);
            return getAllGames(request);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de sauvegarder le jeu");
        }
        return errorPage();
    }

    @RequestMapping("/detail/{id}")
    public ModelAndView getGame(@PathVariable("id") int id, HttpServletRequest request) {
        try {
            if (id == 0) {
                request.setAttribute(ERROR_KEY, "Id manquant dans le path");
                return errorPage();
            }

            JeuEntity jeu = service.get(id);

            if (jeu == null) {
                request.setAttribute(ERROR_KEY, "Impossible d'obtenir un jeu pour l'id saisie");
                return errorPage();
            }

            request.setAttribute("jeu", jeu);
            request.setAttribute("actionSubmit", "/games/edit/");
            return new ModelAndView("/jeu/formGames");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible d'obtenir un jeu pour l'id saisie");
        }
        return errorPage();
    }

    @RequestMapping("/edit/")
    public ModelAndView updateGame(HttpServletRequest request) throws CustomException {
        if(request.getParameter("txtId") == null || request.getParameter("txtlibelle").isEmpty()) {
            request.setAttribute(ERROR_KEY, "Il manque des arguments à la méthode update games");
            return errorPage();
        }

        try {
            JeuEntity jeuToUpdate = service.get(Integer.parseInt(request.getParameter("txtId")));
            jeuToUpdate.setLibellejeu(request.getParameter("txtlibelle"));
            service.save(jeuToUpdate);
            return getAllGames(request);

        } catch(Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de mettre à jour le jeu");
        }
        return errorPage();
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView deleteGame(@PathVariable("id") int id, HttpServletRequest request) {
        if(id == 0) {
            request.setAttribute(ERROR_KEY, "Impossible de supprimer un jeu sans son id.");
            return errorPage();
        }
        try {
            service.delete(service.get(id));
            return getAllGames(request);
        } catch(Exception e){
            request.setAttribute(ERROR_KEY, "Impossible de supprimer le jeu de la base");
        }
        return errorPage();
    }

    /***
     * Return Error ModalAndView
     * @return
     */
    public ModelAndView errorPage() {
        return new ModelAndView("error");
    }
}
