package nctruong;

import nctruong.helper.FileUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileUtil file = new FileUtil();
		System.out.println("Content: " +file.readFromFile("account.txt"));
	}
	
}