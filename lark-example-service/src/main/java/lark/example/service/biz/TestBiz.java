package lark.example.service.biz;

import lark.example.service.entity.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lark.example.service.dao.TestDao;

@Service
public class TestBiz {
	@Autowired
	private TestDao testDao;

    // todo: remove this method
	public TestDO getObject(int id) {
        return testDao.getObject(id);
	}
}