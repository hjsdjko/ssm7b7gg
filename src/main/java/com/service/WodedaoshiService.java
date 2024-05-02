package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WodedaoshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WodedaoshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WodedaoshiView;


/**
 * 我的导师
 *
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface WodedaoshiService extends IService<WodedaoshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WodedaoshiVO> selectListVO(Wrapper<WodedaoshiEntity> wrapper);
   	
   	WodedaoshiVO selectVO(@Param("ew") Wrapper<WodedaoshiEntity> wrapper);
   	
   	List<WodedaoshiView> selectListView(Wrapper<WodedaoshiEntity> wrapper);
   	
   	WodedaoshiView selectView(@Param("ew") Wrapper<WodedaoshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WodedaoshiEntity> wrapper);
   	
}

