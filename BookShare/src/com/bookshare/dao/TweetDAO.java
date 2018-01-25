package com.bookshare.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bookshare.dto.TweetDTO;
import com.bookshare.util.DBConnector;

public class TweetDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	
	//つぶやき情報の取得
	public ArrayList<TweetDTO> getTweetInfo(String tweet_master_id) throws SQLException{
		ArrayList<TweetDTO> list = new ArrayList<>();

		String sql = ""
				+ "SELECT * "
				+ "FROM tweet_transaction "
				+ "WHERE tweet_master_id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, tweet_master_id);

		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()){
			TweetDTO dto = new TweetDTO();
			dto.setId(resultSet.getInt("id"));
			dto.setTweet_master_id(resultSet.getString("tweet_master_id"));
			dto.setTweet_user_name(resultSet.getString("tweet_user_name"));
			dto.setTweet(resultSet.getString("tweet_message"));
			dto.setTweet_date(resultSet.getDate("tweet_date"));

			list.add(dto);
		}

		return list;
	}


	public void addTweet(TweetDTO dto) throws SQLException{
		String sql = ""
				+ "INSERT INTO tweet_transaction(tweet_master_id,tweet_user_name,tweet_message,tweet_date) VALUES(?, ?, ?, ?)";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, dto.getTweet_master_id());
		statement.setString(2, dto.getTweet_user_name());
		statement.setString(3, dto.getTweet_message());
		statement.setDate(4, new java.sql.Date(dto.getTweet_date().getTime()));

		statement.executeUpdate();
	}


	public int removeTweet(int id) throws SQLException{
		String sql = ""
				+ "DELETE FROM tweet_transaction "
				+ "WHERE id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		int removeTweet = statement.executeUpdate();

		return removeTweet;
	}

}
