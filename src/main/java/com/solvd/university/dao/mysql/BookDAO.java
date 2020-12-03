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
import com.solvd.university.dao.IBookDAO;
import com.solvd.university.model.Book;

public class BookDAO extends MySQLDAO implements IBookDAO {
	private Connection con;
	private static final String INSERT = "INSERT INTO Book(title,author, num_pages, year, library_id) VALUES(?,?,?,?,?)";
	private static final String DELETE = "DELETE FROM Book WHERE id = ?";
	private static final String GETBYID = "SELECT * FROM Book WHERE id = ?";
	private static final String GETBYLIBID = "SELECT * FROM Book WHERE library_id = ?";
	private Logger log = LogManager.getLogger(BookDAO.class);
	public BookDAO() {
	}

	@Override
	public Book save(Book b, long idLib) {
		PreparedStatement stat = null;
        try{
        	con=connection.getConnection();
            stat= con.prepareStatement(INSERT);
           
            stat.setString(1, b.getTitle());
            stat.setString(2, b.getAuthor());
            stat.setInt(3, b.getNum_pages());
            stat.setInt(4, b.getYear());
            stat.setLong(5,idLib);
            if(stat.executeUpdate()==0){
              log.info("It may not have been saved.");
            }
            
            return b;
        } catch (SQLException | InterruptedException ex) {
           log.error(ex);
           return new Book();
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
		PreparedStatement stat = null;
        try{
        	con=connection.getConnection();
            stat= con.prepareStatement(DELETE);
            stat.setLong(1,id);
            stat.execute();
            return true;
        } catch (SQLException | InterruptedException ex) {
            log.error(ex);
    		return false;
        }finally {
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
	public Book getById(Long id) {
		PreparedStatement stat=null;
		ResultSet rs=null;
		Book t=null;
		try{
			con=connection.getConnection();
			stat=con.prepareStatement(GETBYID);
			stat.setLong(1,id);
			rs=stat.executeQuery();
			if(rs.next()){
				t = new Book(rs.getLong("id"),rs.getString("title"),rs.getString("author"),rs.getInt("num_pages"), rs.getInt("year"));
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
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByLibId(Long id) {
		PreparedStatement stat=null;
		ResultSet rs=null;
		List<Book> t=new ArrayList<Book>();
		try{
			con=connection.getConnection();
			stat=con.prepareStatement(GETBYLIBID);
			stat.setLong(1,id);
			rs=stat.executeQuery();
			while(rs.next()){
				t.add(new Book(rs.getLong("id"),rs.getString("title"),rs.getString("author"),rs.getInt("num_pages"), rs.getInt("year")));
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
