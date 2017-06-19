package com.epul.controlleur;

import com.epul.dao.*;
import com.epul.entities.*;
import com.epul.exception.CustomException;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lafay on 18/06/2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/simulations")
public class SimulationController extends Controller{

    final static int MAX_NOTE = 20;

    private ServiceMission serviceMission = new ServiceMission();
    private ServiceApprenant serviceApprenant= new ServiceApprenant();
    private ServiceObtient serviceObtient = new ServiceObtient();
    private ServiceGame serviceJeu = new ServiceGame();
    private ServiceInscrit serviceInscrit = new ServiceInscrit();


    @Override
    public ModelAndView getAll(HttpServletRequest request) {
        return null;
    }

    @Override
    @RequestMapping(value = "/")
    public ModelAndView getForm(HttpServletRequest request) {
        return new ModelAndView("/simulation/formConnexionSimulation");
    }

    @RequestMapping(value = "/verif_user")
    public ModelAndView checkUser(HttpServletRequest request) {
        List<ApprenantEntity> apprenants = serviceApprenant.getAll();
        for(ApprenantEntity apprenant:apprenants){
            if(apprenant.getNomapprenant().equals(request.getParameter("txtNom"))){
                request.setAttribute("jeux",serviceJeu.getAll());
                request.setAttribute("num_apprenant",apprenant.getNumapprenant());
                return new ModelAndView("/simulation/listGames");
            }
        }
        request.setAttribute(ERROR_KEY,"Apprenant non reconu.");
        return new ModelAndView("/simulation/formConnexionSimulation");
    }

    @RequestMapping(value = "/select_game")
    public ModelAndView getListGames(HttpServletRequest request) {

        int numApprenant = Integer.parseInt(request.getParameter("num_apprenant"));
        int numJeu = Integer.parseInt(request.getParameter("num_jeu"));

        ApprenantEntity apprenantEntity = serviceApprenant.get(numApprenant);
        CalendrierEntity calendrierEntity = new CalendrierEntity();
        calendrierEntity.setDatejour(Date.valueOf(LocalDate.now()));
        new ServiceCalendrier().save(calendrierEntity);


        //inscription de l'aprenant
        //verification de l'inscription

        InscritEntity inscription;
        try{
            inscription = serviceInscrit.getInscription(numApprenant,numJeu);
        } catch (CustomException e) {
            e.printStackTrace();
            inscription = null;

        }
        if(inscription == null){
            inscription = new InscritEntity();
            inscription.setNumjeu(numJeu);
            inscription.setNumapprenant(numApprenant);
            inscription.setDatejour(calendrierEntity.getDatejour());
            new ServiceInscrit().save(inscription);
        }


        //génération de valeurs aléatoires et affichage
        //récupération des missions
        List<MissionEntity> missions = serviceMission.getAllFromJeu(numJeu);

        //récupération des actions
        List<ActionEntity> actions = new ArrayList<>();
        for(MissionEntity mission:missions){

            for(FixeEntity fixeEntity:mission.getObjectifs()){
                for(EstAssocieEntity estAssocieEntity:fixeEntity.getObjectif().getEstAssocie()){
                    actions.add(estAssocieEntity.getAction());
                }

            }

        }

        //atribution d'une note aléatoire
        for(ActionEntity actionEntity:actions){
            ObtientEntity obtientEntity = serviceObtient.get(numApprenant,actionEntity.getNumaction());
            if(obtientEntity == null){
                obtientEntity = new ObtientEntity();
                obtientEntity.setNumapprenant(numApprenant);
                obtientEntity.setNumaction(actionEntity.getNumaction());
                /*obtientEntity.setAction(actionEntity);
                obtientEntity.setApprenant(apprenantEntity);*/
            }

            obtientEntity.setDatejour(calendrierEntity.getDatejour());
            obtientEntity.setValeurdebut(1);
            obtientEntity.setValeurfin(new Random().nextInt(MAX_NOTE));

            serviceObtient.save(obtientEntity);
        }

        try {
            serviceObtient.getAll();

            List<ObtientEntity> obtients = serviceObtient.getAllForApprenant(numApprenant);

            if (obtients == null) {
                request.setAttribute(ERROR_KEY, "Impossible d'obtenir les action pour l'apprenant sélectionné.");
                return errorPage();
            }

            request.setAttribute("list", obtients);
            request.setAttribute("trainee", new ServiceApprenant().get(numApprenant));
            return new ModelAndView("/action/listActionsApprenant");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible d'obtenir les action pour l'apprenant sélectionné.");
        }
        return errorPage();



    }



    @Override
    public ModelAndView insert(HttpServletRequest request) {
        return null;
    }

    @Override
    public ModelAndView get(int id, HttpServletRequest request) {
        return null;
    }
}
