package com.myproject.aem.core.models;

import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

public class FAQDetails {
	
	@ValueMapValue
	private String faqQuestion;
	
	@ValueMapValue
	private String faqAnswer;
	private String uniqueId;
	
	public String getFaqQuestion() {
		return faqQuestion;
	}
	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}
	public String getFaqAnswer() {
		return faqAnswer;
	}
	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
}
