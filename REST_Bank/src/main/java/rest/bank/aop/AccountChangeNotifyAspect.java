package rest.bank.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import rest.bank.domain.Account;
import rest.bank.integration.AccountChangeGateway;

@Aspect
@Component
public class AccountChangeNotifyAspect {
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Pointcut("execution(* rest.bank.service..*(..))")
	public void depositOrWithdraw() {
	}

	@Pointcut("execution(* rest.bank.service..*(..))")
	public void transferFund() {
	}

	@After("depositOrWithdraw() && args(account, amount)")
	public void logDepositOrWithdrawTransaction(JoinPoint joinPoint, Account account, Double amount) {
		try {
			notifyTransaction(joinPoint, account);
			
		} catch (Throwable e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
	}

	@After("transferFund() && args(source, destination, amount)")
	public void logTransferFundTransaction(JoinPoint joinPoint, Account source, Account destination, Double amount) {
		try {
			notifyTransaction(joinPoint, source);
			
		} catch (Throwable e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
	}

	
	private void notifyTransaction(JoinPoint joinPoint, Account account) {
		try {
			Logger log = Logger.getLogger("");
		    log.info("   **********     Sending Message to Rest  Email!    **********");
			
			AccountChangeGateway accountChangeGateway = (AccountChangeGateway) applicationContext.getBean("accountChange");
			accountChangeGateway.process(account);
			
		} catch (Throwable e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
	}

}
