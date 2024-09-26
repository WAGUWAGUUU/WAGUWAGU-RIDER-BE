# 🏍️ 와구와구 배달 기사 서버

### 👤 담당자 : 조진호

## <br>📃 핵심 기능
### 배달 기사, 내역, 요청 건 관리 / 배달 기사 실시간 위치 관리 및 거리 계산

- 배달 기사 정보 관리
- 배달 상세 내역 가져오기
- 배달 기사 자격 검증 후 배달 요청 건 할당
- 배달 기사 실시간 위치 저장 및 가져오기
- 두 지점 위,경도로 사이의 거리 계산

## <br>🏷️ 전체 프로젝트 링크
https://github.com/WAGUWAGUUU/WAGUWAGU

## <br>⚙️ 기술스택

### ✔️ Server Framework
![Spring-Boot](https://img.shields.io/badge/spring--boot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)

### ✔️ Database
![postgresql](https://img.shields.io/badge/postgresql-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![redis](https://img.shields.io/badge/redis-FF4438?style=for-the-badge&logo=redis&logoColor=white)

### ✔️ Message Broker  
![apachekafka](https://img.shields.io/badge/apachekafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white)

### ✔️ Deployment  
![amazoneks](https://img.shields.io/badge/amazoneks-232F3E?style=for-the-badge&logo=amazoneks&logoColor=white)
![googlecloud](https://img.shields.io/badge/googlecloud-4285F4?style=for-the-badge&logo=googlecloud&logoColor=white)

### ✔️ Container & Container orchestration
![docker](https://img.shields.io/badge/docker-496ED?style=for-the-badge&logo=docker&logoColor=white)
![kubernetes](https://img.shields.io/badge/kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white)
![helm](https://img.shields.io/badge/helm-0F1689?style=for-the-badge&logo=helm&logoColor=white)

### ✔️ CI/CD  
![jenkins](https://img.shields.io/badge/jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)
   
## <br>🧾 API 명세서 (with Swagger API)<br><br>

<img width="1085" alt="image" src="https://github.com/user-attachments/assets/4ebb2ae2-7bbb-41c7-ac1b-38759efd342b">
<img width="1085" alt="image" src="https://github.com/user-attachments/assets/a584ba9c-c81a-42cb-a5ac-0a80ab9a693c">

<br><br>
## 🧾 데이터 흐름도<br><br>
<img width="839" alt="image" src="https://github.com/user-attachments/assets/6cf60977-d629-45f1-b93b-d206ef220b57"><br>
<img width="845" alt="image" src="https://github.com/user-attachments/assets/e00e47e9-047b-4077-ac90-d73307a5ba3c"><br>
<img width="845" alt="image" src="https://github.com/user-attachments/assets/3f992d04-efe7-45a2-81d3-5f2edeb797e9">


## 🔗 ERD<br>
<img width="886" alt="image" src="https://github.com/user-attachments/assets/ce980faf-a0e8-43d1-93fb-6c5c3fe2e94e">


##  <br>🔧 트러블 슈팅

**1. linux 환경에서 ```export postgres-user=root```를 하면 ```-bash: export: `postgres-user=root': not a valid identifier```와 같은 에러가 뜬다.<br><br>**
> * 원인 : linux 환경에서 환경 변수이름에 - (dash)를 쓸 수 없다. 대신 _ (underscore)를 써야 한다.<br><br>
> * 해결 : ```export postgres_user=root``` 후 ```echo $postgres_user``` 를 하면 root로 제대로 뜬다.<br>

<br>

**2. application.yaml file에서 환경 변수 설정 시 ${ POSTGRES-USER }와 같이 중괄호와 변수명 사이에 space가 있으면 환경 변수 주입이 되지 않는다.<br><br>**
> * 원인 : Yaml file은 space가 있고 없음을 구분한다. (space-sensitive) <br><br>
> * 해결 : ${POSTGRES-USER} 로 진행해야 배포할 때 docker run 혹은 kubernetes의 env 항목의 환경 변수 값이 제대로 주입된다.<br>

<br>


