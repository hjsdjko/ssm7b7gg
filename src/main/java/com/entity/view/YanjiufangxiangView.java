package com.entity.view;

import com.entity.YanjiufangxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 研究方向
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
@TableName("yanjiufangxiang")
public class YanjiufangxiangView  extends YanjiufangxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YanjiufangxiangView(){
	}
 
 	public YanjiufangxiangView(YanjiufangxiangEntity yanjiufangxiangEntity){
 	try {
			BeanUtils.copyProperties(this, yanjiufangxiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
