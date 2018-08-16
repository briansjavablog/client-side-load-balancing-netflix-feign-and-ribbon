package com.briansjavablog.accountidentifierservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.briansjavablog.accountidentifierservice.component.AccountTypeConverter;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Override
	public FormattingConversionService mvcConversionService() {
		
		FormattingConversionService conversionService = super.mvcConversionService();
		conversionService.addConverter(new AccountTypeConverter());
		return conversionService;
	}

}
