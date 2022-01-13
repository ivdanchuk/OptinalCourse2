package com.java.spring.validator;

import java.util.regex.Pattern;

/**
 * The {@code DataValidator} class contains methods for validating an input data
 * (data from forms).
 */
public class SecurityDataValidator {
	private final static String REGEX_CHECK_FOR_LOGIN_AS_EMAIL = "^([\\w\\-\\.]+)@([\\w\\-\\.]+)\\.([a-zA-Z]{2,5})$";
	private final static String REGEX_CHECK_FOR_PASSWORD = "^([\\wа-яА-Я]{7,20})$";
	private final static String REGEX_CHECK_FOR_NAME = "^[a-zA-Zа-яА-Я\\\\s]{2,20}$";

	public static boolean validateLogin(String login) {
		return Pattern.matches(REGEX_CHECK_FOR_LOGIN_AS_EMAIL, login);
	}

	public static boolean validatePassword(String password) {
		return Pattern.matches(REGEX_CHECK_FOR_PASSWORD, password);
	}

	public static boolean validateName(String name) {
		return Pattern.matches(REGEX_CHECK_FOR_NAME, name);
	}

}
