package food;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import frame.Sql;

public class FoodDao {
	public void insert(FoodVO f, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertFood);
			pstmt.setString(1, f.getKind());
			pstmt.setString(2, f.getName());
			pstmt.setInt(3, f.getPrice());
			pstmt.setInt(4, f.getDistance());
			
			pstmt.setInt(5, f.getReview());
			pstmt.setString(6, f.getMap());
			int result = pstmt.executeUpdate();
			System.out.println("DAO insert 결과:" + result);
		} catch (SQLException e) {
			throw e;
		} finally {
			System.out.println("DAO Finally...");
			pstmt.close();
		}
	}

	public void update(FoodVO f, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateFood);
			pstmt.setString(1, f.getKind());
			pstmt.setInt(2, f.getDistance());
			pstmt.setInt(3, f.getPrice());
			pstmt.setString(4, f.getMap());
			pstmt.setString(5, f.getName());
			int result = pstmt.executeUpdate();
			System.out.println("DAO update 결과:" + result);
		} catch (SQLException e) {
			e.getStackTrace();
			throw e;
		} finally {
			System.out.println("DAO Finally...");
			pstmt.close();
		}
	}

	public void delete(String name, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteFood);
			pstmt.setString(1, name);
			int result = pstmt.executeUpdate();
			System.out.println("DAO delete 결과:" + result);
		} catch (SQLException e) {
			throw e;
		} finally {
			System.out.println("DAO Finally...");
			pstmt.close();
		}
	}

		public ArrayList<FoodVO> selectKind(String kind, Connection conn) throws SQLException {
		ArrayList<FoodVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectKind);
			pstmt.setString(1, kind);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				FoodVO food = null;
				String name = rset.getString("NAME");
				int price = rset.getInt("PRICE");
				int distance = rset.getInt("DISTANCE");
				
				int review = rset.getInt("REVIEW");
				String map = rset.getString("MAP");
				food = new FoodVO(kind, name, price, distance, review, map);
				
				list.add(food);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (rset != null)
				rset.close();
		}
		return list;
	}
		public ArrayList<FoodVO> selectKind_d(String kind, Connection conn) throws SQLException {
			ArrayList<FoodVO> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			try {
				pstmt = conn.prepareStatement(Sql.selectKind_d);
				pstmt.setString(1, kind);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					FoodVO food = null;
					String name = rset.getString("NAME");
					int price = rset.getInt("PRICE");
					int distance = rset.getInt("DISTANCE");
					String map = rset.getString("MAP");
					int review = rset.getInt("REVIEW");
					
					food = new FoodVO(kind, name, price, distance, review, map);
					
					list.add(food);
				}
			} catch (SQLException e) {
				throw e;
			} finally {
				if (pstmt != null)
					pstmt.close();
				if (rset != null)
					rset.close();
			}
			return list;
		}
		public ArrayList<FoodVO> selectKind_r(String kind, Connection conn) throws SQLException {
			ArrayList<FoodVO> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			try {
				pstmt = conn.prepareStatement(Sql.selectKind_r);
				pstmt.setString(1, kind);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					FoodVO food = null;
					String name = rset.getString("NAME");
					int price = rset.getInt("PRICE");
					int distance = rset.getInt("DISTANCE");
					String map = rset.getString("MAP");
					int review = rset.getInt("REVIEW");
					
					food = new FoodVO(kind, name, price, distance, review, map);
					
					list.add(food);
				}
			} catch (SQLException e) {
				throw e;
			} finally {
				if (pstmt != null)
					pstmt.close();
				if (rset != null)
					rset.close();
			}
			return list;
		}
		public ArrayList<FoodVO> selectAll(Connection conn) throws SQLException {
			ArrayList<FoodVO> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			try {
				pstmt = conn.prepareStatement(Sql.selectAll);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					FoodVO food = null;
					String kind = rset.getString("KIND");
					String name = rset.getString("NAME");
					int price = rset.getInt("PRICE");
					int distance = rset.getInt("DISTANCE");
					String map = rset.getString("MAP");
					int review = rset.getInt("REVIEW");
					
					food = new FoodVO(kind, name, price, distance, review, map);
					
					list.add(food);
				}
			} catch (SQLException e) {
				throw e;
			} finally {
				if (pstmt != null)
					pstmt.close();
				if (rset != null)
					rset.close();
			}
			return list;
		}
		public ArrayList<FoodVO> selectAll_d(Connection conn) throws SQLException {
			ArrayList<FoodVO> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			try {
				pstmt = conn.prepareStatement(Sql.selectAll_d);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					FoodVO food = null;
					String kind = rset.getString("KIND");
					String name = rset.getString("NAME");
					int price = rset.getInt("PRICE");
					int distance = rset.getInt("DISTANCE");
					String map = rset.getString("MAP");
					int review = rset.getInt("REVIEW");
					
					food = new FoodVO(kind, name, price, distance, review, map);
					
					list.add(food);
				}
			} catch (SQLException e) {
				throw e;
			} finally {
				if (pstmt != null)
					pstmt.close();
				if (rset != null)
					rset.close();
			}
			return list;
		}
		public ArrayList<FoodVO> selectAll_r(Connection conn) throws SQLException {
			ArrayList<FoodVO> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			try {
				pstmt = conn.prepareStatement(Sql.selectAll_r);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					FoodVO food = null;
					String kind = rset.getString("KIND");
					String name = rset.getString("NAME");
					int price = rset.getInt("PRICE");
					int distance = rset.getInt("DISTANCE");
					String map = rset.getString("MAP");
					int review = rset.getInt("REVIEW");
					
					food = new FoodVO(kind, name, price, distance, review, map);
					
					list.add(food);
				}
			} catch (SQLException e) {
				throw e;
			} finally {
				if (pstmt != null)
					pstmt.close();
				if (rset != null)
					rset.close();
			}
			return list;
		}
}
