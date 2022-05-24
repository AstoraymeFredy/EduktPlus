package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Curso")
public class Course implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_course;

	@NotEmpty(message = "Ingrese su nombre")
	@Column(name="nombre", nullable=false, length=80)
	private String name;
	
	@NotEmpty(message = "Ingrese su descripción")
	@Column(name="descripción", nullable=false, length=200)
	private String description;
	
	@Column(name="precio", nullable=false)
	private float price;
	
	@NotNull(message = "Seleccione docente a cargo")
	@ManyToOne
	@JoinColumn(name="id_teacher", nullable=false)
	private Teacher teacher;
	
	@Column(name="enabled", nullable=false)
	private Boolean enabled;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id_course, @NotEmpty(message = "Ingrese su nombre") String name,
			@NotEmpty(message = "Ingrese su descripción") String description, float price,
			@NotNull(message = "Seleccione docente a cargo") Teacher teacher, Boolean enabled) {
		super();
		this.id_course = id_course;
		this.name = name;
		this.description = description;
		this.price = price;
		this.teacher = teacher;
		this.enabled = enabled;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
