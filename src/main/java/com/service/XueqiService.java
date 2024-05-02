package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueqiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueqiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueqiView;


/**
 * 学期
 *
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface XueqiService extends IService<XueqiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueqiVO> selectListVO(Wrapper<XueqiEntity> wrapper);
   	
   	XueqiVO selectVO(@Param("ew") Wrapper<XueqiEntity> wrapper);
   	
   	List<XueqiView> selectListView(Wrapper<XueqiEntity> wrapper);
   	
   	XueqiView selectView(@Param("ew") Wrapper<XueqiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueqiEntity> wrapper);
   	
}

