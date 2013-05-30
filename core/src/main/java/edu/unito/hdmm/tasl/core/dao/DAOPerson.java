package edu.unito.hdmm.tasl.core.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.unito.hdmm.tasl.core.bean.Person;
import edu.unito.hdmm.tasl.db.DAOException;
import edu.unito.hdmm.tasl.db.DataSource;
import edu.unito.hdmm.tasl.db.DataSourceFactory;
import edu.unito.hdmm.tasl.utility.Logger;
public class DAOPerson {

	
	
	
	public static void insertPerson(Person person) throws DAOException {

		Connection connection = null;
		PreparedStatement stat = null;
		DataSource dataSource = DataSourceFactory.getInstance().getDataSource();

		try {

			connection = dataSource.getConnection();

			
			
				stat= connection
						.prepareStatement(insertString);

					
				Logger.logFine("insert : "+stat.toString());
				
				
				
				boolean bb=stat.execute();
				
				
				
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

	}

	
	
	
	
	
}
