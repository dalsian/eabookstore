package edu.mum.hbteam.inv.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;


@Aspect
@Component
public class LoggingAspect {
	//Application methods
	@Pointcut("execution(* edu.mum.hbteam.inv.service..*(..))")
	public void applicationMethod() {}
	
	//RESTful methods
	@Pointcut("execution(* edu.mum.hbteam.inv.rest.service.impl.*(..))")
	public void applicationRestMethod() {}

	//@Pointcut("execution(* edu.mum.hbteam.inv.service..save(..)) && args(Book) ")
	@Pointcut("@annotation(edu.mum.hbteam.inv.aspect.annotation.Logging)")
	public void logging() {}
	
	
	//--------------------------------------------------------------------		  
	//@Before("logging()")                        				
//	@Before("applicationMethod() || logging()")	
	@Before("applicationMethod()")
	public void logResource(JoinPoint joinPoint) {
//        Logger log = Logger.getLogger("");
//        
//        //Write out to file
//        log.warn(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName() + "    **********");
    }
	
}