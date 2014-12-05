/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: MashServiceImpl.java
 * Author:   izpzp
 * Date:     2014-11-5 上午11:12:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izpzp.mash.intf.Mash;
import com.izpzp.mash.intf.MashArg;
import com.izpzp.mash.intf.MashInfoDao;
import com.izpzp.mash.intf.MashService;
import com.izpzp.mash.intf.dto.MashInfoBean;

/**
 * mash服务实现类<br> 
 * mash服务实现类
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class MashServiceImpl implements MashService {

    @Autowired
    MashInfoDao mashInfoDao;
    
    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MashService#saveMashResult(com.izpzp.mash.intf.MashArg)
     */
    public boolean saveMashResult(MashArg mashArg) {
        if(checkMashArg(mashArg)){
            MashInfoBean mashA = mashInfoDao.getMashInfo(mashArg.getMashAid());
            MashInfoBean mashB = mashInfoDao.getMashInfo(mashArg.getMashBid());
            int[] S = this.getScore(mashArg);
            Mash mash = new Mash(mashA.getMashValue(), mashB.getMashValue(), S[0], S[1]);
            //更新分数
            MashInfoBean modMashA = new MashInfoBean();
            modMashA.setMashValue(mash.getAScore());
            modMashA.setMashId(mashA.getMashId());
            modMashA.setMashNum(mashA.getMashNum() + 1);
            MashInfoBean modMashB = new MashInfoBean();
            modMashB.setMashValue(mash.getBScore());
            modMashB.setMashId(mashB.getMashId());
            modMashB.setMashNum(mashB.getMashNum() + 1);
            mashInfoDao.updateMashInfo(modMashA);
            mashInfoDao.updateMashInfo(modMashB);
        }
        return true;
    }
    
    /*
     * 获得本次得分情况-顺序由a到b
     */
    private int[] getScore(MashArg mashArg){
        int Sa = 0, Sb=0;
        if(mashArg.getMashAid() == mashArg.getWinId()){
            Sa = 1;
        }else if(mashArg.getMashAid() == mashArg.getWinId()){
            Sb = 1;
        }
        int[] result ={Sa, Sb};
        return result;
    }
    
    /*
     * 检查入参
     */
    private boolean checkMashArg(MashArg mashArg){
        boolean result = false;
        if(null != mashArg 
                && null != mashArg.getMashAid()
                && null != mashArg.getMashBid()
                ){
            result = true;
        }
        return result;
    }
    
}
