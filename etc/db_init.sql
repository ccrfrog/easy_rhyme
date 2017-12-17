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
DROP TABLE IF EXISTS `rhyme_a`; 
CREATE TABLE `rhyme_a` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_e`; 
CREATE TABLE `rhyme_e` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_i`; 
CREATE TABLE `rhyme_i` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_o`; 
CREATE TABLE `rhyme_o` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_u`; 
CREATE TABLE `rhyme_u` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ua`; 
CREATE TABLE `rhyme_ua` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ue`; 
CREATE TABLE `rhyme_ue` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ui`; 
CREATE TABLE `rhyme_ui` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ia`; 
CREATE TABLE `rhyme_ia` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_un`; 
CREATE TABLE `rhyme_un` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_uo`; 
CREATE TABLE `rhyme_uo` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ie`; 
CREATE TABLE `rhyme_ie` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ei`; 
CREATE TABLE `rhyme_ei` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_in`; 
CREATE TABLE `rhyme_in` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ou`; 
CREATE TABLE `rhyme_ou` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ai`; 
CREATE TABLE `rhyme_ai` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_en`; 
CREATE TABLE `rhyme_en` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_iu`; 
CREATE TABLE `rhyme_iu` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_an`; 
CREATE TABLE `rhyme_an` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_er`; 
CREATE TABLE `rhyme_er` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ao`; 
CREATE TABLE `rhyme_ao` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ve`; 
CREATE TABLE `rhyme_ve` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_iao`; 
CREATE TABLE `rhyme_iao` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ian`; 
CREATE TABLE `rhyme_ian` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ang`; 
CREATE TABLE `rhyme_ang` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_uai`; 
CREATE TABLE `rhyme_uai` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_eng`; 
CREATE TABLE `rhyme_eng` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ing`; 
CREATE TABLE `rhyme_ing` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_uan`; 
CREATE TABLE `rhyme_uan` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_ong`; 
CREATE TABLE `rhyme_ong` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_iang`; 
CREATE TABLE `rhyme_iang` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_iong`; 
CREATE TABLE `rhyme_iong` LIKE rhyme_template; 
DROP TABLE IF EXISTS `rhyme_uang`; 
CREATE TABLE `rhyme_uang` LIKE rhyme_template; 

