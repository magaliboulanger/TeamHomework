package com.solvd.university.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.university.dao.IPersonDAO;
import com.solvd.university.model.Library;
import com.solvd.university.model.Person;

public class PersonDAO extends MySQLDAO implements IPersonDAO {
	private static final String INSERT = "INSERT INTO Person(name, phone, email, address_id) VALUES(?,?,?,?)";
	private static final String DELETE = "DELETE FROM Person WHERE id = ?";
	private static final String GETBYID = "SELECT * FROM Person WHERE id = ?";
	private static final String GETADDRID = "SELECT address_id FROM Person WHERE id = ?";
	private Logger log = LogManager.getLogger(TeacherDAO.class);
	@Override
	public boolean removeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person getById(Long id) {
		PreparedStatement stat=null;
		ResultSet rs=null;
		Connection con =null;
		Person t=null;
		try{
			con=connection.getConnection();
			stat=con.prepareStatement(GETBYID);
			stat.setLong(1,id);
			rs=stat.executeQuery();
			if(rs.next()){
				t = new Person(rs.getLong("id"),rs.getString("name"), rs.getString("phone"), rs.getString("email"));
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
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person save(Person b) {
		Connection con =null;
		PreparedStatement stat = null;
        try{
        	con=connection.getConnection();
            stat= con.prepareStatement(INSERT);
           
            stat.setString(1, b.getName());
            stat.setString(2, b.getPhone()); 
            stat.setString(3, b.getEmail());
            stat.setLong(4, b.getAddress().getId());
            if(stat.executeUpdate()==0){
              log.info("It may not have been saved.");
            }
            
            return b;
        } catch (SQLException | InterruptedException ex) {
           log.error(ex);
           return new Person();
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
	public long getAddressId(Long idPerson) {
		PreparedStatement stat=null;
		ResultSet rs=null;
		Connection con =null;
		Long t=null;
		try{
			con=connection.getConnection();
			stat=con.prepareStatement(GETADDRID);
			stat.setLong(1,idPerson);
			rs=stat.executeQuery();
			if(rs.next()){
				t = rs.getLong("address_id");
			}
			else {
				log.info("Cannot find Person with id= "+idPerson);
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
