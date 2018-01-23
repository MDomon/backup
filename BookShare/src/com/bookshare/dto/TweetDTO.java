package com.bookshare.dto;


import java.util.Date;

public class TweetDTO {

	private String tweet_user_id;
	private String tweet_user_name;
	private String tweet;
	private Date tweet_date;

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
}