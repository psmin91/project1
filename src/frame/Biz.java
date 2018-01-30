package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Biz<O,I> {
	protected Dao<O,I> dao;
	
	public Biz(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found...");
		}
	}
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@70.12.111.147:1521:XE";
		String user = "food";
		String password = "food";
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void close(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			
			}
	}
	public abstract void register(O o) throws Exception;
	public abstract void remove(I i) throws Exception;
	public abstract void modify(O o) throws Exception;
	public abstract ArrayList<O> get(I i) throws Exception;
	public abstract ArrayList<O> get_d(I i) throws Exception;
	public abstract ArrayList<O> get_r(I i) throws Exception;
	public abstract ArrayList<O> getAll() throws Exception;
	public abstract ArrayList<O> getAll_d() throws Exception;
	public abstract ArrayList<O> getAll_r() throws Exception;
}
