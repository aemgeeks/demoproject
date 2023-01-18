package com.myproject.aem.core.bean;

import java.util.List;


public class SearchResultVO {
    String offset;
    int hitCount;
    Long totalMatches;
    String searchKeyword;

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }


    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public Long getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(Long totalMatches) {
        this.totalMatches = totalMatches;
    }

    public List<SearchRecordVO> getResults() {
        return results;
    }

    public void setResults(List<SearchRecordVO> results) {
        this.results = results;
    }

    List<SearchRecordVO> results;

   
}