package com.myproject.aem.core.models;

import java.util.List;

public interface FAQ {
		public List<FAQDetails> getQasWithIds() ;
		public List<FAQDetails> getSortedQasWithIds() ;
		public List<FAQDetails> getQasWithoutHtmlTagss();
	}
