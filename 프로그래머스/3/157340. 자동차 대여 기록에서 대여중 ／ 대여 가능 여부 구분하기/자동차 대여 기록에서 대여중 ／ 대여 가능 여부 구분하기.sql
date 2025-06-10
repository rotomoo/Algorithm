select
crcrh.car_id,
case when sum(case when crcrh.start_date <= '2022-10-16' and crcrh.end_date >= '2022-10-16' then 1 else 0 end) > 0 then '대여중'
else '대여 가능'
end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as crcrh
group by crcrh.car_id
order by crcrh.car_id desc