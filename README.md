### 주문제작 판매 소상공인을 위한 주문관리 솔루션
 **[ 제 10회 K 해커톤 영남권 본선 진출작 ]**
# MyOrder
<img width="1440" alt="image" src="https://user-images.githubusercontent.com/46425142/185873921-4316314d-c901-41d2-8bce-b8b8def3c853.png">
세분화된 취향과 개성을 중시하는 MZ 세대의 선호로, 다양한 품목을 제작하고 판매하는 소상공인들이 증가하고 있습니다
이에 따라, 주문을 접수 받고 관리하는 방식을 새롭게 개선할 수 있는 솔루션을 제공하는 어플리케이션입니다.


## 🔐 기존 방식의 문제점
<img width="822" alt="image" src="https://user-images.githubusercontent.com/46425142/185875560-e2ecab98-52ef-4cba-ae90-1bbeee999af7.png">

대부분의 주문제작 소상공인들은 카카오톡 오픈채팅과 같은 SNS 메시지를 통해 주문을 접수 받습니다.

이러한 주문과정은 많은 불편함이 존재 합니다.
1. 채팅을 통해 소상공인이 보내는 주문 전 옵션 선택과 주의사항 등은 정보량이 상당한데, 이 정보들이 한눈에 가시화되지 않아 주문 의뢰자가 보기 불편
2. 반복적으로 메세지를 보내는 의뢰자의 경우로 인해 접수된 주문들이 섞이기도 함
3. 채팅으로 주문을 받다가 주문 의뢰자가 임의로 또는 실수로 채팅방을 나가는 경우, 고객이 다시 찾아오지 않는 한 주문을 돌이키기가 쉽지 않다는 불편함 존재

## 🗝 솔루션

<img width="1899" alt="image" src="https://user-images.githubusercontent.com/46425142/185876302-d3cd3f5e-d200-4292-90a5-895d138e45c0.png">


- 옵션 선택을 통해 자유롭게 주문 옵션을 구성
- 중요한 정보를 한 눈에 파악할 수 있는 주문서
- 시간별, 상황별로 파악되는 목록으로 쉽게 관리

## ✒️ 사용자 별 시나리오
|소비자 시나리오|
|:---:|
|![소비자](https://user-images.githubusercontent.com/46425142/186337521-a21e40c4-3c6f-473d-946b-263c16026cab.gif)|
|케이크를 주문하는 과정|

### 소비자
- 설정한 위치(구)를 기반으로 근처 가게 리스트를 확인
- 선택한 가게에서 케이크를 선택할 수 있음
- 케이크의 옵션을 선택하고 파일을 첨부하여 주문할 수 있음
- 자신의 주문 목록과 그 상태를 확인 가능

----

|사장님 시나리오|
|:---:|
|![사장님2](https://user-images.githubusercontent.com/46425142/186337598-8a9540e6-e4d7-4cc4-93ea-2ae86ad07c22.gif)|
|케이크를 주문받는 과정|


### 사장님
- 주문 목록을 관리하고 상태에 따라 따로 확인 가능
- 자신의 케이크 카테고리를 수정할 수 있음


## 🛠 Android 사용 기술 키워드

- `Kotlin`
- `JetPack Compose`
- `ViewModel`, `MVVM`, `AAC`, `Clean Architecture`
- `Coroutine`, `Flow`, `Coil`
- `OkHttp`, `Retrofit2`, `FCM`
- `Dagger-Hilt`


## 🛠 Backend 사용 기술 키워드
- `spring`
- `spring security`
- `JUnit5`
- `JPA`
- `AWS EC2`
- `maria DB`
- `JWT`
- `lombok`, `jjwt`, `jackson`



## 팀원
- 진윤정 (기획자) (팀장)
- 홍유준 (android), Github: [@Kick-snare](https://github.com/kick-snare)
- 김성진 (android), Github: [@sonuji0907](https://github.com/sonuji0907)
- 신민건 (server), Github: [@zhdhfhd33](https://github.com/zhdhfhd33)
- 민혜원 (디자이너)
