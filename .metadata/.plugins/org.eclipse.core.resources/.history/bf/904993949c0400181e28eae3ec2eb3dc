package com.bookshare.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bookshare.dao.TweetCreateCompleteDAO;
import com.bookshare.dto.TweetDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TweetAction2  extends ActionSupport implements SessionAware{

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> session;

	/**
	 * つぶやき情報取得DAO
	 */
	private TweetCreateCompleteDAO TweetCreateCompleteDAO = new TweetCreateCompleteDAO();

	/**
	 * つぶやき情報格納DTO
	 */
	public ArrayList<TweetDTO> tweetList = new ArrayList<TweetDTO>();

	/**
	 * 削除フラグ
	 */
	private String deleteFlg;

	private String message;

	/**
	 * つぶやき履歴取得メソッド
	 *
	 * @author internous
	 */
	public String execute() throws SQLException {

		if (!session.containsKey("id")) {
			return ERROR;
		}

		// つぶやき履歴を削除しない場合
		if(deleteFlg == null) {
			String tweet_master_id = session.get("tweet_master_id").toString();

			tweetList = TweetCreateCompleteDAO.getTweetInfo(tweet_master_id);

			Iterator<TweetDTO> iterator = tweetList.iterator();
			if (!(iterator.hasNext())) {
				tweetList = null;
			}
		// つぶやき履歴を削除する場合
		} else if(deleteFlg.equals("1")) {
			delete();
		}

		String result = SUCCESS;
		return result;
	}

	/**
	 * つぶやき履歴削除
	 *
	 * @throws SQLException
	 */
	public void delete() throws SQLException {

		int id = (int) session.get("id");

		int res = TweetCreateCompleteDAO.removeTweet(id);

		if(res > 0) {
			tweetList = null;
			setMessage("つぶやきを削除しました。");
		} else if(res == 0) {
			setMessage("つぶやきの削除に失敗しました。");
		}
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
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
}

