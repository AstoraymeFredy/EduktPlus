package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="Docente")
public class Teacher implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_teacher;
	
	@NotEmpty(message = "Ingrese su nombre")
	@Pattern(regexp = "[^0-9]*", message = "El nombre no debe contener números")
	@Column(name="nombre", nullable=false, length=80)
	private String name;
	
	@NotEmpty(message = "Ingrese su apellido")
	@Pattern(regexp = "[^0-9]*", message = "El nombre no debe contener números")
	@Column(name="apellidos", nullable=false, length=100)
	private String lastname;
	
	@Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
	@Pattern(regexp = "[0-9]+", message = "El DNI debe contener solo números")
	@NotEmpty(message = "Ingrese su DNI")
	@Column(name="DNI", nullable=false, length=8, unique = true)
	private String dni;
	
	@Size(min = 9, max = 9, message = "El celular de tener 9 digitos")
	@Pattern(regexp = "[0-9]+", message = "El celular debe contener solo números")
	@NotEmpty(message = "Ingrese su celular")
	@Column(name="celular", nullable=false, length=9)
	private String phone;
	
	@Email(message = "El correo no es válido", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message = "Ingrese su correo")
	@Column(name="email", nullable=false, length=100)
	private String email;
	
	@NotNull(message = "Ingrese la fecha")
	@Past(message = "La fecha debe estar en el pasado")
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth_date;


	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int id_teacher,
			@NotEmpty(message = "Ingrese su nombre") @Pattern(regexp = "[^0-9]*", message = "El nombre no debe contener números") String name,
			@NotEmpty(message = "Ingrese su apellido") @Pattern(regexp = "[^0-9]*", message = "El nombre no debe contener números") String lastname,
			@Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos") @Pattern(regexp = "[0-9]+", message = "El DNI debe contener solo números") @NotEmpty(message = "Ingrese su DNI") String dni,
			@Size(min = 9, max = 9, message = "El celular de tener 9 digitos") @Pattern(regexp = "[0-9]+", message = "El celular debe contener solo números") @NotEmpty(message = "Ingrese su celular") String phone,
			@Email(message = "El correo no es válido", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])") @NotEmpty(message = "Ingrese su correo") String email,
			@NotNull(message = "Ingrese la fecha") @Past(message = "La fecha debe estar en el pasado") Date birth_date
			) {
		super();
		this.id_teacher = id_teacher;
		this.name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.phone = phone;
		this.email = email;
		this.birth_date = birth_date;
	}

	public int getId_teacher() {
		return id_teacher;
	}

	public void setId_teacher(int id_teacher) {
		this.id_teacher = id_teacher;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}


}
