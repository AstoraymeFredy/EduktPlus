package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Matricula")
public class Registration implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_registration;
	
	@NotNull(message = "Seleccione curso")
	@ManyToOne
	@JoinColumn(name="id_course", nullable=false)
	private Course course;
	
	@NotNull(message = "Seleccione estudiante")
	@ManyToOne
	@JoinColumn(name="id_student", nullable=false)
	private Student student;
	
	@NotNull(message = "Ingrese la fecha")
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_register;
	
	@Column(name="enabled", nullable=false)
	private Boolean enabled;

}