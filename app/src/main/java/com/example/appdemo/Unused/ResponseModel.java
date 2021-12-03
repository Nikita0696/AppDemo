package com.example.appdemo.Unused;

public class ResponseModel {

    private int id;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /*private String response;
    private String resId;
    private String timespan;
    private TestOutputDTO testOutput;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getTimespan() {
        return timespan;
    }

    public void setTimespan(String timespan) {
        this.timespan = timespan;
    }

    public TestOutputDTO getTestOutput() {
        return testOutput;
    }

    public void setTestOutput(TestOutputDTO testOutput) {
        this.testOutput = testOutput;
    }

    public static class TestOutputDTO {
        private List<DrtDataDTO> drtData;

        public List<DrtDataDTO> getDrtData() {
            return drtData;
        }

        public void setDrtData(List<DrtDataDTO> drtData) {
            this.drtData = drtData;
        }

        public static class DrtDataDTO {
            private String display;
            private String type;
            private int id;
            private boolean isbarcodeCompulsary;
            private List<TestDetailsDTO> testDetails;
            private List<FiledsDTO> fileds;
            private List<ResultDTO> result;

            public String getDisplay() {
                return display;
            }

            public void setDisplay(String display) {
                this.display = display;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isIsbarcodeCompulsary() {
                return isbarcodeCompulsary;
            }

            public void setIsbarcodeCompulsary(boolean isbarcodeCompulsary) {
                this.isbarcodeCompulsary = isbarcodeCompulsary;
            }

            public List<TestDetailsDTO> getTestDetails() {
                return testDetails;
            }

            public void setTestDetails(List<TestDetailsDTO> testDetails) {
                this.testDetails = testDetails;
            }

            public List<FiledsDTO> getFileds() {
                return fileds;
            }

            public void setFileds(List<FiledsDTO> fileds) {
                this.fileds = fileds;
            }

            public List<ResultDTO> getResult() {
                return result;
            }

            public void setResult(List<ResultDTO> result) {
                this.result = result;
            }

            public static class TestDetailsDTO {
                private int test;
                private String testName;
                private String sampleType;
                private int id;
                private int b2B;
                private int b2C;
                private String testCodeId;
                private String disclaimer;
                private String combination;
                private int isResultCompulsory;

                public int getTest() {
                    return test;
                }

                public void setTest(int test) {
                    this.test = test;
                }

                public String getTestName() {
                    return testName;
                }

                public void setTestName(String testName) {
                    this.testName = testName;
                }

                public String getSampleType() {
                    return sampleType;
                }

                public void setSampleType(String sampleType) {
                    this.sampleType = sampleType;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getB2B() {
                    return b2B;
                }

                public void setB2B(int b2B) {
                    this.b2B = b2B;
                }

                public int getB2C() {
                    return b2C;
                }

                public void setB2C(int b2C) {
                    this.b2C = b2C;
                }

                public String getTestCodeId() {
                    return testCodeId;
                }

                public void setTestCodeId(String testCodeId) {
                    this.testCodeId = testCodeId;
                }

                public String getDisclaimer() {
                    return disclaimer;
                }

                public void setDisclaimer(String disclaimer) {
                    this.disclaimer = disclaimer;
                }

                public String getCombination() {
                    return combination;
                }

                public void setCombination(String combination) {
                    this.combination = combination;
                }

                public int getIsResultCompulsory() {
                    return isResultCompulsory;
                }

                public void setIsResultCompulsory(int isResultCompulsory) {
                    this.isResultCompulsory = isResultCompulsory;
                }
            }

            public static class FiledsDTO {
                private String name;
                private String feildType;
                private int isActive;
                private int isCompulsary;
                private int minLength;
                private int maxLength;
                private Object moduleid;
                private int testid;
                private int sequence;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getFeildType() {
                    return feildType;
                }

                public void setFeildType(String feildType) {
                    this.feildType = feildType;
                }

                public int getIsActive() {
                    return isActive;
                }

                public void setIsActive(int isActive) {
                    this.isActive = isActive;
                }

                public int getIsCompulsary() {
                    return isCompulsary;
                }

                public void setIsCompulsary(int isCompulsary) {
                    this.isCompulsary = isCompulsary;
                }

                public int getMinLength() {
                    return minLength;
                }

                public void setMinLength(int minLength) {
                    this.minLength = minLength;
                }

                public int getMaxLength() {
                    return maxLength;
                }

                public void setMaxLength(int maxLength) {
                    this.maxLength = maxLength;
                }

                public Object getModuleid() {
                    return moduleid;
                }

                public void setModuleid(Object moduleid) {
                    this.moduleid = moduleid;
                }

                public int getTestid() {
                    return testid;
                }

                public void setTestid(int testid) {
                    this.testid = testid;
                }

                public int getSequence() {
                    return sequence;
                }

                public void setSequence(int sequence) {
                    this.sequence = sequence;
                }
            }

            public static class ResultDTO {
                private String result;
                private String prefix;
                private int id;
                private Object feildsName;
                private String subcategory;
                private int minval;
                private int maxval;
                private Object unit;
                private int istextbox;
                private int testCodeID;

                public String getResult() {
                    return result;
                }

                public void setResult(String result) {
                    this.result = result;
                }

                public String getPrefix() {
                    return prefix;
                }

                public void setPrefix(String prefix) {
                    this.prefix = prefix;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public Object getFeildsName() {
                    return feildsName;
                }

                public void setFeildsName(Object feildsName) {
                    this.feildsName = feildsName;
                }

                public String getSubcategory() {
                    return subcategory;
                }

                public void setSubcategory(String subcategory) {
                    this.subcategory = subcategory;
                }

                public int getMinval() {
                    return minval;
                }

                public void setMinval(int minval) {
                    this.minval = minval;
                }

                public int getMaxval() {
                    return maxval;
                }

                public void setMaxval(int maxval) {
                    this.maxval = maxval;
                }

                public Object getUnit() {
                    return unit;
                }

                public void setUnit(Object unit) {
                    this.unit = unit;
                }

                public int getIstextbox() {
                    return istextbox;
                }

                public void setIstextbox(int istextbox) {
                    this.istextbox = istextbox;
                }

                public int getTestCodeID() {
                    return testCodeID;
                }

                public void setTestCodeID(int testCodeID) {
                    this.testCodeID = testCodeID;
                }
            }
        }
    }*/
}
