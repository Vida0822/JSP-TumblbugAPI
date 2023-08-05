# :pushpin: Tumblbug JSP Project

> 크라우드 펀딩 사이트 '텀블벅' - DispatcherServlet을 직접 제작한 모델 2방식(MVC) 웹사이트 구현

</br>



### 목차

1. 제작기간 & 참여 인원  <br>
2. 사용 기술  <br>
3. 프로젝트 개요 <br>
4. 요구분석 : User - Diagram 설계 
5. DB 모델링 : ERD / EXERD 설계    <br>
6. 프로젝트 흐름도  
7. 핵심 기능 코딩    <br>
8. 트러블 슈팅  <br>
9. 프로젝트 회고 <br>

</br></br>



## 1. 제작 기간 & 참여 인원

- 👩‍👧‍👧 팀 프로젝트 (7인)<br>

- 📆 2023 5월 30일 ~ 6월 19일 (21일)  <br>

  

  </br>

## 2. 사용 기술

#### `Back-end`

  - Java 8
  - Spring Framework 2.3
  - Gradle
  - Spring Data JPA
  - QueryDSL
  - H2
  - MySQL 5.7
  - Spring Security
  - Jsoup

#### `Front-end`

  - Vue.js 3.0
  - Element UI

</br>



## 3. 프로젝트 개요

​	이 프로젝트는  프레임워크의 도움을 받지않고 고전적인 방식으로 모델2 방식의 MVC 구조를 구현한 jsp 기반 프로젝트이다. 실제 존재하는 사이트의 프론트/백앤드 기능을 구현하는 웹 프로젝트로, 사이트는 리워드(보상형) 크라우드 펀딩 업체, '텀블벅(tumblbug)'을 선택하였다. 

​	웹 컨테이너 개발환경을 설정하고 서블릿 및 Model, Controller 클래스를 직접 작성, 등록, 매핑하며 스프링을 본격적으로 공부하기전 MVC 및 웹 어플리케이션의 동작 원리와 구조를 정확히 파악할 수 있는 기회가 되었다.   

</br>

<details>
<summary><b>개발 단계 및 일정 </b></summary>
<div markdown="1">

  
* 5월 21일 ~ 5월 29일 : 요구분석 취합본 도출 
* 5월 30일 ~ 6월 02일 : DB 구축
* 6월 02일 ~ 6월 06일 : 개발환경 세팅, 기능구현-공통작업
* 6월 07일 ~ 6월 16일 : 기능구현-분담작업
* 6월 17일 ~ 6월 19일 : 프로젝트 취합, 발표준비

</div>
</details> 
    
</br>



## 4. 요구분석 : User - Diagram 설계 

![use-diagram drawio](https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/ac4f8f32-d952-45da-ab38-4c13bdf0da96)

</br></br>







## 5. DB 모델링 :  ERD / EXERD 설계

![erd](https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/14500790-be8d-4112-8344-a597e2be1d8f)

</br></br>





<details>
<summary><b> 개체 및 속성 정리</b></summary>
<div markdown="1">

<img width="625" alt="1" src="https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/a67cb148-a8a1-40f8-8c57-438b61c836f8">
<img width="625" alt="2" src="https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/9f8e341e-0059-4f7a-942c-a23bd40c8b98">
<img width="625" alt="3" src="https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/7a3dfb94-b371-4fe0-8de2-1de715918fce">
<img width="625" alt="4" src="https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/ac4d35b0-24b6-4550-9795-f85a2f891774">
<img width="625" alt="5" src="https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/2b88923c-fbef-49e9-8914-f2acfe003de8">
<img width="625" alt="6" src="https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/07bffd01-1d39-41c3-ab5b-cdd1843de0cc">


</div>
</details> 
    
</br>




## 6. 프로젝트 흐름

### 구조 : 모델2 방식(MVC 패턴)  
![전체흐름](https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/dc7100a7-ee6f-4ec3-9c8e-06e63b295c60)


</br>


<details>
<summary><b>프로젝트 구조 설명 펼치기</b></summary>
<div markdown="1">


### 6.1. View
![jsp](https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/107ca051-3928-4e89-b5ca-c46553f4a11d)
</br>
* 의외로 가장 시간이 많이 들고 어렵게 구현
  * 페이지 설계(html 태그)를 공개하지 않아 개발자 도구에 출력되는 태그들을 화면 캡쳐하듯이 가져옴. 
  * 스타일(css) 태그도 의도적으로 알아보기 힘들게 작성되어있어 개발자 도구로 각 태그별 적용된 스타일을 하나씩 클래스명으로 매치시켜가면서 작성
  * 동적인 요소가 많은데 스크립트 코딩이 공개되어있지 않아 모든 동적인 기능 일일히 구현

