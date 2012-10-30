package hivemind.aop.com;


import hivemind.aop.com.annotations.WrapThis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyClass implements MyInterface {

	private static final Logger logger = LoggerFactory.getLogger(MyClass.class);
	
	@Override
	public void setDoSimpleSet(int value){
		logger.info("Getting this value: "+value);
	}

	@Override
	@WrapThis
	public int needsWrapping(int value) {
		logger.info("Getting this value: "+value);
		int result = value * value;
		logger.info("Returning (value * value): "+result);
		return result;
	}
	
}
