package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YanjiufangxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YanjiufangxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YanjiufangxiangView;


/**
 * 研究方向
 *
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
public interface YanjiufangxiangService extends IService<YanjiufangxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YanjiufangxiangVO> selectListVO(Wrapper<YanjiufangxiangEntity> wrapper);
   	
   	YanjiufangxiangVO selectVO(@Param("ew") Wrapper<YanjiufangxiangEntity> wrapper);
   	
   	List<YanjiufangxiangView> selectListView(Wrapper<YanjiufangxiangEntity> wrapper);
   	
   	YanjiufangxiangView selectView(@Param("ew") Wrapper<YanjiufangxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YanjiufangxiangEntity> wrapper);
   	
}

