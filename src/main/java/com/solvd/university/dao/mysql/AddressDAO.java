package com.solvd.university.dao.mysql;

import java.util.List;

import com.solvd.university.dao.IAddressDAO;
import com.solvd.university.model.Address;

public class AddressDAO extends MySQLDAO implements IAddressDAO{

	@Override
	public boolean removeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
