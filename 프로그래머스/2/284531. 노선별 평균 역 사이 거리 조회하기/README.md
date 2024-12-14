# [level 2] 노선별 평균 역 사이 거리 조회하기 - 284531 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/284531) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2024년 12월 14일 11:55:51

### 문제 설명

<p><code>SUBWAY_DISTANCE</code> 테이블은 서울지하철 2호선의 역 간 거리 정보를 담은 테이블입니다. <code>SUBWAY_DISTANCE</code> 테이블의 구조는 다음과 같으며 <code>LINE</code>, <code>NO</code>, <code>ROUTE</code>, <code>STATION_NAME</code>, <code>D_BETWEEN_DIST</code>, <code>D_CUMULATIVE</code>는 각각 호선, 순번, 노선, 역 이름, 역 사이 거리, 노선별 누계 거리를 의미합니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody></tbody>
      </table>
<p>| LINE | VARCHAR(10) | FALSE |<br>
| NO | NUMBER | FALSE |<br>
| ROUTE | VARCHAR(50) | FALSE |<br>
| STATION_NAME | VARCHAR(100)| FLASE |<br>
| D_BETWEEN_DIST | NUMBER | FLASE |<br>
| D_CUMULATIVE | NUMBER | FLASE |</p>

<hr>

<h5>문제</h5>

<p><code>SUBWAY_DISTANCE</code> 테이블에서 노선별로 노선, 총 누계 거리, 평균 역 사이 거리를 노선별로 조회하는 SQL문을 작성해주세요.</p>

<p>총 누계거리는 테이블 내 존재하는 역들의 <code>역 사이 거리</code>의 총 합을 뜻합니다. 총 누계 거리와 평균 역 사이 거리의 컬럼명은 각각 <code>TOTAL_DISTANCE</code>, <code>AVERAGE_DISTANCE</code>로 해주시고, 총 누계거리는 소수 둘째자리에서, 평균 역 사이 거리는 소수 셋째 자리에서 반올림 한 뒤 단위(km)를 함께 출력해주세요.<br>
결과는 총 누계 거리를 기준으로 내림차순 정렬해주세요.</p>

<hr>

<h5>예시</h5>

<p><code>SUBWAY_DISTANCE</code> 테이블이 다음과 같을 때</p>
<table class="table">
        <thead><tr>
<th>LINE</th>
<th>NO</th>
<th>ROUTE</th>
<th>STATION_NAME</th>
<th>D_BETWEEN_DIST</th>
<th>D_CUMULATIVE</th>
</tr>
</thead>
        <tbody></tbody>
      </table>
<p>| 2호선 | 45 | 성수지선 | 용답 | 2.3 | 51.1 |<br>
| 2호선 | 46 | 성수지선 | 신답 | 1 | 52.1 |<br>
| 2호선 | 47 | 성수지선 | 용두(동대문구청) | 0.9 | 53 |<br>
| 2호선 | 48 | 성수지선 | 신설동 | 1.2 | 54.2 |<br>
| 2호선 | 49 | 신정지선 | 도림천 | 1 | 55.2 |<br>
| 2호선 | 50 | 신정지선 | 양천구청 | 1.7 | 56.9 |<br>
| 2호선 | 51 | 신정지선 | 신정네거리 | 1.9 | 58.8 |<br>
| 2호선 | 52 | 신정지선 | 까치산 | 1.4 | 60.2 |</p>

<p>SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table">
        <thead><tr>
<th>ROUTE</th>
<th>TOTAL_DISTANCE</th>
<th>AVERAGE_DISTANCE</th>
</tr>
</thead>
        <tbody><tr>
<td>신정지선</td>
<td>6km</td>
<td>1.5km</td>
</tr>
<tr>
<td>성수지선</td>
<td>5.4km</td>
<td>1.35km</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges