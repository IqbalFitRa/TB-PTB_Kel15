package com.kelompok_15.tb_ptb.retrofit;

import com.google.gson.annotations.SerializedName;

public class LogoutResponse{

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}