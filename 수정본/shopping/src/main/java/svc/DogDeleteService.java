package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DogDAO;

public class DogDeleteService {
	public boolean deletePro(int id) {
		boolean deleteResult = false;
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		int deleteCount = dogDAO.DeleteProduct(id);
		
		if(deleteCount > 0) {
			commit(con);
			deleteResult = true;
		} else {
			rollback(con);
		}
		close(con);
		return deleteResult;
		
	}
}
