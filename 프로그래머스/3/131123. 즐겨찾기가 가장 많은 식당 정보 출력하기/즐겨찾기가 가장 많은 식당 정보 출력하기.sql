-- 코드를 입력하세요
select
    ri.food_type,
    ri.rest_id,
    ri.rest_name,
    ri.favorites
from rest_info ri
where ri.favorites = 
    (
    select 
        max(ri2.favorites)
    from rest_info ri2
    where ri2.food_type = ri.food_type
    )
order by ri.food_type desc