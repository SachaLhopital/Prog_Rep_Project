package com.epul.controlleur;

import com.epul.dao.ServiceInscrit;
import com.epul.exception.CustomException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sachouw on 14/06/2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/inscrits")
public class InscritController extends Controller {

    ServiceInscrit service = new ServiceInscrit();

    @Override
    @RequestMapping(value = "/")
    public ModelAndView getAll(HttpServletRequest request) {
        try {
            request.setAttribute("list", service.getAll());
            return new ModelAndView("/inscrit/listInscrit");
        } catch (CustomException e) {
            e.printStackTrace();
            request.setAttribute(ERROR_KEY, e.getMessage());
        }
        return errorPage();
    }

    @Override
    public ModelAndView getForm(HttpServletRequest request) {
        //Todo
        return null;
    }

    @Override
    public ModelAndView insert(HttpServletRequest request) {
        //Todo
        return null;
    }

    @Override
    public ModelAndView get(int id, HttpServletRequest request) {
        //Todo
        return null;
    }
}
