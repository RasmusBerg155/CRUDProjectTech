package crudprojecttech.demo.Repository;

import crudprojecttech.demo.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepo {
    @Autowired
    JdbcTemplate template;

    public List<Song> fetchAll(){
        String sql = "SELECT * FROM songs";
        RowMapper<Song> rowMapper = new BeanPropertyRowMapper<>(Song.class);
        return template.query(sql, rowMapper);
    }

    public Song addSong(Song s){
        String sql = "INSERT INTO songs (id, artist, album, song_name, duration) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, s.getId(), s.getArtist(), s.getAlbum(), s.getSong_name(), s.getDuration());
        return null;
    }

    public Song findSongByID(int id){
        String sql = "SELECT * FROM songs WHERE id = ?";
        RowMapper<Song> rowMapper = new BeanPropertyRowMapper<>(Song.class);
        Song s = template.queryForObject(sql, rowMapper, id);
        return s;
    }

    public Boolean deleteSong(int id){
        String sql = "DELETE FROM songs WHERE id = ?";
        return template.update(sql, id) < 0;
    }

    public Song updateSong(int id, Song s){
        String sql = "UPDATE songs SET id = ?, artist = ?, album = ?, song_name = ?, duration = ? WHERE id = ?";
        template.update(sql, s.getId(), s.getArtist(), s.getAlbum(), s.getSong_name(), s.getDuration(), s.getId());
        return null;
    }
}