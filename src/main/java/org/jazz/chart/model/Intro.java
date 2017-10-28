package org.jazz.chart.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Intro implements Serializable
{
	private static final long serialVersionUID = 1867867L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long intro_id;

	// Intro is a one liner object but could be changed
	@OneToOne(targetEntity=Line.class, cascade={CascadeType.ALL}, orphanRemoval=true, fetch=FetchType.EAGER)
	private Line line;

}