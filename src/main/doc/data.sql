INSERT INTO store.`user` (password,name) VALUES
('123456','fudo')
;

INSERT INTO store.buy_goods (goods_id,amount,create_time,creator_id) VALUES
(2,100,'2019-06-19 09:14:19.000',1)
,(1,100,'2019-06-19 09:14:19.000',1)
,(2,100,'2019-06-19 09:18:47.000',1)
,(1,100,'2019-06-19 09:18:47.000',1)
;

INSERT INTO store.goods (name,specs,buy_price,sell_price,create_time,modify_time) VALUES
('水管','1cm*1cm*100cm',100,130,'2019-06-19 07:02:04.000','2019-06-19 07:02:04.000')
,('插座','5cm*10cm*1cm',10,30,'2019-06-19 07:22:55.000','2019-06-19 07:22:55.000')
,('插排','5cm*10cm*1cm',10,30,'2019-06-19 09:03:19.000','2019-06-19 09:03:19.000')
;

INSERT INTO store.sell_goods (goods_id,amount,create_time,creator_id) VALUES
(2,100,'2019-06-19 09:25:12.000',1)
,(1,100,'2019-06-19 09:25:12.000',1)
,(2,100,'2019-06-19 09:27:22.000',1)
,(1,100,'2019-06-19 09:27:22.000',1)
;

INSERT INTO store.stock (goods_id,total,remains,sells,cost,profit,create_time,modify_time) VALUES
(2,200,0,200,2000,4000,'2019-06-19 09:14:20.000','2019-06-19 09:14:20.000')
,(1,200,0,200,20000,6000,'2019-06-19 09:14:20.000','2019-06-19 09:14:20.000')
;