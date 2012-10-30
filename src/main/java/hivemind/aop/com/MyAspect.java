package hivemind.aop.com;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {

	private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);
	
	
	@Before("execution(void set*(*))")
	public void doBefore(){
		logger.info("doBefore");
	}
	
	@After("execution(* hivemind.aop..*.*(*))")
	public void doAfter(){
		logger.info("doAfter");
	}
	
	@Around("@annotation(hivemind.aop.com.annotations.WrapThis)")
//	@Around("execution(int need*(*))")
	public Object wrapAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		logger.info("=================");
		logger.info("Before call");
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
			return result;
		}
		finally {
			logger.info("After call");
			logger.info("=================");
		}
		
		
	}
	
	
	
	
//	@Around()
//	public Object doAround()
	
}
