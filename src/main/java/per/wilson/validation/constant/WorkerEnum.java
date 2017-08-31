package per.wilson.validation.constant;

import per.wilson.validation.var.Worker;

import java.util.List;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/30
 */
public enum WorkerEnum {
    STATUS(Worker.STATUS),
    SEX( Worker.SEX);

    public List<String> list;

    WorkerEnum( List<String> list) {
        this.list = list;
    }

    public boolean check(String name) {
        return this.list.contains(name);
    }
}
