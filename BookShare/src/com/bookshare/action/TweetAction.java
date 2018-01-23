package com.bookshare.action;


import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bookshare.dao.TweetDAO;
import com.bookshare.dto.TweetDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TweetAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private TweetDAO dao = new TweetDAO();

	private String tweet_user_id;
	private String tweet_user_name;
	private String tweet;
	private Date tweet_date;


	public String execute(){

		TweetDTO dto = new TweetDTO();
		dto.setTweet_user_id(tweet_user_id);
		dto.setTweet_user_name(tweet_user_name);
		dto.setTweet(tweet);
		dto.setTweet_date(new Date());

		try {
			dao.addTweet(dto);
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public String getTweet_user_id() {
		return tweet_user_id;
	}

	public void setTweet_user_id(String tweet_user_id) {
		this.tweet_user_id = tweet_user_id;
	}

	public String getTweet_user_name() {
		return tweet_user_name;
	}

	public void setTweet_user_name(String tweet_user_name) {
		this.tweet_user_name = tweet_user_name;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public Date getTweet_date() {
		return tweet_date;
	}

	public void setTweet_date(Date tweet_date) {
		this.tweet_date = tweet_date;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}


}