* 프로젝트 구조에 실제 사이트 요구사항 반영

  * 요청 url로 접근할 수 없고 단계별로 접근 해야하는 페이지는 web-inf아래 view 폴더에 배치 (직접접근방지) 
  * 요청 url만으로도 직접 접근할 수 있는 view 페이지는 web-inf 밖의 publicWeb 폴더에 배치

* jsp 페이지로 제작

  * 사용자 동작에 맞게 스크립트 처리 (**프론트엔드 개발)

  * 사용자 입력값 (요청값) 보내기

  * html, css 로 화면 구성

  * 서버로부터 넘어온 응답 데이터 el,jstl로 출력 

    

### 6.2. DispatcherServlet

![Servlet](https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/614a1ae5-c864-4bc5-bb28-9c2d2cb913db)
</br>
​	모든 요청에 대해 들어가기 전 수행해야할 공통작업, 필수작업을  수행하는 frontController로서 전달받은 요청 url에 따라 업무를 수행할 핸들러를 호출하는 Mapping 기능을 담당했다.  

* 서블릿 등록 

  ```xml
  <servlet>
  	<servlet-name>ControllerUsingURI</servlet-name>
  	<servlet-class>mvc.controller.ControllerUsingURI</servlet-class>
  	<init-param>
  		<param-name>configFile</param-name>
  		<param-value>
                 /WEB-INF/commandHandlerURI.properties
           </param-value>
  	</init-param>
  <load-on-startup>1</load-on-startup>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>ControllerUsingURI</servlet-name>
  	<url-pattern>*.do</url-pattern>
  </servlet-mapping>
  ```

  * servlet 등록 : web.xml로 서블릿 컨테이너(톰캣)에 생성 - 매개변수로 properties 파일 넣어줌 
  * servlet 매핑 : *.do로 들어오는 모든 요청을 이 컨트롤러(ControllerUsingURI)가 담당

  * properties 파일 :  각 요청 url 별 처리할 Handler를 매치시켜 목록으로 작성해놓은 일반 파일 
  * application이 실행될 때 init() 호출  : properties 파일을 FileReader로 읽어 commandHandlerMap라는 Map 형태로 Handler 목록 저장 => (요청 url, 담당할 Handler)

* 매핑

  * 요청이 들어오면 commandHandlerMap에서 해당 요청 url에 해당하는 Handler를 찾아 객체를 생성해 interface형 참조변수(CommandHandler)에 대입

  * interface CommandHandler: 요청을 처리하는 함수 process()가 선언되어 있음 

    : 모든 핸들러는 해당 process()를 오버라이딩해서 매핑된 요청을 다뤄야 함  

  * 생성된 handler 객체의 process() 호출 

    : 전송방식이 get이던 post던 해당 메서드가 요청을 처리 (doGet(), doPost() 둘다 process() 호출)  

    => 매핑된 Handler로 요청, 응답 객체 전달 

  * Mapping 된 Handler가 없으면 NullHandler라는 Handler 객체 생성 

    * SC_NOT_FOUND : 404 에러 -> 이 에러를 응답객체에  클라이언트에 send(보내겠다)

    ```java
    public class NullHandler implements CommandHandler {
    
    	@Override
    	public String process(HttpServletRequest req, HttpServletResponse res)
    	throws Exception {
    		res.sendError(HttpServletResponse.SC_NOT_FOUND); 
    		return null;
    	}
    }
    ```

    

* 포워딩 

  * return된 viewPage(String)로 request, response 객체 포워딩

  * redirect는 Handler에서 임의로 처리 : redirect시 컨트롤러로 돌아오지 않고 핸들러에서 로직 종료 

     

### 6.3. Handler
![Handler](https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/ca6bbd0a-876d-4626-8747-4990d880b28a)

​	매핑으로 전달받은 요청과 응답 객체를 직접 다루며 모델과 뷰를 제어한다. 사용자의 요청을 받아서 분석하고 비즈니스 로직을 처리하는 Model을 호출한다. 모델이 결과값을 반환하면 출력할 뷰(jsp 페이지)를 선택한 후 전달한다. 

