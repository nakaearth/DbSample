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
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			
			String insert_sql =" Insert into TEST VALUES(4, ?)";
			PreparedStatement insertStatement = conn.prepareStatement(insert_sql);
			insertStatement.setString(1, "テスト太郎");
			int resultVal = insertStatement.executeUpdate();
			System.out.println(resultVal);
			if ( resultVal == 1) {
				System.out.println("登録完了");
			} else {
				System.out.println("登録失敗");
			}
			String sql = "Select * from TEST where id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, 4);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println("id:" + resultSet.getInt("id"));
				System.out.println("name:" + resultSet.getString("name"));
			}
			
			String delete_sql =" delete from TEST where id = ?";
			PreparedStatement deleteStatement = conn.prepareStatement(delete_sql);
			deleteStatement.setInt(1, 4);
			deleteStatement.execute();
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

}
