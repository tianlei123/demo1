package com.tianlei.dao;

import org.springframework.stereotype.Repository;
@Repository("tos")
public class tos {
        private String YY;
        private String YJSJ;
        private String YJSJMS;
        private String FZR;
        private String StData;
        private String EndData;
        private String WCData;
        private String GS ;

        public String getYY() {
            return YY;
        }

        public void setYY(String YY) {
            this.YY = YY;
        }

        public String getYJSJ() {
            return YJSJ;
        }

        public void setYJSJ(String YJSJ) {
            this.YJSJ = YJSJ;
        }

        public String getYJSJMS() {
            return YJSJMS;
        }

        public void setYJSJMS(String YJSJMS) {
            this.YJSJMS = YJSJMS;
        }

        public String getFZR() {
            return FZR;
        }

        public void setFZR(String FZR) {
            this.FZR = FZR;
        }

        public String getStData() {
            return StData;
        }

        public void setStData(String stData) {
            StData = stData;
        }

        public String getEndData() {
            return EndData;
        }

        public void setEndData(String endData) {
            EndData = endData;
        }

        public String getWCData() {
            return WCData;
        }

        public void setWCData(String WCData) {
            this.WCData = WCData;
        }

        public String getGS() {
            return GS;
        }

        public void setGS(String GS) {
            this.GS = GS;
        }


}
