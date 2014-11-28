package com.izpzp.mash.task;
import java.io.IOException;


/**
 * FileName: DoMain.java
 * Author:   wormchaos
 * Date:     2014-11-6 上午11:54:45
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
public class DoMain {
    public static void main(String[] args) throws IOException {
        CachedThreadPool pool = CachedThreadPool.createThreadPool();
        for (int i = 13070000; i <= 13079999; i++) {
            Runnable thread = CrawThreadFactory.createThread(i);
            pool.execute(thread);
        }
    }
}
