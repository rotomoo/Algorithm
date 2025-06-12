select *
from food_product as fp
where fp.price = (select max(fp2.price) from food_product fp2)