package org.jazz.chart.model;

import lombok.*;

import java.io.Serializable;
import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Info implements Serializable
{
	private static final long serialVersionUID = 768554L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long info_id;

	@Column
	private Integer seconds;

	@Column
	private Double minutes;

	@Column
	private Integer copyright;

	@Column
	private Integer bpmeasure;

	@Column
	private Integer bpminute;

	@Column
	private String genre;

	@Column
	private String status;

	@Column
	private Integer bars;

	@Column String key;

	@OneToOne(targetEntity = Intro.class, cascade = { CascadeType.ALL }, orphanRemoval = true, fetch=FetchType.EAGER)
	private Intro intro;

}