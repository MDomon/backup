package com.bookshare.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BookCreateConfirmAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	private int book_id;
	private int book_master_id;
	private String book_name;
	private String book_author_name;
	private String book_infomation;
	private Date book_date;

	private String errorMessage;


	public String execute(){

		String result = SUCCESS;

		if(!(book_name.equals("")) && !(book_author_name.equals("")) && !(book_infomation.equals(""))){
			session.put("book_name", book_name);
			session.put("book_author_name", book_author_name);
			session.put("book_infomation", book_infomation);
		}else{
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}

		return result;

	}




	public int getBook_id(){
		return book_id;
	}
	public void setBook_id(int book_id){
		this.book_id = book_id;
	}

	public int getBook_master_id(){
		return book_master_id;
	}
	public void setBook_master_id(int book_master_id){
		this.book_master_id = book_master_id;
	}

	public String getBook_name(){
		return book_name;
	}
	public void setBook_name(String book_name){
		this.book_name = book_name;
	}

	public String getBook_author_name(){
		return book_author_name;
	}
	public void setBook_author_name(String book_author_name){
		this.book_author_name = book_author_name;
	}

	public String getBook_infomation(){
		return book_infomation;
	}
	public void setBook_infomation(String book_infomation){
		this.book_infomation = book_infomation;
	}

	public Date getBook_date(){
		return book_date;
	}
	public void setBook_date(Date book_date){
		this.book_date = book_date;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String  errorMessage){
		this.errorMessage = errorMessage;
	}


}
