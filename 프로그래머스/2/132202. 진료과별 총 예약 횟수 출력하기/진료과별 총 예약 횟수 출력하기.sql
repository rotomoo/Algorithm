select
MCDP_CD as 진료과코드,
COUNT(*) as 5월예약건수
from appointment
where month(apnt_ymd) = 5
group by MCDP_CD
order by COUNT(*) asc, MCDP_CD asc;