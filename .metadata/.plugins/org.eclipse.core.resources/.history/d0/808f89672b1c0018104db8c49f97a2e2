package com.bookshare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bookshare.dto.BookDTO;
import com.bookshare.util.DBConnector;
import com.bookshare.util.DateUtil;

public class BookCreateCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO book_transaction(book_master_id,book_user_name,book_name,book_author_name,book_infomation,book_date,id) VALUES(?, ?, ?, ?, ?, ?, ?)";

	public void createBook(BookDTO dto) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, dto.getBook_master_id());
			preparedStatement.setString(2, dto.getBook_user_name());
			preparedStatement.setString(3, dto.getBook_name());
			preparedStatement.setString(4, dto.getBook_author_name());
			preparedStatement.setString(5, dto.getBook_infomation());
			preparedStatement.setString(6, dateUtil.getDate());
			preparedStatement.setInt(7, dto.getBook_id());


			preparedStatement.execute();

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
