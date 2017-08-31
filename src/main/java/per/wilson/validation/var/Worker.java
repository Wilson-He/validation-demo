package per.wilson.validation.var;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/30
 */
public interface Worker {
    List<String> STATUS = Lists.newArrayList("ENABLE", "UNABLE");
    List<String> SEX = Lists.newArrayList("FEMALE", "MALE");
}
