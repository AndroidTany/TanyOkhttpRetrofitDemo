package com.angcyo.eventbus30demo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2016/11/10.
 */

public class Repo implements Serializable{


    /**
     * success : 1
     * msg :
     * data : [{"GID":"8","goodsId":"38","storeId":"27","smallTitle":"塔里木奶制品爆款","title":"塔里木奶制品爆款","price":"12.00","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-14/5800729818691.jpg","commission":0.72,"store_count":"100"},{"GID":"7","goodsId":"38","storeId":"27","smallTitle":"塔里木奶制品爆款","title":"塔里木奶制品爆款","price":"12.00","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-14/5800729818691.jpg","commission":0.72,"store_count":"100"},{"GID":"6","goodsId":"38","storeId":"27","smallTitle":"塔里木奶制品爆款","title":"塔里木奶制品爆款","price":"12.00","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-14/5800729818691.jpg","commission":0.72,"store_count":"100"},{"GID":"5","goodsId":"38","storeId":"27","smallTitle":"塔里木奶制品爆款","title":"塔里木奶制品爆款","price":"12.00","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-14/5800729818691.jpg","commission":0.72,"store_count":"100"},{"GID":"4","goodsId":"38","storeId":"27","smallTitle":"塔里木奶制品爆款","title":"塔里木奶制品爆款","price":"12.00","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-14/5800729818691.jpg","commission":0.72,"store_count":"100"},{"GID":"3","goodsId":"75","storeId":"24","smallTitle":"双十一特价","title":"双十一特价","price":"128.00","originalImg":"http://www.wsqonline.com/Public/Home/upload/2016-10-17/5804a627abc25.jpg","commission":2.4,"store_count":"100"}]
     */

    private int success;
    private String msg;
    /**
     * GID : 8
     * goodsId : 38
     * storeId : 27
     * smallTitle : 塔里木奶制品爆款
     * title : 塔里木奶制品爆款
     * price : 12.00
     * originalImg : http://www.wsqonline.com/Public/Home/upload/2016-10-14/5800729818691.jpg
     * commission : 0.72
     * store_count : 100
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
        private String GID;
        private String goodsId;
        private String storeId;
        private String smallTitle;
        private String title;
        private String price;
        private String originalImg;
        private double commission;
        private String store_count;

        public String getGID() {
            return GID;
        }

        public void setGID(String GID) {
            this.GID = GID;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getSmallTitle() {
            return smallTitle;
        }

        public void setSmallTitle(String smallTitle) {
            this.smallTitle = smallTitle;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getOriginalImg() {
            return originalImg;
        }

        public void setOriginalImg(String originalImg) {
            this.originalImg = originalImg;
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "GID='" + GID + '\'' +
                    ", goodsId='" + goodsId + '\'' +
                    ", storeId='" + storeId + '\'' +
                    ", smallTitle='" + smallTitle + '\'' +
                    ", title='" + title + '\'' +
                    ", price='" + price + '\'' +
                    ", originalImg='" + originalImg + '\'' +
                    ", commission=" + commission +
                    ", store_count='" + store_count + '\'' +
                    '}';
        }
    }
}
