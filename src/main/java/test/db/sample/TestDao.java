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
}
