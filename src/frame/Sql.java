package frame;
 
public class Sql {

	public static String insertFood = "INSERT INTO FOOD VALUES (?, ?, ?, ?, ?, ?)";
	public static String updateFood = "update FOOD set kind =?, distance=?, price =?, map=? where name= ?";
	public static String deleteFood = "delete from FOOD where name= ?";
	public static String selectKind = "select * from FOOD where kind=? order by price";
	public static String selectKind_d = "select * from FOOD where kind=? order by distance";
	public static String selectKind_r = "select * from FOOD where kind=? order by review DESC";
	public static String selectAll = "select * from FOOD order by price";
	public static String selectAll_d = "select * from FOOD order by distance";
	public static String selectAll_r = "select * from FOOD order by review DESC";

	
	
	
	
}
