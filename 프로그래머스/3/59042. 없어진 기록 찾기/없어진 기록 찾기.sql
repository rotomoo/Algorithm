select a.ANIMAL_ID, a.NAME
from ANIMAL_OUTS a
left join ANIMAL_INS b
on a.ANIMAL_ID = b.ANIMAL_ID
where b.ANIMAL_ID IS NULL