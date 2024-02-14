package com.example.bootproject.BookMyShow.util;

public class ResponseStructure<T> {


	private String Message;
	private int Status;
	private T Data;
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public T getData() {
		return Data;
	}
	public void setData(T data) {
		Data = data;
	}
	@Override
	public String toString() {
		return "ResponseStructure [Message=" + Message + ", Status=" + Status + ", Data=" + Data + "]";
	}
	
}
