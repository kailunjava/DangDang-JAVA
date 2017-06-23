package com.zzu.action;

import java.util.ArrayList;
import java.util.List;

import com.zzu.entity.Category;
import com.zzu.entity.Product;
import com.zzu.service.CategoryService;
import com.zzu.service.ProductService;
import com.zzu.service.impl.CategoryServiceImpl;
import com.zzu.service.impl.ProductServiceImpl;

public class BookListAction {
	private List<Product> one;// 图书列表集合
	private Category c;// 显示图书列表左侧
	private Category c1;// 根据parent_id判断需要查询的图书
	private List<Product> fen1 = new ArrayList<Product>();// 分页显示
	private int pageNow = 1;// 希望显示第几页 默认显示第一页,当前页码
	private int pageCount;// 一共有多少页 ——通过计算得到，总页数

	private CategoryService service = new CategoryServiceImpl();// 获得分类信息service层
	private ProductService ps = new ProductServiceImpl();// 获得商品相关service层

	public List<Product> getOne() {
		return one;
	}

	public void setOne(List<Product> one) {
		this.one = one;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public List<Product> getFen1() {
		return fen1;
	}

	public void setFen1(List<Product> fen1) {
		this.fen1 = fen1;
	}

	public Category getC() {
		return c;
	}

	public void setC(Category c) {
		this.c = c;
	}

	public Category getC1() {
		return c1;
	}

	public void setC1(Category c1) {
		this.c1 = c1;
	}

	/**
	 * 根据用户点击超链接判断显示内容,并且分页显示数据
	 */
	public String bookList() {
		// 判断当前页码，如果大于总页数则显示最大页数
		// 小于最小页则显示最小页
		if (pageNow > pageCount) {
			pageNow = pageCount;
		}
		if (pageNow < 1) {
			pageNow = 1;
		}
		int pageSize = 3;// 每页显示多少条记录，每页显示数量
		int rowCount;// 一共有多少条记录 ——从数据库查询，总数据量
		int start = (pageNow - 1) * pageSize;// 第n页的起始查询数据
        //
		List<Product> list = new ArrayList<Product>();
		List<Category> list1 = new ArrayList<Category>();
		// 根据id查询一级分类信息
		c = service.queryCategoryByFirstId(c.getId());
		// 统计属于一级分类的图书的数量
		list = ps.queryProductByOne(c.getId());
		c.setCount(list.size());
		// 统计属于二级分类的图书的数量
		list1 = c.getCategorys();
		for (int i = 0; i < list1.size(); i++) {
			list1.get(i).setCount(
					ps.queryProductByTwo(list1.get(i).getId()).size());
		}
        //
		c1 = service.queryCategoryByFirstId(c1.getId());

		if (c1.getParent_id() != null) {
			// 如果是二级分类的图书，则计算二级分类图书量
			one = ps.queryProductByTwo(c1.getId());
			rowCount = one.size();
		} else {
			// 如果是一级分类的图书，则计算二级分类图书量
			one = ps.queryProductByOne(c1.getId());
			rowCount = one.size();
		}
		// 计算 pageCount一共分多少页
		pageCount = (rowCount + pageSize - 1) / pageSize;
		// 如果总页数为0，那么修改当前页为第0页
		if (pageCount == 0) {
			pageNow = 0;
		}
		// 设置每一页从开始遍历到第几个数据
		int count = pageSize + start;
		// 如果count大于总数据量则把count设为总数据量
		if (rowCount % pageSize != 0) {
			if (count > rowCount) {
				count = rowCount;
			}
		}
		if (c1.getParent_id() != null) {
			if (rowCount != 0) {
				for (int i = start; i < count; i++) {
					fen1.add(one.get(i));
				}
			}
		} else {
			if (rowCount != 0) {
				for (int i = start; i < count; i++) {
					fen1.add(one.get(i));
				}
			}
		}
		return "yes";
	}

}
