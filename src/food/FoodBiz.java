package food;

import java.sql.Connection;
import java.util.ArrayList;

import frame.Biz;

public class FoodBiz extends Biz<FoodVO, String> {
	
	FoodDao dao;
	
	public FoodBiz() {
		dao= new FoodDao();
	}
	
	@Override
	public void register(FoodVO o) throws Exception {
		Connection conn= getConnection();
		
		try {
		
			dao.insert(o, conn);
			conn.commit();
			
		}catch(Exception e) {
			conn.rollback();
			throw e;
		}finally {
			close(conn);
		}
	}

	@Override
	public void remove(String i) throws Exception {
		Connection conn= getConnection();
		try {
			dao.delete(i,conn);
			conn.commit();
			
		
		}catch(Exception e) {
			conn.rollback();
			throw e;
		}finally {
			
			close(conn);
		}
		
		
	}

	@Override
	public void modify(FoodVO o) throws Exception {
		Connection conn= getConnection();
		try {
			dao.update(o,conn);
			conn.commit();
			
		}catch(Exception e){
			conn.rollback();
			throw e;
		}finally {
			
			close(conn);
		}
		
	}

	@Override
	public ArrayList<FoodVO> get(String kind) throws Exception {
	
		Connection conn= getConnection();
		ArrayList<FoodVO> food=null;
	
		
		try {
			
			food=dao.selectKind(kind,conn);
			
			
		}catch(Exception e) {
			
			throw e;
		}finally {
			close(conn);
		}
		return food;
	}
	public ArrayList<FoodVO> get_d(String kind) throws Exception {
		
		Connection conn= getConnection();
		ArrayList<FoodVO> food=null;
	
		
		try {
			
			food=dao.selectKind_d(kind,conn);
			
			
		}catch(Exception e) {
			
			throw e;
		}finally {
			close(conn);
		}
		return food;
	}
public ArrayList<FoodVO> get_r(String kind) throws Exception {
		
		Connection conn= getConnection();
		ArrayList<FoodVO> food=null;
	
		
		try {
			
			food=dao.selectKind_r(kind,conn);
			
			
		}catch(Exception e) {
			
			throw e;
		}finally {
			close(conn);
		}
		return food;
	}
public ArrayList<FoodVO> getAll() throws Exception {
		
		Connection conn= getConnection();
		ArrayList<FoodVO> food=null;
	
		
		try {
			
			food=dao.selectAll(conn);
			
			
		}catch(Exception e) {
			
			throw e;
		}finally {
			close(conn);
		}
		return food;
	}
public ArrayList<FoodVO> getAll_d() throws Exception {
	
	Connection conn= getConnection();
	ArrayList<FoodVO> food=null;

	
	try {
		
		food=dao.selectAll_d(conn);
		
		
	}catch(Exception e) {
		
		throw e;
	}finally {
		close(conn);
	}
	return food;
}
public ArrayList<FoodVO> getAll_r() throws Exception {
	
	Connection conn= getConnection();
	ArrayList<FoodVO> food=null;

	
	try {
		
		food=dao.selectAll_r(conn);
		
		
	}catch(Exception e) {
		
		throw e;
	}finally {
		close(conn);
	}
	return food;
} 
	
	

}
