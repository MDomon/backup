package com.bookshare.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.bookshare.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author internous
 *
 */
public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;

	private String loginPassword;

	private String userName;

	public Map<String,Object> session;

	private String errorMassage;

	public String execute() {

		String result = SUCCESS;

		if(!(loginUserId.equals("")) && !(loginPassword.equals("")) && !(userName.equals(""))) {

			UserCreateConfirmDAO userCreateConfirmDAO = new UserCreateConfirmDAO();
			boolean checkId = userCreateConfirmDAO.getUserInfo(loginUserId);

			if(checkId){
				session.put("loginUserId", loginUserId);
				session.put("loginPassword", loginPassword);
				session.put("userName", userName);
			}else{
				setErrorMassage("このIDは既に登録されています。");
				result = ERROR;
			}


		} else {

			setErrorMassage("未入力の項目があります。");
			result = ERROR;
		}

		return result;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}
}
