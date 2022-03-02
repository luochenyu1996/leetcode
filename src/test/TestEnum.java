package test;

public enum TestEnum {

    Chrome("Chrome",""),
    FireFox("Firefox",""),
    Safari("Safari","");


    private String  type;
    private String version;



    TestEnum(String type,String version ) {
        this.version = version;
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return
                type  +" " +version ;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
