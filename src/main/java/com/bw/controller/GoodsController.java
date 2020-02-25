package com.bw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.objenesis.instantiator.annotations.Typology;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bw.bean.Brand;
import com.bw.bean.Goods;
import com.bw.bean.Kind;
import com.bw.service.GoodsService;
import com.bw.utils.FileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class GoodsController {
	
	@Resource
	private GoodsService goodsService;
	
	
	/**
	 * 商品列表展示
	 * @param model
	 * @return
	 */
	@RequestMapping({"queryAll","/"})
	public String list(Model model,@RequestParam(defaultValue="1")Integer pageNum){
		PageHelper.startPage(pageNum, 2);
		List<Goods> list = goodsService.queryAll();
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		model.addAttribute("page", page);
		return "list";
	}

	
	@RequestMapping("queryBrandAndKind")
	@ResponseBody
	public Map<String, Object> queryBrandAndKind(Model model){
		//查询品牌列表
		List<Brand> listBrand = goodsService.queryBrand();
		
		//查询种类列表
		List<Kind> listKind = goodsService.queryKind();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("listBrand", listBrand);
		map.put("listKind", listKind);
		
		return map;
	}
	
	
	@RequestMapping("add")
	public String add(Goods goods,MultipartFile file) throws IllegalStateException, IOException{
		try {
			//图片上传   并返回图片路径
			String upload = FileUtils.upload(file);
			goods.setPicurl(upload);
			goodsService.addGoods(goods);
			return "redirect:queryAll";
		} catch (Exception e) {
			return "add";
		}
		
	}
	
	
	@RequestMapping("lookImg")
	public void lookImg(String path,HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg(path, request, response);
	}
	
	
	/**
	 * 商品详情
	 * @param id
	 * @return
	 */
	@RequestMapping("queryGoodsById")
	public String queryGoodsById(Integer id,Model model){
		//根据id查询商品信息
		Goods goods = goodsService.queryGoodsById(id);
		model.addAttribute("goods", goods);
		//跳转页面，回显数据
		return "show";
	}
	
	
	
	
	/**
	 * 商品详情
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("update")
	public String update(Goods goods,MultipartFile file) throws IllegalStateException, IOException{
		
		try {
			String upload = FileUtils.upload(file);
			goods.setPicurl(upload);
			//修改
			goodsService.update(goods);
			return "redirect:queryAll";
		} catch (Exception e) {
			return "show";
		}
	}
	
	@RequestMapping("delGoods")
	@ResponseBody
	public boolean delGoods(String gid){
		
		try {
			goodsService.delGoods(gid);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
}
