package com.example.braintech.restrofitandroiddemo.moedel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HealthList {


    @SerializedName("Successful")
        @Expose
        private Boolean successful;
        @SerializedName("Message")
        @Expose
        private String message;
        @SerializedName("Value")
        @Expose
        private ArrayList<Value> value = null;

        public Boolean getSuccessful() {
            return successful;
        }

        public void setSuccessful(Boolean successful) {
            this.successful = successful;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ArrayList<Value> getValue() {
            return value;
        }

        public void setValue(ArrayList<Value> value) {
            this.value = value;
        }

        public class Value {

            @SerializedName("ID")
            @Expose
            private Integer iD;
            @SerializedName("Name")
            @Expose
            private String name;

            public Integer getID() {
                return iD;
            }

            public void setID(Integer iD) {
                this.iD = iD;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

        }

    }








