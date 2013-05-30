package edu.unito.hdmm.tasl.core.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.unito.hdmm.tasl.core.bean.Dpi;
import edu.unito.hdmm.tasl.core.bean.Person;
import edu.unito.hdmm.tasl.db.DAOException;
import edu.unito.hdmm.tasl.db.DataSource;
import edu.unito.hdmm.tasl.db.DataSourceFactory;
import edu.unito.hdmm.tasl.utility.Logger;
public class DAOPerson {

	
	
	
	public static boolean insertPerson(Person person) throws DAOException {

		Connection connection = null;
		PreparedStatement stat = null;
		DataSource dataSource = DataSourceFactory.getInstance().getDataSource();
		boolean bb=false;
		try {

			connection = dataSource.getConnection();

			
			
			
			String insertString="insert into   values (?,?,?,?);";
			
			
			
				stat= connection
						.prepareStatement(insertString);
			
			
			

					
				Logger.logFine("insert : "+stat.toString());
				
				
				
				bb=stat.execute();
				
				
				
				Logger.logFine("insert for index "+person.getTaslObject().getId()+" result: "+bb);
			
			
			
			
		
		} catch (SQLException sqle) {
			throw new DAOException(sqle);
		
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			Logger.logFine("DAO exception  for  "+ person +" "+e.getMessage());
			
		} finally {
			dataSource.close(stat);
			dataSource.close(connection);
		}

		
		return bb;
		
	}

	
	
	
	public  static  Person gettingPersonById(Person p){ return null;};
	public static  boolean submitPersonDpi(Person id , List<Dpi> list){ return false;};
	
	public static boolean checkPersonById(Person p){ return false;};
	
	
	
	
	
}
