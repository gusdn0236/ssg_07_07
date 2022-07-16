package com.ll.ssg_07_07;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    public List<WiseSaying> WList;
    public int WiseSayingLastId;

    WiseSayingRepository(){
        WList = new ArrayList<>();
        WiseSayingLastId = 0;
    }

    public WiseSaying findById(int paramId) {
        for (WiseSaying w : WList) {
            if (w.id == paramId) {
                return w;
            }
        }
        return null;
    }
}
