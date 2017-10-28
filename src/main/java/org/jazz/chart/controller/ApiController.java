package org.jazz.chart.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.jazz.chart.db.ChartRepository;
import org.jazz.chart.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import javax.persistence.EntityManager;
import java.util.List;

@CommonsLog
@Controller
public class ApiController
{
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ChartRepository chartRepository;

    @RequestMapping(value = "/app/findFirstByTitle", method = RequestMethod.GET)
    public @ResponseBody Song findFirstByTitle(@RequestParam(value="title") String title) {
        List<Song> response = chartRepository.findByTitle(title);
        if ( response.size() > 0) return response.get(0);
        return new Song();
    }

    @RequestMapping(value = "/app/findAll", method = RequestMethod.GET)
    public @ResponseBody List<Song> findAll() {
        return chartRepository.findAll();
    }

    //@RequestMapping(value = "/app/save", method = RequestMethod.POST)
    //String save(@ModelAttribute("song") Song song, Model model)
    //{
    //    song.updateSongStatistics(song);
    //    chartRepository.save(song);
    //    model.addAttribute("song", song);
    //    return "index";
    //}

    /**
     * For raw JSON submittal
     */
    @RequestMapping(value = "/app/submit", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String submitChart(@RequestBody Song song)
    {
        song.updateSongStatistics(song);
        chartRepository.save(song);
        return "SAVED " + song.getTitle();
    }

}
