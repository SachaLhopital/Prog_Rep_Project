package com.simulateurPermis.controllers;

import com.simulateurPermis.metier.Action;
import com.simulateurPermis.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sachouw on 13/04/2017.
 */
@Controller
public class ActionController {

    @Autowired
    private ActionRepository actionRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listActions(ModelMap model) {
        model.addAttribute("action", new Action());
        model.addAttribute("actions", actionRepository.findAll());
        return "actions";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAction(@ModelAttribute("action") Action action, BindingResult result) {

        actionRepository.save(action);

        return "redirect:/";
    }

    @RequestMapping("/delete/{actionId}")
    public String deleteAction(@PathVariable("actionId") Long actionId) {

        actionRepository.delete(actionRepository.findOne(actionId));

        return "redirect:/";
    }
}
