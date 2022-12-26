package com.kelompok_15.tb_ptb.retrofit;

import com.google.gson.annotations.SerializedName;

public class Authorisation{

	@SerializedName("type")
	private String type;

	@SerializedName("token")
	private String token;

	public String getType(){
		return type;
	}

	public String getToken(){
		return token;
	}
}