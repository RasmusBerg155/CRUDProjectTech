package crudprojecttech.demo.controller;


import crudprojecttech.demo.Service.SongService;
import crudprojecttech.demo.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    SongService songService;

    @GetMapping("/")
    public String showPage(Model model){
        List<Song> songList = songService.fetchAll();
        model.addAttribute("song", songList);
        return "home/index";
    }

    @GetMapping("/create")
    public String create(){
        return "home/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Song song){
        songService.addSong(song);
        return "redirect:/";
    }

    @GetMapping("/viewOne/{id}")
    public String viewOne(@PathVariable("id") int id, Model model){
        model.addAttribute("song", songService.findSongByID(id));
        return "home/viewOne";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        boolean deleted = songService.deleteSong(id);
        if (deleted) {
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("song", songService.findSongByID(id));
        return "home/update";
    }

    @PostMapping("/updateSong")
    public String updateSong(@ModelAttribute Song song){
        songService.updateSong(song.getId(), song);
        return "redirect:/";
    }
}
