package net.suncaper.demo;

import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.common.domain.WorkerExample;
import net.suncaper.demo.common.util.IdentificationCard;
import net.suncaper.demo.common.util.TwoElements;
import net.suncaper.demo.mapper.EmployMapper;
import net.suncaper.demo.mapper.WorkerMapper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import static net.suncaper.demo.common.util.HashCode.GetHashCode;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	WorkerMapper workerMapper;

	@Test

	public void main() throws Exception {
		Worker worker = new Worker();
		worker.setSex("男");
		worker.setId(3);
		workerMapper.updateByPrimaryKey(worker);


	}
}

}
