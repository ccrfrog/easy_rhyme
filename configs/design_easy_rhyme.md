

### 背景知识

#### 汉语拼音
汉语拼音方案里声母如果不算 y w 共21个，如果算上y w共 23个。
韵母共 35个，可组合出的音节(声母加韵母加声调，本需求里暂不考虑声调)共 400+ 个。
21 * 35 > 400，但是有些组合并不在汉语拼音方案里，比如 biangbiang面，jeng 等等。

所谓的拼音，就是 按照普通话音节的构成规律，把声母、韵母迅速连续拼合并加上声调从而成为一个音节。

#### 术语
声母： initial consonant of a Chinese syllable，一般使用 consonant
韵母：vowel (of a Chinese syllable)，一般使用 vowel
声调：tone，本需求不涉及，忽略。


#### 押韵
押韵，又作压韵，是指在韵文的创作中，在某些句子的最后一个字，都使用韵母相同或相近的字或者平仄统一，
使朗诵或咏唱时，产生铿锵和谐感。这些使用了同一韵母字的地方，称为韵脚。

普通话一般有十八韵表，随便一搜便有。
a, ia, ua
an, ian, uan

参考以下帖子

https://www.douban.com/note/328761881/?type=like


#### 参考
汉字注音拉丁化方案 百度百科

https://baike.baidu.com/item/%E6%B1%89%E8%AF%AD%E6%8B%BC%E9%9F%B3/454?fr=aladdin#9_2

汉语拼音音节

https://baike.baidu.com/item/%E6%B1%89%E8%AF%AD%E6%8B%BC%E9%9F%B3%E9%9F%B3%E8%8A%82/9167981?fr=aladdin

在线汉语词典，按拼音检索

http://xh.5156edu.com/pinyi.html

百度百科 押韵

https://baike.baidu.com/item/%E6%8A%BC%E9%9F%B5/192771?fr=aladdin#5


### 基础词库
先抓取一个音乐数据源，比如网易云音乐的全部中文歌词，分词后入库。
后续考虑增加诗经，唐诗等经典语料库。
注意该语料库后续可能做其它使用，比如根据发音近似的歌词搜索歌曲名，所以抓取时尽量保存完整的
原数据，比如歌名，歌手信息，流行度等等


### 存储方案
韵母一共 35个，考虑每个韵母建一张表，单词 保存在最后一个字的韵母对应的表中。
例如 ian 对应的表名为 `rhyme_ian`，那么 蓝天(lantian)，冷面(lengmian)
都保存到表 rhyme_ian。好处是
1. 虽然存在 分布不均问题，但是每个表的记录数不会太大，
2. 单韵查询非常方便，





### 查询逻辑 
#### 单韵查询
eg. q = 蓝天，求得 韵母 vowel = ian，根据 押韵映射表 得到 韵母集合[an, ian, uan]
并发从 `rhyme_an, rhyme_ian, rhyme_uan` 3 个表里查询对应的词按 词频freq 排序返回即可


#### 双韵查询
eg. q = 蓝天，求得韵母 vowel = [an, ian]，先执行单韵查询，增加条件 word.length > 1，


#### 多韵查询
eg. q = 核武器，求得韵母 vowel = [e, u, i]，
 
 



