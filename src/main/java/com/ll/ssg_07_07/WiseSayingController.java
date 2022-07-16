package com.ll.ssg_07_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {


    private Scanner sc;
    private WiseSayingRepository wiseSayingRepository;

    WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository();

    }


    public void write(Rq rq) {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();
        int id = ++wiseSayingRepository.WiseSayingLastId;
        WiseSaying w = new WiseSaying(id, content, author);
        wiseSayingRepository.WList.add(w);
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void list(Rq rq) {
        System.out.println("번호 / 명언 / 작가");
        System.out.println("----------------");
        for (int i = 0; i < wiseSayingRepository.WList.size(); i++) {
            WiseSaying w = wiseSayingRepository.WList.get(i);
            System.out.printf("%d / %s / %s\n", w.id, w.content, w.author);

        }
    }

    public void remove(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.println("id를 입력하세요");
            return;
        }


        WiseSaying wisedel = wiseSayingRepository.findById(paramId);

        if (wisedel == null) {
            System.out.printf("%d 번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        wiseSayingRepository.WList.remove(wisedel);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);

    }

    public void modify(Rq rq) {
        int paramIdmod = rq.getIntParam("id", 0);

        if (paramIdmod == 0) {
            System.out.println("id를 입력하세요");
            return;
        }

        WiseSaying wisemod = wiseSayingRepository.findById(paramIdmod);


        if (wisemod == null) {
            System.out.printf("%d 번 명언은 존재하지 않습니다.\n", paramIdmod);
            return;
        }


        System.out.printf("명언(기존) %s\n", wisemod.content);
        System.out.printf("명언 : ");
        wisemod.content = sc.nextLine().trim();
        System.out.printf("작가(기존) %s\n", wisemod.author);
        System.out.printf("작가 : ");
        wisemod.author = sc.nextLine().trim();

        System.out.printf("%d번 명언이 수정되었습니다.\n", paramIdmod);
    }


}
