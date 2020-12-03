package com.solvd.university.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.connectionpool.MyConnectionPool;
import com.solvd.university.dao.IExamDAO;
import com.solvd.university.model.Exam;

public class ExamDAO extends MySQLDAO implements IExamDAO{
	private static final String INSERT = "INSERT INTO Exam(mark, date, study_id) VALUES(?,?,?)";
	private static final String DELETE = "DELETE FROM Exam WHERE id = ?";
	private static final String GETBYID = "SELECT * FROM Exam WHERE id = ?";
	private static final String GETBYSTUDYID = "SELECT * FROM Exam WHERE study_id = ?";
	private Logger log = LogManager.getLogger(ExamDAO.class);
	
	@Override
	public Exam save(Exam b, long stuId) {
		PreparedStatement stat = null;
		Connection con =null;
        try{
        	con=connection.getConnection();
            stat= con.prepareStatement(INSERT);
           
            stat.setString(1, b.getMark());
            stat.setDate(2,  new java.sql.Date(b.getDate().getTime()) );
            stat.setLong(3, stuId);
            if(stat.executeUpdate()==0){
              log.info("It may not have been saved.");
            }
            
            return b;
        } catch (SQLException | InterruptedException ex) {
           log.error(ex);
           return new Exam();
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
	public Exam getById(Long id) {
		PreparedStatement stat=null;
		Connection con =null;
		ResultSet rs=null;
		Exam t=null;
		try{
			con=connection.getConnection();
			stat=con.prepareStatement(GETBYID);
			stat.setLong(1,id);
			rs=stat.executeQuery();
			if(rs.next()){
				t = new Exam(rs.getLong("id"),rs.getString("mark"),rs.getDate("date"));
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
	public List<Exam> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exam> getByStudyId(long id) {
		Connection con =null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		List<Exam> t=new ArrayList<Exam>();
		try{
			con=connection.getConnection();
			stat=con.prepareStatement(GETBYSTUDYID);
			stat.setLong(1,id);
			rs=stat.executeQuery();
			while(rs.next()){
				t.add(new Exam(rs.getLong("id"),rs.getString("mark"),rs.getDate("date")));
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
