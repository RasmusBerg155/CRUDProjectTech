package crudprojecttech.demo.Service;

import crudprojecttech.demo.model.Song;
import crudprojecttech.demo.Repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    SongRepo songRepo;

    public List<Song> fetchAll(){
        return songRepo.fetchAll();
    }

    public Song addSong(Song s){
        return songRepo.addSong(s);
    }

    public Song findSongByID(int id){
        return songRepo.findSongByID(id);
    }

    public Boolean deleteSong(int id){
        return songRepo.deleteSong(id);
    }

    public Song updateSong(int id, Song s){
        return songRepo.updateSong(id, s);
    }
}
