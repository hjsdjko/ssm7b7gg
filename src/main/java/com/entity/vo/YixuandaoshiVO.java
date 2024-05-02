package com.entity.vo;

import com.entity.YixuandaoshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 已选导师
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public class YixuandaoshiVO  implements Serializable {
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
	 * 学工号
	 */
	
	private String xuegonghao;
		
	/**
	 * 学生姓名
	 */
	
	private String xueshengxingming;
		
	/**
	 * 志愿顺序
	 */
	
	private String zhiyuanshunxu;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
	 * 设置：学工号
	 */
	 
	public void setXuegonghao(String xuegonghao) {
		this.xuegonghao = xuegonghao;
	}
	
	/**
	 * 获取：学工号
	 */
	public String getXuegonghao() {
		return xuegonghao;
	}
				
	
	/**
	 * 设置：学生姓名
	 */
	 
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
				
	
	/**
	 * 设置：志愿顺序
	 */
	 
	public void setZhiyuanshunxu(String zhiyuanshunxu) {
		this.zhiyuanshunxu = zhiyuanshunxu;
	}
	
	/**
	 * 获取：志愿顺序
	 */
	public String getZhiyuanshunxu() {
		return zhiyuanshunxu;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
