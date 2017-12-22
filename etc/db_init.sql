set names utf8mb4;
DROP DATABASE IF EXISTS easy_rhyme;
CREATE database easy_rhyme DEFAULT CHARACTER SET = 'utf8mb4';

use easy_rhyme;
DROP TABLE IF EXISTS rhyme_template;
CREATE TABLE `rhyme_template` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `lexeme` varchar(60) NOT NULL DEFAULT '' COMMENT '词语本身',
  `freq` int(32) NOT NULL DEFAULT '1' COMMENT '词频，默认按freq 排序输出搜索结果',
  `score` decimal(10,2) NOT NULL DEFAULT '1.0' COMMENT '综合词频，歌手等信息后的权重值，用于查询结果排序',
  `pos` varchar(16) NOT NULL DEFAULT 'others' COMMENT 'pos=part of speech，词性：名性，形容词，动词',
  `language` varchar(8) NOT NULL DEFAULT 'CN' COMMENT '语言：中文，英文',
  `first` varchar(8) NOT NULL DEFAULT '' COMMENT '最后一个韵母',
  `second` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第二个韵母',
  `third` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第三个韵母',
  `fourth` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第四个韵母',
  `fifth` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第五个韵母',
  `sixth` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第六个韵母',
  `seventh` varchar(8) NOT NULL DEFAULT '' COMMENT '倒数第七个韵母',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_lexeme` (`lexeme`),
  KEY `idx_freq` (`freq`),
  KEY `idx_first` (`first`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='押韵词语模版表';

use easy_rhyme;
DROP TABLE IF EXISTS `rhyme_word`; 
CREATE TABLE `rhyme_word` LIKE rhyme_template; 

