package com.epul.controlleur;

import com.epul.dao.ServiceGame;
import com.epul.dao.ServiceMission;
import com.epul.exception.CustomException;
import com.epul.metier.JeuEntity;
import com.epul.metier.MissionEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sacha on 16/05/2017.
 */
@Controller
@RequestMapping("/missions")
public class missionController {

    private static String ERROR_KEY = "messageErreur"; //todo refactor ?

    private ServiceMission service = new ServiceMission();

    @RequestMapping(value = "/")
    public ModelAndView getAllMissions(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Liste des Missions");
        request.setAttribute("list", service.getAll());
        return new ModelAndView("/missions/listMissions");
    }

    @RequestMapping("/add/")
    public ModelAndView getMissionForm(HttpServletRequest request) {
        request.setAttribute("actionSubmit", "/missions/insert/");
        return new ModelAndView("/missions/formMissions");
    }

    @RequestMapping("/insert/")
    public ModelAndView insertGame(HttpServletRequest request) {
        try {
            MissionEntity mission = new MissionEntity();
            mission.setNummission(service.getNextIdToInsert()); //todo refactor ?
            //mission.setNumjeu(request.getParameter("txtlibelle"));
            mission.setLibmission("todo");
            service.save(mission);
            return getAllMissions(request);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de sauvegarder la mission");
        }
        return errorPage();
    }

    @RequestMapping("/detail/{id}")
    public ModelAndView getMission(@PathVariable("id") int id, HttpServletRequest request) {
        try {
            if (id == 0) {
                request.setAttribute(ERROR_KEY, "Id manquant dans le path");
                return errorPage();
            }

            MissionEntity mission = service.get(id);

            if (mission == null) {
                request.setAttribute(ERROR_KEY, "Impossible d'obtenir la mission pour l'id saisie");
                return errorPage();
            }

            request.setAttribute("mission", mission);
            request.setAttribute("actionSubmit", "/missions/edit/");
            return new ModelAndView("/missions/formMissions");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible d'obtenir la mission pour l'id saisie");
        }
        return errorPage();
    }

    @RequestMapping("/edit/")
    public ModelAndView updateMission(HttpServletRequest request) throws CustomException {
        /*if(request.getParameter("txtId") == null || request.getParameter("txtlibelle").isEmpty()) {
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
        }*/
        //TODO : really necessary ?...
        return errorPage();
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView deleteMission(@PathVariable("id") int id, HttpServletRequest request) {
        if(id == 0) {
            request.setAttribute(ERROR_KEY, "Impossible de supprimer la mission sans son id.");
            return errorPage();
        }
        try {
            service.delete(service.get(id));
            return getAllMissions(request);
        } catch(Exception e){
            request.setAttribute(ERROR_KEY, "Impossible de supprimer la mission de la base");
        }
        return errorPage();
    }

    /***
     * Return Error ModalAndView
     * @return
     */
    public ModelAndView errorPage() {
        return new ModelAndView("error");
    } //TODO refactor ?
}
