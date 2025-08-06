# Spring_Board
![Spring](https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![SpringBoot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)

---
### 📅 250730
- M:N (다대다) 관계 및 첨부파일 업로드 기능 학습을 위한 신규 mreview 프로젝트 생성
- 기본 엔티티(BaseEntity, Member, Movie, MoiveImage, Review) 생성
- 기본 레포지토리 생성(Member, Movie, MovieImage, Review) 생성 및 기본 Repository Test(더미 데이터 insert 포함)
- 특정 영화에 달린 리뷰 및 image 조회 등 JPA @Query를 활용한 기능 구현 
- EntityGraph 등을 통한 일부 속성 Fetch EAGER 로딩 
- 파일 업로드 컨트롤러, 화면, 자바스크립트 코드 작성 (기존 서블릿 pbl + 교재 참조)

### 📅 250731
- 업로드 컨트롤러 보완, 이미지만 업로드 제한, 썸네일레이터 활용 webp 변환 업로드, 썸네일 미리보기 기능
- 영화 등록 페이지 구현, movie 등록 및 첨부파일 등록, db 등록 및 image 로컬 저장소 저장 기능 추가
- movie title/첨부파일 submit 후 title이 db에 저장 안되는 이슈 해결

### 📅 250801
- moive list 페이지 구현(이미지 업로드시 대표 이미지(여러장 등록시 inum이 가장 작은값) 1장, 없을시에는 placehold.co 활용
- movie에 들어가는 title, regDate, modDate, 첨부파일 조회할 수 있도록 readpage 구현
- Review Controller 및 Controller에 들어가는 Aspect before 로그 설정 
- integrated test code 작성 및 MockMvc를 활용
- swagger 의존성 추가 및 간단한 활용방법 숙지

### 📅 250803
- swagger 커스터마이징 연습, 추가 연습 필요

### 📅 250804 ~ 250806
- /swagger-ui/index.html /swag로 forward 성공(filter interface 활용), 추가 커스터마이징 필요
