package org.jazz.chart;

import org.jazz.chart.db.ChartRepository;
import org.jazz.chart.model.Song;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ChartRepositoryTests
{
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ChartRepository customers;

    @Test
    @Transactional
    public void testFindByTitle()
    {
        Song chart = Song.builder()
                .title("Minor Swing")
                .build();

        this.entityManager.persist(chart);

        List<Song> findByTitleResponse = customers.findByTitle(chart.getTitle());
        assertTrue(findByTitleResponse.size()> 0);

        //assertThat(findByTitleResponse).extracting(Song::getTitle).containsOnly(chart.getTitle());
    }
}
