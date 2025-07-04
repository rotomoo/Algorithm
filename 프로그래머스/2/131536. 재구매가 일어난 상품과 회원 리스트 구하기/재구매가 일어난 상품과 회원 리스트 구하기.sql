select
online_sale.USER_ID,
online_sale.PRODUCT_ID
from
online_sale
group by online_sale.user_id, online_sale.product_id
having COUNT(online_sale.ONLINE_SALE_ID) > 1
order by user_id asc, product_id desc