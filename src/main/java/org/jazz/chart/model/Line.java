package org.jazz.chart.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@NamedQuery(name="Line.findAll", query="SELECT l FROM Line l")
public class Line implements Serializable
{
	private static final long serialVersionUID = 53244523L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long line_id;

	@Column
	private Integer bar_size;

	@OneToMany(targetEntity=Bar.class, cascade={CascadeType.ALL}, orphanRemoval=true, fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name="bar")
	private List<Bar> bars = new ArrayList<>();

}