*  Model 호출 :  Service, DAO의 메서드 호출 

​	: 생성된 자바 응답 데이터를 request 객체에 담고 포워딩 시킬 뷰페이지 컨트롤러에 반환 

*  process() 오버라이딩 : 이 handler에서 매핑된 요청을 어떻게 처리할지 본격적으로 구현 

  * processGet()  : 요청이 get방식으로 들어오면 실행 

     => 주로 포워딩 : return FORMVIEW (String)

  *  processSubmit()  : 요청이 post방식으로 들어오면 실행 

    => 주로 리다이렉트: 원래는 Controller에서 해줘야하지만 편의상 Handler가 처리 

* 바인딩 : 비즈니스 로직 부분에 요청을 다루는 코딩(요청, 응답 객체)을 직접 넣어주지 않고 매개변수를 추출해  자바 데이터 형태로 변환해서 넣어줌

  ```java
  public class MakeProjectHandler implements CommandHandler {
  	private static final String FORM_VIEW = "/WEB-INF/view/projectForm.jsp";
  	
  	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
  		if (req.getMethod().equalsIgnoreCase("GET")) {
  			return processForm(req, res); // 폼 띄우는함수 
  		} else if (req.getMethod().equalsIgnoreCase("POST")) {
  			return processSubmit(req, res); // db에 submit 하는 함수 
  		} else {
  			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // get, post 방식 외 요청방식이 있는데 (안배웠지만) 그걸로 들어왔다면 !
  			return null;
  		}
  	}// process
  ```

  

### 6.4. Model(Service & DAO)
![Service](https://github.com/Vida0822/Tumblbug_JSP_Project/assets/132312673/8d90a9de-ba7a-45bf-8497-27c42ea62091)
</br>

​	업무 처리 로직(비즈니스 로직) 혹은 데이터 베이스와 관련된 작업을 담당한다 

* Service

  * 비즈니스 로직 수행: 로직 처리 후 view 페이지로 전달할 객체로 구성(생성)해서 반환
  * 트랜잭션 처리 - commit , rollback 

* DAO 

  * DB를 직접적으로 다룸 :  주로 dto 를 단위로 넘기고 넘겨받는다

  * java의 jdbc 기능 사용 : SQL 및 DB연결, Java언어가 모두 존재하기때문에 재사용성이 좋지 않았다. 

    

</div>
</details> 
    
</br>



## 7. 핵심 기능

#### 7.1. 회원가입- <a href="https://github.com/Vida0822/Tumblbug_JSP-MVC-Project/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%EB%A9%94%EC%9D%B8-Page)" >상세보기 - WIKI 이동</a>

- DB값 검증 : 이미 있는 계정
- 입력값 유효성 검사: 형식에 맞는 이메일/ 비밀번호
- 입력값 확인 
- 약관 동의 체크박스 
- 회원 탈퇴

#### 7.2. 로그인 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Member)" >상세보기 - WIKI 이동</a>

- 주소 API 연동
- ID 중복 체크
- 로그아웃 

#### 7.2. 회원 정보 관리 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Member)" >상세보기 - WIKI 이동</a>

- 주소 API 연동
- ID 중복 체크

#### 7.3. 메인 페이지 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Member)" >상세보기 - WIKI 이동</a>

- 프로젝트 목록보기
- ID 중복 체크

#### 7.4. 조건별로 검색하기 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Member)" >상세보기 - WIKI 이동</a>

- 주소 API 연동
- 회원정보 변경

#### 7.4. 상세 페이지 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%EC%98%81%ED%99%94-%EC%98%88%EB%A7%A4)" >상세보기 - WIKI 이동</a>

- 영화 선택(날짜 지정)
- 영화관 선택(대분류/소분류 선택) 및 시간 선택
- 좌석 선택
- 결제 페이지
- 예매 완료

#### 7.5. 후원하기 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%EB%A9%94%EC%9D%B8-Page)" >상세보기 - WIKI 이동</a>

- YouTube API 연동
- 메인 포스터(영화) 이미지 슬라이드(CSS)

#### 7.6. 프로젝트 올리기  - <a href="" >상세보기 - WIKI 이동</a> 

- 글 작성, 읽기, 수정, 삭제(CRUD)





</div>
</details>

</br>

## 8. 핵심 트러블 슈팅 (프젝 올리기 스크립트 쪽 여기에)

(기입 예정) 



## 9. 회고 / 느낀점

(기입 예정) 
