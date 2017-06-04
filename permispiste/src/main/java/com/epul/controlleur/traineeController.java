package com.epul.controlleur;

import com.epul.dao.ServiceGame;
import com.epul.dao.ServiceTrainee;
import com.epul.exception.CustomException;
import com.epul.metier.ApprenantEntity;
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
@RequestMapping("/trainees")
public class traineeController {

    private static String ERROR_KEY = "messageErreur";
    private static String INSERER_TRAINEE = "/trainees/insert/";

    private ServiceTrainee service = new ServiceTrainee();

    @RequestMapping(value = "/")
    public ModelAndView getAllTrainees(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Liste des Jeux");
        request.setAttribute("list", service.getAll());
        return new ModelAndView("/apprenant/listTrainees");
    }

    @RequestMapping("/add/")
    public ModelAndView getTraineeForm(HttpServletRequest request) {
        request.setAttribute("actionSubmit", INSERER_TRAINEE);
        return new ModelAndView("/apprenant/formTrainees");
    }

    @RequestMapping("/insert/")
    public ModelAndView insertTrainee(HttpServletRequest request) {
        try {
            ApprenantEntity apprenantEntity = new ApprenantEntity();
            apprenantEntity.setNumapprenant(service.getNextIdToInsert());
            apprenantEntity.setNomapprenant(request.getParameter("txtnom"));
            apprenantEntity.setPrenomapprenant(request.getParameter("txtprenom"));
            service.save(apprenantEntity);
            return getAllTrainees(request);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de sauvegarder l'apprenant");
        }
        return errorPage();
    }

    @RequestMapping("/detail/{id}")
    public ModelAndView getTrainee(@PathVariable("id") int id, HttpServletRequest request) {
        try {
            if (id == 0) {
                request.setAttribute(ERROR_KEY, "Id manquant dans le path");
                return errorPage();
            }

            ApprenantEntity apprenantEntity = service.get(id);

            if (apprenantEntity == null) {
                request.setAttribute(ERROR_KEY, "Impossible d'obtenir un apprenant pour l'id saisie");
                return errorPage();
            }

            request.setAttribute("apprenant", apprenantEntity);
            request.setAttribute("actionSubmit", "/trainees/edit/");
            return new ModelAndView("/apprenant/formTrainees");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible d'obtenir un apprenant pour l'id saisie");
        }
        return errorPage();
    }

    @RequestMapping("/edit/")
    public ModelAndView updateTrainee(HttpServletRequest request) throws CustomException {
        if(request.getParameter("txtNum") == null || request.getParameter("txtNom").isEmpty() || request.getParameter("txtPrenom").isEmpty()) {
            request.setAttribute(ERROR_KEY, "Il manque des arguments à la méthode updateTrainee");
            return errorPage();
        }

        try {
            ApprenantEntity apprenantEntity = service.get(Integer.parseInt(request.getParameter("txtNum")));
            apprenantEntity.setPrenomapprenant(request.getParameter("txtPrenom"));
            apprenantEntity.setNomapprenant(request.getParameter("txtNom"));
            service.save(apprenantEntity);
            return getAllTrainees(request);

        } catch(Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de mettre à jour l'apprenant");
        }
        return errorPage();
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView deleteTrainee(@PathVariable("id") int id, HttpServletRequest request) {
        if(id == 0) {
            request.setAttribute(ERROR_KEY, "Impossible de supprimer un apprenant sans son id.");
            return errorPage();
        }
        try {
            service.delete(service.get(id));
            return getAllTrainees(request);
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
