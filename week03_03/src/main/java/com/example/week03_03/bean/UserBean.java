package com.example.week03_03.bean;

import java.util.List;

public class UserBean {

    /**
     * msg : 成功的返回
     * code : 1
     * data : [{"uniquekey":"3d7c25ec33afa593b7cace5d74a37020","title":"天下一家 风雨同舟\u2014\u2014记\u201c汉语桥\u201d乌克兰赛区决赛","date":"2018-05-12 09:33","category":"国际","author_name":"人民网","url":"http://mini.eastday.com/mobile/180512093308495.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180512/20180512093308_406a6087ff2bf411675505b6c3b28b4e_5_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180512/20180512093308_979dba3dafc7c529f01a4123d78796a2_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180512/20180512093308_add02e096f3622e1ba35d8d4cac1c0d5_2_mwpm_03200403.jpg"},{"uniquekey":"9126e6d37e9827225ebffefc346fb3ae","title":"专访：\u201c一带一路\u201d项目在非洲落地前景广阔\u2014\u2014访中国中铁总裁张宗言","date":"2018-05-12 09:34","category":"国际","author_name":"新华社","url":"http://mini.eastday.com/mobile/180512093444832.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180512/20180512093444_8330dfbc2a9747a40b375ac127faca3b_1_mwpm_03200403.jpg"},{"uniquekey":"d506303744cfa3679b6c063c75885702","title":"巴以在加沙地带爆发第七场大规模冲突致一人死近千人伤","date":"2018-05-12 09:31","category":"国际","author_name":"央视新闻app","url":"http://mini.eastday.com/mobile/180512093111254.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180512/20180512093111_d5c2e75a340ab4e465428e417623720e_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180512/20180512093111_d5c2e75a340ab4e465428e417623720e_2_mwpm_03200403.jpg"},{"uniquekey":"fc3f8672d341c090780be6a2aaf03603","title":"美方批中国\u201c奥威尔式废话\u201d 崔天凯：不想评论任何人的愚蠢言论","date":"2018-05-12 09:28","category":"国际","author_name":"环球网","url":"http://mini.eastday.com/mobile/180512092810340.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180512/20180512092810_31fc1b0df6992a90ebf37a8e08a8f1c9_1_mwpm_03200403.jpg"},{"uniquekey":"12e8eb6346e1d621078f0f290a2db433","title":"好好生活才是对地震灾难的最好纪念","date":"2018-05-12 09:28","category":"国际","author_name":"说书人思郁","url":"http://mini.eastday.com/mobile/180512092807821.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180512/20180512092807_b7f092ce3637e47f176bf9dc447d8afe_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20180512/20180512092807_b7f092ce3637e47f176bf9dc447d8afe_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20180512/20180512092807_b7f092ce3637e47f176bf9dc447d8afe_3_mwpm_03200403.jpg"},{"uniquekey":"c493f4726a1ca219b20e100a1b7826cf","title":"与 055 大驱竞赛？美国开工首艘伯克Ⅲ型驱逐舰","date":"2018-05-12 09:27","category":"国际","author_name":"环球网","url":"http://mini.eastday.com/mobile/180512092729164.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180512/20180512092729_fefaffbdfea4dc59b1b032d711f05850_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20180512/20180512092729_fefaffbdfea4dc59b1b032d711f05850_1_mwpm_03200403.jpg"},{"uniquekey":"1c6ca78a71dbc96491ad28995f552371","title":"92岁的马哈蒂尔上位，马来西亚人为何选他？","date":"2018-05-12 09:23","category":"国际","author_name":"中国网观点中国","url":"http://mini.eastday.com/mobile/180512092329916.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180512/20180512092329_96fafa08dc290424dc1fa9c63b88b617_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180512/20180512092329_96fafa08dc290424dc1fa9c63b88b617_1_mwpm_03200403.jpg"},{"uniquekey":"971743c1ab2c36e6071d5c199b5ab676","title":"侵华日军第731部队罪证陈列馆新馆获中国年度建筑大奖","date":"2018-05-12 09:21","category":"国际","author_name":"东北网","url":"http://mini.eastday.com/mobile/180512092140095.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180512/20180512092140_ec1070b7f8b9d6b5b83334a68686563b_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180512/20180512092140_ec1070b7f8b9d6b5b83334a68686563b_2_mwpm_03200403.jpg"},{"uniquekey":"8441ade0fccce270794cc35179edb707","title":"马来西亚92岁新总理：我的确蛮老 但我还有用","date":"2018-05-12 09:20","category":"国际","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180512092009958.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180512/20180512092009_0056b8abfc9b9b33c877a7eb492089cf_1_mwpm_03200403.jpg"},{"uniquekey":"dbd184b9339637f2c0f9e58ed3cf2b71","title":"耶路撒冷美新使馆14日开幕 特朗普将发表电视讲话","date":"2018-05-12 09:19","category":"国际","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180512091924525.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180512/20180512091924_fa73ba8e0654d05e18ca4c06274cc0c5_1_mwpm_03200403.jpg"},{"uniquekey":"f8abe8ce2e060d47d91f4443a28e434d","title":"\u201c金特会\u201d选址定了！新加坡为何成首脑会谈\u201c客厅\u201d？","date":"2018-05-12 09:16","category":"国际","author_name":"大白新闻","url":"http://mini.eastday.com/mobile/180512091639740.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180512/20180512091639_ef6a2711d435e1bbc62896d3ab5f8fa9_1_mwpm_03200403.jpg"},{"uniquekey":"a00c5ba416359ff07cd8d1b978542773","title":"首个海外老舍展厅在埃及苏伊士运河大学成立","date":"2018-05-12 09:16","category":"国际","author_name":"浙江在线","url":"http://mini.eastday.com/mobile/180512091622775.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180512/20180512091622_680bdbbc157ce523702c61a80e58ad56_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180512/20180512091622_f64b58ddf9ff0f468831609f729519d8_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180512/20180512091622_996d43e3e6e6d0d58df56d118a217fb1_1_mwpm_03200403.jpg"},{"uniquekey":"3b9da82112a7eabe0a2feb2ed09868ff","title":"美对伊朗挥舞制裁大棒 盟友愤怒：不该为美退出伊核协议付出代价","date":"2018-05-12 09:16","category":"国际","author_name":"解放网","url":"http://mini.eastday.com/mobile/180512091609665.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180512/20180512091609_b99b6a961faef5cde48f7ea34cb46db9_1_mwpm_03200403.jpg"},{"uniquekey":"329539f4ebccecb3f33177b403803539","title":"新加坡人问：为什么有些美国人认为新加坡只是中国的一座城市？","date":"2018-05-12 09:16","category":"国际","author_name":"悦闻闻","url":"http://mini.eastday.com/mobile/180512091608620.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180512/20180512_06b871038757fb27597427cdbfaa294e_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180512/20180512_b55aedc725850e02248583a70a8e1fb8_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180512/20180512_3bf119034e02f95ba915a0583e466dca_cover_mwpm_03200403.jpg"},{"uniquekey":"968df01eb782456bc90fe2a8126d6edc","title":"老人看着蔬菜被动物糟蹋，竟自己研究出机器怪兽狗来吓跑它们！","date":"2018-05-12 09:16","category":"国际","author_name":"谈趣闻","url":"http://mini.eastday.com/mobile/180512091606865.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180512/20180512_3b392e5285e2c8610a8818e2db8e0ed3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180512/20180512_8e0fcf5a56e69ec1d16b92595cb5aa02_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180512/20180512_0cfecb7a1841ebe95d0227e54edb250b_mwpm_03200403.jpg"},{"uniquekey":"34e74d35c52b9460a86d5e96336f834f","title":"俄罗斯人问：我听说，现在的中国比俄罗斯更发达，这是真的吗？","date":"2018-05-12 09:15","category":"国际","author_name":"小小润仔","url":"http://mini.eastday.com/mobile/180512091535536.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180512/20180512_d324453fc987cd69f750dbcc87579147_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180512/20180512_9c77b8bca67cee328328bbed9afe0601_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180512/20180512_0ebaae9ffcc9983c6b49f5f80d45a207_cover_mwpm_03200403.jpg"},{"uniquekey":"49799988d673af118ba82ba624723968","title":"印度一名男子和狗狗结婚，只因他15年前打死过一条狗！","date":"2018-05-12 09:14","category":"国际","author_name":"谈趣闻","url":"http://mini.eastday.com/mobile/180512091422664.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180512/20180512_55cfc70b5f9ac7322cda80bb7ff71835_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180512/20180512_91a25a7524819020bb4c3ec3edfd3c50_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180512/20180512_d3a31b832f40e860494846e003188fcb_mwpm_03200403.jpg"},{"uniquekey":"0920bf6240b5d26e95e238ae742bbc84","title":"英国女王宣布一决定，所有人都为她拍手叫好","date":"2018-05-12 09:11","category":"国际","author_name":"天下有警","url":"http://mini.eastday.com/mobile/180512091148195.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180512/20180512091148_83fbdae8ed56094f4885a4ea5c6d5000_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180512/20180512091148_83fbdae8ed56094f4885a4ea5c6d5000_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180512/20180512091148_83fbdae8ed56094f4885a4ea5c6d5000_1_mwpm_03200403.jpg"},{"uniquekey":"ab77f9fbdd76039ec44834039f721abd","title":"这个家族基因有点怪，100多年只生男孩，全家重女轻男！","date":"2018-05-12 09:11","category":"国际","author_name":"树袋熊说世界","url":"http://mini.eastday.com/mobile/180512091140913.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180512/20180512_61929a296658b0e96b677ea7de63f76d_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180512/20180512_74f7a01e2a7feb6f2cf8aa23dea31f60_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180512/20180512_453f3022f5784936af9175edbcbeef19_cover_mwpm_03200403.jpg"},{"uniquekey":"f86e48cbf74fe1cc4559954f650a7546","title":"美法院对西雅图Uber工会法案提出质疑","date":"2018-05-12 09:11","category":"国际","author_name":"cnBeta","url":"http://mini.eastday.com/mobile/180512091121916.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180512/20180512091121_d32d89dd2608df242e53eb5665ca4d9a_1_mwpm_03200403.jpg"},{"uniquekey":"f8715ab8eafa6be16e2b77a76f53cff2","title":"有一种港普叫蔡少芬，有一种美是清纯美，而我更喜欢后者成熟美","date":"2018-05-12 09:09","category":"国际","author_name":"菲菲小文艺","url":"http://mini.eastday.com/mobile/180512090916217.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180512/20180512090916_ad393f46b7b477f174ff0c22c895077f_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180512/20180512090916_ad393f46b7b477f174ff0c22c895077f_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20180512/20180512090916_ad393f46b7b477f174ff0c22c895077f_2_mwpm_03200403.jpg"},{"uniquekey":"3316197c4b57e5b6b83edabee367dfdf","title":"欧洲企业或受美对伊朗制裁波及 法德主张捍卫权益","date":"2018-05-12 09:09","category":"国际","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/180512090915082.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180512/20180512090915_d8042f83d007e39d29ca57e829ac3140_1_mwpm_03200403.jpg"},{"uniquekey":"cbd12cfe71c3cba93d3c791818d61929","title":"被称为世界上最温馨的母女三人，她们的合影可爱顽皮！","date":"2018-05-12 09:07","category":"国际","author_name":"谈趣闻","url":"http://mini.eastday.com/mobile/180512090726974.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180512/20180512_012c4c64a332ce8ef7f19a2fe8903874_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180512/20180512_488ae3250cb099f4de5d059c238e8a10_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180512/20180512_d88352d7ae0da47cb9754cc89ba90fd1_mwpm_03200403.jpg"},{"uniquekey":"688b230becbaccf9e1edbddb3f2833ef","title":"金伯利加纳造型奇特出现在法国戛纳，网友：身材保持的真好","date":"2018-05-12 09:06","category":"国际","author_name":"小乔情感心理","url":"http://mini.eastday.com/mobile/180512090622609.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180512/20180512090622_934982d153db639925c9e9fb27b8d1a7_5_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180512/20180512090622_934982d153db639925c9e9fb27b8d1a7_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180512/20180512090622_934982d153db639925c9e9fb27b8d1a7_1_mwpm_03200403.jpg"},{"uniquekey":"577cee29af89d11748daf4766749e169","title":"极限高度爱好者脚下的迪拜，30年前这里还是一片沙漠！","date":"2018-05-12 09:05","category":"国际","author_name":"侃侃儿谈","url":"http://mini.eastday.com/mobile/180512090557432.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180512/20180512_c5461cc0a875646c0e4456d23d29a163_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180512/20180512_74250806390cc7872ae6b5ce764f38dd_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180512/20180512_9f03563af64f58b94b4fce0566a086eb_cover_mwpm_03200403.jpg"},{"uniquekey":"9a71f177d20cdb30fdf3cc0109161759","title":"美国-亚洲新的跨太平洋海底电缆NCP已投运","date":"2018-05-12 09:05","category":"国际","author_name":"电缆网","url":"http://mini.eastday.com/mobile/180512090506029.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180512/20180512090506_f11d78c4cb8bde984cee193e07d5219e_1_mwpm_03200403.jpg"},{"uniquekey":"d253ebb385f05897de6551d12d8a5502","title":"身价高达30亿的乌克兰女孩，生活极致 \u201c奢华\u201d23岁至今单身","date":"2018-05-12 09:02","category":"国际","author_name":"爆料一姐","url":"http://mini.eastday.com/mobile/180512090228692.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180512/20180512_6c2b950c10178e828f8b4033bce19a16_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20180512/20180512_9996612a8b7c1b5d9c68551e8c24c648_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20180512/20180512_b08a10f194a1e714025ef5548799a3c5_cover_mwpm_03200403.jpg"},{"uniquekey":"4c3001925420a6f4db37dc56b42ff375","title":"马哈蒂尔：92岁政坛老将东山再起","date":"2018-05-12 09:02","category":"国际","author_name":"凤凰网","url":"http://mini.eastday.com/mobile/180512090210025.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180512/20180512090210_9bd3211db6440d9281aa505363e86147_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20180512/20180512090210_9bd3211db6440d9281aa505363e86147_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20180512/20180512090210_9bd3211db6440d9281aa505363e86147_2_mwpm_03200403.jpg"},{"uniquekey":"8b75ccb5e8cc5f99d400ca26e230533d","title":"希拉里再对中国\u201c开炮\u201d 中方回应","date":"2018-05-12 09:01","category":"国际","author_name":"参考消息网","url":"http://mini.eastday.com/mobile/180512090154000.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180512/20180512090154_dcaa8a60186c8eacd6638a8761b5865d_18_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20180512/20180512090154_dcaa8a60186c8eacd6638a8761b5865d_32_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20180512/20180512090154_dcaa8a60186c8eacd6638a8761b5865d_24_mwpm_03200403.jpg"},{"uniquekey":"90370e417115df1633fb7e30482773de","title":"世界旅游组织秘书长：中东地区旅游业呈现复苏势头","date":"2018-05-12 09:01","category":"国际","author_name":"新华网","url":"http://mini.eastday.com/mobile/180512090143799.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180512/20180512090143_e871721174d04c51c6c547ea07336ba8_1_mwpm_03200403.jpg"}]
     */

