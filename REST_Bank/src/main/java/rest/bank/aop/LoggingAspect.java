package rest.bank.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Pointcut("execution(* rest.bank.service..*(..))")
	public void depositOrWithdraw() {
	}

	@Pointcut("execution(* rest.bank.service..*(..))")
	public void transferFund() {
	}

	@After("depositOrWithdraw()")
	public void logDepositOrWithdrawTransaction(JoinPoint joinPoint) {
		try {
			logTransaction(joinPoint);
			
		} catch (Throwable e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
	}

	@After("transferFund()")
	public void logTransferFundTransaction(JoinPoint joinPoint) {
		try {
			logTransaction(joinPoint);
			
		} catch (Throwable e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
	}

	private void logTransaction(JoinPoint joinPoint) {
		System.out.println("===========LoggingAspect==logResource(JoinPoint joinPoint)===========");
		Logger log = Logger.getLogger("");
		log.info("   **********     TARGET CLASS : " + joinPoint.getSignature().getName() + "    **********");
		System.out.println();
		System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName() + "    **********");
	}

}
