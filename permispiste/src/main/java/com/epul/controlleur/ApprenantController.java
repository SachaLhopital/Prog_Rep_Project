package com.epul.controlleur;

import com.epul.dao.ServiceApprenant;
import com.epul.exception.CustomException;
import com.epul.entities.ApprenantEntity;
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

    /***
     * Récupère tous les apprenants et les affiche sour forme d'une liste
     * @param request
     * @return
     */
    @Override
    @RequestMapping(value = "/")
    public ModelAndView getAll(HttpServletRequest request) {
        request.setAttribute("list", service.getAll());
        request.setAttribute("total", service.countAll());
        return new ModelAndView("/apprenant/listApprenant");
    }

    /***
     * Redirige vers le formulaire d'ajout d'un apprenant
     * @param request
     * @return
     */
    @RequestMapping("/add/")
    public ModelAndView getForm(HttpServletRequest request) {
        request.setAttribute("actionSubmit", "/apprenants/insert/");
        return new ModelAndView("/apprenant/formApprenant");
    }

    /***
     * Insert l'adhérent dans la base
     * @param request
     * @return
     */
    @RequestMapping("/insert/")
    public ModelAndView insert(HttpServletRequest request) {
        try {
            ApprenantEntity apprenant = new ApprenantEntity();
            apprenant.setNumapprenant(service.getNextIdToInsert());
            apprenant.setNomapprenant(request.getParameter("txtnom"));
            apprenant.setPrenomapprenant(request.getParameter("txtprenom"));
            service.save(apprenant);
            return getAll(request);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de sauvegarder l'apprenant");
        }
        return errorPage();
    }

    /***
     * Redirige sur le formulaire d'un adhérent précomplété
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

            ApprenantEntity apprenant = service.get(id);

            if (apprenant == null) {
                request.setAttribute(ERROR_KEY, "Impossible d'obtenir l'apprenant pour l'id saisie");
                return errorPage();
            }

            request.setAttribute("apprenant", apprenant);
            request.setAttribute("actionSubmit", "/apprenants/edit/");
            return new ModelAndView("/apprenant/formApprenant");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible d'obtenir l'apprenant pour l'id saisie");
        }
        return errorPage();
    }

    /***
     * Update un apprenant à partir du formulaire
     * @param request
     * @return
     * @throws CustomException
     */
    @RequestMapping("/edit/")
    public ModelAndView updateTrainee(HttpServletRequest request) throws CustomException {
        if(request.getParameter("txtId") == null || request.getParameter("txtnom").isEmpty() || request.getParameter("txtprenom").isEmpty()) {
            request.setAttribute(ERROR_KEY, "Il manque des arguments à la méthode updateTrainee");
            return errorPage();
        }

        try {
            ApprenantEntity apprenantEntity = service.get(Integer.parseInt(request.getParameter("txtId")));
            apprenantEntity.setPrenomapprenant(request.getParameter("txtprenom"));
            apprenantEntity.setNomapprenant(request.getParameter("txtnom"));
            service.save(apprenantEntity);
            return getAll(request);

        } catch(Exception e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, "Impossible de mettre à jour l'apprenant");
        }
        return errorPage();
    }

    /***
     * Supprime un apprenant
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/delete/{id}")
    public ModelAndView deleteTrainee(@PathVariable("id") int id, HttpServletRequest request) {
        if(id == 0) {
            request.setAttribute(ERROR_KEY, "Impossible de supprimer un apprenant sans son id.");
            return errorPage();
        }
        try {
            service.delete(service.get(id));
            return getAll(request);
        } catch(Exception e){
            request.setAttribute(ERROR_KEY, "Impossible de supprimer l'apprenant de la base");
        }
        return errorPage();
    }
}
