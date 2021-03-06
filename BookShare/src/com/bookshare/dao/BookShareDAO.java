package com.bookshare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookshare.dto.BookDTO;
import com.bookshare.dto.MyAccountDTO;
import com.bookshare.util.DBConnector;
import com.bookshare.util.DateUtil;

public class BookShareDAO {

	private BookDTO bookDTO = new BookDTO();

	private DateUtil dateUtil = new DateUtil();

	// 売買対象Book情報取得
	public BookDTO getBookInfo(int book_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "SELECT * FROM book_transaction WHERE id = ?";

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

	// Book譲り渡し情報挿入
	public void insertGiveBookInfo(int you_id, String book_user_name, String book_name, String book_author_name,
			String book_infomation) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "INSERT INTO give_book_transaction(book_master_id,book_user_name,book_name,book_author_name,book_infomation,book_date) VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, you_id);
			ps.setString(2, book_user_name);
			ps.setString(3, book_name);
			ps.setString(4, book_author_name);
			ps.setString(5, book_infomation);
			ps.setString(6, dateUtil.getDate());

			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	// book譲り受け情報挿入
	public void insertTakeBookInfo(int my_id, String book_user_name, String book_name, String book_author_name,
			String book_infomation) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "INSERT INTO take_book_transaction(book_master_id,book_user_name,book_name,book_author_name,book_infomation,book_date) VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, my_id);
			ps.setString(2, book_user_name);
			ps.setString(3, book_name);
			ps.setString(4, book_author_name);
			ps.setString(5, book_infomation);
			ps.setString(6, dateUtil.getDate());

			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	// Book情報削除
	public void deleteBookInfo(int book_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "DELETE FROM book_transaction WHERE id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, book_id);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	// 自分ユーザー情報取得
	public MyAccountDTO getMyInfo(int my_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "SELECT * FROM user_transaction WHERE id = ?";
		MyAccountDTO my = new MyAccountDTO();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, my_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				my.setBookcoin(resultSet.getInt("user_bookcoin"));
				my.setTakeBook(resultSet.getInt("user_take_book"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return my;

	}

	// 相手ユーザー情報取得
	public MyAccountDTO getYouInfo(int you_id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "SELECT * FROM user_transaction WHERE id = ?";
		MyAccountDTO you = new MyAccountDTO();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, you_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				you.setBookcoin(resultSet.getInt("user_bookcoin"));
				you.setGiveBook(resultSet.getInt("user_give_book"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return you;
	}

	// 自分ユーザー情報更新
	public void updateMyInfo(int my_id, int my_bookcoin, int takeBook) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "UPDATE user_transaction SET user_bookcoin = ?, user_take_book = ? WHERE id = ?";
		int totalBookcoin = my_bookcoin - 1;
		int totalTakeBook = takeBook + 1;

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, totalBookcoin);
			ps.setInt(2, totalTakeBook);
			ps.setInt(3, my_id);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	// 相手ユーザー情報更新
	public void updateYouInfo(int you_id, int you_bookcoin, int giveBook) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "UPDATE user_transaction SET user_bookcoin = ?, user_give_book = ? WHERE id = ?";
		int totalBookcoin2 = you_bookcoin + 1;
		int totalGiveBook = giveBook + 1;

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, totalBookcoin2);
			ps.setInt(2, totalGiveBook);
			ps.setInt(3, you_id);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public void setBookDTO(BookDTO bookDTO) {
		this.bookDTO = bookDTO;
	}

}
