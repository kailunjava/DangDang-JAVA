
alter table dd_category
   drop constraint FK_DD_CATEG_DD_CATEG;

alter table dd_order
   drop constraint FK_DD_ORDER_DD_ADDRE;

alter table dd_order
   drop constraint FK_DD_ORDER_DD_USER;

alter table dd_product
   drop constraint FK_DD_PRODU_DD_CATEG;

alter table dd_product_order
   drop constraint FK_DD_PRODU_REFERENCE_DD_PRODU;

alter table dd_product_order
   drop constraint FK_DD_PRODU_REFERENCE_DD_ORDER;

drop table dd_address cascade constraints;

drop table dd_category cascade constraints;

drop table dd_order cascade constraints;

drop table dd_product cascade constraints;

drop table dd_product_order cascade constraints;

drop table dd_user cascade constraints;

drop table dd_product_order;

drop sequence dd_category_seq;

drop sequence dd_product_seq;

drop sequence dd_user_seq;

/*==============================================================*/
/* Table: dd_address        收货地址表                                    */
/*==============================================================*/
create table dd_address  (
   id                   INTEGER                         not null,
   receive_name         varchar2(20),
   full_address         varchar2(30),
   postal_code          varchar2(10),
   mobile               number(12),
   phone                number(11),
   u_id                 INTEGER,
   constraint PK_DD_ADDRESS primary key (id)
);

/*==============================================================*/
/* Table: dd_category        分类信息表                                   */
/*==============================================================*/
create table dd_category  (
   id                   INTEGER                         not null,
   category_name        VARCHAR(30),
   parent_id            INTEGER,
   product_count        INTEGER,
   constraint PK_DD_CATEGORY primary key (id)
);

create sequence dd_category_seq;

insert into dd_category values(dd_category_seq.nextval,'管理',null,0);
insert into dd_category values(dd_category_seq.nextval,'管理学',1,0);
insert into dd_category values(dd_category_seq.nextval,'战略管理',1,0);
insert into dd_category values(dd_category_seq.nextval,'市场营销',1,0);
insert into dd_category values(dd_category_seq.nextval,'商业史传',1,0);
insert into dd_category values(dd_category_seq.nextval,'电子商务',1,0);

insert into dd_category values(dd_category_seq.nextval,'小说',null,0);
insert into dd_category values(dd_category_seq.nextval,'当代小说',7,0);
insert into dd_category values(dd_category_seq.nextval,'近现代小说',7,0);
insert into dd_category values(dd_category_seq.nextval,'世界名著',7,0);
insert into dd_category values(dd_category_seq.nextval,'古典小说',7,0);
insert into dd_category values(dd_category_seq.nextval,'四大名著',7,0);

insert into dd_category values(dd_category_seq.nextval,'外语',null,0);
insert into dd_category values(dd_category_seq.nextval,'英语',13,0);
insert into dd_category values(dd_category_seq.nextval,'日语',13,0);
insert into dd_category values(dd_category_seq.nextval,'韩语',13,0);
insert into dd_category values(dd_category_seq.nextval,'俄语',13,0);
insert into dd_category values(dd_category_seq.nextval,'德语',13,0);

insert into dd_category values(dd_category_seq.nextval,'青春',null,0);
insert into dd_category values(dd_category_seq.nextval,'校园',19,0);
insert into dd_category values(dd_category_seq.nextval,'爱情/情感',19,0);
insert into dd_category values(dd_category_seq.nextval,'叛逆/成长',19,0);
insert into dd_category values(dd_category_seq.nextval,'玄幻',19,0);
insert into dd_category values(dd_category_seq.nextval,'原创',19,0);

