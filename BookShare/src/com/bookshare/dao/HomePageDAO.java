package com.bookshare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bookshare.dto.TweetDTO;
import com.bookshare.util.DBConnector;

public class HomePageDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();



	//つぶやき情報の取得
		public ArrayList<TweetDTO> getTweetInfo() throws SQLException{
			ArrayList<TweetDTO> tweetList = new ArrayList<TweetDTO>();

			String sql = "SELECT * FROM tweet_transaction JOIN user_transaction ON tweet_transaction.tweet_master_id = user_transaction.id ORDER BY tweet_date DESC";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()){
				TweetDTO dto = new TweetDTO();
				dto.setTweet_id(resultSet.getInt("id"));
				dto.setTweet_master_id(resultSet.getInt("tweet_master_id"));
				dto.setTweet_user_name(resultSet.getString("tweet_user_name"));
				dto.setTweet_message(resultSet.getString("tweet_message"));
				dto.setTweet_date(resultSet.getDate("tweet_date"));

				tweetList.add(dto);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

			return tweetList;
		}


}
