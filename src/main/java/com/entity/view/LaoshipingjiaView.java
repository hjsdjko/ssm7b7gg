package com.entity.view;

import com.entity.LaoshipingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 老师评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
@TableName("laoshipingjia")
public class LaoshipingjiaView  extends LaoshipingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LaoshipingjiaView(){
	}
 
 	public LaoshipingjiaView(LaoshipingjiaEntity laoshipingjiaEntity){
 	try {
			BeanUtils.copyProperties(this, laoshipingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
