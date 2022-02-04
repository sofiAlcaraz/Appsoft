package com.soft.Appsoft.dao;

import com.soft.Appsoft.modelos.Prestamo;
import org.springframework.data.domain.Page;

import java.util.List;


public class Devolver<T> {
    List<T> items;
    int page;
    int totalItems;
    int totalPage;
    int size;

    public Devolver(Page<T> prestamoPagina) {
        this.page=prestamoPagina.getNumber();
        this.totalItems= (int) prestamoPagina.getTotalElements();
        this.totalPage=prestamoPagina.getTotalPages();
        this.size=prestamoPagina.getSize();
        this.items=prestamoPagina.getContent();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
