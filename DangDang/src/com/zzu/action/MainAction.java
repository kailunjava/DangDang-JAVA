package com.zzu.action;

import java.util.List;

import com.zzu.entity.Category;
import com.zzu.entity.Product;
import com.zzu.service.CategoryService;
import com.zzu.service.ProductService;
import com.zzu.service.impl.CategoryServiceImpl;
import com.zzu.service.impl.ProductServiceImpl;

public class MainAction {
	private List<Category> category;// 分类信息集合
	private List<Product> recommend;// 编辑推荐集合
	private List<Product> hot;// 热销图书集合
	private List<Product> neww;// 热销图书集合
	private List<Product> hotborad;// 新书热卖榜集合
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public List<Product> getRecommend() {
		return recommend;
	}

	public void setRecommend(List<Product> recommend) {
		this.recommend = recommend;
	}

	public List<Product> getHot() {
		return hot;
	}

	public void setHot(List<Product> hot) {
		this.hot = hot;
	}

	public List<Product> getNeww() {
		return neww;
	}

	public void setNeww(List<Product> neww) {
		this.neww = neww;
	}

	public List<Product> getHotborad() {
		return hotborad;
	}

	public void setHotborad(List<Product> hotborad) {
		this.hotborad = hotborad;
	}

	private CategoryService service = new CategoryServiceImpl();// 获得分类信息service层
	private ProductService ps = new ProductServiceImpl();//获得商品的service层
    /**
     * 主页面加载各个模块的信息
     */
	public String main() {
		category = service.queryAll();

		recommend = ps.queryTuiJian();

		hot = ps.queryHot();

		neww = ps.queryNew();

		hotborad = ps.queryProductHotBorad();

		return "yes";
	}

	/**
	 * 查询图书详细信息
	 * 
	 */
	public String detail() {
		// 调用service中根据id查询图书的方法， 将数据赋值给action的实例变量		
		product = ps.queryProductById(product.getId());

		return "yes";
	}

}
