package com.epul.controlleur;

import com.epul.dao.ServiceFixe;
import com.epul.dao.ServiceGame;
import com.epul.dao.ServiceMission;
import com.epul.entities.FixeEntity;
import com.epul.entities.MissionEntity;
import com.epul.entities.ObjectifEntity;
import com.epul.exception.CustomException;
import com.epul.entities.JeuEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sacha on 15/05/2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/games")
public class GameController extends Controller {

    private static String INSERER_JEU = "/games/insert/";

    private ServiceGame serviceGame = new ServiceGame();
    private ServiceMission serviceMission = new ServiceMission();
    private ServiceFixe serviceFixe = new ServiceFixe();

    @Override
    @RequestMapping(value = "/")
    public ModelAndView getAll(HttpServletRequest request) {
        List<JeuEntity> jeux = serviceGame.getAll();
        Map<JeuEntity,Map<MissionEntity,List<ObjectifEntity>>> jeuMap = new HashMap<>();
        for (JeuEntity jeu : jeux){
            List<MissionEntity> missions = serviceMission.getAllFromJeu(jeu.getNumjeu());
            Map<MissionEntity,List<ObjectifEntity>> missionsMap = new HashMap<>();

            for (MissionEntity mission : missions){
                List<ObjectifEntity> objectifs = new ArrayList<>();
                List<FixeEntity> fixes = serviceFixe.getAllFromMission(mission.getNummission());
                for (FixeEntity fixe : fixes){
                    objectifs.add(fixe.getObjectif());
                }
                missionsMap.put(mission,objectifs);
            }
            jeuMap.put(jeu,missionsMap);
        }

        request.setAttribute("pageTitle", "Liste des Jeux");
        request.setAttribute("list", jeuMap);
        return new ModelAndView("/jeu/listGames");
    }

    /***
     * Retourne le formulaire d'un jeu
     * @param request
     * @return
     */
    @RequestMapping("/add/")
    public ModelAndView getForm(HttpServletRequest request) {
        request.setAttribute("actionSubmit", INSERER_JEU);
        return new ModelAndView("/jeu/formGames");
    }

    /***
     * Insert un jeu dans la bdd et redirige vers la vue générale
     * @param request
     * @return
     */
    @RequestMapping("/insert/")
    public ModelAndView insert(HttpServletRequest request) {
        try {
            JeuEntity jeu = new JeuEntity();
            jeu.setNumjeu(serviceGame.getNextIdToInsert());
            jeu.setLibellejeu(request.getParameter("txtlibelle"));
            serviceGame.save(jeu);
            return getAll(request);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de sauvegarder le jeu");
        }
        return errorPage();
    }

    /***
     * Redirige vers la vue détail d'un jeu
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

            JeuEntity jeu = serviceGame.get(id);

            if (jeu == null) {
                request.setAttribute(ERROR_KEY, "Impossible d'obtenir un jeu pour l'id saisie");
                return errorPage();
            }

            List<MissionEntity> missions = serviceMission.getAllFromJeu(jeu.getNumjeu());
            Map<MissionEntity,List<ObjectifEntity>> missionsMap = new HashMap<>();

            for (MissionEntity mission : missions){
                List<ObjectifEntity> objectifs = new ArrayList<>();
                List<FixeEntity> fixes = serviceFixe.getAllFromMission(mission.getNummission());
                for (FixeEntity fixe : fixes){
                    objectifs.add(fixe.getObjectif());
                }
                missionsMap.put(mission,objectifs);
            }

            request.setAttribute("jeu", jeu);
            request.setAttribute("missions", missionsMap);
            request.setAttribute("actionSubmit", "/games/edit/");
            return new ModelAndView("/jeu/formGames");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible d'obtenir un jeu pour l'id saisie");
        }
        return errorPage();
    }

    /***
     * Redirige vers le formulaire précomplété d'un jeu
     * @param request
     * @return
     * @throws CustomException
     */
    @RequestMapping("/edit/")
    public ModelAndView updateGame(HttpServletRequest request) throws CustomException {
        if(request.getParameter("txtId") == null || request.getParameter("txtlibelle").isEmpty()) {
            request.setAttribute(ERROR_KEY, "Il manque des arguments à la méthode update games");
            return errorPage();
        }

        try {
            JeuEntity jeuToUpdate = serviceGame.get(Integer.parseInt(request.getParameter("txtId")));
            jeuToUpdate.setLibellejeu(request.getParameter("txtlibelle"));
            serviceGame.save(jeuToUpdate);
            return getAll(request);

        } catch(Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de mettre à jour le jeu");
        }
        return errorPage();
    }

    /***
     * Supprime un jeu
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/delete/{id}")
    public ModelAndView deleteGame(@PathVariable("id") int id, HttpServletRequest request) {
        if(id == 0) {
            request.setAttribute(ERROR_KEY, "Impossible de supprimer un jeu sans son id.");
            return errorPage();
        }
        try {
            serviceGame.delete(serviceGame.get(id));
            return getAll(request);
        } catch(Exception e){
            request.setAttribute(ERROR_KEY, "Impossible de supprimer le jeu de la base");
        }
        return errorPage();
    }
}
