package com.bookshare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookshare.util.DBConnector;

public class UserCreateConfirmDAO {
	private DBConnector dbconnector = new DBConnector();

	private Connection connection = dbconnector.getConnection();

	private boolean result = false;

	//既に登録済みのIDかどうかの確認
	public boolean getUserInfo(String loginUserId) {
		String sql = "SELECT * FROM user_transaction";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String userId = resultSet.getString("user_id");

				if (userId.equals(loginUserId)) {
					result = false;
					return result;
				} else {
					result = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
