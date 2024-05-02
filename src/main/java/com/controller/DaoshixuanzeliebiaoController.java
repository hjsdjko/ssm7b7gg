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

import com.entity.DaoshixuanzeliebiaoEntity;
import com.entity.view.DaoshixuanzeliebiaoView;

import com.service.DaoshixuanzeliebiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 导师选择列表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-23 13:26:15
 */
@RestController
@RequestMapping("/daoshixuanzeliebiao")
public class DaoshixuanzeliebiaoController {
    @Autowired
    private DaoshixuanzeliebiaoService daoshixuanzeliebiaoService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaoshixuanzeliebiaoEntity daoshixuanzeliebiao, 
		HttpServletRequest request){

        EntityWrapper<DaoshixuanzeliebiaoEntity> ew = new EntityWrapper<DaoshixuanzeliebiaoEntity>();
		PageUtils page = daoshixuanzeliebiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoshixuanzeliebiao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DaoshixuanzeliebiaoEntity daoshixuanzeliebiao, 
		HttpServletRequest request){
        EntityWrapper<DaoshixuanzeliebiaoEntity> ew = new EntityWrapper<DaoshixuanzeliebiaoEntity>();
		PageUtils page = daoshixuanzeliebiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoshixuanzeliebiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaoshixuanzeliebiaoEntity daoshixuanzeliebiao){
       	EntityWrapper<DaoshixuanzeliebiaoEntity> ew = new EntityWrapper<DaoshixuanzeliebiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daoshixuanzeliebiao, "daoshixuanzeliebiao")); 
        return R.ok().put("data", daoshixuanzeliebiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaoshixuanzeliebiaoEntity daoshixuanzeliebiao){
        EntityWrapper< DaoshixuanzeliebiaoEntity> ew = new EntityWrapper< DaoshixuanzeliebiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daoshixuanzeliebiao, "daoshixuanzeliebiao")); 
		DaoshixuanzeliebiaoView daoshixuanzeliebiaoView =  daoshixuanzeliebiaoService.selectView(ew);
		return R.ok("查询导师选择列表成功").put("data", daoshixuanzeliebiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DaoshixuanzeliebiaoEntity daoshixuanzeliebiao = daoshixuanzeliebiaoService.selectById(id);
		daoshixuanzeliebiao.setClicknum(daoshixuanzeliebiao.getClicknum()+1);
		daoshixuanzeliebiao.setClicktime(new Date());
		daoshixuanzeliebiaoService.updateById(daoshixuanzeliebiao);
        return R.ok().put("data", daoshixuanzeliebiao);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DaoshixuanzeliebiaoEntity daoshixuanzeliebiao = daoshixuanzeliebiaoService.selectById(id);
		daoshixuanzeliebiao.setClicknum(daoshixuanzeliebiao.getClicknum()+1);
		daoshixuanzeliebiao.setClicktime(new Date());
		daoshixuanzeliebiaoService.updateById(daoshixuanzeliebiao);
        return R.ok().put("data", daoshixuanzeliebiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DaoshixuanzeliebiaoEntity daoshixuanzeliebiao, HttpServletRequest request){
    	daoshixuanzeliebiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoshixuanzeliebiao);

        daoshixuanzeliebiaoService.insert(daoshixuanzeliebiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody DaoshixuanzeliebiaoEntity daoshixuanzeliebiao, HttpServletRequest request){
    	daoshixuanzeliebiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoshixuanzeliebiao);

        daoshixuanzeliebiaoService.insert(daoshixuanzeliebiao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DaoshixuanzeliebiaoEntity daoshixuanzeliebiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daoshixuanzeliebiao);
        daoshixuanzeliebiaoService.updateById(daoshixuanzeliebiao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        daoshixuanzeliebiaoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DaoshixuanzeliebiaoEntity> wrapper = new EntityWrapper<DaoshixuanzeliebiaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = daoshixuanzeliebiaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DaoshixuanzeliebiaoEntity daoshixuanzeliebiao, HttpServletRequest request,String pre){
        EntityWrapper<DaoshixuanzeliebiaoEntity> ew = new EntityWrapper<DaoshixuanzeliebiaoEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = daoshixuanzeliebiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoshixuanzeliebiao), params), params));
        return R.ok().put("data", page);
    }


}
