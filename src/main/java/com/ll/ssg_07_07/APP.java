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
                case "종료":
                    break outer;
            }
        }
        sc.close();
    }
}
