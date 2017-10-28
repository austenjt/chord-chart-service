package org.jazz.chart.model;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;
import java.io.Serializable;
import javax.persistence.*;

@CommonsLog
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Song implements Serializable
{
	private static final long serialVersionUID = 7435435L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String author;

	@Column
	private String title;

	@OneToOne(targetEntity = Info.class, cascade = { CascadeType.ALL }, orphanRemoval = true, fetch=FetchType.EAGER)
	private Info info;

	@OneToOne(targetEntity = Grid.class, cascade = { CascadeType.ALL }, orphanRemoval = true, fetch=FetchType.EAGER)
	private Grid grid;

	//@Column(name = "created")
	//@CreationTimestamp
	//private LocalDateTime created;

	//@Column(name = "updated")
	//@UpdateTimestamp
	//private LocalDateTime updated;

	public void updateSongStatistics(Song song)
	{
		Info songInfo = song.getInfo();
		if (songInfo.getBars() == null) {
			int barCount = countBars(song);
			songInfo.setBars(barCount);
			log.info("Updated song info: bars=" + barCount);
		}

		if ( (songInfo.getBpmeasure() != null && songInfo.getBpmeasure().intValue() > 0) &&
				(songInfo.getBpminute() != null && songInfo.getBpminute().intValue() > 0) &&
				(songInfo.getBars() != null && songInfo.getBars().intValue() > 0) )
		{
			int bars = songInfo.getBars().intValue();
			int bpmeasure = songInfo.getBpmeasure().intValue();
			int bpminute = songInfo.getBpminute().intValue();
			int calculatedLength = (bars * bpmeasure*60)/(bpminute);
			songInfo.setSeconds(calculatedLength);
			log.info("Updated song info: seconds=" + calculatedLength);
			double calculatedMinutes = calculatedLength/60.00;
			songInfo.setMinutes(Math.round(calculatedMinutes * 100D) / 100D);
			log.info("Updated song info: minutes=" + calculatedMinutes);
		}
	}

	public int countBars(Song song)
	{
		int count = 0;
		for (Line x : song.getGrid().getLines()) {
			for (Bar b : x.getBars()) {
				count++;
			}
		}
		return count;
	}

}