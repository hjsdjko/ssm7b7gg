package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YixuandaoshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YixuandaoshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YixuandaoshiView;


/**
 * 已选导师
 *
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface YixuandaoshiService extends IService<YixuandaoshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YixuandaoshiVO> selectListVO(Wrapper<YixuandaoshiEntity> wrapper);
   	
   	YixuandaoshiVO selectVO(@Param("ew") Wrapper<YixuandaoshiEntity> wrapper);
   	
   	List<YixuandaoshiView> selectListView(Wrapper<YixuandaoshiEntity> wrapper);
   	
   	YixuandaoshiView selectView(@Param("ew") Wrapper<YixuandaoshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YixuandaoshiEntity> wrapper);
   	
}

