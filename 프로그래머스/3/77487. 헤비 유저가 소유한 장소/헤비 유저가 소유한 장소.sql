-- 코드를 입력하세요
SELECT *
from places b
where b.host_id in (select places.host_id from places group by places.host_id having count(places.host_id) > 1)
order by id asc