package test.db.sample;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.db.sample.model.Test;
import test.db.sample.model.mapper.TestMapper;

public class TestDao {
	private SqlSessionFactory sessionFactory;

	public TestDao() {
		sessionFactory = DaoUtil.getSqlSessionFactory();
	}

	public List<Test> all() {
		SqlSession session = sessionFactory.openSession();
		TestMapper mapper = session.getMapper(TestMapper.class);
		List<Test> list = mapper.selectAll();
		session.close();

		return list;
	}
	
	public void save(Integer id, String name) {
		SqlSession session = sessionFactory.openSession();
		TestMapper mapper = session.getMapper(TestMapper.class);
		Test test = new Test();
		test.setId(id);
		test.setName(name);
		mapper.save(test);
		session.commit();
		session.close();
	}
	
	public void delete(Integer id) {
		SqlSession session = sessionFactory.openSession();
		TestMapper mapper = session.getMapper(TestMapper.class);
		mapper.delete(id);
		session.commit();
		session.close();
	}
}
