package com.example.azheng.rxjavamvpdemo.bean;

import java.util.List;


/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * https://github.com/764990722
 * 类 描 述：
 */
public class LoginBean{

    /**
     * userToken : l4bnvakjd9b7vpj7ms945k60sd
     * apiToken : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJEbWZWOW1hWFY0SXhodG81VTNDazVLbkVwd1k3V1NaVyIsImF1ZCI6IlJzVm02V1d0cDdaS3RuYzlUeGNPTHM2eTRJOU5WRXRWIiwiaXNzIjoibnZFbjVBMk05RVRzNUdCNDVvM1RsbHRvZUZ4T2doRHIiLCJ1c2VyU2lkIjoiMyIsImV4cCI6MTU2ODM2NjkyNCwiaWF0IjoxNTY3NzYyMTI0fQ.aMF0LFp8rWrGk2_eLuxP6T8zSd61-HFC2KrTP74ec0I
     * complete : true
     * user : {"lastRecord":{"bloodCircleCountryText":"江北区","ancestralSurnameText":"周","ancestralProvinceText":"重庆","bloodCircleCountrySid":3338,"ancestralCountrySid":3338,"bloodCircleSurnameText":"周","bloodCircleProvinceText":"重庆","ancestralCountryText":"江北区","bloodCircleSurnameSid":5,"ancestralProvinceSid":32,"bloodCircleProvinceSid":32,"ancestralSurnameSid":5},"wangyicloud":{"token":"da742d7a647ee8f503637f69b1d96905","name":"周靖杰","accid":"045cc099d14f4b0f87efe65efc300417"},"banners":[],"surname":{"sameSurname":true,"prefixName":"周","baiduLink":"https://baike.baidu.com/item/周姓","sid":5},"person":{"editOriginTimes":"2","birthday":"1993-01-01","country":"江北区","provinceSid":32,"countrySid":3338,"hasPwd":true,"sex":"男","buddyQuantity":"6","avatar":"https://ancestry-images.oss-cn-chengdu.aliyuncs.com/user/2019-08/ANC_1565939253516669951.jpg","familyGroupQuantity":"3","province":"重庆市","phone":"17320378805","name":"周靖杰","suffixName":"靖杰","editPersonTimes":"3","age":26},"dynamic":{"countryAncestral":false,"chineseAncestral":false,"provinceAncestral":false,"provinceCircle":false,"countryCircle":false,"chineseCircle":false}}
     */

    private String userToken;
    private String apiToken;
    private boolean complete;
    private UserBean user;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * lastRecord : {"bloodCircleCountryText":"江北区","ancestralSurnameText":"周","ancestralProvinceText":"重庆","bloodCircleCountrySid":3338,"ancestralCountrySid":3338,"bloodCircleSurnameText":"周","bloodCircleProvinceText":"重庆","ancestralCountryText":"江北区","bloodCircleSurnameSid":5,"ancestralProvinceSid":32,"bloodCircleProvinceSid":32,"ancestralSurnameSid":5}
         * wangyicloud : {"token":"da742d7a647ee8f503637f69b1d96905","name":"周靖杰","accid":"045cc099d14f4b0f87efe65efc300417"}
         * banners : []
         * surname : {"sameSurname":true,"prefixName":"周","baiduLink":"https://baike.baidu.com/item/周姓","sid":5}
         * person : {"editOriginTimes":"2","birthday":"1993-01-01","country":"江北区","provinceSid":32,"countrySid":3338,"hasPwd":true,"sex":"男","buddyQuantity":"6","avatar":"https://ancestry-images.oss-cn-chengdu.aliyuncs.com/user/2019-08/ANC_1565939253516669951.jpg","familyGroupQuantity":"3","province":"重庆市","phone":"17320378805","name":"周靖杰","suffixName":"靖杰","editPersonTimes":"3","age":26}
         * dynamic : {"countryAncestral":false,"chineseAncestral":false,"provinceAncestral":false,"provinceCircle":false,"countryCircle":false,"chineseCircle":false}
         */

        private LastRecordBean lastRecord;
        private WangyicloudBean wangyicloud;
        private SurnameBean surname;
        private PersonBean person;
        private DynamicBean dynamic;
        private List<?> banners;

        public LastRecordBean getLastRecord() {
            return lastRecord;
        }

        public void setLastRecord(LastRecordBean lastRecord) {
            this.lastRecord = lastRecord;
        }

        public WangyicloudBean getWangyicloud() {
            return wangyicloud;
        }

        public void setWangyicloud(WangyicloudBean wangyicloud) {
            this.wangyicloud = wangyicloud;
        }

        public SurnameBean getSurname() {
            return surname;
        }

        public void setSurname(SurnameBean surname) {
            this.surname = surname;
        }

