
-- Project > script.sql
select * from tblAuth;
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

-- 게시판

DELETE FROM tblAuth WHERE id='hong';
DELETE FROM tblMember WHERE id='hong';
DELETE FROM tblAuth WHERE id='hong';



















