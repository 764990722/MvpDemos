package com.example.azheng.rxjavamvpdemo.bean;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/11
 * 类 描 述：
 */
public class BeanFamily {

    /**
     * replyQuantity : 0
     * precept : "36919",36919
     * avatar : https://ancestry.oss-cn-beijing.aliyuncs.com/family_group/2019-09/ANC_1568088377260819805.jpg
     * sort : 4
     * number : 6066799003
     * name : 13646
     * approveQuantity : 0
     * isManager : true
     * createUser : {"country":"爱辉区","province":"黑龙江省","name":"骆卧佛"}
     * quadrangleSid : 32
     */

    private String replyQuantity;
    private String precept;
    private String avatar;
    private int sort;
    private String number;
    private String name;
    private int approveQuantity;
    private boolean isManager;
    private CreateUserBean createUser;
    private int quadrangleSid;

    public String getReplyQuantity() {
        return replyQuantity;
    }

    public void setReplyQuantity(String replyQuantity) {
        this.replyQuantity = replyQuantity;
    }

    public String getPrecept() {
        return precept;
    }

    public void setPrecept(String precept) {
        this.precept = precept;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getApproveQuantity() {
        return approveQuantity;
    }

    public void setApproveQuantity(int approveQuantity) {
        this.approveQuantity = approveQuantity;
    }

    public boolean isIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

    public CreateUserBean getCreateUser() {
        return createUser;
    }

    public void setCreateUser(CreateUserBean createUser) {
        this.createUser = createUser;
    }

    public int getQuadrangleSid() {
        return quadrangleSid;
    }

    public void setQuadrangleSid(int quadrangleSid) {
        this.quadrangleSid = quadrangleSid;
    }

    public static class CreateUserBean {
        /**
         * country : 爱辉区
         * province : 黑龙江省
         * name : 骆卧佛
         */

        private String country;
        private String province;
        private String name;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
