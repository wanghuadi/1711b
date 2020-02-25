package com.bw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bw.bean.Brand;
import com.bw.bean.Goods;
import com.bw.bean.Kind;

public interface GoodsMapper {
	
	public List<Goods> queryAll();

	public List<Brand> queryBrand();

	public List<Kind> queryKind();

	public void addGoods(Goods goods);

	public Goods queryGoodsById(Integer id);

	public void update(Goods goods);

	public void delGoods(@Param("gid")String gid);
}
