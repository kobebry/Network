package kr.co.jhchoi.cont;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MainRun {

	public static void main(String[] args) {
		//입력값 관리
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader); //써야될 버퍼메모리 읽기
	
		try {
			System.out.println("이름 입력");
			System.out.println(br.readLine());
			System.out.println("나이 입력");
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
