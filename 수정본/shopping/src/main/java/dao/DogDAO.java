package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;
import vo.Dog;

public class DogDAO {

	Connection con;
	private static DogDAO boardDAO;
	
	private DogDAO() {
		
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public static DogDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new DogDAO();
		}
		
		return boardDAO;
	}
	
	public ArrayList<Dog> selectDogList() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dog> dogList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM Goods");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dogList = new ArrayList<Dog>();
				
				do {
					dogList.add(new Dog(
							rs.getInt("id")
							,rs.getString("kind")
							,rs.getString("GoodsName")
							,rs.getInt("price")
							,rs.getString("image")
							,rs.getString("content")
							,rs.getInt("readcount")));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return dogList;
		
	}
	
	public Dog selectDog(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dog dog = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM Goods WHERE id=?");
			pstmt.setInt(1,  id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dog = new Dog(
						rs.getInt("id")
						,rs.getString("kind")
						,rs.getString("GoodsName")
						,rs.getInt("price")
						,rs.getString("image")
						,rs.getString("content")
						,rs.getInt("readcount"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return dog;
				
	}
	
	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		
		try {
			sql = "UPDATE Goods SET readcount = readcount + 1 WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  id);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	public int insertDog(Dog dog) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql= "";
		
		try {
			sql = "INSERT INTO Goods VALUES(Goods_seq.nextval,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dog.getKind());
			pstmt.setString(2, dog.getName());
			pstmt.setInt(3, dog.getPrice());
			pstmt.setString(4, dog.getImage());
			pstmt.setString(5, dog.getContent());
			pstmt.setInt(6, dog.getReadcount());
			insertCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	public int DeleteProduct(int id) {
		PreparedStatement pstmt = null;
		int DeleteProduct = 0;
		String sql = "";
		
		try {
			sql = "DELETE FROM Goods WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  id);
			DeleteProduct = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return DeleteProduct;
	}
	
}
