package com.myproject.aem.core.bean;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import java.util.Collections;
import java.util.List;

@Model(adaptables = Resource.class)
public class AssetsListVO {

    private String numberOfAssestsPerPage;
    private String totalAssets;
	private String offsetValue;
    private List<AssetsVO> assetsVO;
	

    public String getNumberOfAssestsPerPage() {
		return numberOfAssestsPerPage;
	}
	public void setNumberOfAssestsPerPage(String numberOfAssestsPerPage) {
		this.numberOfAssestsPerPage = numberOfAssestsPerPage;
	}
	public String getTotalAssets() {
		return totalAssets;
	}
	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}
	public List<AssetsVO> getAssetsVO() {
		return Collections.unmodifiableList(assetsVO);
	}
	public void setAssetsVO(List<AssetsVO> assetsVO) {
		this.assetsVO =Collections.unmodifiableList(assetsVO);
	}
	public String getOffsetValue() {
		return offsetValue;
	}
	public void setOffsetValue(String offsetValue) {
		this.offsetValue = offsetValue;
	}

}