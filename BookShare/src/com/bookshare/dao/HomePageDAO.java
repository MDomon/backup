package com.bookshare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bookshare.dto.BookDTO;
import com.bookshare.dto.TweetDTO;
import com.bookshare.util.DBConnector;

public class HomePageDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	// つぶやき情報の取得
	public ArrayList<TweetDTO> getTweetInfo() throws SQLException {
		ArrayList<TweetDTO> tweetList = new ArrayList<TweetDTO>();

		String sql = "SELECT * FROM tweet_transaction JOIN user_transaction ON tweet_transaction.tweet_master_id = user_transaction.id ORDER BY tweet_date DESC";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				TweetDTO dto = new TweetDTO();
				dto.setTweet_id(resultSet.getInt("id"));
				dto.setTweet_master_id(resultSet.getInt("tweet_master_id"));
				dto.setTweet_user_name(resultSet.getString("tweet_user_name"));
				dto.setTweet_message(resultSet.getString("tweet_message"));
				dto.setTweet_date(resultSet.getDate("tweet_date"));

				tweetList.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return tweetList;
	}

	// Book情報の取得
	public ArrayList<BookDTO> getBookInfo() throws SQLException {
		ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();

		String sql2 = "SELECT * FROM book_transaction JOIN user_transaction ON book_transaction.book_master_id = user_transaction.id ORDER BY book_date DESC";

		try {
			PreparedStatement statement2 = connection.prepareStatement(sql2);

			ResultSet resultSet2 = statement2.executeQuery();

			while (resultSet2.next()) {
				BookDTO dto = new BookDTO();
				dto.setBook_id(resultSet2.getInt("id"));
				dto.setBook_master_id(resultSet2.getInt("book_master_id"));
				dto.setBook_name(resultSet2.getString("book_name"));
				dto.setBook_user_name(resultSet2.getString("book_user_name"));
				dto.setBook_author_name(resultSet2.getString("book_author_name"));
				dto.setBook_infomation(resultSet2.getString("book_infomation"));
				dto.setBook_date(resultSet2.getDate("book_date"));

				bookList.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return bookList;
	}

}
