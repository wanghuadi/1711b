package com.bw.service;

import java.util.List;

import com.bw.bean.Brand;
import com.bw.bean.Goods;
import com.bw.bean.Kind;

public interface GoodsService {
	
	public List<Goods> queryAll();

	public List<Brand> queryBrand();

	public List<Kind> queryKind();

	public void addGoods(Goods goods);

	public Goods queryGoodsById(Integer id);

	public void update(Goods goods);

	public void delGoods(String gid);
}
