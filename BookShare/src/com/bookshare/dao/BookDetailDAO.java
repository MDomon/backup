package com.bookshare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookshare.dto.BookDTO;
import com.bookshare.util.DBConnector;

public class BookDetailDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private BookDTO bookDTO = new BookDTO();

	// Book詳細情報取得
	public BookDTO getBookInfo(int book_id) {

		String sql = "SELECT * FROM book_transaction where id = ? ";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, book_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				bookDTO.setBook_id(resultSet.getInt("id"));
				bookDTO.setBook_master_id(resultSet.getInt("book_master_id"));
				bookDTO.setBook_user_name(resultSet.getString("book_user_name"));
				bookDTO.setBook_name(resultSet.getString("book_name"));
				bookDTO.setBook_author_name(resultSet.getString("book_author_name"));
				bookDTO.setBook_infomation(resultSet.getString("book_infomation"));
				bookDTO.setBook_date(resultSet.getDate("book_date"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookDTO;
	}

	public BookDTO getBookDTO() {
		return bookDTO;
	}

}
