package com.example.appdemo.PostApiCalling;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestDataModel {
    @SerializedName("ALL_LEAVES")
    private List<ALLLEAVESDTO> all_leaves;
    private String Ecode;
    public List<ALLLEAVESDTO> getAllleaves() {
        return all_leaves;
    }

    public void setAllleaves(List<ALLLEAVESDTO> all_leaves) {
        this.all_leaves = all_leaves;
    }

    public String getEcode() {
        return Ecode;
    }

    public void setEcode(String ecode) {
        Ecode = ecode;
    }



    public static class ALLLEAVESDTO {

        @SerializedName("ACTION")
        private String ACTION;
        @SerializedName("LEAVE_ID")
        private String leave_id;

        public String getAction() {
            return ACTION;
        }

        public void setAction(String action) {
            this.ACTION = action;
        }

        public String getLeaveId() {
            return leave_id;
        }

        public void setLeaveId(String leaveId) {
            this.leave_id = leaveId;
        }


    }
}
