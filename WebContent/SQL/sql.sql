create database chatnorefresh;
use chatnorefresh;
create table user (
	userId int primary key auto_increment,
    userName varchar(255) not null,
    password varchar(255) not null,
    readCount int default 0,
    userPicture varchar(255) not null
)default charset=utf8 engine=innodb;
create table chat (
    chatId int primary key auto_increment,
    userId int references user(userId),
    chatContent text not null,
    sendDate datetime
)default charset=utf8 engine=innodb;
create table headPicture (
    pictureId int primary key auto_increment,
    pictureURL varchar(255) not null,
    useCount int
)default charset=utf8 engine=innodb;

insert into headPicture values(null, '/ChatNoRefresh/assets/img/moren.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/001.jpeg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/002.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/003.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/004.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/005.png', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/006.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/007.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/008.gif', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/009.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/010.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/011.jpeg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/012.png', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/013.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/014.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/015.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/016.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/017.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/018.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/019.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/020.jpeg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/021.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/022.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/023.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/024.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/025.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/026.jpg', 0);
insert into headPicture values(null, '/ChatNoRefresh/assets/img/027.jpg', 0);

