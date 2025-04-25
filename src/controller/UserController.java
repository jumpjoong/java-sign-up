package controller;

import domain.User;
import service.UserService;

import java.util.Scanner;

public class UserController {
    private final UserService userService = new UserService();
    Scanner scanner = new Scanner(System.in);
    public void start() {
        while (true) {
            System.out.println("\n===== 회원 시스템 =====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 로그아웃");
            System.out.println("4. 계정정보상태");
            System.out.println("0. 종료");
            String number = scanner.nextLine().trim();

            switch (number) {
                case "1": signUp(); break;
                case "2": login(); break;
                case "3" : logout(); break;
                case "4" : checkId(); break;
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
    private void signUp() {
        System.out.print("아이디 입력: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호 입력: ");
        String pw = scanner.nextLine();

        boolean result = userService.signUp(id, pw);
        if(result) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("이미 존재하는 아이디가 있습니다");
        }
    }

    private void login() {
        if (userService.checkLogin()) {
            //로그인이 이미 되어있을 경우
            System.out.println("로그인이 되어있습니다");
            return;
        }

        System.out.print("아이디 입력: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호 입력: ");
        String pw = scanner.nextLine();
        boolean result = userService.login(id, pw);

        if(result) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("\n!!!!!!!!!!!!로그인 실패!!!!!!!!!!!!");
        }
    }

    private void logout() {
        System.out.println("로그아웃 하시겠습니까?");
        System.out.println("1. 예 // 2. 아니오");
        String number = scanner.nextLine().trim();
        switch (number) {
            case "1": // 로그아웃 처리
                boolean result = userService.logout();
                if (!result) {
                    System.out.println("현재 로그인된 계정이 없습니다.");
                } else {
                    System.out.println("로그아웃 되었습니다.");
                }
                break;
            case "2" :
                return;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }

    private void checkId() {
        if (!userService.checkLogin()) {
            System.out.println("로그인 먼저 해주세요");
            return;
        }

        User currentUser = userService.getUserId();
        System.out.println("현재 로그인된 사용자 정보: " + currentUser);
    }
}
