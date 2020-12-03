package com.solvd.university.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.connectionpool.MyConnectionPool;
import com.solvd.university.dao.IStudyDAO;
import com.solvd.university.model.Study;
import com.solvd.university.model.Teacher;

public class StudyDAO extends MySQLDAO implements IStudyDAO {
	private static final String INSERT = "INSERT INTO Study(student_id,teach_id) VALUES(?,?)";
	private static final String DELETE = "DELETE FROM Study WHERE id = ?";
	private static final String GETBYID = "SELECT * FROM Study WHERE id = ?";
	private static final String GETSTUID = "SELECT student_id FROM Study WHERE id = ?";
	private static final String GETTEAID = "SELECT teach_id FROM Study WHERE id = ?";
	private Logger log = LogManager.getLogger(StudyDAO.class);
	

	@Override
	public Study save(Study b) {
		Connection con=null;
		PreparedStatement stat = null;
        try{
        	con=connection.getConnection();
            stat= con.prepareStatement(INSERT);
           
            stat.setLong(1, b.getStudent().getId());
            stat.setLong(2, b.getTeach().getId());

            if(stat.executeUpdate()==0){
              log.info("It may not have been saved.");
            }
            
            return b;
        } catch (SQLException | InterruptedException ex) {
           log.error(ex);
           return new Study();
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
	public Study getById(Long id) {
		// TODO Auto-generated method stub
		return new Study(id,null,null,null);
	}

	@Override
	public List<Study> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getStudentId(long id) {
		Connection con=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		long t=0;
		try{
			con=connection.getConnection();
			stat=con.prepareStatement(GETSTUID);
			stat.setLong(1,id);
			rs=stat.executeQuery();
			if(rs.next()){
				t = rs.getLong("student_id");
			}
			else {
				log.info("Cannot find Subject with id= "+id);
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
	public long getTeachId(long id) {
		Connection con=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		long t=0;
		try{
			con=connection.getConnection();
			stat=con.prepareStatement(GETTEAID);
			stat.setLong(1,id);
			rs=stat.executeQuery();
			if(rs.next()){
				t = rs.getLong("teach_id");
			}
			else {
				log.info("Cannot find Teach with id= "+id);
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

}
