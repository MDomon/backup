package com.bookshare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bookshare.dto.TweetDTO;
import com.bookshare.util.DBConnector;
import com.bookshare.util.DateUtil;

public class TweetCreateCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO tweet_transaction(tweet_master_id,tweet_user_name,tweet_message,tweet_date,id) VALUES(?, ?, ?, ?, ?)";

	//つぶやき情報の新規登録
	public void createTweet(TweetDTO dto) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, dto.getTweet_master_id());
			preparedStatement.setString(2, dto.getTweet_user_name());
			preparedStatement.setString(3, dto.getTweet_message());
			preparedStatement.setString(4, dateUtil.getDate());
			preparedStatement.setInt(5, dto.getTweet_id());

			preparedStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
