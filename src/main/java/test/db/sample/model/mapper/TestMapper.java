package test.db.sample.model.mapper;

import java.util.List;

import test.db.sample.model.Test;

public interface TestMapper {
	  List<Test> selectAll();
	  void save(Test test);
	  void delete(Integer id);
	  void deleteAll();
	  
	  void update(Integer id, String name);
}
