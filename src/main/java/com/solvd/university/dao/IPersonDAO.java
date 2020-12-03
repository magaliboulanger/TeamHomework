package com.solvd.university.dao;

import com.solvd.university.model.*;

public interface IPersonDAO extends DAO<Person, Long> {

	Person save(Person b);
	long getAddressId(Long idPerson);
}
