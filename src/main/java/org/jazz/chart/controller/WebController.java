package org.jazz.chart.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.jazz.chart.db.ChartRepository;
import org.jazz.chart.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@CommonsLog
@Controller
public class WebController
{
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ChartRepository chartRepository;

    // WEB mappings
    // Ex: http://localhost:8080/?lang=fr

    @RequestMapping(value = {"/", "/index", "/home"}, method = RequestMethod.GET)
    String index(HttpSession session) {
        session.setAttribute("mySessionAttribute", "someValue");
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String list(HttpSession session, Model model) {
        model.addAttribute("songs", chartRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    String detail(HttpSession session, Model model) {
        Optional<Song> response = chartRepository.findById(1L);
        if (response.isPresent()) model.addAttribute("song", response.get());
        return "detail";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    String submit(HttpSession session) {
        return "submit";
    }

}
