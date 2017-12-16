
set names utf8mb4;
use easy_rhyme;
create database easy_rhyme default CHARACTER SET = 'utf8mb4';

CREATE TABLE `rhyme_template` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `lexeme` varchar(60) NOT NULL DEFAULT '' COMMENT '词语本身',
  `freq` int(32) NOT NULL DEFAULT '1' COMMENT '词频',
  `pos` varchar(16) NOT NULL DEFAULT 'others' COMMENT 'pos=part of speech，词性：名性，形容词，动词',
  `language` varchar(8) NOT NULL DEFAULT 'CN' COMMENT '语言：中文，英文',
  `first` varchar(8) NOT NULL DEFAULT '' COMMENT '最后一个韵母',
  `second` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第二个韵母',
  `third` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第三个韵母',
  `fourth` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第四个韵母',
  `fifth` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第五个韵母',
  `sixth` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第六个韵母',
  `seventh` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第七个韵母',
  `create_time` timestamp NOT NULL DEFAULT '1970-01-01 12:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_lexeme` (`lexeme`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='押韵词语模版表'

