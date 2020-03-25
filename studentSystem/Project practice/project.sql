/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : project

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2020-02-13 12:51:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `student_id` int(11) NOT NULL auto_increment,
  `student_name` varchar(255) collate utf8_bin default NULL,
  `class_name` varchar(255) collate utf8_bin default NULL,
  `chinese` int(255) default NULL,
  `math` int(255) default NULL,
  `english` int(255) default NULL,
  `physics` int(255) default NULL,
  `chemistry` int(255) default NULL,
  `biolog` int(255) default NULL,
  PRIMARY KEY  (`student_id`),
  KEY `class_name` (`class_name`),
  KEY `student_name` (`student_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '张三', '1班', '29', '29', '77', '56', '56', '55');
INSERT INTO `grade` VALUES ('2', '李四', '11班', '77', '56', '89', '53', '52', '56');
INSERT INTO `grade` VALUES ('3', '王五', '2班', '65', '70', '8', '99', '48', '48');
INSERT INTO `grade` VALUES ('4', '赵六', '9班', '79', '79', '79', '7', '979', '79');
INSERT INTO `grade` VALUES ('5', '王八', '1班', '13', '65', '1', '15', '51', '5');
INSERT INTO `grade` VALUES ('6', '好好', '1班', '13', '65', '1', '15', '51', '5');
INSERT INTO `grade` VALUES ('7', '郭大侠', '1班', '80', '60', '70', '75', '56', '90');
INSERT INTO `grade` VALUES ('8', '郭大', '3班', '30', '85', '75', '52', '78', '82');
INSERT INTO `grade` VALUES ('9', '人才', '9班', '95', '82', '75', '69', '52', '75');
INSERT INTO `grade` VALUES ('10', '王五', '11班', '62', '45', '85', '25', '75', '96');
INSERT INTO `grade` VALUES ('11', '小米', '8班', '95', '69', '48', '82', '63', '81');
INSERT INTO `grade` VALUES ('12', '鹏程', '12班', '85', '40', '69', '68', '83', '75');
INSERT INTO `grade` VALUES ('13', '小红', '7班', '70', '90', '70', '84', '52', '40');
INSERT INTO `grade` VALUES ('14', '小明', '14班', '62', '75', '85', '42', '80', '60');
INSERT INTO `grade` VALUES ('15', '小紫', '10班', '58', '80', '72', '96', '83', '50');
INSERT INTO `grade` VALUES ('16', '秦', '4班', '90', '80', '70', '50', '60', '60');
INSERT INTO `grade` VALUES ('17', '小静', '6班', '72', '69', '58', '85', '76', '43');
INSERT INTO `grade` VALUES ('18', '小莎', '13班', '92', '80', '60', '85', '72', '82');
INSERT INTO `grade` VALUES ('19', '郭大侠', '1班', '52', '62', '75', '81', '86', '71');
INSERT INTO `grade` VALUES ('20', '秦', '13班', '92', '80', '60', '85', '72', '82');
INSERT INTO `grade` VALUES ('21', '秦秦', '13班', '0', '0', '0', '0', '0', '0');
INSERT INTO `grade` VALUES ('22', '秦秦', '13班', '0', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) collate utf8_bin default NULL,
  `user_password` varchar(255) collate utf8_bin default NULL,
  `user_tel` int(11) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('1', 'admin', '1', '110');

-- ----------------------------
-- Table structure for set_class
-- ----------------------------
DROP TABLE IF EXISTS `set_class`;
CREATE TABLE `set_class` (
  `class_id` int(255) NOT NULL,
  `grade_id` int(11) default NULL,
  `class_name` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`class_id`),
  KEY `grade` (`grade_id`),
  KEY `class_name` (`class_name`),
  CONSTRAINT `grade` FOREIGN KEY (`grade_id`) REFERENCES `set_grade` (`grade_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of set_class
-- ----------------------------
INSERT INTO `set_class` VALUES ('1', '1', '1班');
INSERT INTO `set_class` VALUES ('2', '1', '2班');
INSERT INTO `set_class` VALUES ('3', '1', '3班');
INSERT INTO `set_class` VALUES ('4', '2', '4班');
INSERT INTO `set_class` VALUES ('5', '6', '5班');
INSERT INTO `set_class` VALUES ('6', '5', '6班');
INSERT INTO `set_class` VALUES ('7', '6', '7班');
INSERT INTO `set_class` VALUES ('8', '5', '8班');
INSERT INTO `set_class` VALUES ('9', '4', '9班');
INSERT INTO `set_class` VALUES ('10', '5', '10班');
INSERT INTO `set_class` VALUES ('11', '5', '11班');
INSERT INTO `set_class` VALUES ('12', '9', '12班');
INSERT INTO `set_class` VALUES ('13', '10', '13班');
INSERT INTO `set_class` VALUES ('14', '11', '14班');

-- ----------------------------
-- Table structure for set_grade
-- ----------------------------
DROP TABLE IF EXISTS `set_grade`;
CREATE TABLE `set_grade` (
  `grade_id` int(11) NOT NULL,
  `grade_name` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`grade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of set_grade
-- ----------------------------
INSERT INTO `set_grade` VALUES ('1', '初一');
INSERT INTO `set_grade` VALUES ('2', '初一');
INSERT INTO `set_grade` VALUES ('4', '初二');
INSERT INTO `set_grade` VALUES ('5', '初一');
INSERT INTO `set_grade` VALUES ('6', '高一');
INSERT INTO `set_grade` VALUES ('7', '高二');
INSERT INTO `set_grade` VALUES ('8', '高三');
INSERT INTO `set_grade` VALUES ('9', '大一');
INSERT INTO `set_grade` VALUES ('10', '大二');
INSERT INTO `set_grade` VALUES ('11', '大二');

-- ----------------------------
-- Table structure for set_sort
-- ----------------------------
DROP TABLE IF EXISTS `set_sort`;
CREATE TABLE `set_sort` (
  `sort_id` int(11) NOT NULL,
  `sort_name` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`sort_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of set_sort
-- ----------------------------
INSERT INTO `set_sort` VALUES ('1', '第一次月考');
INSERT INTO `set_sort` VALUES ('2', '第二次月考');
INSERT INTO `set_sort` VALUES ('3', '其中考试');
INSERT INTO `set_sort` VALUES ('4', '第四次月考');
INSERT INTO `set_sort` VALUES ('5', '第五次月考');
INSERT INTO `set_sort` VALUES ('6', '期末考试');

-- ----------------------------
-- Table structure for set_subject
-- ----------------------------
DROP TABLE IF EXISTS `set_subject`;
CREATE TABLE `set_subject` (
  `subject_id` int(255) NOT NULL,
  `subject_name` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of set_subject
-- ----------------------------
INSERT INTO `set_subject` VALUES ('1', '语文');
INSERT INTO `set_subject` VALUES ('2', '数学');
INSERT INTO `set_subject` VALUES ('3', '英语');
INSERT INTO `set_subject` VALUES ('4', '物理');
INSERT INTO `set_subject` VALUES ('5', '化学');
INSERT INTO `set_subject` VALUES ('6', '生物');
INSERT INTO `set_subject` VALUES ('7', '高数');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `class_id` int(255) default NULL,
  `student_name` varchar(255) collate utf8_bin default NULL,
  `student_sex` varchar(255) collate utf8_bin default NULL,
  `student_age` int(11) default NULL,
  `student_adress` varchar(255) collate utf8_bin default NULL,
  `student_tel` int(11) default NULL,
  PRIMARY KEY  (`student_id`),
  KEY `setclass` (`class_id`),
  KEY `student_name` (`student_name`),
  CONSTRAINT `setclass` FOREIGN KEY (`class_id`) REFERENCES `set_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1', '张三', '男', '18', '我家', '189');
INSERT INTO `student` VALUES ('2', '2', '李四', '女', '19', '你这里', '456');
INSERT INTO `student` VALUES ('3', '2', '王五', '男', '24', '他家', '4155');
INSERT INTO `student` VALUES ('4', '1', '赵六', '男', '22', '广东', '111');
INSERT INTO `student` VALUES ('5', '7', '王八', '女', '20', '四川', '123');
INSERT INTO `student` VALUES ('6', '3', '好好', '女', '44', '山西', '487');
INSERT INTO `student` VALUES ('7', '1', '郭大侠', '男', '30', '你家', '111');
INSERT INTO `student` VALUES ('8', '1', '郭大', '男', '30', '你家', '111');
INSERT INTO `student` VALUES ('9', '3', '人才', '男', '44', '四川', '456');
INSERT INTO `student` VALUES ('10', '2', '王五', '男', '24', '他家', '4155');
INSERT INTO `student` VALUES ('11', '9', '小米', '女', '20', '广州', '159753');
INSERT INTO `student` VALUES ('12', '11', '鹏程', '男', '24', '揭阳', '173522');
INSERT INTO `student` VALUES ('13', '8', '小红', '女', '35', '湛江', '1369428');
INSERT INTO `student` VALUES ('14', '12', '小明', '男', '19', '汕头', '1364982');
INSERT INTO `student` VALUES ('15', '13', '小紫', '女', '36', '顺德', '123684');
INSERT INTO `student` VALUES ('16', '7', '小马', '男', '20', '汕尾', '1359627');
INSERT INTO `student` VALUES ('17', '14', '高达', '男', '23', '北京', '1352035');
INSERT INTO `student` VALUES ('18', '10', '小莎', '女', '26', '天津', '1536947');
INSERT INTO `student` VALUES ('19', '6', '小静', '女', '29', '新疆', '1360295');
INSERT INTO `student` VALUES ('20', '4', '秦秦', '男', '21', '河北', '135520');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `user_id` int(255) NOT NULL auto_increment,
  `user_name` varchar(255) collate utf8_bin default NULL,
  `user_password` varchar(255) collate utf8_bin default NULL,
  `user_tel` int(255) default NULL,
  PRIMARY KEY  (`user_id`),
  CONSTRAINT `id` FOREIGN KEY (`user_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', '朱', '1', '111');
INSERT INTO `s_user` VALUES ('2', '雨', '1', '2');
INSERT INTO `s_user` VALUES ('3', '源', 'klk', '45');
INSERT INTO `s_user` VALUES ('4', '嚼', '123', '111');
INSERT INTO `s_user` VALUES ('5', '俊', 'ddd', '21');
INSERT INTO `s_user` VALUES ('6', '囧', '3', '3');
INSERT INTO `s_user` VALUES ('7', 'guo', '123', '789');
INSERT INTO `s_user` VALUES ('8', 'chen', '456', '456');
INSERT INTO `s_user` VALUES ('9', 'huang', '147', '369');
INSERT INTO `s_user` VALUES ('10', 'qin', '456', '123');
INSERT INTO `s_user` VALUES ('11', 'xi', 'aaa', '12593');
INSERT INTO `s_user` VALUES ('12', 'zhen', 'bbb', '155369');
INSERT INTO `s_user` VALUES ('13', 'yi', 'ccc', '14369');
INSERT INTO `s_user` VALUES ('14', 'wen', 'ddd', '1236955');
INSERT INTO `s_user` VALUES ('15', 'peng', 'eee', '136952');
INSERT INTO `s_user` VALUES ('16', 'yu', '789', '1362504');
INSERT INTO `s_user` VALUES ('17', 'yon', 'fff', '1364002');
INSERT INTO `s_user` VALUES ('18', 'jun', '10086', '1255236');
INSERT INTO `s_user` VALUES ('19', 'kai', '159', '10248637');
INSERT INTO `s_user` VALUES ('20', 'chuan', '753', '12645550');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL auto_increment,
  `class_id` int(255) default NULL,
  `teacher_name` varchar(255) collate utf8_bin default NULL,
  `teacher_sex` varchar(255) collate utf8_bin default NULL,
  `teacher_major` varchar(255) collate utf8_bin default NULL,
  `teacher_level` varchar(255) collate utf8_bin default NULL,
  `teacher_tel` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`teacher_id`),
  KEY `class` (`class_id`),
  CONSTRAINT `class` FOREIGN KEY (`class_id`) REFERENCES `set_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '1', '仑哥', '男', 'java', '教授', '123');
INSERT INTO `teacher` VALUES ('2', '2', '薛爷爷', '男', 'mysql', '教授', '1');
INSERT INTO `teacher` VALUES ('3', '3', '贤哥', '男', 'java', '教授', '1516');
INSERT INTO `teacher` VALUES ('4', '3', '欧阳通', '男', '线性代数', '教授', '111');
INSERT INTO `teacher` VALUES ('5', '3', '曾波', '男', '线性代数', '副教授', '1234');
INSERT INTO `teacher` VALUES ('6', '1', '高仑', '男', 'java', '副教授', '2');
INSERT INTO `teacher` VALUES ('7', '6', '薛建民', '男', 'java', '副教授', '2');
INSERT INTO `teacher` VALUES ('8', '4', '陈立军', '男', 'Linux', '讲师', '6215');
INSERT INTO `teacher` VALUES ('9', '9', '卢青华', '女', 'c++', '副教授', '1552');
INSERT INTO `teacher` VALUES ('10', '10', '陈孝如', '男', '计算机导论', '副教授', '1369');
INSERT INTO `teacher` VALUES ('11', '5', '王宏渊', '男', '网页设计', '教授', '5542');
INSERT INTO `teacher` VALUES ('12', '8', '陈坚强', '男', 'Python', '副教授', '22133');
INSERT INTO `teacher` VALUES ('13', '2', '李祎', '男', 'Linux', '教授', '33625');
INSERT INTO `teacher` VALUES ('14', '7', '毛养红', '女', 'PHP', '教授', '1542');
INSERT INTO `teacher` VALUES ('15', '13', '袁丽娜', '女', '网页设计', '副教授', '2159');
INSERT INTO `teacher` VALUES ('16', '14', '张屹', '男', 'c++', '教授', '02365');
INSERT INTO `teacher` VALUES ('17', '12', '钟迅科', '男', 'PHP', '讲师', '20221');
INSERT INTO `teacher` VALUES ('18', '11', '林若钦', '男', 'Linux', '教授', '9584');
INSERT INTO `teacher` VALUES ('19', '8', '杨威', '女', '计算机导论', '副教授', '8457');
INSERT INTO `teacher` VALUES ('20', '9', '彭金喜', '男', 'Python', '讲师', '6954');
INSERT INTO `teacher` VALUES ('21', '8', '林若钦', '男', 'Linux', '教授', '9584');

-- ----------------------------
-- Table structure for t_college
-- ----------------------------
DROP TABLE IF EXISTS `t_college`;
CREATE TABLE `t_college` (
  `id` int(11) NOT NULL default '0',
  `name` varchar(255) character set utf8 NOT NULL default '',
  `president` varchar(255) character set utf8 default NULL,
  `start_time` timestamp NULL default NULL,
  `telephone` varchar(255) character set utf8 default NULL,
  `email` varchar(255) character set utf8 default NULL,
  `address` varchar(255) character set utf8 default NULL,
  `profile` varchar(10000) character set utf8 default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_college
-- ----------------------------
INSERT INTO `t_college` VALUES ('1', '华软', '冠军', '2019-07-06 00:00:00', '189485888001', '1154627822@qq.com', '从化', '广州大学华软软件学院创办于2002年，是经教育部批准举办的本科层次独立学院，是全国300多家独立学院中唯一的一所软件学院。先后获得“中国十大品牌独立学院”、“中国十大优势专业院校”、“21世纪最具发展潜力教育机构”、“全国教育系统网络示范单位”等荣誉称号。\n广州大学华软软件学院\n广州大学华软软件学院\n\n学院交通便利，校园环境优雅写意，教学、娱乐、生活设施齐备，是一所环境怡人、教学设备完善、教学管理现代、教育理念先进的现代化大学。现有10系1部3个研究所。十系分别为：软件工程系、网络技术系、计算机系、数码媒体系、游戏系、电子系、管理系、国际经贸系、财会系、外语系；一部为基础部；三个研究所分别为软件研究所、信息科学研究所、高等教育研究所。共开设60余个专业方向，在校生逾万人。\n\n学院依托软件产业的发展，坚持“以质量求生存，以创新求发展”的办学思路，以IT市场需求为导向，以软件技术在各行各业的应用为立足点，采用完全学分制，实施信息化管理，形成了以软件开发、网络工程、嵌入式技术、动漫制作、游戏设计、电子信息工程、信息管理为核心的优势学科群，积极发展以数字媒体艺术为特色的新兴学科，培养适应中国软件产业发展需求的规范化应用型人才。\n\n学院在师资引入上采取“三三制”原则，教师队伍由三部分组成：1）来自传统高校的教师，具有高职称与丰富的教学经验；2）来自企业的工程师，具有工程实践和管理经验，能够将实践经验、最新技术和企业思维融入教学中；3）来自海外有教学和工作经验的留学人员，能够引进海外先进的教学理念、拓宽国际视野。同时，学院还设立社会导师制，聘请成功人士担任学生的社会导师，为学生提供一个与之交流的平台，通过耳濡目染提升学生的综合素养。\n\n学院是企业与高校合作办学的产物，在办学过程中积极搭建与企业交流沟通的平台，校企合作已成为学院长期坚持的发展方针。目前，学院已与IBM、微软、PARASOFT、DHL（中外运敦豪）、德邦物流、21CN等三百余家企业建立合作联盟，开展包括课程嵌入、订单培养、人才储备俱乐部、短期培训等多种模式的合作，共同塑造华软学子的就业竞争力。\n\n学院以认真、严谨的治学方式，以先进、适用的教学内容，以科学、创新的教学手段，以优美、完善的教学环境，以开放、独立的交流态度，培养华软的学子，努力建立一家中国著名的国际性高等院校。');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) collate utf8_bin default NULL,
  `user_password` varchar(255) collate utf8_bin default NULL,
  `user_tel` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`user_id`),
  CONSTRAINT `t_user` FOREIGN KEY (`user_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '朱', '2', '777');
INSERT INTO `t_user` VALUES ('2', '雨', '2', '123');
INSERT INTO `t_user` VALUES ('3', '鹏', '165', '123');
INSERT INTO `t_user` VALUES ('4', '通', '4', '4');
INSERT INTO `t_user` VALUES ('5', '郭', 'abc', '16952');
INSERT INTO `t_user` VALUES ('6', '钦', 'def', '13692');
INSERT INTO `t_user` VALUES ('7', '黄', '123', '159634');
INSERT INTO `t_user` VALUES ('8', '咪', '456', '152855');
INSERT INTO `t_user` VALUES ('9', '陈', 'hijk', '23648');
INSERT INTO `t_user` VALUES ('10', '钲', 'abcd', '120358');
INSERT INTO `t_user` VALUES ('11', '禧', 'efgh', '19635');
INSERT INTO `t_user` VALUES ('12', '艺', '123', '1582');
INSERT INTO `t_user` VALUES ('13', '文', '456', '12058');
INSERT INTO `t_user` VALUES ('14', 'hong', '789', '13648');
INSERT INTO `t_user` VALUES ('15', 'na', '001', '1596');
INSERT INTO `t_user` VALUES ('16', '屹', '002', '12045');
INSERT INTO `t_user` VALUES ('17', '科', '003', '16935');
INSERT INTO `t_user` VALUES ('18', 'qin', 'aaa', '12548');
INSERT INTO `t_user` VALUES ('19', 'wei', 'bbb', '13694');
INSERT INTO `t_user` VALUES ('20', '喜', 'ccc', '154628');
