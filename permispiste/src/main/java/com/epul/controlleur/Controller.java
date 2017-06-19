package com.epul.controlleur;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sachouw on 25/05/2017.
 */
public abstract class Controller {

    String ERROR_KEY = "messageErreur";

    public abstract ModelAndView getAll(HttpServletRequest request);
    public abstract ModelAndView get(@PathVariable("id") int id, HttpServletRequest request);

    /***
     * Return Error ModalAndView
     * @return
     */
    public ModelAndView errorPage() {
        return new ModelAndView("erreur");
    }
}
