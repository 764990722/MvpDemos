package com.example.azheng.rxjavamvpdemo.bean;

import java.util.List;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * 类 描 述：
 */
public class BeanZqin {

    /**
     * users : [{"birthday":"1993-01-01","sweep":18,"country":"江北区","sex":"男","merit":0,"avatar":"https://ancestry-images.oss-cn-chengdu.aliyuncs.com/user/2019-08/ANC_1565939253516669951.jpg","province":"重庆市","name":"周靖杰","wangyicloudAccid":"045cc099d14f4b0f87efe65efc300417","tribute":0}]
     * totalElements : 1
     * size : 20
     * totalPages : 1
     * page : 1
     */

    private int totalElements;
    private int size;
    private int totalPages;
    private int page;
    private List<UsersBean> users;

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<UsersBean> getUsers() {
        return users;
    }

    public void setUsers(List<UsersBean> users) {
        this.users = users;
    }

    public static class UsersBean {
        /**
         * birthday : 1993-01-01
         * sweep : 18
         * country : 江北区
         * sex : 男
         * merit : 0
         * avatar : https://ancestry-images.oss-cn-chengdu.aliyuncs.com/user/2019-08/ANC_1565939253516669951.jpg
         * province : 重庆市
         * name : 周靖杰
         * wangyicloudAccid : 045cc099d14f4b0f87efe65efc300417
         * tribute : 0
         */

        private String birthday;
        private int sweep;
        private String country;
        private String sex;
        private int merit;
        private String avatar;
        private String province;
        private String name;
        private String wangyicloudAccid;
        private int tribute;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getSweep() {
            return sweep;
        }

        public void setSweep(int sweep) {
            this.sweep = sweep;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getMerit() {
            return merit;
        }

        public void setMerit(int merit) {
            this.merit = merit;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
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

        public String getWangyicloudAccid() {
            return wangyicloudAccid;
        }

        public void setWangyicloudAccid(String wangyicloudAccid) {
            this.wangyicloudAccid = wangyicloudAccid;
        }

        public int getTribute() {
            return tribute;
        }

        public void setTribute(int tribute) {
            this.tribute = tribute;
        }
    }
}
