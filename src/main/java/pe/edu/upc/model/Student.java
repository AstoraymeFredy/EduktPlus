package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Estudiante")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_student;
	
	@NotEmpty(message = "Ingrese su nombre")
	@Size(min = 1, max = 80, message = "El nombre debe tener máximo 80 caracteres")
	@Pattern(regexp = "[^0-9]*", message = "El nombre no debe contener números")
	@Column(name="nombre", nullable=false, length=80)
	private String name;
	
	@NotEmpty(message = "Ingrese su apellido")
	@Pattern(regexp = "[^0-9]*", message = "El apellido no debe contener números")
	@Column(name="apellidos", nullable=false, length=100)
	private String lastname;
	
	@Email(message = "El correo no es válido", regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")
	@NotEmpty(message = "Ingrese su correo")
	@Column(name="email", nullable=false, length=100)
	private String email;
	
	@Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
	@Pattern(regexp = "[0-9]+", message = "El DNI debe contener solo números")
	@NotEmpty(message = "Ingrese su DNI")
	@Column(name="DNI", nullable=false, length=8, unique = true)
	private String dni;
	
	@NotNull(message = "Ingrese la fecha")
	@Past(message = "La fecha debe estar en el pasado")
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Calendar birth_date;
	
	@OneToOne
	@JoinColumn(name="id_usuario", nullable=false)
	private UserModel user;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id_student,
			@NotEmpty(message = "Ingrese su nombre") @Pattern(regexp = "[^0-9]*", message = "El nombre no debe contener números") String name,
			@NotEmpty(message = "Ingrese su apellido") @Pattern(regexp = "[^0-9]*", message = "El nombre no debe contener números") String lastname,
			@Email(message = "El correo no es válido", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])") @NotEmpty(message = "Ingrese su correo") String email,
			@Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos") @Pattern(regexp = "[0-9]+", message = "El DNI debe contener solo números") @NotEmpty(message = "Ingrese su DNI") String dni,
			@NotNull(message = "Ingrese la fecha") @Past(message = "La fecha debe estar en el pasado") Calendar birth_date,
			UserModel user) {
		super();
		this.id_student = id_student;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.dni = dni;
		this.birth_date = birth_date;
		this.user = user;
	}

	public int getId_student() {
		return id_student;
	}

	public void setId_student(int id_student) {
		this.id_student = id_student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Calendar getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Calendar birth_date) {
		this.birth_date = birth_date;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	
	

}
