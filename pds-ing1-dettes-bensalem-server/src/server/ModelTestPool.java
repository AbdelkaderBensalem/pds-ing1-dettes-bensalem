package server;

import java.sql.SQLException;

import server.DataSource;

public class ModelTestPool {
	private DataSource data;
	
	public ModelTestPool() throws SQLException, ClassNotFoundException {
		data = new DataSource();
	}

}
