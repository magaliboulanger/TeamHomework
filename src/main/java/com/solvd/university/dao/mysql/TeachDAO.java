package com.solvd.university.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.connectionpool.MyConnectionPool;
import com.solvd.university.dao.ITeachDAO;
import com.solvd.university.model.Subject;
import com.solvd.university.model.Teach;

public class TeachDAO extends MySQLDAO implements ITeachDAO {
	private static final String INSERT = "INSERT INTO Teach(subject_id, teacher_id) VALUES(?,?)";
	private static final String DELETE = "DELETE FROM Teach WHERE id = ?";
	private static final String GETBYID = "SELECT * FROM Teach WHERE id = ?";
	private static final String GETTEID = "SELECT teacher_id FROM Teach WHERE id = ?";
	private static final String GETSUID = "SELECT subject_id FROM Teach WHERE id = ?";
	private Logger log = LogManager.getLogger(TeachDAO.class);

	@Override
	public Teach save(Teach b) {
		Connection con =null;
		PreparedStatement stat = null;
        try{
        	con=connection.getConnection();
            stat= con.prepareStatement(INSERT);
           
            stat.setLong(1, b.getSubject().getId());
            stat.setLong(2, b.getTeacher().getId() );
        
            if(stat.executeUpdate()==0){
              log.info("It may not have been saved.");
            }
            
            return b;
        } catch (SQLException | InterruptedException ex) {
           log.error(ex);
           return new Teach();
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
	public Teach getById(Long id) {
		// TODO Auto-generated method stub
		return new Teach(id,null,null);
	}

	@Override
	public List<Teach> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getSubjIdById(long id) {
		PreparedStatement stat=null;
		Connection con =null;
		ResultSet rs=null;
		long t = 0;
		try{
			con=connection.getConnection();
			stat=con.prepareStatement(GETSUID);
			stat.setLong(1,id);
			rs=stat.executeQuery();
			if(rs.next()){
				t = rs.getLong("subject_id");
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
	public long getTeacherIdById(long id) {
		PreparedStatement stat=null;
		Connection con =null;
		ResultSet rs=null;
		long t = 0;
		try{
			con=connection.getConnection();
			stat=con.prepareStatement(GETTEID);
			stat.setLong(1,id);
			rs=stat.executeQuery();
			if(rs.next()){
				t = rs.getLong("teacher_id");
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

}
