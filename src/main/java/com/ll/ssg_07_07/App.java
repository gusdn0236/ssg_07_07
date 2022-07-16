package com.ll.ssg_07_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);


    public void run() {

        System.out.println("=== 명언 SSG ===");

        WiseSayingController WiseSayingController = new WiseSayingController(sc);

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            switch (rq.getPath()) {

                case "수정":
                    WiseSayingController.modify(rq);
                    break;
//삭제?id=2
                case "삭제":
                    WiseSayingController.remove(rq);
                    break;

                case "목록":
                    WiseSayingController.list(rq);

                    break;

                case "등록":
                    WiseSayingController.write(rq);


                    break;

                case "종료":
                    break outer;

            }

        }


    }


}