insert into dd_category values(dd_category_seq.nextval,'计算机',null,0);
insert into dd_category values(dd_category_seq.nextval,'计算机理论',25,0);
insert into dd_category values(dd_category_seq.nextval,'数据库',25,0);
insert into dd_category values(dd_category_seq.nextval,'程序设计',25,0);
insert into dd_category values(dd_category_seq.nextval,'人工智能',25,0);
insert into dd_category values(dd_category_seq.nextval,'计算机考试',25,0);
/*

select * from dd_category;  ---查询所有分类
select * from dd_category where parent_id is not null;
update dd_category set product_count=3 where id in(3,4,5,6,7)  
update dd_category set parent_id=null where id=1 or id =2  

---通过二级分类中父类id连接一级分类id
select d1.*,d2.* from dd_category d1 left join dd_category d2 on d2.parent_id=d1.id where d1.parent_id is null;
select d1.* from dd_category d1 left join dd_category d2 on d2.parent_id=d1.id where d1.parent_id is null;
---起别名的方式分类查询
select 
  d1.id as d1_id,
  d1.category_name as d1_category_name,
  d1.product_count as d1_product_count,
  d2.id as d2_id,
  d2.category_name as d2_category_name,
  d2.product_count as d2_product_count
from dd_category d1 
left join dd_category d2 
on d2.parent_id = d1.id 
where d1.parent_id is null


*/



/*==============================================================*/
/* Table: dd_order       订单表                                       */
/*==============================================================*/
drop table dd_order;
create table dd_order  (
   id                   INTEGER                         not null,
   product_name         varchar2(30),
   fixed_price          number(10,2),
   dang_price           number(10,2),
   count                INTEGER,
   total_price          number(10,2),
   pay_status           varchar2(3),
   delivery_status      varchar2(3),
   order_time           DATE,
   user_id              INTEGER,
   address_id           INTEGER,
   product_id           INTEGER,
   constraint PK_DD_ORDER primary key (id)
);

/*==============================================================*/
/* Table: dd_product            商品表                               */
/*==============================================================*/
create table dd_product  (
   id                   INTEGER not null,   --id
   product_name         varchar2(30),      --商品名称
   author               varchar2(30),      --作者
   publishing           varchar2(30),    --出版社
   publish_time         DATE,        --出版时间
   putaway_time         DATE,        --上架时间
   print_time           DATE,        --印刷时间
   fixed_price          number(10,2),    --定价
   dang_price           number(10,2),    --当当价
   which_edtion         INTEGER,      --版次
   word_number          INTEGER,      --字数
   total_page           INTEGER,      --页数
   kaiben               INTEGER,      --开本
   print_count          INTEGER,      --印次
   paper_sheet          varchar2(20),    --纸张
   isbn                 INTEGER,      --isbn码
   baozhuang            VARCHAR(10),    --包装
   edit_recommend       varchar2(100),    --编辑推荐
   content_introduce    varchar2(100),    --内容简介
   writer_introduce     varchar2(100),    --作者简介
   catelog              varchar2(100),    --目录
   media_comments       varchar2(100),    --媒体评论
   excerpt              varchar2(100),    --书摘
   picture              varchar2(30),    --图片名
   sales_count          INTEGER,      --销量
   kucun                INTEGER,      --库存
   click_rate           INTEGER,      --点击量
   category_id          INTEGER,      --类别
   constraint PK_DD_PRODUCT primary key (id)
);

create sequence dd_product_seq;

insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','17.jpg',10,100,80,3);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','18.jpg',10,100,80,4);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','19.jpg',10,100,80,5);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','20.jpg',10,100,80,6);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','21.jpg',10,100,80,7);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','22.jpg',10,100,80,3);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','23.jpg',10,100,80,4);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','24.jpg',10,100,80,5);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','2.jpg',10,100,80,6);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','3.jpg',10,100,80,7);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','4.jpg',10,100,80,3);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','5.jpg',10,100,80,4);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','6.jpg',10,100,80,5);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','7.jpg',10,100,80,6);
insert into dd_product values(dd_product_seq.nextval,'上课头疼的故事','高志远','加里顿大学出版社',sysdate,sysdate,sysdate,200,180,1,10000,100,16,1,null,123456,'平装','我们得出的结论已经显现于这本书名中――玛丽娅•蒙台梭利（本书作者）','上课头疼的故事','我写的 作者是好人','这真是一本好书啊','好，非常畅销!难得的一本好书','对教育方法的历史回顾','8.jpg',10,100,80,9);
/*

update dd_product set click_rate=100 where id = 29

根据一级分类id查其下所有的二级分类
select d1.*,d2.* from dd_category d1 left join dd_category d2 on d2.parent_id=d1.id where d1.parent_id=2;

根据一级分类查到的所有二级分类id为条件查商品
select * from dd_product where category_id in (select d1.id from dd_category d1 left join dd_category d2 on d2.parent_id=d1.id where d1.parent_id=2);

查所有商品
select * from dd_product;

根据编辑推荐查商品(点击率)
select * from (select p1.*,rownum r from (select p.* from dd_product p order by click_rate  desc) p1) where r<=2

*/




