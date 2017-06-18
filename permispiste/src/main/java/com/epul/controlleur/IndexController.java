package com.epul.controlleur;

import com.epul.dao.ServiceApprenant;
import com.epul.dao.ServiceInscrit;
import com.epul.dao.ServiceObtient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lafay on 03/05/2017.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String home(HttpServletRequest request){
        ServiceObtient serviceObtient =  new ServiceObtient();

        request.setAttribute("totalApprenants", new ServiceApprenant().countAll());
        request.setAttribute("totalParties",serviceObtient.getCount());
        request.setAttribute("moyenneScores", serviceObtient.getScoreAverage());
        request.setAttribute("nombrePartiesAujourdhui", new ServiceInscrit().getCountToday());
        return "home";
    }
}
