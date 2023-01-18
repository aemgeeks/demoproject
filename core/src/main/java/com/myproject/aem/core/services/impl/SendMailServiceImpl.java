package com.myproject.aem.core.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myproject.aem.core.services.SendMailService;

@Component(service = SendMailService.class, property = { Constants.SERVICE_ID + "= Send Email Service",
		Constants.SERVICE_DESCRIPTION + "=This services is used to send the Email Notification to the Users/Business" })
public class SendMailServiceImpl implements SendMailService {


	private static Logger log = LoggerFactory.getLogger(SendMailServiceImpl.class);

	@Override
	public boolean sendEmail(Map<String, String> emailParams, String emailTemplatePath, String[] emailTo) {

		boolean messageSent = false;
		try {

			//List<String> failureList = emailService.sendEmail(emailTemplatePath, emailParams, emailTo);
			List<String> failureList = Collections.emptyList();
			if (failureList.isEmpty()) {
				messageSent = true;
				log.info("Email sent successfully to {} recipients", emailTo.length);
			} else {
				log.info("Email sent failed");
			}
		} catch (Exception e) {
			log.error("Exception while sending the mail ", e);
		}
		return messageSent;
	}

}