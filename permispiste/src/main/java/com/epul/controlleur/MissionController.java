package com.epul.controlleur;

import com.epul.dao.ServiceGame;
import com.epul.dao.ServiceMission;
import com.epul.entities.JeuEntity;
import com.epul.exception.CustomException;
import com.epul.entities.MissionEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Sacha on 16/05/2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/missions")
public class MissionController extends Controller {

    private ServiceMission service = new ServiceMission();

    /***
     * Récupère toutes les missions
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = "/")
    public ModelAndView getAll(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Liste des Missions");
        request.setAttribute("list", service.getAll());
        return new ModelAndView("/mission/listMissions");
    }

    /***
     * Redirige vers le formulaire d'ajout d'une mission
     * @param request
     * @return
     */
    @RequestMapping("/add/")
    public ModelAndView getForm(HttpServletRequest request) {
        request.setAttribute("actionSubmit", "/missions/insert/");
        ServiceGame serviceGame = new ServiceGame();
        List<JeuEntity> jeux = serviceGame.getAll();
        request.setAttribute("jeux", jeux);
        return new ModelAndView("/mission/formMissions");
    }

    /***
     * Redirige vers le formulaire d'ajout d'une mission pour un jeu
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/add/{id}")
    public ModelAndView getForm(@PathVariable("id") int id, HttpServletRequest request) {
        if(id==0){
            request.setAttribute(ERROR_KEY, "Id manquant dans le path");
            return errorPage();
        }
        ServiceGame serviceGame = new ServiceGame();
        JeuEntity jeu = serviceGame.get(id);
        List<JeuEntity> jeux = serviceGame.getAll();
        request.setAttribute("actionSubmit", "/missions/insert/");
        request.setAttribute("jeu", jeu);
        request.setAttribute("jeux", jeux);
        return new ModelAndView("/mission/formMissions");
    }

    /***
     * Insert une mission en base
     * @param request
     * @return
     */
    @RequestMapping("/insert/")
    public ModelAndView insert(HttpServletRequest request) {
        try {
            MissionEntity mission = new MissionEntity();
            mission.setNummission(service.getNextIdToInsert()); //todo refactor ?
            mission.setLibmission(request.getParameter("txtlibelle"));
            mission.setNumjeu(Integer.parseInt(request.getParameter("txtjeu")));
            service.save(mission);
            return new ModelAndView("redirect:/missions/") ;

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de sauvegarder la mission");
        }
        return errorPage();
    }

    /***
     * Récupère les détails d'une mission
     * @param id
     * @param request
     * @return
     */
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

    /***
     * Supprime une mission
     * @param id
     * @param request
     * @return
     */
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
