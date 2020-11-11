package lark.example.service.biz;

import lark.example.service.entity.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lark.example.service.dao.TestDao;

@Service
public class TestBiz {
	@Autowired
	private TestDao testDao;

    // todo: remove this method
	public TestObject getObject(int id) {
        return testDao.getObject(id);
	}
}