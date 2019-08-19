package com.ubaid.app.xcite.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.ubaid.app.xcite.entity.Product;

@Aspect
@Component
public class Logger extends Logging
{
	@Around("scrape()")
	public Object logger1(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Object result = null;
				
		try
		{
			result = joinPoint.proceed();
			Product prod = (Product) result;
			System.out.println("[Info]: " + prod);

		}
		catch(Exception exp)
		{
			result = exp.getMessage();
			System.out.println("[Error]: " + result);
		}
			
		

		return result;
	}
}
