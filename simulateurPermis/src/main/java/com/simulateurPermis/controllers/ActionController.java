package com.simulateurPermis.controllers;

import com.simulateurPermis.entities.ActionEntity;
import com.simulateurPermis.services.ActionService;
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
    private ActionService actionService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listActions(ModelMap map)
    {
        map.addAttribute("action", new ActionEntity());
        map.addAttribute("actionList", actionService.getAll());
        return "action";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAction(@ModelAttribute(value="action") ActionEntity action, BindingResult result)
    {
        actionService.add(action);
        return "redirect:/";
    }

    @RequestMapping("/delete/{actionId}")
    public String deleteAction(@PathVariable("actionId") int actionId)
    {
        actionService.delete(actionId);
        return "redirect:/";
    }

    public void setActionService(ActionService actionService) {
        this.actionService = actionService;
    }
}
