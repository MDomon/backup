package com.bookshare.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bookshare.dao.BookShareDAO;
import com.bookshare.dto.BookDTO;
import com.bookshare.dto.MyAccountDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BookShareCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private int book_id;

	private String book_user_name;
	private String book_name;
	private String book_author_name;
	private String book_infomation;

	private BookDTO bookDTO = new BookDTO();

	private BookShareDAO bookShareDAO = new BookShareDAO();

	private MyAccountDTO my = new MyAccountDTO();
	private MyAccountDTO you = new MyAccountDTO();

	public String execute() throws SQLException {

		int my_id = Integer.parseInt(session.get("masterId").toString());
		int you_id = Integer.parseInt(session.get("book_master_id").toString());

		// 売買対象Book情報取得
		bookDTO = bookShareDAO.getBookInfo(book_id);
		book_user_name = bookDTO.getBook_user_name();
		book_name = bookDTO.getBook_name();
		book_author_name = bookDTO.getBook_author_name();
		book_infomation = bookDTO.getBook_infomation();

		// Book譲り渡し情報挿入
		bookShareDAO.insertGiveBookInfo(you_id, book_user_name, book_name, book_author_name, book_infomation);

		// book譲り受け情報挿入
		bookShareDAO.insertTakeBookInfo(my_id, book_user_name, book_name, book_author_name, book_infomation);

		// Book情報削除
		bookShareDAO.deleteBookInfo(book_id);

		// 自分ユーザー情報取得
		my = bookShareDAO.getMyInfo(my_id);
		int my_bookcoin = my.getBookcoin();
		int takeBook = my.getTakeBook();

		// 相手ユーザー情報取得
		you = bookShareDAO.getYouInfo(you_id);
		int you_bookcoin = you.getBookcoin();
		int giveBook = you.getGiveBook();

		// 自分ユーザー情報更新
		bookShareDAO.updateMyInfo(my_id, my_bookcoin, takeBook);

		// 相手ユーザー情報更新
		bookShareDAO.updateYouInfo(you_id, you_bookcoin, giveBook);

		return SUCCESS;

	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_user_name() {
		return book_user_name;
	}

	public void setBook_user_name(String book_user_name) {
		this.book_user_name = book_user_name;
	}

	public String getBook_author_name() {
		return book_author_name;
	}

	public void setBook_author_name(String book_author_name) {
		this.book_author_name = book_author_name;
	}

	public String getBook_infomation() {
		return book_infomation;
	}

	public void setBook_infomation(String book_infomation) {
		this.book_infomation = book_infomation;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public MyAccountDTO getMy() {
		return my;
	}

	public void setMy(MyAccountDTO my) {
		this.my = my;
	}

	public MyAccountDTO getYou() {
		return you;
	}

	public void setYou(MyAccountDTO you) {
		this.you = you;
	}

	public BookShareDAO getBookShareDAO() {
		return bookShareDAO;
	}

	public void setBookShareDAO(BookShareDAO bookShareDAO) {
		this.bookShareDAO = bookShareDAO;
	}

	public BookDTO getBookDTO() {
		return bookDTO;
	}

	public void setBookDTO(BookDTO bookDTO) {
		this.bookDTO = bookDTO;
	}

}
