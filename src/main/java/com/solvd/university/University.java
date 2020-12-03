package com.solvd.university;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.connectionpool.MyConnectionPool;
import com.solvd.university.dao.*;
import com.solvd.university.dao.mysql.*;
import com.solvd.university.model.*;
import com.solvd.university.services.*;


public class University extends AbstractEntity {

	private static Logger log = LogManager.getLogger(University.class);
	
	public static void main (String [] args ) {
		
		//DEPARTMENT SERVICE
		IDepartmentDAO d = new DepartmentDAO();
		ITeacherDAO t = new TeacherDAO();
		Teacher t1= new Teacher(01,"Martin", "123456", "martin@martin.com");
		Teacher t2= new Teacher(02,"Lucas", "123456", "lucas@gmail.com");
		Teacher t3= new Teacher(03,"Maria", "123456", "maria@gmail.com");
		List<Teacher> teachers=new ArrayList<Teacher>();
		teachers.add(t3);
		teachers.add(t2);
		teachers.add(t1);
		Department dep = new Department(14,"Geography",teachers);
		d.save(dep);
		t.save(t3,01);
		t.save(t2,01);
		t.save(t1,01);
		DepartmentService ds=new DepartmentService();
		Department dept = ds.getById(01);
		log.info(dept.toString());
		
		
		
		//LIBRARY SERVICE
		Book b1 = new Book(01,"Hello", "M.L.K", 120, 2020);
		Book b2 = new Book(02,"Sunset", "S.K", 520, 2017);
		Book b3 = new Book(03,"Wake up", "H.I", 700, 2019);
		List<Book> books = new ArrayList<Book>();
		books.add(b3);
		books.add(b2);
		books.add(b1);
		Library l1= new Library(01, "Sarmiento", new Address(0,"",0), books);
		ILibraryDAO l=new LibraryDAO();
		l.save(l1);
		IBookDAO b= new BookDAO();
		b.save(b1,01);
		b.save(b2,01);
		b.save(b3,01);
		LibraryService ls= new LibraryService();
		Library lib=ls.getById(1);

		log.info("library service");
		log.info(lib.toString());
		
		//STUDY SERVICE AND TEACH SERVICE
		Student student=new Student(01, "John", "123456", 248671,"student@gmail.com");
		Subject subject = new Subject(01, "Maths", 75, 5);
		Teach teach = new Teach(01, t1, subject);
		IExamDAO e=new ExamDAO();
		Exam e1=new Exam(1,"A",new Date());
		Exam e2=new Exam(2,"C",new Date());
		Exam e3=new Exam(3,"F",new Date());
		List<Exam> exams = new ArrayList<Exam>();
		exams.add(e3);
		exams.add(e2);
		exams.add(e1);
		Study study=new Study(01,student,teach,exams);
		IStudyDAO sdao=new StudyDAO();
		sdao.save(study);
		e.save(e1, 01);
		e.save(e2, 01);
		e.save(e3, 01);
		IStudyDAO stdao=new StudyDAO();
		stdao.save(study);
		ISubjectDAO subdao=new SubjectDAO();
		subdao.save(subject);
		ITeachDAO teachdao=new TeachDAO();
		teachdao.save(teach);
		IStudentDAO studentdao=new StudentDAO();
		studentdao.save(student);
		
		StudyService stuserv = new StudyService ();
		Study out=stuserv.getById(01);
		log.info(out.toString());
		}
}
