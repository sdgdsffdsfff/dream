package com.izpzp.mash.task;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FileName: CachedThreadPool.java
 * Author:   wormchaos
 * Date:     2014-11-6 上午11:59:05
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
public class CachedThreadPool {

    /**
     * 连接数
     */
    private int CONNECT_NUM = 10;

    /**
     * 
     */
    private static ExecutorService pool;

    private static CachedThreadPool cachedThreadPool;

    private CachedThreadPool() {
        pool = Executors.newFixedThreadPool(CONNECT_NUM);
    }

    public static CachedThreadPool createThreadPool() {
        if (null == pool) {
            synchronized (CachedThreadPool.class) {
                if (null == pool) {
                    // 创建一个可重用固定线程数的线程池
                    cachedThreadPool = new CachedThreadPool();
                }
            }
        }
        return cachedThreadPool;
    }

    public void execute(Runnable... threads) {
        for (int i = 0; i < threads.length; i++) {
            pool.execute(threads[i]);
        }
    }

    public void close() {
        if (null != pool) {
            // 关闭线程池
            pool.shutdown();
        }
    }
}
