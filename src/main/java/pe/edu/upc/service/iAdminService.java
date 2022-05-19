package pe.edu.upc.service;

import pe.edu.upc.model.Admin;

public interface iAdminService {
	public Admin findById(int idAdmin);
	public Admin findByUserId(int idUser);
}
