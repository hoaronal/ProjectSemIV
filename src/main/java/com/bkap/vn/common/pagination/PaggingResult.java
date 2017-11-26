package com.bkap.vn.common.pagination;

import java.util.List;

public class PaggingResult {
    private int firstPage = 1;
    private int lastPage;
    private int currentPage;
    private int totalRecord;
    private int totalPage;
    private int[] pages;
    private int pageRange = 20;
    private List item;

    public PaggingResult() {
    }

    public PaggingResult(int firstPage, int lastPage, int currentPage, int totalRecord, int totalPage, int[] pages, int pageRange) {
        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.pages = pages;
        this.pageRange = pageRange;
    }

    public PaggingResult(int firstPage, int lastPage, int currentPage, int totalRecord, int totalPage, int[] pages, int pageRange, List item) {
        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.pages = pages;
        this.pageRange = pageRange;
        this.item = item;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int[] getPages() {
        return pages;
    }

    public void setPages(int[] pages) {
        this.pages = pages;
    }

    public int getPageRange() {
        return pageRange;
    }

    public void setPageRange(int pageRange) {
        this.pageRange = pageRange;
    }

    public List getItem() {
        return item;
    }

    public void setItem(List item) {
        this.item = item;
    }

    public Integer[] paging(int totalRows, int firstRow) {
        Integer[] pages;
        currentPage = (totalRows / pageRange) - ((totalRows - firstRow) / pageRange) + 1;
        totalPage = (totalRows / pageRange) + ((totalRows % pageRange != 0) ? 1 : 0);
        int pagesLength = Math.min(pageRange, totalPage);
        pages = new Integer[pagesLength];
        int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPage - pagesLength);
        for (int i = 0; i < pagesLength; i++) {
            pages[i] = ++firstPage;
        }
        return pages;
    }
}
