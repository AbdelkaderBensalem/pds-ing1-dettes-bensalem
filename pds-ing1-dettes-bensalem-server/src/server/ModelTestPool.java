package server;

import java.sql.SQLException;

import connection_pool.DataSource;

public class ModelTestPool {
	private DataSource data;
	
	public ModelTestPool() throws SQLException, ClassNotFoundException {
		data = new DataSource();
	}

}
