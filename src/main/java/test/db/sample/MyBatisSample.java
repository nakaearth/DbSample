package test.db.sample;

import java.util.List;

import test.db.sample.model.Test;

public class MyBatisSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestDao dao = new TestDao();
		dao.save(Integer.valueOf(1), "test");
		
		List<Test> list = dao.all();
		for(Test test : list) {
			System.out.println("Name:" + test.getName());
		}
		System.out.println("-----2回目---------");
		for(Test test : list) {
			System.out.println("Name:" + test.getName());
		}
		
		dao.delete(Integer.valueOf(1));
		list = dao.all();
		for(Test test : list) {
			System.out.println("Name:" + test.getName());
		}
	}
}
