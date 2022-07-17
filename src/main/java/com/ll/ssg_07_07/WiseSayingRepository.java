package com.ll.ssg_07_07;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private List<WiseSaying> WList;
    private int WiseSayingLastId;

    WiseSayingRepository() {
        WList = new ArrayList<>();
        WiseSayingLastId = 0;
    }

    public void modify(int paramIdmod, String content, String author) {
        WiseSaying wisemod = findById(paramIdmod);

        wisemod.content = content;
        wisemod.author = author;
    }


    public WiseSaying findById(int paramId) {
        for (WiseSaying w : WList) {
            if (w.id == paramId) {
                return w;
            }
        }
        return null;
    }

    public List<WiseSaying> findAll() {
        return WList;

    }

    public WiseSaying write(String content, String author) {
        int id = ++WiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        WList.add(wiseSaying);
        return wiseSaying;
    }

    public void remove(int paramId) {
        WiseSaying wisedel = findById(paramId);
        WList.remove(wisedel);
    }
}