        public PersonBean getPerson() {
            return person;
        }

        public void setPerson(PersonBean person) {
            this.person = person;
        }

        public DynamicBean getDynamic() {
            return dynamic;
        }

        public void setDynamic(DynamicBean dynamic) {
            this.dynamic = dynamic;
        }

        public List<?> getBanners() {
            return banners;
        }

        public void setBanners(List<?> banners) {
            this.banners = banners;
        }

        public static class LastRecordBean {
            /**
             * bloodCircleCountryText : 江北区
             * ancestralSurnameText : 周
             * ancestralProvinceText : 重庆
             * bloodCircleCountrySid : 3338
             * ancestralCountrySid : 3338
             * bloodCircleSurnameText : 周
             * bloodCircleProvinceText : 重庆
             * ancestralCountryText : 江北区
             * bloodCircleSurnameSid : 5
             * ancestralProvinceSid : 32
             * bloodCircleProvinceSid : 32
             * ancestralSurnameSid : 5
             */

            private String bloodCircleCountryText;
            private String ancestralSurnameText;
            private String ancestralProvinceText;
            private int bloodCircleCountrySid;
            private int ancestralCountrySid;
            private String bloodCircleSurnameText;
            private String bloodCircleProvinceText;
            private String ancestralCountryText;
            private int bloodCircleSurnameSid;
            private int ancestralProvinceSid;
            private int bloodCircleProvinceSid;
            private int ancestralSurnameSid;

            public String getBloodCircleCountryText() {
                return bloodCircleCountryText;
            }

            public void setBloodCircleCountryText(String bloodCircleCountryText) {
                this.bloodCircleCountryText = bloodCircleCountryText;
            }

            public String getAncestralSurnameText() {
                return ancestralSurnameText;
            }

            public void setAncestralSurnameText(String ancestralSurnameText) {
                this.ancestralSurnameText = ancestralSurnameText;
            }

            public String getAncestralProvinceText() {
                return ancestralProvinceText;
            }

            public void setAncestralProvinceText(String ancestralProvinceText) {
                this.ancestralProvinceText = ancestralProvinceText;
            }

            public int getBloodCircleCountrySid() {
                return bloodCircleCountrySid;
            }

            public void setBloodCircleCountrySid(int bloodCircleCountrySid) {
                this.bloodCircleCountrySid = bloodCircleCountrySid;
            }

            public int getAncestralCountrySid() {
                return ancestralCountrySid;
            }

            public void setAncestralCountrySid(int ancestralCountrySid) {
                this.ancestralCountrySid = ancestralCountrySid;
            }

            public String getBloodCircleSurnameText() {
                return bloodCircleSurnameText;
            }

            public void setBloodCircleSurnameText(String bloodCircleSurnameText) {
                this.bloodCircleSurnameText = bloodCircleSurnameText;
            }

            public String getBloodCircleProvinceText() {
                return bloodCircleProvinceText;
            }

            public void setBloodCircleProvinceText(String bloodCircleProvinceText) {
                this.bloodCircleProvinceText = bloodCircleProvinceText;
            }

            public String getAncestralCountryText() {
                return ancestralCountryText;
            }

            public void setAncestralCountryText(String ancestralCountryText) {
                this.ancestralCountryText = ancestralCountryText;
            }

            public int getBloodCircleSurnameSid() {
                return bloodCircleSurnameSid;
            }

            public void setBloodCircleSurnameSid(int bloodCircleSurnameSid) {
                this.bloodCircleSurnameSid = bloodCircleSurnameSid;
            }

            public int getAncestralProvinceSid() {
                return ancestralProvinceSid;
            }

            public void setAncestralProvinceSid(int ancestralProvinceSid) {
                this.ancestralProvinceSid = ancestralProvinceSid;
            }

            public int getBloodCircleProvinceSid() {
                return bloodCircleProvinceSid;
            }

            public void setBloodCircleProvinceSid(int bloodCircleProvinceSid) {
                this.bloodCircleProvinceSid = bloodCircleProvinceSid;
            }

            public int getAncestralSurnameSid() {
                return ancestralSurnameSid;
            }

            public void setAncestralSurnameSid(int ancestralSurnameSid) {
                this.ancestralSurnameSid = ancestralSurnameSid;
            }
        }

        public static class WangyicloudBean {
            /**
             * token : da742d7a647ee8f503637f69b1d96905
             * name : 周靖杰
             * accid : 045cc099d14f4b0f87efe65efc300417
             */

            private String token;
            private String name;
            private String accid;

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAccid() {
                return accid;
            }

            public void setAccid(String accid) {
                this.accid = accid;
            }
        }

