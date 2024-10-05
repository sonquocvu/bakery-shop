package com.sonvu.springboot.bakeryshop.DAO;

public class ImageBBResponse {
	
	private ImageBBData data;
	private boolean success;
	private int status;
	
	public ImageBBData getData() {
		return data;
	}
	public void setData(ImageBBData data) {
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}	
}
