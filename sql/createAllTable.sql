create database simple_bbs;
create table t_user (u_id int auto_increment primary key not null ,/*用户表（含版主）*/
                   u_userid varchar(255) not null,
                   u_password varchar(255) not null,
                   u_nickname varchar(255) not null,
                   u_sex varchar(255) not null,
                   u_name varchar(255),
                   u_email varchar(255),
                   u_intro varchar(255),
                   u_headpic varchar(255),/*存储头像*/
                   u_age varchar(255),
                   u_workplace varchar(255),
                   u_workproperty varchar(255),
                   u_issectioner int,/*识别版主*/
                   u_points int
);
create table t_administrator(/*管理员表*/
                              a_id int  auto_increment not null primary key ,
                              a_adminname varchar(20) not null,
                              a_password varchar(20) not null,
                              a_headpic varchar(255),
                              a_email varchar(30) not null
);
create table t_section(/*板块表*/
                        s_id int auto_increment  not null  primary key,
                        s_sectionname varchar(255),
                        s_description varchar(255),
                        s_banzhuid int ,/*版主*/
                        foreign key (s_banzhuid)references t_user(u_id) on delete cascade
) ;
create table  t_main(/*主帖表*/
                      m_mainid int auto_increment not null  primary key ,/*一条记录*/
                      m_title varchar(255),
                      m_content varchar(255) ,
                      m_mainerid int,/*发帖人*/
                      m_sectionid int,
                      m_isontop int,/*置顶*/
                      m_isperfect int,/*精品*/
                      m_maindate datetime,
                      m_point int , /*发布需求信息的积分*/
                      foreign key (m_mainerid) references t_user(u_id) on delete cascade ,
                      foreign key (m_sectionid) references t_section(s_id) on delete cascade

) ;
create table t_follow(/*跟贴表*/
                       f_followid int auto_increment primary key not null ,/*一条记录*/
                       f_content varchar(255),
                       f_followerid int,/*跟贴人*/
                       f_mainid int ,/*主帖id*/
                       f_followdate datetime,
                       foreign key (f_followerid) references t_user(u_id) on delete cascade,
                       foreign key (f_mainid) references t_main(m_mainid) on delete cascade
);
create table t_reply(/*回复表*/
                      r_replyid int auto_increment primary key not null ,/*一条记录*/
                      r_content varchar(255),
                      r_replyerid int ,/*回复人*/
                      r_followid int ,/*跟帖id*/
                      r_replydate datetime,
                      foreign key (r_replyerid) references  t_user(u_id) on delete cascade ,
                      foreign key (r_followid) references t_follow(f_followid) on delete cascade
)




