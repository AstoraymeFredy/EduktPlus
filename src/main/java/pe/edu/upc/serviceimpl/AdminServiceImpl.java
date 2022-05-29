package pe.edu.upc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.model.Admin;
import pe.edu.upc.service.iAdminService;
import pe.edu.upc.controller.repository.iAdminRepository;

@Service
public class AdminServiceImpl implements iAdminService {
	
	@Autowired
	private iAdminRepository dAdmin;

	@Override
	public Admin findById(int idAdmin) {
		return dAdmin.findById(idAdmin).get();
	}

	@Override
	public Admin findByUserId(int idUser) {
		return dAdmin.findByUserId(idUser);
	}

}
