package com.ubaid.app.xcite.logger;

import org.aspectj.lang.annotation.Pointcut;

public abstract class Logging
{
	@Pointcut("execution(* com.ubaid.app.xcite.scrapper.ScrapperService.getProduct(..))")
	public void scrape() {}
}
