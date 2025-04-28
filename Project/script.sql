
-- Project > script.sql

select * from member;

-- 회원
create table tblMember (
    id varchar2(50) primary key,                    --아이디(PK)
    pw varchar2(100) not null,                      --암호
    name varchar2(30) not null,                     --이름
    email varchar2(100) not null,                   --이메일
    pic varchar2(100) default 'pic.png' not null,   --프로필사진
    regdate date default sysdate not null,          --가입날짜
    ing char(1) default '1' not null                --활동유무
);

-- 회원 권한
create table tblAuth (
    id varchar2(50) not null references tblMember(id),  --아이디(FK)
    auth varchar2(50) not null                          --권한
);

insert into tblMember (id, pw, name, email, pic, regdate, ing)
    values ('hong', '1111', '홍길동', 'hong@gmail.com', default, default, default);
insert into tblMember (id, pw, name, email, pic, regdate, ing)
    values ('test', '1111', '테스트', 'test@gmail.com', default, default, default);

insert into tblAuth (id, auth) values ('hong', 'ROLE_MEMBER');
insert into tblAuth (id, auth) values ('test', 'ROLE_ADMIN');
insert into tblAuth (id, auth) values ('test', 'ROLE_MEMBER');

select * from tblMember;
select * from tblAuth;

delete from tblMember;
delete from tblAuth;

commit;

drop table tblComment;
drop table tblBoard;
drop sequence seqComment;
drop sequence seqBoard;

-- 게시판
create table tblBoard (
    seq number primary key,                             --번호(PK)
    subject varchar2(500) not null,                     --제목
    content varchar2(4000) not null,                    --내용
    regdate date default sysdate not null,              --날짜
    readcount number default 0 not null,                --조회수
    id varchar2(50) not null references tblMember(id),  --아이디(FK)
    attach varchar2(100) null                           --첨부파일
);
create sequence seqBoard;

alter table tblBoard 
    add (attach varchar2(100) null);

select * from tblBoard;

update tblBoard set regdate = regdate - 5 where seq = 1;
update tblBoard set regdate = regdate - 4 where seq = 2;
update tblBoard set regdate = regdate - 3 where seq = 3;
update tblBoard set regdate = regdate - 2 where seq = 4;

commit;





create or replace view vwBoard
as
select
    seq, subject, id, regdate, readcount, content,
    (select name from tblMember where id = tblBoard.id) as name,
    (sysdate - regdate) as isnew,
    (select count(*) from tblComment where bseq = tblBoard.seq) as commentcount,
    attach as attachName
from tblBoard
    order by seq desc;



-- 페이징
-- A. rownum
-- 보통
-- 대용량 데이터(1,000만 이상) > 속도 저하
select * from (select rownum as rnum, v.* from vwBoard v) 
    where rnum between 21 and 30;

-- B. rownum
-- A와 유사
-- 대용량 데이터 > 속도 유지
select * from (select rownum as rnum, v.* from vwBoard v where rownum <= 20) 
    where rnum >= 11;

-- C. offset rows fetch
-- - offset 건너뛸 레코드 수
-- - fetch 반환할 레코드 수
-- 대용량 데이터 > 속도 저하
-- 코드 간결
-- JPA > 11g이하(B방식) 12c이후(C방식)
select * from vwBoard
    offset 20 rows fetch next 10 rows only;


-- 댓글 테이블
create table tblComment (
    seq number primary key,                             --댓글번호(PK)
    content varchar2(2000) not null,                    --내용
    regdate date default sysdate not null,              --날짜
    id varchar2(50) not null references tblMember(id),  --아이디(FK)
    bseq number not null references tblBoard(seq)       --부모글번호(FK)
);
create sequence seqComment;


select * from tblComment;


select * from (select 
        tblComment.*,
        (select name from tblMember where id = tblComment.id) as name
    from tblComment
        where bseq = 290
            order by seq desc)
                offset 0 rows fetch next 5 rows only;


select * from tblComment order by seq desc;


delete from tblBoard where seq >= 41;
commit;

select * from tblBoard;

select
			tblBoard.*,
			tblBoard.attachName as attach,
			(select name from tblMember where id = tblBoard.id) as name
		from tblBoard
			where seq = 321;


-- 태그
create table tblTag (
    seq number primary key,             --번호(PK)
    tag varchar2(100) unique not null   --해시태그(UQ)
);
create sequence seqTag;

-- 게시판 태그 연결
create table tblTagging (
    seq number primary key,                         --번호(PK)
    bseq number not null references tblBoard(seq),  --글번호(FK)
    tseq number not null references tblTag(seq)    --태그번호(FK)
);
create sequence seqTagging;


select * from tblBoard order by seq desc;
select * from tblTag order by seq desc;
select * from tblTagging order by seq desc;

select
    *
from vwBoard b
    inner join tblTagging tg
        on b.seq = tg.bseq
            inner join tblTag t
                on t.seq = tg.tseq
                    where t.tag = '게시판';

-- MEMBER, GUEST
select 
    a.* ,
    (select auth from tblAuth where id = a.id) as auth
from tblMember a
    where (select count(*) from tblAuth where id = a.id) = 1;







