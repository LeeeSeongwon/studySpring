package hello.singleton;

public class SingletonService {
    
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
        // new 로 생성 불가
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
