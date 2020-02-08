package com.woodson.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageDTO {
    private List<QuestionDTO> questionDTOS;
    private Integer currentPage;
    private Integer totalPage;
    private List<Integer> pageList;
    public PageDTO(){
        pageList = new ArrayList<>();
    }

    public void setPage(Integer totalCount, Integer size) {
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

    }
}
