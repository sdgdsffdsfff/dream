package com.izpzp.mash.task;

/**
 * FileName: CrawThreadFactory.java
 * Author:   wormchaos
 * Date:     2014-11-6 下午2:55:05
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CrawThreadFactory{

    // public static Runnable createThread() {
    // return new CrawThread();
    // }

    public static Runnable createThread(int i) {
        return new CrawThread(i);
    }

}
