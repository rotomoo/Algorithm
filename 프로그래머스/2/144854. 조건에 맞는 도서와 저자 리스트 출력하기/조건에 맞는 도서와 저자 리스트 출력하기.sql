select
    book.book_id,
    author.author_name,
    DATE_FORMAT(book.published_date, '%Y-%m-%d')
from book
join author
on author.author_id = book.author_id
where book.category = '경제'
order by book.published_date asc