        public static class SurnameBean {
            /**
             * sameSurname : true
             * prefixName : 周
             * baiduLink : https://baike.baidu.com/item/周姓
             * sid : 5
             */

            private boolean sameSurname;
            private String prefixName;
            private String baiduLink;
            private int sid;

            public boolean isSameSurname() {
                return sameSurname;
            }

            public void setSameSurname(boolean sameSurname) {
                this.sameSurname = sameSurname;
            }

            public String getPrefixName() {
                return prefixName;
            }

            public void setPrefixName(String prefixName) {
                this.prefixName = prefixName;
            }

            public String getBaiduLink() {
                return baiduLink;
            }

            public void setBaiduLink(String baiduLink) {
                this.baiduLink = baiduLink;
            }

            public int getSid() {
                return sid;
            }

            public void setSid(int sid) {
                this.sid = sid;
            }
        }

        public static class PersonBean {
            /**
             * editOriginTimes : 2
             * birthday : 1993-01-01
             * country : 江北区
             * provinceSid : 32
             * countrySid : 3338
             * hasPwd : true
             * sex : 男
             * buddyQuantity : 6
             * avatar : https://ancestry-images.oss-cn-chengdu.aliyuncs.com/user/2019-08/ANC_1565939253516669951.jpg
             * familyGroupQuantity : 3
             * province : 重庆市
             * phone : 17320378805
             * name : 周靖杰
             * suffixName : 靖杰
             * editPersonTimes : 3
             * age : 26
             */

            private String editOriginTimes;
            private String birthday;
            private String country;
            private int provinceSid;
            private int countrySid;
            private boolean hasPwd;
            private String sex;
            private String buddyQuantity;
            private String avatar;
            private String familyGroupQuantity;
            private String province;
            private String phone;
            private String name;
            private String suffixName;
            private String editPersonTimes;
            private int age;

            public String getEditOriginTimes() {
                return editOriginTimes;
            }

            public void setEditOriginTimes(String editOriginTimes) {
                this.editOriginTimes = editOriginTimes;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public int getProvinceSid() {
                return provinceSid;
            }

            public void setProvinceSid(int provinceSid) {
                this.provinceSid = provinceSid;
            }

            public int getCountrySid() {
                return countrySid;
            }

            public void setCountrySid(int countrySid) {
                this.countrySid = countrySid;
            }

            public boolean isHasPwd() {
                return hasPwd;
            }

            public void setHasPwd(boolean hasPwd) {
                this.hasPwd = hasPwd;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getBuddyQuantity() {
                return buddyQuantity;
            }

            public void setBuddyQuantity(String buddyQuantity) {
                this.buddyQuantity = buddyQuantity;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getFamilyGroupQuantity() {
                return familyGroupQuantity;
            }

            public void setFamilyGroupQuantity(String familyGroupQuantity) {
                this.familyGroupQuantity = familyGroupQuantity;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSuffixName() {
                return suffixName;
            }

            public void setSuffixName(String suffixName) {
                this.suffixName = suffixName;
            }

            public String getEditPersonTimes() {
                return editPersonTimes;
            }

            public void setEditPersonTimes(String editPersonTimes) {
                this.editPersonTimes = editPersonTimes;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }

        public static class DynamicBean {
            /**
             * countryAncestral : false
             * chineseAncestral : false
             * provinceAncestral : false
             * provinceCircle : false
             * countryCircle : false
             * chineseCircle : false
             */

            private boolean countryAncestral;
            private boolean chineseAncestral;
            private boolean provinceAncestral;
            private boolean provinceCircle;
            private boolean countryCircle;
            private boolean chineseCircle;

            public boolean isCountryAncestral() {
                return countryAncestral;
            }

            public void setCountryAncestral(boolean countryAncestral) {
                this.countryAncestral = countryAncestral;
            }

            public boolean isChineseAncestral() {
                return chineseAncestral;
            }

            public void setChineseAncestral(boolean chineseAncestral) {
                this.chineseAncestral = chineseAncestral;
            }

            public boolean isProvinceAncestral() {
                return provinceAncestral;
            }

            public void setProvinceAncestral(boolean provinceAncestral) {
                this.provinceAncestral = provinceAncestral;
            }

            public boolean isProvinceCircle() {
                return provinceCircle;
            }

            public void setProvinceCircle(boolean provinceCircle) {
                this.provinceCircle = provinceCircle;
            }

            public boolean isCountryCircle() {
                return countryCircle;
            }

            public void setCountryCircle(boolean countryCircle) {
                this.countryCircle = countryCircle;
            }

            public boolean isChineseCircle() {
                return chineseCircle;
            }

            public void setChineseCircle(boolean chineseCircle) {
                this.chineseCircle = chineseCircle;
            }
        }
    }
}
