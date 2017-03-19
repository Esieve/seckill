CREATE DATABASE seckill;
USE seckill;

CREATE TABLE seckill (
  seckill_id  BIGINT       NOT NULL AUTO_INCREMENT,
  name        VARCHAR(120) NOT NULL,
  number      INT          NOT NULL,
  start_time  TIMESTAMP    NOT NULL,
  end_time    TIMESTAMP    NOT NULL,
  create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;

INSERT INTO
  seckill (name, number, start_time, end_time)
VALUES
  ('1000元秒杀iphone7', 100, '2017-3-1 00:00:00', '2017-6-1 00:00:00'),
  ('500元秒杀ipad2', 100, '2017-3-1 00:00:00', '2017-6-1 00:00:00'),
  ('300元秒杀小米6', 100, '2017-3-1 00:00:00', '2017-6-1 00:00:00'),
  ('200元秒杀红米note', 100, '2017-3-1 00:00:00', '2017-6-1 00:00:00');

CREATE TABLE success_killed (
  seckill_id  BIGINT    NOT NULL,
  user_phone  BIGINT    NOT NULL,
  state       TINYINT   NOT NULL DEFAULT -1,
  create_time TIMESTAMP NOT NULL,
  PRIMARY KEY (seckill_id, user_phone),
  KEY idx_create_time(create_time)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;