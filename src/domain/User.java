package domain;

public class User {
    private final String id;
    private final String pw;

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
    //아이디 중복 여부
    public String getUserId () {
        return id;
    }
    //로그인할 때 사용할 메서드
    public boolean checkPw (String pw) {
        return this.pw.equals(pw);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
