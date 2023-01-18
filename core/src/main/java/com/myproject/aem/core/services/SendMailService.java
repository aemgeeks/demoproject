package com.myproject.aem.core.services;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;

public interface SendMailService {

	public boolean sendEmail(Map<String, String> emailParams, String emailTemplatePath, String[] emailTo)
			throws IOException, MessagingException;

}
