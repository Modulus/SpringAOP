package hivemind.aop.com;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-config.xml", "classpath:aspect-config.xml"})
public class MyAspectTest {
	
	@Autowired
	private MyInterface object;
	
	@Test
	public void verifyConfig(){
		assertNotNull(object);
		

	}
	
	
	@Test
	public void testBeforeSet(){
		object.setDoSimpleSet(56);
	}
	
	@Test
	public void testAroundWithInterface(){
		object.needsWrapping(5);
	}
	

}
