package com.solvd.university.services;

import com.solvd.university.dao.*;
import com.solvd.university.dao.mysql.*;
import com.solvd.university.model.*;

public class LibraryService {
	private IBookDAO bdao;
	private ILibraryDAO ldao;
	public LibraryService() {
		bdao = new BookDAO();
		ldao = new LibraryDAO();
	}
	public Library getById(long id) {

		Library d = ldao.getById(id);
		d.setBooks(bdao.getByLibId(d.getId()));
		return d;

	}
}
