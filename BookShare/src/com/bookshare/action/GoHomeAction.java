package com.bookshare.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bookshare.dao.HomePageDAO;
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
	 * ツイート履歴取得メソッド
	 *
	 * @author internous
	 */
	public String execute() throws SQLException {


			tweetList = homePageDAO.getTweetInfo();

			Iterator<TweetDTO> iterator = tweetList.iterator();
			if (!(iterator.hasNext())) {
				tweetList = null;
				}

		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}







