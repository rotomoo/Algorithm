select
ecoli_data.id,
count(ecoli_data2.parent_id) as child_count
from ecoli_data
left join ecoli_data ecoli_data2 on ecoli_data2.parent_id = ecoli_data.id
group by ecoli_data.id