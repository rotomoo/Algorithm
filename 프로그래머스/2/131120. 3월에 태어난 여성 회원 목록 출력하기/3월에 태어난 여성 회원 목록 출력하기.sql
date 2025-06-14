select
MEMBER_ID,
MEMBER_NAME,
GENDER,
DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
from member_profile
where gender = 'W' and MONTH(DATE_OF_BIRTH) = 3 and TLNO IS NOT NULL
order by member_id asc