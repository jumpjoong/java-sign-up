package service;

import domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users = new ArrayList<>();
    //로그인한 유저 계정
    private User userCurrent = null;
    //회원가입
    public boolean signUp(String id, String pw) {
        //아이디 중복 검사
        for (User u : users) {
            if (u.getUserId().equals(id)) {
                return false;
            }
        }
        User newUser = new User(id, pw);
        users.add(newUser);
        return true;
    }
    //로그인
    public boolean login(String id, String pw) {
        for (User u : users) {
            if(u.getUserId().equals(id) && u.checkPw(pw)) {
                //로그인 할 때 유저 정보를 userCurrent에 담아놓음
                userCurrent = u;
                return true;
            }
        }
        return false;
    }
    //로그인 확인 여부
    public boolean checkLogin() {
        //로그인 한 상태
        if(userCurrent == null) {
            return false;
        }
        //로그인 안 한 상태
        return true;
    }
    //로그아웃
    public boolean logout() {
        //이미 로그아웃 된 상태
        if (userCurrent == null) {
            return false;
        }
        userCurrent = null;
        return true;
    }
    //자신의 계정 정보 상태
    public User getUserId() {
        return userCurrent;
    }
}
