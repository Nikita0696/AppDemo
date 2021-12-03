package com.example.appdemo.VolleyandRetrofitAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

        @SerializedName("RespId")
        @Expose
        private String respId;
        @SerializedName("ResponseMessage")
        @Expose
        private String responseMessage;
        @SerializedName("Id")
        @Expose
        private Integer id;
        @SerializedName("UserId")
        @Expose
        private String userId;
        @SerializedName("UserCode")
        @Expose
        private String userCode;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("Address")
        @Expose
        private Object address;
        @SerializedName("Pincode")
        @Expose
        private Object pincode;
        @SerializedName("Mobile")
        @Expose
        private String mobile;
        @SerializedName("Email")
        @Expose
        private Object email;
        @SerializedName("Role")
        @Expose
        private String role;
        @SerializedName("LoginType")
        @Expose
        private String loginType;
        @SerializedName("Company")
        @Expose
        private String company;
        @SerializedName("API_Key")
        @Expose
        private Object aPIKey;
        @SerializedName("access_token")
        @Expose
        private String accessToken;
        @SerializedName("token_type")
        @Expose
        private String tokenType;
        @SerializedName("expires_in")
        @Expose
        private String expiresIn;
        @SerializedName("_issued")
        @Expose
        private Object issued;
        @SerializedName("_expires")
        @Expose
        private Object expires;
        @SerializedName("error")
        @Expose
        private Object error;
        @SerializedName("error_description")
        @Expose
        private Object errorDescription;
        @SerializedName("Parent")
        @Expose
        private Object parent;
        @SerializedName("Center")
        @Expose
        private UserModel userModel;

        public String getRespId() {
            return respId;
        }

        public void setRespId(String respId) {
            this.respId = respId;
        }

        public String getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getPincode() {
            return pincode;
        }

        public void setPincode(Object pincode) {
            this.pincode = pincode;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getLoginType() {
            return loginType;
        }

        public void setLoginType(String loginType) {
            this.loginType = loginType;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public Object getAPIKey() {
            return aPIKey;
        }

        public void setAPIKey(Object aPIKey) {
            this.aPIKey = aPIKey;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

        public String getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(String expiresIn) {
            this.expiresIn = expiresIn;
        }

        public Object getIssued() {
            return issued;
        }

        public void setIssued(Object issued) {
            this.issued = issued;
        }

        public Object getExpires() {
            return expires;
        }

        public void setExpires(Object expires) {
            this.expires = expires;
        }

        public Object getError() {
            return error;
        }

        public void setError(Object error) {
            this.error = error;
        }

        public Object getErrorDescription() {
            return errorDescription;
        }

        public void setErrorDescription(Object errorDescription) {
            this.errorDescription = errorDescription;
        }

        public Object getParent() {
            return parent;
        }

        public void setParent(Object parent) {
            this.parent = parent;
        }

        public UserModel getUserModel() {
            return userModel;
        }

        public void setCenter(UserModel center) {
            this.userModel = center;
        }
        public class Example
        {
            @SerializedName("CenterId")
            @Expose
            private String centerId;
            @SerializedName("Name")
            @Expose
            private String name;
            @SerializedName("Addres")
            @Expose
            private Object addres;
            @SerializedName("Pincode")
            @Expose
            private Object pincode;
            @SerializedName("Mobile")
            @Expose
            private Object mobile;
            @SerializedName("Email")
            @Expose
            private Object email;
            @SerializedName("Type")
            @Expose
            private String type;
            @SerializedName("ContactPerson")
            @Expose
            private Object contactPerson;
            @SerializedName("ContactPersonNo")
            @Expose
            private Object contactPersonNo;

            public String getCenterId() {
                return centerId;
            }

            public void setCenterId(String centerId) {
                this.centerId = centerId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getAddres() {
                return addres;
            }

            public void setAddres(Object addres) {
                this.addres = addres;
            }

            public Object getPincode() {
                return pincode;
            }

            public void setPincode(Object pincode) {
                this.pincode = pincode;
            }

            public Object getMobile() {
                return mobile;
            }

            public void setMobile(Object mobile) {
                this.mobile = mobile;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Object getContactPerson() {
                return contactPerson;
            }

            public void setContactPerson(Object contactPerson) {
                this.contactPerson = contactPerson;
            }

            public Object getContactPersonNo() {
                return contactPersonNo;
            }

            public void setContactPersonNo(Object contactPersonNo) {
                this.contactPersonNo = contactPersonNo;
            }


        }
}
