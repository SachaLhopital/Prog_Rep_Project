package com.epul.controlleur;

import com.epul.dao.ServiceAction;
import com.epul.dao.ServiceApprenant;
import com.epul.dao.ServiceObtient;
import com.epul.exception.CustomException;
import com.epul.entities.ActionEntity;
import com.epul.entities.ObtientEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Sacha on 16/05/2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/actions")
public class ActionController extends Controller {

    private ServiceAction serviceAction = new ServiceAction();
    private ServiceObtient serviceObtient = new ServiceObtient();

    @Override
    @RequestMapping(value = "/")
    public ModelAndView getAll(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Liste des Actions");
        request.setAttribute("list", serviceAction.getAll());
        return new ModelAndView("/action/listActions");
    }

    @RequestMapping("/add/")
    public ModelAndView getForm(HttpServletRequest request) {
        request.setAttribute("actionSubmit", "/action/insert/");
        return new ModelAndView("/action/formAction");
    }
    @Override
    public ModelAndView insert(HttpServletRequest request) {
        try {
            ActionEntity actionEntity = new ActionEntity();
            actionEntity.setNumaction(serviceAction.getNextIdToInsert());
            actionEntity.setLibaction("");
            serviceAction.save(actionEntity);
            return getAll(request);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de sauvegarder l'action.");
        }
        return errorPage();
    }

    @RequestMapping("/apprenant/all")
    public ModelAndView getAllGamesLaunched(HttpServletRequest request){
        try {
            List<ObtientEntity> obtient = serviceObtient.getAll();

            if (obtient == null) {
                request.setAttribute(ERROR_KEY, "Impossible d'obtenir les parties lancées.");
                return errorPage();
            }

            request.setAttribute("list", obtient);
            request.setAttribute("actionSubmit", "/actions/edit/");
            return new ModelAndView("/action/listActionsApprenantAll");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible d'obtenir les action pour l'apprenant sélectionné.");
        }
        return errorPage();
    }

    @RequestMapping("/apprenant/{id}")
    public ModelAndView getAll(@PathVariable("id") int id, HttpServletRequest request) {
        try {
            if (id == 0) {
                request.setAttribute(ERROR_KEY, "Id manquant dans le path");
                return errorPage();
            }

            serviceObtient.getAll();

            List<ObtientEntity> obtients = serviceObtient.getAllFromApprenant(id);

            if (obtients == null) {
                request.setAttribute(ERROR_KEY, "Impossible d'obtenir les action pour l'apprenant sélectionné.");
                return errorPage();
            }

            request.setAttribute("list", obtients);
            request.setAttribute("trainee", new ServiceApprenant().get(id));
            request.setAttribute("actionSubmit", "/actions/edit/");
            return new ModelAndView("/action/listActionsApprenant");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible d'obtenir les action pour l'apprenant sélectionné.");
        }
        return errorPage();
    }

    @RequestMapping("/detail/{id}")
    public ModelAndView get(@PathVariable("id") int id, HttpServletRequest request) {
        try {
            if (id == 0) {
                request.setAttribute(ERROR_KEY, "Aucune action sélectionnée.");
                return errorPage();
            }

            ActionEntity action = serviceAction.get(id);

            if (action == null) {
                request.setAttribute(ERROR_KEY, "Impossible d'obtenir l'action sélectionnée.");
                return errorPage();
            }

            request.setAttribute("action", action);
            request.setAttribute("actionSubmit", "/action/edit/");
            return new ModelAndView("/action/formAction");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible d'obtenir l'action sélectionnée.");
        }
        return errorPage();
    }

    @RequestMapping("/edit/")
    public ModelAndView updateAction(HttpServletRequest request) throws CustomException {
        return errorPage();
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView deleteAction(@PathVariable("id") int id, HttpServletRequest request) {
        if(id == 0) {
            request.setAttribute(ERROR_KEY, "Aucune action sélectionnée.");
            return errorPage();
        }
        try {
            serviceAction.delete(serviceAction.get(id));
            return getAll(request);
        } catch(Exception e){
            request.setAttribute(ERROR_KEY, "Impossible de supprimer l'action.");
        }
        return errorPage();
    }
}
