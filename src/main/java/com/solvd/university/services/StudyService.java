package com.solvd.university.services;

import com.solvd.university.dao.*;
import com.solvd.university.dao.mysql.*;
import com.solvd.university.model.*;

public class StudyService {
	private ITeachDAO tdao;
	private TeacherService ts;
	private IExamDAO edao;
	private IStudentDAO sdao;
	private ISubjectDAO sudao;
	private IStudyDAO stuDAO;
	public StudyService() {
		tdao = new TeachDAO();
		edao = new ExamDAO();
		sdao = new StudentDAO();
		stuDAO = new StudyDAO();
		ts= new TeacherService();
		sudao = new SubjectDAO();
	}
	public Study getById(long id) {
		Study out =stuDAO.getById(id);
		TeachService t=new TeachService();
		out.setTeach(t.getById(stuDAO.getTeachId(id)));
		out.setStudent(sdao.getById(stuDAO.getStudentId(id)));
		out.setExams(edao.getByStudyId(id));
		return out;
		
	}
}
