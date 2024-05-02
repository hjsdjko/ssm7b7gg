package com.entity.vo;

import com.entity.DaoshixuanzeliebiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 导师选择列表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public class DaoshixuanzeliebiaoVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 导师姓名
	 */
	
	private String daoshixingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 职称
	 */
	
	private String zhicheng;
		
	/**
	 * 邮箱
	 */
	
	private String youxiang;
		
	/**
	 * 研究方向
	 */
	
	private String yanjiufangxiang;
		
	/**
	 * 研究方向介绍
	 */
	
	private String yanjiufangxiangjieshao;
		
	/**
	 * 个人简介
	 */
	
	private String gerenjianjie;
		
	/**
	 * 学术成果
	 */
	
	private String xueshuchengguo;
		
	/**
	 * 照片
	 */
	
	private String zhaopian;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：导师姓名
	 */
	 
	public void setDaoshixingming(String daoshixingming) {
		this.daoshixingming = daoshixingming;
	}
	
	/**
	 * 获取：导师姓名
	 */
	public String getDaoshixingming() {
		return daoshixingming;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：职称
	 */
	 
	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}
	
	/**
	 * 获取：职称
	 */
	public String getZhicheng() {
		return zhicheng;
	}
				
	
	/**
	 * 设置：邮箱
	 */
	 
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}
	
	/**
	 * 获取：邮箱
	 */
	public String getYouxiang() {
		return youxiang;
	}
				
	
	/**
	 * 设置：研究方向
	 */
	 
	public void setYanjiufangxiang(String yanjiufangxiang) {
		this.yanjiufangxiang = yanjiufangxiang;
	}
	
	/**
	 * 获取：研究方向
	 */
	public String getYanjiufangxiang() {
		return yanjiufangxiang;
	}
				
	
	/**
	 * 设置：研究方向介绍
	 */
	 
	public void setYanjiufangxiangjieshao(String yanjiufangxiangjieshao) {
		this.yanjiufangxiangjieshao = yanjiufangxiangjieshao;
	}
	
	/**
	 * 获取：研究方向介绍
	 */
	public String getYanjiufangxiangjieshao() {
		return yanjiufangxiangjieshao;
	}
				
	
	/**
	 * 设置：个人简介
	 */
	 
	public void setGerenjianjie(String gerenjianjie) {
		this.gerenjianjie = gerenjianjie;
	}
	
	/**
	 * 获取：个人简介
	 */
	public String getGerenjianjie() {
		return gerenjianjie;
	}
				
	
	/**
	 * 设置：学术成果
	 */
	 
	public void setXueshuchengguo(String xueshuchengguo) {
		this.xueshuchengguo = xueshuchengguo;
	}
	
	/**
	 * 获取：学术成果
	 */
	public String getXueshuchengguo() {
		return xueshuchengguo;
	}
				
	
	/**
	 * 设置：照片
	 */
	 
	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}
	
	/**
	 * 获取：照片
	 */
	public String getZhaopian() {
		return zhaopian;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
