#  [Java 기초] public static void main(String [] args)

[TOC]

## **public static void 선언 이유**

### **Java의 Main**

- Java는 Main에서 시작해서 Main에서 끝난다
- Main은 여러 클래스와 연결될 수 있는 중심부의 역할이다.

 

### **매인의 public**

- Main을 실행하는데 있어, Main에서는 다른 클래스의 메소드 등을 호출해야하는데, 막상 Main 자체가 다른 곳에서 접근을 허용하지 않는다면 문제가 생길 수 밖에 없어 Main의 접근제한자를 **public**으로 선언한 것이다.

 

### **메인의 static**

- static은 프로그램이 시작하면 따로 인스턴스화 하지 않아도 method 영역 메모리에 호출되어 진다. 이렇게 호출되어진 것들은 프로그램이 종료되기 까지 유지된다.

- 즉, **프로그램의 시작과 끝을 함께하는 Main 메소드는 프로그램이 종료되는 시점까지 유지해야하기 때문에 static으로 선언된 것이다.**

- 추가 설명

  - static은 보통 변수나 메소드 앞에 static 키워드를 붙여서 사용하게 된다.

  - 정적(static)은 고정된이란 의미를 가지고 있습니다. Static이라는 키워드를 사용하여 Static변수와 Static메소드를 만들 수 있는데 다른말로 정적필드와 정적 메소드라고도 하며 이 둘을 합쳐 정적 멤버라고 합니다. (클래스 멤버라고도 합니다.) 정적 필드와 정적 메소드는 객체(인스턴스)에 소속된 멤버가 아니라 클래스에 고정된 멤버입니다. 그렇기에 클래스 로더가 클래스를 로딩해서 메소드 메모리 영역에 적재할때 클래스별로 관리됩니다. 따라서 클래스의 로딩이 끝나는 즉시 바로 사용할 수 있습니다.

     

    ## 정적(Static) 멤버 생성

    

    ![img](public static void main(String [] args) 개념.assets/img.png)

    

    Static 키워드를 통해 생성된 정적멤버들은 Heap영역이 아닌 Static영역에 할당됩니다. Static 영역에 할당된 메모리는 모든 객체가 공유하여 하나의 멤버를 어디서든지 참조할 수 있는 장점을 가지지만 Garbage Collector의 관리 영역 밖에 존재하기에 Static영역에 있는 멤버들은 프로그램의 종료시까지 메모리가 할당된 채로 존재하게 됩니다. 그렇기에 Static을 너무 남발하게 되면 만들고자 하는 시스템 성능에 악영향을 줄 수 있습니다.

     

    ## 정적(Static) 멤버 선언

    필드나 메소드를 생성 시 인스턴스로 생성할것인지 정적으로 생성할것인지에 대한 판단 기준은 공용으로 사용하느냐 아니냐로 내리면 됩니다. 그냥 생성한다면 자동으로 인스턴스로 생성되며 정적으로 생성하려면 필드와 메소드 선언 시 static이라는 키워들를 추가적으로 붙이면 됩니다. 

    ```
    static int num = 0; //타입 필드 = 초기값
    public static void static_method(){} //static 리턴 타입 메소드 {}
    ```

     

    ## 정적(Static) 필드 사용 예시

    ```
    class Number{
        static int num = 0; //클래스 필드
        int num2 = 0; //인스턴스 필드
    }
    
    public class Static_ex {
    	
        public static void main(String[] args) {
        	Number number1 = new Number(); //첫번째 number
        	Number number2 = new Number(); //두번쨰 number
        	
        	number1.num++; //클래스 필드 num을 1증가시킴
        	number1.num2++; //인스턴스 필드 num을 1증가시킴
        	System.out.println(number2.num); //두번째 number의 클래스 필드 출력
        	System.out.println(number2.num2); //두번째 number의 인스턴스 필드 출력
        }
    }
    ```

    

    ![img](public static void main(String [] args) 개념.assets/img.png)

    

    Number이라는 클래스안에 클래스 변수 num과 인스턴스 변수 num2를 생성하였고 두개의 Number인스턴스 number1과 number2를 생성했을때 number1에서 num1과 num2를 각각 1씩 증가시키고 number2에서 num1와 num2를 각각 출력시켰을때는 num1은 1, num2는 0이 출력되었습니다. 왜 이런 현상이 나타났느냐면 인스턴스 변수는 인스턴스가 생성될 때마다 생성되므로 인스턴스마다 각기 다른 값을 가지지만 정적 변수는 모든 인스턴스가 하나의 저장공간을 공유하기에 항상 같은 값을 가지기에 나타난 현상입니다.

     

    ## 정적(Static) 메서드 사용 예시

    ```
    class Name{
        static void print() { //클래스 메소드
    	System.out.println("내 이름은 홍길동입니다.");
        }
    
        void print2() { //인스턴스 메소드
    	System.out.println("내 이름은 이순신입니다.");
        }
    }
    
    public class Static_ex {
    	
        public static void main(String[] args) {
            Name.print(); //인스턴스를 생성하지 않아도 호출이 가능
        	
            Name name = new Name(); //인스턴스 생성
            name.print2(); //인스턴스를 생성하여야만 호출이 가능
        }
    }
    ```

    

    ![img](public static void main(String [] args) 개념.assets/img.png)

    

    정적 메소드는 클래스가 메모리에 올라갈 때 정적 메소드가 자동적으로 생성됩니다. 그렇기에 정적 메소드는 인스턴스를 생성하지 않아도 호출을 할 수 있습니다. 정적 메소드는 유틸리티 함수를 만드는데 유용하게 사용됩니다.

 

### **메인의 void**

- Main 메소드는 프로그램이 종료되는 시점까지 유지가 된다. 즉, **만약 반환 타입이 선언되어 있다면 프로그램이 종료될 때 어떤 값을 반환하겠다라는 것인데, 이는 우리가 추구하는 목적과는 상관없는 로직이다.**
- 우리는 프로그램을 사용할 때 프로그램이 구동되는 그 시점에서만 메시지를 주고 받으므로, 프로그램이 종료되는 시점에서 반환되는 값은 전혀 의미가 없는 값이다.



### **메인의 String [] args**

- 결론부터 말하면, **외부에서 값을 받아오기 위해 사용한 매개변수이다.**

- 외부에서 받아오는 값을 옵션이라고 하는데 이 옵션들은 String 배열에 넣어 프로그램을 실행한다.

- 여기서 옵션은,

  - 예를 들어, 도스 창에서 **dir \*.txt ** 라는 명령어를 사용하게 되면 txt 확장자를 가진 파일들의 목록이 출력되는데, 여기서 *.txt가 옵션에 해당하는 것이다.

  - java에서는

     

    java Foo

     

    로 **Foo라는 자바 프로그램을 실행할 때,

    - java Foo ABC IBM naver

       

      이런 식으로 Foo 뒤에 문자열을 붙여서 실행한다면,

      - **String []에 ABC, IBM, naver**가 저장되는 것이다.

- 만약 **-help**와 같은 옵션이 설정된다면 프로그래머는 String 배열에서 해당 문자를 꺼내와 알맞은 처리를 진행하면 되는 것이다.