    private String msg;
    private int code;
    private List<DataBean> data;
    public boolean isSuccess(){
        return code==1;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uniquekey : 3d7c25ec33afa593b7cace5d74a37020
         * title : 天下一家 风雨同舟——记“汉语桥”乌克兰赛区决赛
         * date : 2018-05-12 09:33
         * category : 国际
         * author_name : 人民网
         * url : http://mini.eastday.com/mobile/180512093308495.html
         * thumbnail_pic_s : http://01.imgmini.eastday.com/mobile/20180512/20180512093308_406a6087ff2bf411675505b6c3b28b4e_5_mwpm_03200403.jpg
         * thumbnail_pic_s02 : http://01.imgmini.eastday.com/mobile/20180512/20180512093308_979dba3dafc7c529f01a4123d78796a2_4_mwpm_03200403.jpg
         * thumbnail_pic_s03 : http://01.imgmini.eastday.com/mobile/20180512/20180512093308_add02e096f3622e1ba35d8d4cac1c0d5_2_mwpm_03200403.jpg
         */

        private String uniquekey;
        private String title;
        private String date;
        private String category;
        private String author_name;
        private String url;
        private String thumbnail_pic_s;
        private String thumbnail_pic_s02;
        private String thumbnail_pic_s03;
        public int isImage(){
            return (thumbnail_pic_s!=null&&thumbnail_pic_s02!=null&&thumbnail_pic_s03!=null)?1:0;
        }
        public String getUniquekey() {
            return uniquekey;
        }

        public void setUniquekey(String uniquekey) {
            this.uniquekey = uniquekey;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbnail_pic_s() {
            return thumbnail_pic_s;
        }

        public void setThumbnail_pic_s(String thumbnail_pic_s) {
            this.thumbnail_pic_s = thumbnail_pic_s;
        }

        public String getThumbnail_pic_s02() {
            return thumbnail_pic_s02;
        }

        public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
            this.thumbnail_pic_s02 = thumbnail_pic_s02;
        }

        public String getThumbnail_pic_s03() {
            return thumbnail_pic_s03;
        }

        public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
            this.thumbnail_pic_s03 = thumbnail_pic_s03;
        }
    }
}
