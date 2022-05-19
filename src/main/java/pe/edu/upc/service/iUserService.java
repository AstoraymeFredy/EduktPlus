package pe.edu.upc.service;

import pe.edu.upc.model.UserModel;

public interface iUserService {
	public boolean createUser (UserModel user);
	public UserModel findByUsernameRepeated(String username);
}
