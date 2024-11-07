package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Criteria {
    private int page;
    private int size;
    public Criteria() {
        this.page=1;
        this.size=2;
    }
    public int getPageStart() {
        return (page-1)*size; //1page->0~9 , 2page->10~19, 3page->20~29
    }
}


