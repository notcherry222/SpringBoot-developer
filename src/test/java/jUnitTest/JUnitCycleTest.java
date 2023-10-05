package jUnitTest;

import org.junit.jupiter.api.*;


public class JUnitCycleTest {
    @BeforeAll //전체를 시작하기 전에 1회 실행하므로 메서드는 static으로 선언
    static void beforeAll(){
        System.out.println("@BeforeAll");
    }

    @BeforeEach //테스트 케이스를 시작하기 전마다 실행
    public void beforeEach(){
        System.out.println("@BeforeEach");
    }
    @DisplayName("1")
    @Test
    public void test1(){
        System.out.println("1");
    }

    @DisplayName("2")
    @Test
    public void test2(){
        System.out.println("2");
    }

    @AfterAll //전체 테스트를 마치고 종료하기 전 1회 실행하므로 메서드는 static으로 선언
    static void afterAll(){
        System.out.println("@AfterAll");
    }

    @AfterEach //테스트 케이스를 종료하기 전마다 실행
    public void afterEach(){
        System.out.println("@AfterEach");
    }
}
