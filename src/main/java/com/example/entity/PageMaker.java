package com.example.entity;


import lombok.Data;

import java.util.List;

@Data
public class PageMaker {
    private Criteria cri;
    private int totalCount;
    private int displayPageNum=5;
    private int startPage;
    private int endPage;
    private boolean prev; // 이전버튼(true, false)
    private boolean next; // 다음버튼(true, false)
    private List<Product> lists; // 제품리스트
    public void setTotalCount(int totalCount) {
        this.totalCount=totalCount;
        pageMaker();
    }

    public void pageMaker() {
        // 1.해당페이지의 끝페이지 번호
        endPage=(int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
        // 2.해당페이지의 시작페이지 번호
        startPage=(endPage-displayPageNum)+1;
        // 3.마지막페이지 번호 구하기
        int tempEndpage=(int)(Math.ceil(totalCount/(double)cri.getSize()));
        // 4.endPage의 유효성 검사
        if(endPage>tempEndpage) {
            endPage=tempEndpage; // endPage를 조정해야한다.
        }
        // 5.이전버튼의 생성여부 : prev(◀)
        prev=(startPage!=1) ? true : false;
        // 6.다음버튼의 생성여부 : next(▶)
        next=(endPage<tempEndpage)? true : false;
    }
}
