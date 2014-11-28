package com.izpzp.mash.task;

import com.izpzp.mash.entity.MashInfo;
import com.izpzp.mash.task.utils.ConnectionUtils;

/**
 * FileName: CrawThread.java
 * Author:   wormchaos
 * Date:     2014-11-6 下午2:44:18
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
public class CrawThread implements Runnable {

    private int userId;

    public CrawThread(int userId) {
        this.userId = userId;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        ConnectionUtils hp = new ConnectionUtils();
        String result = hp.connect("http://weibo.cnsuning.com/index.php?mod=" + userId);
        sealResult(result, String.valueOf(userId));
    }

    private MashInfo sealResult(String result) {
        try {
            String string = result.split("<div class=\"avatar_left\">")[1].split("</div>")[0];
            String name = string.split("title=\"")[2].split("\"")[0];
            String image = string.split("<img src=\"")[1].split("\"")[0];
            MashInfo bean = new MashInfo();
            bean.setMashContent(image);
            bean.setUserName(name);
            return bean;
        } catch (Exception e) {
            // 异常说明工号不存在
        }
        return null;
    }

    private void sealResult(String result, String userId) {
        MashInfo bean = sealResult(result);
        if (null == bean) {
            // 告知数据库已经查过，但是没有该用户
            return;
        }
        // TODO 插入数据库
        System.out.println(userId + " " + bean.getUserName() + (bean.getMashContent().contains("no.gif") ? "" : bean
                .getMashContent()));
    }

}
