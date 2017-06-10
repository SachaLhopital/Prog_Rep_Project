package com.epul.controlleur;

import com.epul.dao.ServiceAction;
import com.epul.dao.ServiceApprenant;
import com.epul.exception.CustomException;
import com.epul.metier.ActionEntity;
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

    private ServiceAction service = new ServiceAction();

    @Override
    @RequestMapping(value = "/")
    public ModelAndView getAll(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Liste des Actions");
        request.setAttribute("list", service.getAll());
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
            actionEntity.setNumaction(service.getNextIdToInsert());
            actionEntity.setLibaction("");
            service.save(actionEntity);
            return getAll(request);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de sauvegarder l'action.");
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

            List<ActionEntity> actions = service.getAll(id);

            if (actions == null) {
                request.setAttribute(ERROR_KEY, "Impossible d'obtenir les action pour l'apprenant sélectionné.");
                return errorPage();
            }

            request.setAttribute("list", actions);
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

            ActionEntity action = service.get(id);

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
            service.delete(service.get(id));
            return getAll(request);
        } catch(Exception e){
            request.setAttribute(ERROR_KEY, "Impossible de supprimer l'action.");
        }
        return errorPage();
    }
}