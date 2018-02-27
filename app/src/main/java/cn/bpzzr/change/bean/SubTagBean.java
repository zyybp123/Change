package cn.bpzzr.change.bean;

/**
 * Created by Administrator on 2018/2/27.
 * test select more tag   subTag
 */

class SubTagBean {
    private String name;
    private int id;

    public SubTagBean(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
