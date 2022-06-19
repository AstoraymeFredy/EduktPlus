package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Calendar;

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
	private Calendar date_register;
	
	@Column(name="enabled", nullable=false)
	private Boolean enabled;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(int id_registration, @NotNull(message = "Seleccione curso") Course course,
			@NotNull(message = "Seleccione estudiante") Student student,
			@NotNull(message = "Ingrese la fecha") Calendar date_register, Boolean enabled) {
		super();
		this.id_registration = id_registration;
		this.course = course;
		this.student = student;
		this.date_register = date_register;
		this.enabled = enabled;
	}

	public int getId_registration() {
		return id_registration;
	}

	public void setId_registration(int id_registration) {
		this.id_registration = id_registration;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Calendar getDate_register() {
		return date_register;
	}

	public void setDate_register(Calendar date_register) {
		this.date_register = date_register;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
}
