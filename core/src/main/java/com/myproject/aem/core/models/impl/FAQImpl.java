package com.myproject.aem.core.models.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Source;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.myproject.aem.core.models.FAQ;
import com.myproject.aem.core.models.FAQDetails;

@Model(adaptables = Resource.class, adapters = FAQ.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FAQImpl implements FAQ {
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQImpl.class);
	private static final String UNIQUEID = "uniqueId";
	private static final String FAQANSWER = "faqanswer";
	private static final String FAQQ = "faqquestion"; 

	@Inject
	private List<FAQDetails> faqs;

	@Self
	private Resource resourcer;

	@Inject
	@Source("sling-object")
	private ResourceResolver resourceResolver;

	private List<FAQDetails> qasWithIds;
	
	private List<FAQDetails> qas3;

	@PostConstruct
	public final void init() {
		if(faqs!=null && faqs.size()>0) {
		generatedIds(new ArrayList<>(faqs));
		qas3=new ArrayList<FAQDetails>();
		qas3.addAll(faqs);
		qas3.forEach(e->e.setFaqAnswer(e.getFaqAnswer().replaceAll("<[^>]++>", "")));
		}
		}
		

	public void generatedIds(List<FAQDetails> qas) {
		PageManager pm = resourcer.getResourceResolver().adaptTo(PageManager.class);
		Page containingPage = pm.getContainingPage(resourcer);
		String pageName = containingPage.getName();
		Resource resource;
		Session session = resourceResolver.adaptTo(Session.class);
		Node node = null;
		try {
			resource = resourceResolver.getResource(containingPage.getPath())
					.getChild("jcr:content/root/responsivegrid/faq/faqs");
			node = resource.adaptTo(Node.class);
			final NodeIterator iterator1 = node.getNodes();
			int i = 0;
			while (iterator1.hasNext()) {
				Node respGrid = iterator1.nextNode();
				respGrid.setProperty(UNIQUEID, pageName + (i + 1));
				i++;
				session.save();
			}
		} catch (RepositoryException e) {
			LOGGER.error("error on node is : {}" , e.getMessage());
		}
		qasWithIds = new ArrayList<>();
			for (int i = 0; i < qas.size(); i++) {
				FAQDetails qaObj = new FAQDetails();
				String question = qas.get(i).getFaqQuestion();
				String answer = qas.get(i).getFaqAnswer();
				String questionId = pageName + (i + 1);
				qaObj.setFaqQuestion(question);
				qaObj.setFaqAnswer(answer);
				qaObj.setUniqueId(questionId);
				qasWithIds.add(qaObj);
			}
		
	}

	@Override
	public List<FAQDetails> getQasWithIds() {
		return Collections.unmodifiableList(this.qasWithIds);
	}

	@Override
	public List<FAQDetails> getSortedQasWithIds() {
		List<FAQDetails> current = Collections.unmodifiableList(this.qasWithIds);
		List<Map<String, String>> sorting = new ArrayList<>();
		for (int i = 0; i < current.size(); i++) {
			Map<String, String> hm = new HashMap<>();
			String answer = current.get(i).getFaqAnswer();
			String questionId = current.get(i).getUniqueId();
			hm.put(FAQANSWER, answer);
			hm.put(UNIQUEID, questionId);
			if (current.get(i).getFaqQuestion() != null && !StringUtils.isBlank(current.get(i).getFaqQuestion())) {
				String question = current.get(i).getFaqQuestion();
				hm.put(FAQQ, question);
				sorting.add(hm);
			}
		}
		Collections.sort(sorting, (m1, m2) -> m1.get(FAQQ).toLowerCase().compareTo(m2.get(FAQQ).toLowerCase()));
		List<FAQDetails> sorted = new ArrayList<>();
		for (int i = 0; i < sorting.size(); i++) {
			FAQDetails qaObj = new FAQDetails();
			String question = sorting.get(i).getOrDefault(FAQQ, "");
			String answer = sorting.get(i).getOrDefault(FAQANSWER, "");
			String questionId = sorting.get(i).getOrDefault(UNIQUEID, "");
			qaObj.setFaqQuestion(question);
			qaObj.setFaqAnswer(answer);
			qaObj.setUniqueId(questionId);
			sorted.add(qaObj);
		}
		return sorted;
	}
	
	@Override
	public List<FAQDetails> getQasWithoutHtmlTagss() {
		return Collections.unmodifiableList(this.qas3);
	}
}
