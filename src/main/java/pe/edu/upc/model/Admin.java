package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Administrador")
public class Admin implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_admin;
	
	@Column(name="nombre", nullable=false, length=80)
	private String name;
	
	@Column(name="apellidos", nullable=false, length=100)
	private String lastname;
	
	@OneToOne
	@JoinColumn(name="id_usuario", nullable=false)
	private UserModel user;

	public Admin() {
		super();
	}

	public Admin(int id_admin, String name, String lastname, UserModel user) {
		super();
		this.id_admin = id_admin;
		this.name = name;
		this.lastname = lastname;
		this.user = user;
	}

	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
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

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	
}
