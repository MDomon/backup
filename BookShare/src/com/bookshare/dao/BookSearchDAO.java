package com.bookshare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookshare.dto.BookDTO;
import com.bookshare.util.DBConnector;

public class BookSearchDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private List<BookDTO> searchList = new ArrayList<BookDTO>();

	//検索ワードからBookリスト情報を取得
	public List<BookDTO> getBookInfo(String searchWord) {

		String sql = "SELECT * FROM book_transaction JOIN user_transaction ON book_transaction.book_master_id = user_transaction.id ORDER BY book_date DESC";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String book_name = resultSet.getString("book_name");
				String book_author_name = resultSet.getString("book_author_name");

				if (book_name.matches(".*" + searchWord + ".*") || book_author_name.matches(".*" + searchWord + ".*")) {
					BookDTO dto = new BookDTO();

					dto.setBook_id(resultSet.getInt("id"));
					dto.setBook_master_id(resultSet.getInt("book_master_id"));
					dto.setBook_user_name(resultSet.getString("book_user_name"));
					dto.setBook_infomation(resultSet.getString("book_infomation"));
					dto.setBook_date(resultSet.getDate("book_date"));
					dto.setBook_name(book_name);
					dto.setBook_author_name(book_author_name);

					searchList.add(dto);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return searchList;
	}

	public List<BookDTO> getBookDTO() {
		return searchList;
	}

}
