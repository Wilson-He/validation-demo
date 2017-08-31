package per.wilson.validation;

import org.junit.Test;

import java.util.regex.Pattern;


/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/29
 */
public class AllTest {
    @Test
    public void testRegexp() {
        //输出true
        Pattern patternA = Pattern.compile("AAA||BBB");
        System.out.println("PatternA:" + patternA.matcher("").matches());
        //输出false
        Pattern patternB = Pattern.compile("AAA|BBB");
        System.out.println("PatternB:" + patternB.matcher("").matches());
    }

}
