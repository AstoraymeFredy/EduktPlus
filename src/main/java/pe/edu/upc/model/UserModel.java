package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_user;
	
	@Column(name="username", nullable=false, length=25, unique = true)
	private String username;
	
	@Column(name="password", length=25, nullable=false)
	private String password;
	
	@Column(name="enabled", nullable=false)
	private Boolean enabled;

	public UserModel() {
		super();
	}

	public UserModel(int id_user, String username, String password, Boolean enabled) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
	
}
