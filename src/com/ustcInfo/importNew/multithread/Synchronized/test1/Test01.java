package com.ustcInfo.importNew.multithread.Synchronized.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test01 {

	public static void main(String[] args) {
		
		Account account = new Account();
		ExecutorService service = Executors.newFixedThreadPool(100);
		
		for(int i = 1; i <= 100; i++) {
			service.execute(new AddMoneyThread(account, 1));
		}
		
		service.shutdown();
		
		while(!service.isTerminated()) { //isTerminated当调用shutdown()方法后，并且所有提交的任务完成后返回为true
			
		}
		System.out.println("账户余额: " + account.getBalance());
	}
}
