package com.solvd.university.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.connectionpool.MyConnectionPool;
import com.solvd.university.dao.IStudentDAO;
import com.solvd.university.model.Student;

public class StudentDAO extends MySQLDAO implements IStudentDAO{
	private static final String INSERT = "INSERT INTO Student(university_identifier) VALUES(?)";
	private static final String DELETE = "DELETE FROM Student WHERE id = ?";
	private static final String GETBYID = "SELECT * FROM Student WHERE id = ?";
	private Logger log = LogManager.getLogger(StudentDAO.class);

	@Override
	public Student save(Student b) {
		PreparedStatement stat = null;
		Connection con =null;
        try{
        	con=connection.getConnection();
            stat= con.prepareStatement(INSERT);
           
            stat.setInt(1, b.getUniversityIdentifier());
            if(stat.executeUpdate()==0){
              log.info("It may not have been saved.");
            }
            
            return b;
        } catch (SQLException | InterruptedException ex) {
           log.error(ex);
           return new Student();
        } finally {
            if (stat!=null){
                try {
                    stat.close();
                } catch (SQLException ex ) {
                    log.error(ex);
                }
            } try {
				connection.releaseConnection(con);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
        
        }
	}

	@Override
	public boolean removeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student getById(Long id) {
		Connection con =null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		Student t=null;
		try{
			con=connection.getConnection();
			stat=con.prepareStatement(GETBYID);
			stat.setLong(1,id);
			rs=stat.executeQuery();
			if(rs.next()){
				t = new Student(rs.getInt("university_identifier"));
			}
			else {
				log.info("Cannot find Teacher with id= "+id);
			}
		}catch (SQLException | InterruptedException ex){
			log.error(ex);
		}finally{
			if(rs!=null){
				try{
					rs.close();
				} catch (SQLException ex) { 
					log.error(ex);
				}
			}
			if(stat!= null){
				try{
					stat.close();
				} catch (SQLException ex) {
					log.error(ex);
				}
			}
			 try {
					connection.releaseConnection(con);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					log.error(e);
				}
		}
		return t;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
