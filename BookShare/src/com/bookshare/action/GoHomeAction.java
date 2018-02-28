package com.bookshare.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bookshare.dao.HomePageDAO;
import com.bookshare.dto.BookDTO;
import com.bookshare.dto.TweetDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoHomeAction extends ActionSupport implements SessionAware {

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> session;

	/**
	 * ツイート情報取得DAO
	 */
	private HomePageDAO homePageDAO = new HomePageDAO();

	/**
	 * ツイート情報格納DTO
	 */
	public ArrayList<TweetDTO> tweetList = new ArrayList<TweetDTO>();

	/**
	 * Book情報取得DAO
	 */
	private HomePageDAO homePageDAO2 = new HomePageDAO();

	/**
	 * Book情報格納DTO
	 */
	public ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();

	private int book_id;

	public String execute() throws SQLException {

		/**
		 * ツイート履歴取得メソッド
		 *
		 * @author internous
		 */
		tweetList = homePageDAO.getTweetInfo();

		Iterator<TweetDTO> iterator = tweetList.iterator();
		if (!(iterator.hasNext())) {
			tweetList = null;
		}

		/**
		 * Book履歴取得メソッド * @author internous
		 */
		bookList = homePageDAO2.getBookInfo();
		session.put("bookList", bookList);

		Iterator<BookDTO> iterator2 = bookList.iterator();
		if (!(iterator2.hasNext())) {
			bookList = null;
		}

		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public HomePageDAO getHomePageDAO() {
		return homePageDAO;
	}

	public void setHomePageDAO(HomePageDAO homePageDAO) {
		this.homePageDAO = homePageDAO;
	}

	public ArrayList<TweetDTO> getTweetList() {
		return tweetList;
	}

	public void setTweetList(ArrayList<TweetDTO> tweetList) {
		this.tweetList = tweetList;
	}

	public HomePageDAO getHomePageDAO2() {
		return homePageDAO2;
	}

	public void setHomePageDAO2(HomePageDAO homePageDAO2) {
		this.homePageDAO2 = homePageDAO2;
	}

	public ArrayList<BookDTO> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<BookDTO> bookList) {
		this.bookList = bookList;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
