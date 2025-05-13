-- 코드를 작성해주세요\
select 
id,
case 
when size_of_colony <= 100 then "LOW"
when size_of_colony <= 1000 then "MEDIUM"
else "HIGH" end as "SIZE"
from ECOLI_DATA