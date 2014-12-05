/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: Mash.java
 * Author:   izpzp
 * Date:     2014-11-5 下午1:57:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

/**
 * 比较类<br> 
 * 比较类- Elo Rating排名算法
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Mash {
    /**
     * 排名分数Ra
     */
    private Long Ra;
    /**
     * 排名分数Rb
     */
    private Long Rb;
    
    /**
     * 期望值Ea
     */
    private Double Ea;
    
    /**
     * 期望值Eb
     */
    private Double Eb;
    
    /**
     * 本局a获得分数
     */
    private int Sa;
    
    /**
     * 本局b获得分数
     */
    private int Sb;
    
    /**
     * K为常数，数值越大比分变动越快
     */
    private int K = 5;
    
    /**
     * 
     */
    public Mash() {
        super();
    }
    
    /**
     * @param ra
     * @param rb
     */
    public Mash(Long ra, Long rb) {
        super();
        Ra = ra;
        Rb = rb;
        this.setE();
    }
    
    /**
     * @param ra
     * @param rb
     */
    public Mash(Long ra, Long rb, int Sa, int Sb) {
        super();
        this.Ra = ra;
        this.Rb = rb;
        this.Sa = Sa;
        this.Sb = Sb;
        this.setE();
    }
    
    /**
     * 功能描述: <br>
     * 计算期望值
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void setE(){
        this.Ea = (1/(1 + java.lang.Math.pow(10,((double)(Rb-Ra)/400))));
        this.Ea = new  java.math.BigDecimal(Ea).setScale(2,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
        this.Eb = (1/(1 + java.lang.Math.pow(10,((double)(Ra-Rb)/400))));
        this.Eb = new  java.math.BigDecimal(Eb).setScale(2,java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    /*
     * 获取a获得分数
     */
    public Long getAScore(){
        Long score = (long) (this.Ra + K*(this.Sa - Ea));
        if(this.Sa == this.Sb){
            score = this.Ra;
        }
        if(score < 0){
            score = 0L;
        }
        return score;
    }
    
    /*
     * 获得b获得分数
     */
    public Long getBScore(){
        Long score = (long) (this.Rb + K*(this.Sb - Eb));
        if(this.Sa == this.Sb){
            score = this.Rb;
        }
        if(score < 0){
            score = 0L;
        }
        return score;
    }

    /**
     * @return the ra
     */
    public Long getRa() {
        return Ra;
    }

    /**
     * @param ra the ra to set
     */
    public void setRa(Long ra) {
        Ra = ra;
    }

    /**
     * @return the rb
     */
    public Long getRb() {
        return Rb;
    }

    /**
     * @param rb the rb to set
     */
    public void setRb(Long rb) {
        Rb = rb;
    }

    /**
     * @return the ea
     */
    public Double getEa() {
        return Ea;
    }

    /**
     * @param ea the ea to set
     */
    public void setEa(Double ea) {
        Ea = ea;
    }

    /**
     * @return the eb
     */
    public Double getEb() {
        return Eb;
    }

    /**
     * @param eb the eb to set
     */
    public void setEb(Double eb) {
        Eb = eb;
    }

    /**
     * @return the sa
     */
    public int getSa() {
        return Sa;
    }

    /**
     * @param sa the sa to set
     */
    public void setSa(int sa) {
        Sa = sa;
    }

    /**
     * @return the sb
     */
    public int getSb() {
        return Sb;
    }

    /**
     * @param sb the sb to set
     */
    public void setSb(int sb) {
        Sb = sb;
    }

    /**
     * @return the k
     */
    public int getK() {
        return K;
    }

    /**
     * @param k the k to set
     */
    public void setK(int k) {
        K = k;
    }
    
}
