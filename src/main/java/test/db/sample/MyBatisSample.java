package test.db.sample;

import java.util.List;

import test.db.sample.model.Test;

public class MyBatisSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestDao().deleteAll();
		
		new TestDao().save(Integer.valueOf(2), "test");
		
		List<Test> list = new TestDao().all();
		for(Test test : list) {
			System.out.println("------------------------");
			System.out.println("Name:" + test.getName());
			System.out.println("------------------------");
		}
		
		new TestDao().delete(Integer.valueOf(2));
		list = new TestDao().all();
		for(Test test : list) {
			System.out.println("Name:" + test.getName());
		}
	}
}
