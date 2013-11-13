package test.db.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = null;
		try {
//			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			conn = DriverManager.getConnection("jdbc:h2:./sample", "sa", "");
			// テーブル初期化
			deleteAll(conn);
			
			insert(conn);
		
			select(conn);
			
			delete(conn);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void insert(Connection conn) throws SQLException{
		String insertSql =" Insert into TEST VALUES(4, ?)";
		PreparedStatement insertStatement = conn.prepareStatement(insertSql);
		insertStatement.setString(1, "テスト太郎");
		int resultVal = insertStatement.executeUpdate();
		System.out.println(resultVal);
		if ( resultVal == 1) {
			System.out.println("登録完了");
		} else {
			System.out.println("登録失敗");
		}
	}
	
	private static void select(Connection conn) throws SQLException {
		String sql = "Select * from TEST where id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, 4);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			System.out.println("id:" + resultSet.getInt("id"));
			System.out.println("name:" + resultSet.getString("name"));
		}
	}
	
	private static void delete(Connection conn) throws SQLException {
		String deleteSql =" delete from TEST where id = ?";
		PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
		deleteStatement.setInt(1, 4);
		deleteStatement.execute();
	}
	
	private static void deleteAll(Connection conn) throws SQLException {
		String deleteSql =" delete from TEST";
		PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
		deleteStatement.execute();
	}
	
	private static void update(Connection conn) throws SQLException {
		String updateSql =" ";
		//TODO idをキーにname属性の値を更新してください。
	}
}
