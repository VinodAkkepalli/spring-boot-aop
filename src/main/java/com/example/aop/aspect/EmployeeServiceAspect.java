package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

	@Before(value = "execution(* com.example.aop.service.EmployeeService.*(..)) and args(name,empId)")
	public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {
		System.out.println("Before method:" + joinPoint.getSignature());
		
		System.out.println("Creating Employee with name - " + name + " and id - " + empId);
	}

	//use of pointcut
	@After(value = "allEmployeeServiceMethodsWithTwoArgs() and args(name,empId)")
	public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
		System.out.println("After method using pointcut:" + joinPoint.getSignature());

		System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
	}
	
	@AfterReturning(value = "execution(* com.example.aop.service.EmployeeService.*(..)) and args(name,empId)")
	public void afterReturningAdvice(JoinPoint joinPoint, String name, String empId) {
		System.out.println("After Returning method:" + joinPoint.getSignature());

		System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
	}
	
	@AfterThrowing(value = "execution(* com.example.aop.service.EmployeeService.exceptionThrowingEmployee())")
	public void afterThrowingAdvice(JoinPoint joinPoint) {
		System.out.println("After Returning method: " + joinPoint.getSignature());

		System.out.println("After Returning method ");
	}
	
	@Around(value= "execution(* com.example.aop.service.EmployeeService.workEmployee())")
	public void aroundAdvice(ProceedingJoinPoint joinPoint) {
		System.out.println("Around method: " + joinPoint.getSignature().getName() + " before method execution");
		System.out.println("Start working now....");
		try {
			//This call is needed to make the target method execute
			joinPoint.proceed();
		} catch (Throwable e) {
			//Do something if you have
			e.printStackTrace();
		}
		System.out.println("Finish working now....");
		System.out.println("Around method: " + joinPoint.getSignature().getName() + " after method execution");
	}
	
	@Pointcut("execution(* com.example.aop.service.EmployeeService.*(..))")
	public void allEmployeeServiceMethodsWithTwoArgs(){}
}

