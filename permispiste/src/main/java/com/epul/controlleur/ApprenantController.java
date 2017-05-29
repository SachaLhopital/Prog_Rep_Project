package com.epul.controlleur;

import com.epul.dao.ServiceApprenant;
import com.epul.metier.ApprenantEntity;
import com.epul.metier.MissionEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sachouw on 25/05/2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/apprenants")
public class ApprenantController extends Controller {

    private ServiceApprenant service = new ServiceApprenant();

    @Override
    @RequestMapping(value = "/")
    public ModelAndView getAll(HttpServletRequest request) {
        request.setAttribute("list", service.getAll());
        return new ModelAndView("/apprenant/listApprenant");
    }

    @RequestMapping("/add/")
    public ModelAndView getForm(HttpServletRequest request) {
        request.setAttribute("actionSubmit", "/apprenants/insert/");
        return new ModelAndView("/apprenant/formApprenant");
    }

    @RequestMapping("/insert/")
    public ModelAndView insert(HttpServletRequest request) {
        try {
            ApprenantEntity apprenant = new ApprenantEntity();
            apprenant.setNomapprenant(request.getParameter("txtnom"));
            apprenant.setPrenomapprenant(request.getParameter("txtprenom"));
            service.save(apprenant);
            return getAll(request);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de sauvegarder le jeu");
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

            ApprenantEntity apprenant = service.get(id);

            if (apprenant == null) {
                request.setAttribute(ERROR_KEY, "Impossible d'obtenir la mission pour l'id saisie");
                return errorPage();
            }

            request.setAttribute("mission", apprenant);
            request.setAttribute("actionSubmit", "/missions/edit/");
            return new ModelAndView("/mission/formMissions");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible d'obtenir la mission pour l'id saisie");
        }
        return errorPage();
    }
}
