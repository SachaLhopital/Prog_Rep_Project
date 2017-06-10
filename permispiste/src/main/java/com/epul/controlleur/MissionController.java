package com.epul.controlleur;

import com.epul.dao.ServiceMission;
import com.epul.exception.CustomException;
import com.epul.metier.MissionEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sacha on 16/05/2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/missions")
public class MissionController extends Controller {

    private ServiceMission service = new ServiceMission();

    @Override
    @RequestMapping(value = "/")
    public ModelAndView getAll(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Liste des Missions");
        request.setAttribute("list", service.getAll());
        return new ModelAndView("/mission/listMissions");
    }

    @RequestMapping("/add/")
    public ModelAndView getForm(HttpServletRequest request) {
        request.setAttribute("actionSubmit", "/missions/insert/");
        return new ModelAndView("/mission/formMissions");
    }

    @RequestMapping("/insert/")
    public ModelAndView insert(HttpServletRequest request) {
        try {
            MissionEntity mission = new MissionEntity();
            mission.setNummission(service.getNextIdToInsert()); //todo refactor ?
            mission.setLibmission("todo");
            service.save(mission);
            return getAll(request);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de sauvegarder la mission");
        }
        return errorPage();
    }

    @RequestMapping("/detail/{id}")
    public ModelAndView get(@PathVariable("id") int id, HttpServletRequest request) {
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
            return new ModelAndView("/mission/formMissions");

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
            return getAll(request);
        } catch(Exception e){
            request.setAttribute(ERROR_KEY, "Impossible de supprimer la mission de la base");
        }
        return errorPage();
    }
}
