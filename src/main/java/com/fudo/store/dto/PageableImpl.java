package com.fudo.store.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableImpl {
    private Integer page;
    private Integer size;
    private Sort.Direction sortType;
    private String sortableFields;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Sort.Direction getSortType() {
        return sortType;
    }

    public void setSortType(Sort.Direction sortType) {
        this.sortType = sortType;
    }

    public String getSortableFields() {
        return sortableFields;
    }

    public void setSortableFields(String sortableFields) {
        this.sortableFields = sortableFields;
    }

    public Pageable getPageable() {
        return PageRequest.of(page - 1, size, new Sort(sortType, sortableFields));
    }
}
