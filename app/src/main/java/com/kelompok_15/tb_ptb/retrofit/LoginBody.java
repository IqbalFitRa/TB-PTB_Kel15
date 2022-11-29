package com.kelompok_15.tb_ptb.retrofit;

import com.google.gson.annotations.SerializedName;

public class LoginBody{

	@SerializedName("password")
	private String password;

	@SerializedName("email")
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"LoginBody{" + 
			"password = '" + password + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}