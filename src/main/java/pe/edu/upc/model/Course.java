package pe.edu.upc.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name="Curso")
public class Course implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_course;

	@Size(max = 80, message = "El nombre debe tener máximo 80 caracteres")
	@NotEmpty(message = "Ingrese un nombre para el curso")
	@Column(name="nombre", nullable=false, length=80)
	private String name;

	@Size(min = 1, max = 200, message = "El campo descripción está vacío")
	@NotEmpty(message = "Ingrese su descripción")
	@Column(name="descripción", nullable=false, length=200)
	private String description;

	@NotNull(message = "Ingrese un precio")
	@Min(value = 1, message = "Ingrese un precio mayor a 0")
	@Column(name="precio", nullable=false)
	private BigDecimal price;

	
	@NotNull(message = "Seleccione docente a cargo")
	@ManyToOne
	@JoinColumn(name="id_teacher", nullable=false)
	private Teacher teacher;


	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Course(int id_course,
			@NotEmpty(message = "Ingrese su nombre") @Pattern(regexp = "[^0-9]*", message = "El nombre no debe contener números") String name,
			@Size(min = 1, max = 200, message = "La descripción está vacía") @NotEmpty(message = "Ingrese su descripción") String description,
			@NotNull(message = "Ingrese un precio") @Min(value = 1, message = "Ingrese un precio mayor a 0") BigDecimal price,
			@NotNull(message = "Seleccione docente a cargo") Teacher teacher) {
		super();
		this.id_course = id_course;
		this.name = name;
		this.description = description;
		this.price = price;
		this.teacher = teacher;

	}

	public int getId_course() {
		return id_course;
	}

	public void setId_course(int id_course) {
		this.id_course = id_course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	
}
