package org.jazz.chart.model;

import lombok.*;

import java.io.Serializable;
import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@NamedQuery(name="Bar.findAll", query="SELECT b FROM Bar b")
public class Bar implements Serializable
{
	private static final long serialVersionUID = 8768687L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bar_id;

	@Column
	private String chord;

}