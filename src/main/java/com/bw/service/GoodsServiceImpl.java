package com.bw.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.bean.Brand;
import com.bw.bean.Goods;
import com.bw.bean.Kind;
import com.bw.mapper.GoodsMapper;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	
	public List<Goods> queryAll() {
		return goodsMapper.queryAll();
	}

	public List<Brand> queryBrand() {
		return goodsMapper.queryBrand();
	}

	public List<Kind> queryKind() {
		return goodsMapper.queryKind();
	}

	public void addGoods(Goods goods) {
		goodsMapper.addGoods(goods);
	}

	public Goods queryGoodsById(Integer id) {
		return goodsMapper.queryGoodsById(id);
	}

	public void update(Goods goods) {
		goodsMapper.update(goods);
	}

	public void delGoods(String gid) {
		goodsMapper.delGoods(gid);
	}

}
