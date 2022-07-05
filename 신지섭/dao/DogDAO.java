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
							,rs.getString("name")
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
						,rs.getString("name")
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
			sql = "UPDATE Goods SET readcount = readcount + 1 WHERE id=?"
			pstmt = con.preprareStatement(sql);
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
			sql = "INSERT INTO Goods VALUES(dog_seq.nextval,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dog.getId());
			pstmt.setString(2, dog.getKind);
			pstmt.setString(3, dog.Name);
			pstmt.setInt(4, dog.Price);
			pstmt.setString(5, Image);
			pstmt.setString(6, Content);
			pstmt.setInt(7, Readcount);
			insertCount = pstmt.executeUpdate();
		} catch(SQLException) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
