# 📚북킹(BooKing)📚

## 개발 기간
2023.10.10 ~ 2023.11.17(기획 2주, 개발 4주)

## 📖서비스 소개📖
(메인 화면 사진)  
북킹은 오프라인 독서모임 관리 서비스입니다.  
위치 기반의 독서 모임 관리와 출석 체크, 참가비 등 모임 관리에 필요한 내용을 관리해주는 서비스입니다.  
독서 모임 내에서의 게시글, 회의 내용 텍스트로 변환 및 요약 기능을 제공합니다.

## 📗주요 기능📗

1. 주변 지역에서 모집 중인 독서 모임과 보고 싶은 도서에 대한 정보 제공  
  - 사용자 위치 기반으로 주변 독서 모임 정보 제공
  - 여러 책에 대한 정보 제공
2. 독서 모임 약속 장소에 대한 정보를 제공하고 GPS기반 출석체크 기능
 - 지도를 통해 모임 장소 정보 제공
 - 사용자 위치 확인을 통해 출석체크
3. 독서 회의 내용을 텍스트로 변환하고 요약하는 기능
 - STT를 통해 모임 대화 녹음본을 텍스트로 변환 
 - STT 변환문 문장별 수정 기능 제공
 - 대화 내용 요약
4. 참가비를 지불하고 출석체크 시 환급 불참 시 미환급
 - 참석자는 참가비 전액 + 미참석자 금액 1/N 을 환급받는다.
 - 미참석자는 참가비 전액 미환급


## 📘핵심 기술📘

- MSA 아키텍처, Spring webFlux, Reactive Database Driver를 통한 Non-blocking I/O 작업을 통해 부하 분산 효과 증가
- 멀티 모듈 기반의 클린 아키텍처 적용을 통한 유지보수성 및 코드 가독성 증가 및 보일러플레이트 코드 감소
- Hilt 라이브러리를 사용하여 의존성 주입을 통한 라이프사이클 관리 용이
- 기존의 XML 기반이 아닌 Jetpack compose를 통해 개발을 진행함으로서 코드 가독성 증가, 유지보수 용이

## 📙주요 화면📙

## 회원 관련 화면 - 1 :man:
|                회원가입                |                 로그인                 |
|:----------------------------------:|:-----------------------------------:|
| ![회원가입](exec/gif/회원가입.gif) | ![로그인](exec/gif/로그인.gif) | 
|    회원 정보를 입력한 뒤 회원가입을 진행합니다    |         카카오와 구글 아이디로 로그인을 진행합니다.        |
* 위치기반 북킹 서비스 제공을 위해 사용자의 위치 정보를 입력받습니다.
* 카카오 로그인 API과 구글 로그인 API를 사용하여 회원가입을 구현했습니다.

## 회원 관련 화면 - 2 :woman:
|               회원 정보 수정              |                마이페이지               |
|:----------------------------------:|:------------------------------:|
| ![내 정보 수정](exec/gif/회원정보수정.gif) | ![마이페이지](exec/gif/마이페이지.gif) |
|     프로필 사진과 닉네임을 수정할 수 있습니다.     | 내 서재와 내 북킹을 확인할 수 있고, 포인트 충전을 할 수 있습니다. |
* 모임에 참여한 책들이 자동으로 `내 서재`에 담기고, 추가로 도서를 등록할 수 있습니다.
* 각 도서들에 대해서는 한 줄 평을 남길 수 있습니다.
* 참여한 모임의 목록을 확인할 수 있습니다.
* 포인트 충전은 카카오페이 API를 사용해 구현했습니다.



|                         모임 생성                       |              모임 확정               |
|:------------------------------------------------------------:|:-----------------------------------------------:|
|            ![모임생성](exec/gif/모임생성.gif)             |  ![모임확정](exec/gif/모임확정.gif) |
| 원하는 책을 고른 후 독서모임을 생성합니다. |      원하는 장소와 시간, 참가비를 선택한 후 모임을 확정합니다.     |
* 제목,소개,인원 수,해시태그를 입력하면 모임이 생성됩니다.
* 입력한 정보를 기반으로 모임을 검색할 수 있습니다.
* 지도는 네이버 API를, 키워드 장소 검색은 카카오 API를 사용해 구현했습니다.


