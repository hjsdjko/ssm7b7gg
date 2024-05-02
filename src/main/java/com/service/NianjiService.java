package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NianjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NianjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NianjiView;


/**
 * 年级
 *
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface NianjiService extends IService<NianjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NianjiVO> selectListVO(Wrapper<NianjiEntity> wrapper);
   	
   	NianjiVO selectVO(@Param("ew") Wrapper<NianjiEntity> wrapper);
   	
   	List<NianjiView> selectListView(Wrapper<NianjiEntity> wrapper);
   	
   	NianjiView selectView(@Param("ew") Wrapper<NianjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NianjiEntity> wrapper);
   	
}

