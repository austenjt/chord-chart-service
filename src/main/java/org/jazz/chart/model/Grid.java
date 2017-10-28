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
public class Grid implements Serializable
{
	private static final long serialVersionUID = 1867867L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long grid_id;

	@Column
	private Integer row_size;

	@OneToMany(targetEntity=Line.class, cascade={CascadeType.ALL}, orphanRemoval=true, fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name="bars")
	private List<Line> lines = new ArrayList<>();

}