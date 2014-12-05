/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: MashService.java
 * Author:   izpzp
 * Date:     2014-11-5 上午11:12:40
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;


/**
 * mash服务类<br> 
 * mash服务类
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface MashService {
    
    /**
     * 功能描述: <br>
     * 保存mash评价结果
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean saveMashResult(MashArg mashArg);
}
