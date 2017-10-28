package org.jazz.chart.db;

import java.util.List;
import java.util.Optional;

import org.jazz.chart.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface ChartRepository extends CrudRepository<Song, Long> {

    List<Song> findByTitle(String title);

    List<Song> findAll();

    Optional<Song> findById(Long id);

}