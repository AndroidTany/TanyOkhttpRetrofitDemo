package com.angcyo.eventbus30demo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2016/11/15.
 */

public class StoreBean implements Serializable{


    /**
     * success : 1
     * msg :
     * data : [{"goodsId":"53","catId":"63","storeId":"15","goodsName":"珍品翠芽","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-17/580487d807b08.jpg","goodsPrice":"318.00","commission":15.36,"store_count":"190","likeGoods":"false","likeGoodsAndroid":0},{"goodsId":"84","catId":"58","storeId":"25","goodsName":"田作故事TIANZU圣上壹品SHENGSHANGYIPIN 五常大米 稻花香2号 新风尚 银钻5Kg","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-18/5805db963f340.jpg","goodsPrice":"119.50","commission":8.28,"store_count":"999","likeGoods":"false","likeGoodsAndroid":0},{"goodsId":"82","catId":"58","storeId":"25","goodsName":"田作故事TIANZUOGUSHI 优选 五常稻花香大米 2.5kg 妈妈饭系列迎春而来","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-18/5805d2b78a1bc.jpg","goodsPrice":"55.00","commission":2.4,"store_count":"1000","likeGoods":"false","likeGoodsAndroid":0},{"goodsId":"11","catId":"74","storeId":"10","goodsName":"蛹虫草子实体100克精品礼盒装","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-13/57feffc7f00d4.jpg","goodsPrice":"248.00","commission":23.52,"store_count":"1000","likeGoods":"ture","likeGoodsAndroid":1},{"goodsId":"195","catId":"70","storeId":"52","goodsName":"布兰蒂奇异果酒","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-29/58145a52736ab.jpg","goodsPrice":"208.00","commission":45.6,"store_count":"100","likeGoods":"false","likeGoodsAndroid":0},{"goodsId":"171","catId":"66","storeId":"45","goodsName":"津乐福蓝莓复合果汁饮料","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-27/5811d51c96dc1.jpg","goodsPrice":"5.50","commission":0.36,"store_count":"1000","likeGoods":"false","likeGoodsAndroid":0},{"goodsId":"170","catId":"66","storeId":"45","goodsName":"津乐福石榴复合果汁饮料","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-27/5811d45f0e78f.jpg","goodsPrice":"5.50","commission":0.36,"store_count":"1000","likeGoods":"false","likeGoodsAndroid":0},{"goodsId":"127","catId":"113","storeId":"33","goodsName":"2016新款全皮女鞋秋冬","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-21/58097c25eef6f.jpg","goodsPrice":"240.00","commission":19.2,"store_count":"1000","likeGoods":"false","likeGoodsAndroid":0},{"goodsId":"126","catId":"113","storeId":"33","goodsName":"2016新款高跟全皮女鞋","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-21/58097b18c3646.jpg","goodsPrice":"248.00","commission":19.92,"store_count":"1000","likeGoods":"false","likeGoodsAndroid":0},{"goodsId":"110","catId":"55","storeId":"31","goodsName":"儿童富硒鲜鸡蛋","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-11-11/58252bf378a22.jpg","goodsPrice":"105.00","commission":1.44,"store_count":"999","likeGoods":"false","likeGoodsAndroid":0}]
     */

    private int success;
    private String msg;
    /**
     * goodsId : 53
     * catId : 63
     * storeId : 15
     * goodsName : 珍品翠芽
     * originalImg : http://www.wsqonline.com/Public/Home/upload/2016-10-17/580487d807b08.jpg
     * goodsPrice : 318.00
     * commission : 15.36
     * store_count : 190
     * likeGoods : false
     * likeGoodsAndroid : 0
     */

    private List<DataBean> data;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String goodsId;
        private String catId;
        private String storeId;
        private String goodsName;
        private String originalImg;
        private String goodsPrice;
        private double commission;
        private String store_count;
        private String likeGoods;
        private int likeGoodsAndroid;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getCatId() {
            return catId;
        }

        public void setCatId(String catId) {
            this.catId = catId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getOriginalImg() {
            return originalImg;
        }

        public void setOriginalImg(String originalImg) {
            this.originalImg = originalImg;
        }

        public String getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(String goodsPrice) {
            this.goodsPrice = goodsPrice;
        }

        public double getCommission() {
            return commission;
        }

        public void setCommission(double commission) {
            this.commission = commission;
        }

        public String getStore_count() {
            return store_count;
        }

        public void setStore_count(String store_count) {
            this.store_count = store_count;
        }

        public String getLikeGoods() {
            return likeGoods;
        }

        public void setLikeGoods(String likeGoods) {
            this.likeGoods = likeGoods;
        }

        public int getLikeGoodsAndroid() {
            return likeGoodsAndroid;
        }

        public void setLikeGoodsAndroid(int likeGoodsAndroid) {
            this.likeGoodsAndroid = likeGoodsAndroid;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "goodsId='" + goodsId + '\'' +
                    ", catId='" + catId + '\'' +
                    ", storeId='" + storeId + '\'' +
                    ", goodsName='" + goodsName + '\'' +
                    ", originalImg='" + originalImg + '\'' +
                    ", goodsPrice='" + goodsPrice + '\'' +
                    ", commission=" + commission +
                    ", store_count='" + store_count + '\'' +
                    ", likeGoods='" + likeGoods + '\'' +
                    ", likeGoodsAndroid=" + likeGoodsAndroid +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "StoreBean{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
