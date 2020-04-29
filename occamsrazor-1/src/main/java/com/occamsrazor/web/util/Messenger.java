package com.occamsrazor.web.util;

public enum Messenger {
	SUCCESS , FAIL, FIlE_INSERT_ERROR, FILE_SELECT_ERROR;
	
	@Override
	public String toString() {
		String returnValue = "";
		
		switch (this) {
		case FILE_SELECT_ERROR:
			returnValue = "파일 읽기에서 에러 발생";
			break;
		case FIlE_INSERT_ERROR:
			returnValue = "파일 입력 시 에러 발생";
			break;
		default:
			break;
		}
		
		return returnValue;
	}
}
