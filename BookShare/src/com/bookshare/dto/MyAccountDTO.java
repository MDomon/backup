package com.bookshare.dto;

//マイアカウント情報のインスタンス
public class MyAccountDTO {

	private String userName;
	private int giveBook;
	private int takeBook;
	private int bookcoin;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getGiveBook() {
		return giveBook;
	}

	public void setGiveBook(int giveBook) {
		this.giveBook = giveBook;
	}

	public int getTakeBook() {
		return takeBook;
	}

	public void setTakeBook(int takeBook) {
		this.takeBook = takeBook;
	}

	public int getBookcoin() {
		return bookcoin;
	}

	public void setBookcoin(int bookcoin) {
		this.bookcoin = bookcoin;
	}

}
