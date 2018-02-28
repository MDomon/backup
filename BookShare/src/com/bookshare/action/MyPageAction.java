package com.bookshare.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bookshare.dao.MyPageDAO;
import com.bookshare.dto.BookDTO;
import com.bookshare.dto.MyAccountDTO;
import com.bookshare.dto.TweetDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	/**
	 * ログインID
	 */
	private String loginUserId;

	/**
	 * ログインパスワード
	 */
	private String loginPassword;

	/* ユーザー名 */
	private String userName;

	/* コイン数 */
	private int bookcoin;

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> session;

	/**
	 * マイページ情報取得DAO
	 */
	private MyPageDAO myPageDAO = new MyPageDAO();

	/**
	 * マイアカウント情報取得DAO
	 */
	private MyPageDAO myAccountDAO = new MyPageDAO();

	// マイツイート情報取得DTO
	private MyPageDAO myTweetDAO = new MyPageDAO();

	/**
	 * ツイート情報格納DTO
	 */
	public ArrayList<TweetDTO> tweetList = new ArrayList<TweetDTO>();

	// MyBook情報取得DTO
	private MyPageDAO myBookDAO = new MyPageDAO();

	/**
	 * Book情報格納DTO
	 */
	public ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();

	// giveBook情報取得DTO
	private MyPageDAO giveBookDAO = new MyPageDAO();

	/**
	 * Book情報格納DTO
	 */
	public ArrayList<BookDTO> giveBookList = new ArrayList<BookDTO>();

	// takeBook情報取得DTO
	private MyPageDAO takeBookDAO = new MyPageDAO();

	/**
	 * Book情報格納DTO
	 */
	public ArrayList<BookDTO> takeBookList = new ArrayList<BookDTO>();

	/**
	 * 削除フラグ
	 */
	private String deleteFlg;

	private String message;

	/**
	 * 削除フラグ
	 */
	private String deleteTweet;

	private String message2;

	/**
	 * 削除フラグ
	 */
	private String deleteBook;

	private String message4;

	private String tweetId;
	private String bookId;

	/**
	 * 商品履歴取得メソッド
	 *
	 * @author internous
	 */
	public String execute() throws SQLException {

		if (!session.containsKey("user_id")) {
			return ERROR;
		}

		// マイアカウント情報取得メソッド
		int id = (int) session.get("masterId");
		MyAccountDTO myAccountDTO = myAccountDAO.getMyAccountInfo(id);
		session.put("bookcoin", myAccountDTO.getBookcoin());
		session.put("giveBook", myAccountDTO.getGiveBook());
		session.put("takeBook", myAccountDTO.getTakeBook());

		// GiveBook情報の取得
		giveBookList = giveBookDAO.getGiveBookInfo(id);
		Iterator<BookDTO> iterator4 = giveBookList.iterator();
		if (!(iterator4.hasNext())) {
			takeBookList = null;
		}

		// TakeBook情報の取得
		takeBookList = takeBookDAO.getTakeBookInfo(id);
		Iterator<BookDTO> iterator5 = takeBookList.iterator();
		if (!(iterator5.hasNext())) {
			takeBookList = null;
		}

		/**
		 * ツイート履歴取得メソッド
		 *
		 * @author internous
		 */
		// 商品履歴を削除しない場合
		if (deleteTweet == null) {
			int tweet_master_id = (int) session.get("masterId");
			tweetList = myTweetDAO.getTweetInfo(tweet_master_id);

			Iterator<TweetDTO> iterator = tweetList.iterator();
			if (!(iterator.hasNext())) {
				tweetList = null;
			}

			// 商品履歴を削除する場合
		} else if (deleteTweet.equals("1")) {
			remove2();
		}

		/**
		 * Book履歴取得メソッド
		 *
		 * @author internous
		 */
		// Book履歴を削除しない場合
		if (deleteBook == null) {
			int book_master_id = (int) session.get("masterId");
			bookList = myBookDAO.getBookInfo(book_master_id);

			Iterator<BookDTO> iterator3 = bookList.iterator();
			if (!(iterator3.hasNext())) {
				bookList = null;
			}

			// Book履歴を削除する場合
		} else if (deleteBook.equals("1")) {
			remove4();
		}

		String result = SUCCESS;
		return result;
	}

	/**
	 * ツイート履歴削除
	 *
	 * @throws SQLException
	 */
	public void remove2() throws SQLException {


		int res2 = myPageDAO.removeTweet(Integer.parseInt(tweetId));

		if (res2 > 0) {
			tweetList = null;
			setMessage2("ツイート情報を削除しました。");
		} else if (res2 == 0) {
			setMessage2("ツイート情報の削除に失敗しました。");
		}

		int tweet_master_id = (int) session.get("masterId");
		tweetList = myTweetDAO.getTweetInfo(tweet_master_id);

		Iterator<TweetDTO> iterator = tweetList.iterator();
		if (!(iterator.hasNext())) {
			tweetList = null;
		}
	}

	/**
	 * Book履歴削除
	 *
	 * @throws SQLException
	 */
	public void remove4() throws SQLException {


		int res4 = myPageDAO.removeBook(Integer.parseInt(bookId));

		if (res4 > 0) {
			bookList = null;
			setMessage4("Book情報を削除しました。");
		} else if (res4 == 0) {
			setMessage4("Book情報の削除に失敗しました。");
		}

		int book_master_id = (int) session.get("masterId");
		bookList = myBookDAO.getBookInfo(book_master_id);

		Iterator<BookDTO> iterator3 = bookList.iterator();
		if (!(iterator3.hasNext())) {
			bookList = null;
		}
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBookcoin() {
		return bookcoin;
	}

	public void setBookcoin(int bookcoin) {
		this.bookcoin = bookcoin;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getDeleteTweet() {
		return deleteTweet;
	}

	public void setDeleteTweet(String deleteTweet) {
		this.deleteTweet = deleteTweet;
	}

	public String getDeleteBook() {
		return deleteBook;
	}

	public void setDeleteBook(String deleteBook) {
		this.deleteBook = deleteBook;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public String getMessage4() {
		return message4;
	}

	public void setMessage4(String message4) {
		this.message4 = message4;
	}

	public String getTweetId() {
		return tweetId;
	}

	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

}