|                         모임 진행                       |              모임 참여               |
|:------------------------------------------------------------:|:-----------------------------------------------:|
|            ![모임진행](exec/gif/모임참여과정.gif)             |  ![모임진행](exec/gif/출첵결제.gif) |
| 출석체크와 참가비 지불 과정을 진행합니다. |             |

|                         실시간 단체 채팅                       |              팔로잉,팔로워               |
|:------------------------------------------------------------:|:-----------------------------------------------:|
|            ![채팅](exec/gif/채팅.gif)             |  ![모임참여](exec/gif/팔로잉팔로워.gif) |
| 모임에 참여한 사람들과 실시간 채팅을 할 수 있습니다. |     유저들은 서로 팔로우를 할 수 있고, 그들의 모임과 서재를 조회할 수 있습니다.      |

|                         도서 검색                       |              독서 모임 STT & 요약               |
|:------------------------------------------------------------:|:-----------------------------------------------:|
|            ![도서 검색](https://github.com/prkhch/booking/assets/122577719/285b6a2b-3385-42b8-9ab9-e22ef310dc79)            |  ![모임참여](exec/gif/독서모임녹음분석.gif) |
| 자체 도서 서버에서 수집된 도서 목록을 조회하고 검색 기능을 통하여 도서를 검색할 수 있습니다. |     |
* Jetpack Compose 의 LazyRow, LazyColumn, LazyVerticalGrid 을 사용하여 많은 양의 데이터를 효과적으로 스크린에 표시하였습니다.
* 보일러 플레이트 코드를 감소시키기 위해 도서 검색 스크린이 필요한 다른 페이지에서도 동일한 composable function 을 호출하여 재사용하였습니다.
* TextField 내의 다양한 옵션(trailingIcon - 일괄 삭제)을 제공하여 UI/UX 를 향상시켰습니다.
* 도서 표지를 터치하여 도서 상세페이지로 이동, 독서 모임 도서 선정, 내 서재 도서 등록 등 다양한 기능을 수행할 수 있도록 Composable function 을 관리하였습니다.
* 자체적으로 녹음 진행이 가능합니다.
* 진행된 녹음을 내 안드로이드 기기 내에 저장 시킬 수 있습니다.
* 내 기기에 저장되어있는 녹음 파일을 불러와 녹음 파일을 등록할 수 있습니다.





## 📔시스템 아키텍처📔
![image](https://github.com/Shin-sangwon/Refill/assets/101318750/d46ff3d4-4dbf-4c02-b06a-f1b06c68cf85)

## 🗾ERD🗾
![EERRDD](https://github.com/Shin-sangwon/Refill/assets/101318750/62f6fde8-884a-4b49-8526-1301aab3e4cc)

## 📑Branch strategy📑

### Git Flow

```bash
# Branch명
master : 운영 서버로 배포하기 위한 branch
develop : 안정되고 배포 가능한 branch
FE/develop : frontend develop
BE/develop : backend develop
{포지션}/feat/{기능}#{이슈 번호} : 기능 개발을 위한 branch
{포지션}/refactor/{기능}#{이슈 번호} : 리팩토링 branch
{포지션}/hotfix : dev 브랜치에서 발생한 버그를 수정하는 branch

// 예시
BE/feat/user#1

# Pull Request명
브랜치명
# Pull Request 내용
템플릿
```

- **New Issues**
  - Title : `[BE] 회원 도메인 생성`
  - Description : 템플릿 사용
  - Assignee : 담당자 지정
  - **Create Issues**
  - 생기는 이슈 번호를 이용해서 브랜치 생성

## Commit convention

- feat: 새로운 기능 추가 또는 기능 관련

- fix: 버그 수정

- perf: 성능 개선을 위한 변경

- refactor: 기능 추가, 버그 수정의 목적이 아닌 코드 리팩토링을 담은 변경

- docs: 마크 다운 작성, 주석 작성 등의 문서 작업

- style: 코드의 의미를 변경하지 않는 formatting 등의 변경

- test: 테스트 관리를 위한 변경

- ci: CI를 위한 변경

- build: 빌드 설정, 개발툴 변경 등 사용자와 관련 없는 변경

- chore: 소스 파일 혹은 테스트 파일의 변화가 없는 단순 작업

- revert: 이전 커밋 취소

## 🐯팀원 소개🐯

<!-- |  이름  |      역할      |                         개발 내용                         |
| :----: | :------------: | :-------------------------------------------------------: |
| 신호인 | 팀장, Back-end |                YOLO 모델 학습, CI/CD 구축                 |
| 신상원 |    Back-end    | 추천 알고리즘, 빅데이터 서버 구축, 북마크/레시피/추천 API |
| 이규민 |    Back-end    |              OAuth2, 소셜 로그인, 영양소 API              |
| 조희라 |    Back-end    |        영수증 OCR, 냉장고 API 및 재료 데이터 정제         |
| 임희선 |   Front-end    |         냉장고 관리 구현, 레시피/마이페이지 구현          |
| 김승현 |   Front-end    |        회원가입/로그인/먹BTI 구현, 식단 관리 구현         | -->
<div align="center">

| [<img src = "https://github.com/kmr5326.png" width = 100>](https://github.com/kmr5326) | [<img src = "https://github.com/Shin-sangwon.png" width = 100>](https://github.com/Shin-sangwon) | [<img src = "https://github.com/seohhh.png" width = 100>](https://github.com/seohhh) |
| :------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------------: |
|                                                     김한결                                                     |                                                       신상원                                                       |                                                    서현영                                                     |
|                                                    팀장, BE, Infra                                                    |                                                         BE, Infra                                                         |                                                      부팀장, BE                                                       |

| [<img src = "https://github.com/jaemaning.png" width = 100>](https://github.com/jaemaning) | [<img src = "https://github.com/heon-2.png" width = 100>](https://github.com/heon-2) | [<img src = "https://github.com/prkhch.png" width = 100>](https://github.com/prkhch) |
| :---------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------: |
|                                                   김재만                                                    |                                                    이지헌                                                    |                                                    박희창                                                    |
|                                                     Android                                                      |                                                      Android                                                      |                                                      Android                                                      |

</div>

## 🧰사용 기술🧰 
### FrontEnd
- `Android`
  - `Language`: `Kotlin`
  - `JDK`: 17
  - `SDK`: API 34
- `React`: 18.17.1
### BackEnd
- `Language`: `Java`
- `JDK`: 17
- `SpringBoot`: 2.7.17
  - `Spring WebFlux`
  - `Spring Data JPA`
  - `Spring Data R2DBC`
  - `Spring Kafka`
  - `Spring Security`
  - `Spring Cloud`
- `Gradle`: 8.3
- `Kafka`: 2.8.1
### Database
- `H2`: 2.1.214
- `MariaDB`: 10.3
- `Mongo`: 7.0.2
- `Redis`: 7.2.3
- `Elasticsearch`: 8.10.3
### INFRA
- `AWS EC2`
- `Ubuntu`: 20.04
- `Docker`: 24.0.6
- `Docker-compose`: 2.23.0
- `Nginx`: 1.18.0
- `Jenkins`: 2.428
### Telemetry
- `Fluentd`: 1.12.0-debian-1.0
- `Prometheus`: 2.47.2
- `Kibana`: 8.10.3
- `Zipkin`: 2.24.3
- `ngrinder`: 3.5.3
- `Grafana`: 10.2.0
### 외부 API
- `Naver CLOVA Speech`
- `Naver Object Storage`
- `Kakaopay`
- `Kakao login`
- `Google login`
