String boot web 

> Java 1.17
> MariaDB
> Jpa ( QueryDSL 5. ~ )
> RestAPI - Board
> 
> 
CREATE
/board
{
    "title": "제목 입니다",
    "name": "demian",
    "categories": "Spring"
}

LIST
/board/list

DETAIL
/board/1

UPDATE
/board/1/update
{
    "title": "제목 입니다223332",
    "name": "demian"
}

DELETE
/board/1