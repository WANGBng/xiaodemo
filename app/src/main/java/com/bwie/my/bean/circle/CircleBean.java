package com.bwie.my.bean.circle;

import java.util.List;

/**
 * date:2018/12/11.
 * @author wangbingjun  王丙均
 */

public class CircleBean {

    /**
     * result : [{"commodityId":1,"content":"小鼠","createTime":1544538086000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":14,"image":"","nickName":"QM_9M92o","userId":18,"whetherGreat":2},{"commodityId":1,"content":"111","createTime":1544538033000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":13,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-11/3916820181211082033.PNG","nickName":"QM_9M92o","userId":18,"whetherGreat":2},{"commodityId":99,"createTime":1544487255000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":12,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-10/5619820181210181415.jpg","nickName":"sg_803fH","userId":24,"whetherGreat":2},{"commodityId":1,"content":"程龙","createTime":1544404509000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":11,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-09/4986320181209191509.jpg","nickName":"oM_4vdk0","userId":48,"whetherGreat":2},{"commodityId":1,"content":"给大家推荐一个好商品","createTime":1544404071000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":10,"image":"http://172.17.8.100/images/small/circle_pic/2018-12-09/7412020181209190751.jpg","nickName":"oM_4vdk0","userId":48,"whetherGreat":2}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;
private boolean isCheck;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 1
         * content : 小鼠
         * createTime : 1544538086000
         * greatNum : 0
         * headPic : http://172.17.8.100/images/small/default/user.jpg
         * id : 14
         * image :
         * nickName : QM_9M92o
         * userId : 18
         * whetherGreat : 2
         */

        private int commodityId;
        private String content;
        private long createTime;
        private int greatNum;
        private String headPic;
        private int id;
        private String image;
        private String nickName;
        private int userId;
        private int whetherGreat;
        private boolean isCheck;

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(int whetherGreat) {
            this.whetherGreat = whetherGreat;
        }
    }
}
