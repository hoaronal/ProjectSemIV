package com.bkap.vn.common.pagination;

import java.util.List;

public class PaggingResult {
    private int firstPage = 1;
    private int lastPage;
    private int currentPage;
    private int totalRecord=0;
    private int totalPage;
    private int numRecordInPage;
    private Integer[] pages;
    private int pageRange = 4;
    private int rowsPerPage = 10;
    private List item;

    public PaggingResult() {
    }

    public PaggingResult(int firstPage, int lastPage, int currentPage, int totalRecord, int totalPage, Integer[] pages, int pageRange) {
        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.pages = pages;
        this.pageRange = pageRange;
    }

    public PaggingResult(int firstPage, int lastPage, int currentPage, int totalRecord, int totalPage, Integer[] pages, int pageRange, List item) {
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

    public Integer[] getPages() {
        return pages;
    }

    public void setPages(Integer[] pages) {
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

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public int getNumRecordInPage() {
        return numRecordInPage;
    }

    public void setNumRecordInPage(int numRecordInPage) {
        this.numRecordInPage = numRecordInPage;
    }

    public Integer[] paging(int currentPage, int totalPages, int totalRows, int rowsPerPage, int firstRow, int pageRange) {
        currentPage = (totalRows / rowsPerPage) - ((totalRows - firstRow) / rowsPerPage) + 1;
        totalPages = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
        // Size of list page link
        int pagesLength = Math.min(pageRange, totalPages);
        pages = new Integer[pagesLength];
        int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPages - pagesLength);
        // Create pages (page numbers for page links).
        for (int i = 0; i < pagesLength; i++) {
            pages[i] = ++firstPage;
        }
        lastPage = totalPages;
        return pages;
    }

    public Integer[] paging() {
        int firstRow = (currentPage - 1) * rowsPerPage;
        currentPage = (totalRecord / rowsPerPage) - ((totalRecord - firstRow) / rowsPerPage) + 1;
        totalPage = (totalRecord / rowsPerPage) + ((totalRecord % rowsPerPage != 0) ? 1 : 0);
        int pagesLength = Math.min(pageRange, totalPage);
        pages = new Integer[pagesLength];
        int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPage - pagesLength);
        for (int i = 0; i < pagesLength; i++) {
            pages[i] = ++firstPage;
        }
        lastPage = totalPage;
        return pages;
    }
}
