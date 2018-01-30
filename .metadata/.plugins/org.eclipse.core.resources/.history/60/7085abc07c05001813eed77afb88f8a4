package com.bookshare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bookshare.util.DBConnector;
import com.bookshare.util.DateUtil;

public class UserCreateCompleteDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO user_transaction (user_id, user_pass, user_name, insert_date) VALUES(?, ? ,?, ?)";

	public void cerateUser(String loginUserId, String loginUserPassword, String userName) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.execute();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
