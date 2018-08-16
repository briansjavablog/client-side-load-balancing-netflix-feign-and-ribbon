package com.briansjavablog.accountidentifierservice.component;

import org.springframework.core.convert.converter.Converter;

import com.briansjavablog.accountidentifierservice.model.EnumAccountType;

public class AccountTypeConverter implements Converter<String, EnumAccountType> {

	@Override
    public EnumAccountType convert(String source) {
       
		 return EnumAccountType.fromValue(source);       
    }
}