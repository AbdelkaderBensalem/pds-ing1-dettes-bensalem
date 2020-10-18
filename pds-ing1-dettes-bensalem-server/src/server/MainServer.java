package server;

import java.sql.PreparedStatement;


import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;
import server.DBConnectController;
import server.TestPoolView;

public class MainServer {
	static DBConnectController namaicityController;

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		namaicityController = new DBConnectController(new TestPoolView());
		namaicityController.start();
	}

}