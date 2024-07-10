package model.domain;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor // 생성자를 자동으로 생성 (매개변수 없는 생성자)
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자를 자동으로 생성
@RequiredArgsConstructor // @NonNull이나 final이 붙은 필드를 매개변수로 받는 생성자를 자동으로 생성

public class Person2 {

    @NonNull //@NotNull - SQL 값 반드시 적용하라는 설정
    private String id; // ID 필드, @NonNull 때문에 반드시 값이 있어야 함

    private int pw; // Password 필드 (비밀번호)

    @NonNull
    private String address; // 주소 필드, @NonNull 때문에 반드시 값이 있어야 함

    //step01 - 컴파일 정상, 실행 불가 왜? 해결책은?
    // - jUnit 비추하는 구조 
//    @NoArgsConstructor 
//    @AllArgsConstructor
//    @RequiredArgsConstructor
    
//    @Test // JUnit 테스트 메서드
//    public void info() {
    //step02 - jUnit에선 불가, 메인에서 실행 
    public static void main(String []args) {
        Person2 p2 = new Person2("username",10, "상암"); // Person2 객체 생성 (ID와 주소만 전달)
        System.out.println(p2.id); // 객체의 ID 출력
    }
}



