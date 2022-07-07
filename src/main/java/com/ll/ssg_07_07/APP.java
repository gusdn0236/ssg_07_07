package com.ll.ssg_07_07;

import java.util.Scanner;

public class APP {
    public void run() {

        System.out.println("=== 명언 SSG ===");
        Scanner sc = new Scanner(System.in);

        outer:
        while( true ){
            System.out.printf("명령) ");
            String cmd = sc.next().trim();

            switch (cmd){
                case "등록":
                    System.out.printf("명언 : ");
                    String content = sc.next().trim();
                    System.out.printf("작가 : ");
                    String author = sc.next().trim();
                    System.out.println("1번 명언이 등록되었습니다.");
                    break;

                case "종료":
                    break outer;
            }


        }
        sc.close();
    }
}
