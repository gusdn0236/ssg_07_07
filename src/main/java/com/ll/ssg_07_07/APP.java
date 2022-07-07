package com.ll.ssg_07_07;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class APP {
    public void run() {


        // n번째 명언
        int wiseSayingLastId = 0;

        System.out.println("=== 명언 SSG ===");
        Scanner sc = new Scanner(System.in);


        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------");
//                     구현하다 멈춤
//                    if(wiseSayingLastId == 0){
//                        System.out.println("아직 등록된 명언이 없습니다.");
//                    }else{
//                        for(int i = 0; i <wiseSayingLastId; i++ ){
//                            System.out.printf("%d / %s / %s",wiseSayingLastId,author,content);
//                        }
//                    }


                case "등록":
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();
                    int id = ++wiseSayingLastId;  // 명언 번호 증가

                    WiseSaying WiseSaying = new WiseSaying(id, content, author);
                    System.out.println(WiseSaying);

                    try {
                        OutputStream output = new FileOutputStream(id+"번째, "+author+"의 명언.txt");
                        // 할일 1. 여기 content가 저장되는데 id,content,author 전부다 저장되게 만들어야됨(?)
                        String str = content;
                        byte[] by=str.getBytes();
                        output.write(by);

                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;


                case "종료":
                    break outer;
            }


        }
        sc.close();
    }
}