/*==============================================================*/
/* Table: dd_product_order        订单和商品关系表                              */
/*==============================================================*/
drop table dd_product_order;
create table dd_product_order  (
   id INTEGER Primary key,
   order_id             INTEGER,
   product_id           INTEGER
);

/*==============================================================*/
/* Table: dd_user                                               */
/*==============================================================*/
create table dd_user  (
   id                   INTEGER                         not null,
   email                varchar2(30)                    not null,
   nickname             varchar2(20),
   password             varchar2(50),
   is_email_verify      CHAR(3),
   user_integral        INTEGER,
   last_login_time      DATE,
   last_login_ip        varchar2(20),
   constraint PK_DD_USER primary key (id)
);
create sequence dd_user_seq;
insert into dd_user values(dd_user_seq.nextval,'gaozhy@zparkhr.com.cn','高志远','密码','y',100,sysdate,'192.168.1.1');

select * from dd_user;

alter table dd_category
   add constraint FK_DD_CATEG__DD_CATEG foreign key (parent_id)
      references dd_category (id);

alter table dd_order
   add constraint FK_DD_ORDER__DD_ADDRE foreign key (address_id)
      references dd_address (id);

alter table dd_order
   add constraint FK_DD_ORDER__DD_USER foreign key (user_id)
      references dd_user (id);

alter table dd_product
   add constraint FK_DD_PRODU__DD_CATEG foreign key (category_id)
      references dd_category (id);

alter table dd_product_order
   add constraint FK_DD_PRODU_REFERENCE_DD_PRODU foreign key (product_id)
      references dd_product (id);

alter table dd_product_order
   add constraint FK_DD_PRODU_REFERENCE_DD_ORDER foreign key (order_id)
      references dd_order (id);
    commit;
select * from dd_user;
select * from dd_category;
select * from dd_product;
update dd_product set category_id= 8 where id = 21;
update dd_product set click_rate=90  where id=10;
update dd_product set sales_count=50  where id=4;
update dd_product set putaway_time=sysdate  where id=11;
select * from(select p1.*,rownum r from (select p.* from dd_product p order by click_rate desc)p1)where r<=2;
select * from(select p1.*,rownum r from (select p.* from dd_product p order by sales_count desc)p1)where r<=4;
select * from(select p1.*,rownum r from (select p.* from dd_product p order by sales_count desc)p1)where r in (1,2,3,4);
select * from(select p1.*,rownum r from (select p.* from dd_product p order by putaway_time  desc)p1)where r<=4;


DROP TABLE IF EXISTS dd_item;
DROP TABLE IF EXISTS dd_order;
CREATE TABLE dd_item (
  id integer primary key,                                               --id
  order_id integer NOT NULL,                                     --订单id
  product_id integer NOT NULL,                                --商品id
  product_name varchar2(100) NOT NULL,            --商品名字
  dang_price integer NOT NULL,                                --商品当当价
  product_num integer NOT NULL,                           --商品数目
  amount integer  not null                                          --商品小结
);
CREATE TABLE dd_order (
  id integer primary key,
  user_id integer NOT NULL,            --订单所属用户id  
  pay_status integer NOT NULL,         --付款状态
  deliver_status integer NOT NULL,     --交付状态
  order_time number(20) NOT NULL,      --订单日期
  order_desc varchar2(100) ,           --订单描述
  total_price integer NOT NULL,        --总价
  receive_name varchar2(100) ,         --收货人名字
  full_address varchar2(200) ,         --收货人完整信息
  postal_code varchar2(8) ,            --邮政编码
  mobile number(11) ,                --收件人手机
  phone  number(12)                   --收件人电话
);
select * from dd_item;
select * from dd_order;
 select * from dd_product p  left join dd_category c  on p.category_id = c.id 
 where c.parent_id=1
 
 select count(*) from dd_product where category_id=5
 select * from dd_order;

select * from dd_user;
select * from dd_address;
delete dd_address where id=4
delete from dd_address where id=1
create sequence dd_orderItem_seq;
select * from dd_address where u_id=1222
