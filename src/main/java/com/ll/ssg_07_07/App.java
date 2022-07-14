package com.ll.ssg_07_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
   private Scanner sc;
   private List<WiseSaying> WList;
   private int WiseSayingLastId;

    App(){
       sc  = new Scanner(System.in);
       WList = new ArrayList<>();
       WiseSayingLastId  = 0;
    }
    public void run() {

        System.out.println("=== 명언 SSG ===");


        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
// 삭제?id=2
                case "삭제":
                  remove(rq);
                    break;
                case "수정":
                    int paramIdmod = rq.getIntParam("id", 0);

                    if (paramIdmod == 0) {
                        System.out.printf("id를 입력해주세요\n");
                        continue;
                    }

                    WiseSaying wisemod = null;

                    for (WiseSaying w : WList) {
                        if (w.id == paramIdmod) {
                            wisemod = w;
                        }
                    }
                    if (wisemod == null) {
                        System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramIdmod);
                        continue;
                    }

                    System.out.printf("명언(기존) : %s\n", wisemod.content);
                    System.out.printf("명언 : ");
                    wisemod.content = sc.nextLine().trim();
                    System.out.printf("작가(기존) : %s\n", wisemod.author);
                    System.out.printf("작가 : ");
                    wisemod.author = sc.nextLine().trim();

                    System.out.printf("%d번 명언이 수정되었습니다.\n", paramIdmod);

                    break;
                case "목록":
                   list(rq);
                    break;

                case "등록":
                    write(rq);
                    break;

                case "종료":
                    break outer;
            }


        }

    }

    private void list(Rq rq) {

        System.out.println("번호 / 명언 / 작가");
        System.out.println("----------------");


        for (int i = WList.size() - 1; i >= 0; i--) {
            WiseSaying w = WList.get(i);
            System.out.printf("%d / %s / %s\n", w.id, w.content, w.author);
        }

    }

    private void remove(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.printf("id를 입력해주세요\n");
            return;
        }

        WiseSaying foundWiseSaying = findById(paramId);
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        WList.remove(foundWiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);


    }

    private WiseSaying findById(int paramId) {

        for (WiseSaying w : WList) {
            if (w.id == paramId) {
               return w;
            }
        }
        return null;
    }

    private void write(Rq rq) {
        System.out.printf("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가 : ");
        String author = sc.nextLine();
        int id = ++WiseSayingLastId;
        WiseSaying w = new WiseSaying(id, content, author);
        WList.add(w);


        System.out.printf("%d번째 명언이 등록되었습니다.\n", id);
    }
}
