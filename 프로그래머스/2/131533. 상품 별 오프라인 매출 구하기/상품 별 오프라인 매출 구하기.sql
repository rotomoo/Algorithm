select
product.product_code
, product.price * sum(offline_sale.sales_amount) as sales
from
offline_sale
join product
on product.product_id = offline_sale.product_id
group by offline_sale.product_id
order by sales desc, product.product_code asc