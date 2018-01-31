package com.bookshare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bookshare.dto.BookDTO;
import com.bookshare.dto.MyAccountDTO;
import com.bookshare.dto.TweetDTO;
import com.bookshare.util.DBConnector;

public class MyPageDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private MyAccountDTO myAccountDTO = new MyAccountDTO();


	//つぶやき情報の取得
			public ArrayList<TweetDTO> getTweetInfo(int tweet_master_id) throws SQLException{
				ArrayList<TweetDTO> tweetList = new ArrayList<TweetDTO>();

				String sql = "SELECT * FROM tweet_transaction JOIN user_transaction ON tweet_transaction.tweet_master_id = user_transaction.id WHERE tweet_transaction.tweet_master_id =? ORDER BY tweet_date DESC";

			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, tweet_master_id);

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

	//つぶやきを削除
	public int removeTweet(int tweet_id) throws SQLException{
		String sql2 = "DELETE FROM tweet_transaction WHERE id = ?";

		PreparedStatement statement2 = connection.prepareStatement(sql2);
		int result2 = 0;
		try {

				statement2.setInt(1, tweet_id);

				result2 = statement2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
			return result2;
	}

	//Book情報の取得
	public ArrayList<BookDTO> getBookInfo(int book_master_id) throws SQLException{
		ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();

		String sql3 = "SELECT * FROM book_transaction JOIN user_transaction ON book_transaction.book_master_id = user_transaction.id WHERE book_transaction.book_master_id =? ORDER BY book_date DESC";

	try {
		PreparedStatement statement3 = connection.prepareStatement(sql3);
		statement3.setInt(1, book_master_id);

		ResultSet resultSet3 = statement3.executeQuery();

		while(resultSet3.next()){
			BookDTO dto = new BookDTO();
			dto.setBook_id(resultSet3.getInt("id"));
			dto.setBook_master_id(resultSet3.getInt("book_master_id"));
			dto.setBook_user_name(resultSet3.getString("book_user_name"));
			dto.setBook_name(resultSet3.getString("book_name"));
			dto.setBook_author_name(resultSet3.getString("book_author_name"));
			dto.setBook_infomation(resultSet3.getString("book_infomation"));
			dto.setBook_date(resultSet3.getDate("book_date"));

			bookList.add(dto);
		}

	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		connection.close();
	}

		return bookList;
	}

	//Bookを削除
	public int removeBook(int book_id) throws SQLException{
	String sql4 = "DELETE FROM book_transaction WHERE id = ?";

	PreparedStatement statement4 = connection.prepareStatement(sql4);
	int result4 = 0;
	try {

			statement4.setInt(1, book_id);

			result4 = statement4.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		connection.close();
	}
		return result4;
	}

	//マイアカウント情報取得
	public MyAccountDTO getMyAccountInfo(int id) {

		String sql5 = "SELECT * FROM user_transaction where id = ? ";

		try {
			PreparedStatement preparedStatement5 = connection.prepareStatement(sql5);
			preparedStatement5.setInt(1, id);

			ResultSet resultSet5 = preparedStatement5.executeQuery();

			if(resultSet5.next()) {
				myAccountDTO.setGiveBook(resultSet5.getInt("user_give_book"));
				myAccountDTO.setTakeBook(resultSet5.getInt("user_take_book"));
				myAccountDTO.setBookcoin(resultSet5.getInt("user_bookcoin"));
				myAccountDTO.setUserName(resultSet5.getString("user_name"));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return myAccountDTO;
	}

	public MyAccountDTO getMyAccountDTO() {
		return myAccountDTO;
	}



}
