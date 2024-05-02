package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YixuandaoshiEntity;
import com.entity.view.YixuandaoshiView;

import com.service.YixuandaoshiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 已选导师
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
@RestController
@RequestMapping("/yixuandaoshi")
public class YixuandaoshiController {
    @Autowired
    private YixuandaoshiService yixuandaoshiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YixuandaoshiEntity yixuandaoshi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("daoshi")) {
			yixuandaoshi.setDaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			yixuandaoshi.setXuegonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YixuandaoshiEntity> ew = new EntityWrapper<YixuandaoshiEntity>();
		PageUtils page = yixuandaoshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yixuandaoshi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YixuandaoshiEntity yixuandaoshi, 
		HttpServletRequest request){
        EntityWrapper<YixuandaoshiEntity> ew = new EntityWrapper<YixuandaoshiEntity>();
		PageUtils page = yixuandaoshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yixuandaoshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YixuandaoshiEntity yixuandaoshi){
       	EntityWrapper<YixuandaoshiEntity> ew = new EntityWrapper<YixuandaoshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yixuandaoshi, "yixuandaoshi")); 
        return R.ok().put("data", yixuandaoshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YixuandaoshiEntity yixuandaoshi){
        EntityWrapper< YixuandaoshiEntity> ew = new EntityWrapper< YixuandaoshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yixuandaoshi, "yixuandaoshi")); 
		YixuandaoshiView yixuandaoshiView =  yixuandaoshiService.selectView(ew);
		return R.ok("查询已选导师成功").put("data", yixuandaoshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YixuandaoshiEntity yixuandaoshi = yixuandaoshiService.selectById(id);
        return R.ok().put("data", yixuandaoshi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YixuandaoshiEntity yixuandaoshi = yixuandaoshiService.selectById(id);
        return R.ok().put("data", yixuandaoshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YixuandaoshiEntity yixuandaoshi, HttpServletRequest request){
    	yixuandaoshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yixuandaoshi);

        yixuandaoshiService.insert(yixuandaoshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody YixuandaoshiEntity yixuandaoshi, HttpServletRequest request){
    	yixuandaoshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yixuandaoshi);

        yixuandaoshiService.insert(yixuandaoshi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YixuandaoshiEntity yixuandaoshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yixuandaoshi);
        yixuandaoshiService.updateById(yixuandaoshi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yixuandaoshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YixuandaoshiEntity> wrapper = new EntityWrapper<YixuandaoshiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("daoshi")) {
			wrapper.eq("daoshizhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuegonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yixuandaoshiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
