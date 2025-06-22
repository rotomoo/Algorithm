select
floor(product.price / 10000) * 10000 as price_group
, count(FLOOR(product.price / 10000) * 10000) as products
from
product
group by
floor(product.price / 10000) * 10000
order by
floor(product.price / 10000) * 10000 asc