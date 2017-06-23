package com.zzu.entity;

import java.util.Date;
/**
 * 商品实体
 * @author Administrator
 *
 */
public class Product {
    private Integer id;                      //id
    private String product_name;             //商品名称
    private String author;                   //作者
    private String publishing;               //出版社
    private Date publish_time;               //出版时间
    private Date putaway_time;               //上架时间
    private Date print_time;                 //印刷时间
    private Double fixed_price;              //定价
    private Double dang_price;               //当当价
    private Integer which_edtion;            //版次
    private Integer word_number;             //字数
    private Integer total_page;              //页数
    private Integer kaiben;                  //开本
    private Integer print_count;             //印次
    private String paper_sheet;              //纸张
    private Integer isbn;                    //isbn码
    private String baozhuang;                //包装
    private String edit_recommend;           //编辑推荐
    private String content_introduce;        //内容简介
    private String writer_introduce;         //作者简介
    private String catelog;                  //目录
    private String media_comments;           //媒体评论
    private String excerpt;                  //书摘
    private String picture;                  //图片名
    private Integer sales_count;             //销量
    private Integer kucun;                   //库存
    private Integer click_rate;              //点击量
    private Integer category_id;             //类别
    
    
    public Product(){}
	public Product(Integer id, String product_name, String author,
			String publishing, Date publish_time, Date putaway_time,
			Date print_time, Double fixed_price, Double dang_price,
			Integer which_edtion, Integer word_number, Integer total_page,
			Integer kaiben, Integer print_count, String paper_sheet,
			Integer isbn, String baozhuang, String edit_recommend,
			String content_introduce, String writer_introduce, String catelog,
			String media_comments, String excerpt, String picture,
			Integer sales_count, Integer kucun, Integer click_rate,
			Integer category_id) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.author = author;
		this.publishing = publishing;
		this.publish_time = publish_time;
		this.putaway_time = putaway_time;
		this.print_time = print_time;
		this.fixed_price = fixed_price;
		this.dang_price = dang_price;
		this.which_edtion = which_edtion;
		this.word_number = word_number;
		this.total_page = total_page;
		this.kaiben = kaiben;
		this.print_count = print_count;
		this.paper_sheet = paper_sheet;
		this.isbn = isbn;
		this.baozhuang = baozhuang;
		this.edit_recommend = edit_recommend;
		this.content_introduce = content_introduce;
		this.writer_introduce = writer_introduce;
		this.catelog = catelog;
		this.media_comments = media_comments;
		this.excerpt = excerpt;
		this.picture = picture;
		this.sales_count = sales_count;
		this.kucun = kucun;
		this.click_rate = click_rate;
		this.category_id = category_id;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
	public Date getPutaway_time() {
		return putaway_time;
	}
	public void setPutaway_time(Date putaway_time) {
		this.putaway_time = putaway_time;
	}
	public Date getPrint_time() {
		return print_time;
	}
	public void setPrint_time(Date print_time) {
		this.print_time = print_time;
	}
	public Double getFixed_price() {
		return fixed_price;
	}
	public void setFixed_price(Double fixed_price) {
		this.fixed_price = fixed_price;
	}
	public Double getDang_price() {
		return dang_price;
	}
	public void setDang_price(Double dang_price) {
		this.dang_price = dang_price;
	}
	public Integer getWhich_edtion() {
		return which_edtion;
	}
	public void setWhich_edtion(Integer which_edtion) {
		this.which_edtion = which_edtion;
	}
	public Integer getWord_number() {
		return word_number;
	}
	public void setWord_number(Integer word_number) {
		this.word_number = word_number;
	}
	public Integer getTotal_page() {
		return total_page;
	}
	public void setTotal_page(Integer total_page) {
		this.total_page = total_page;
	}
	public Integer getKaiben() {
		return kaiben;
	}
	public void setKaiben(Integer kaiben) {
		this.kaiben = kaiben;
	}
	public Integer getPrint_count() {
		return print_count;
	}
	public void setPrint_count(Integer print_count) {
		this.print_count = print_count;
	}
	public String getPaper_sheet() {
		return paper_sheet;
	}
	public void setPaper_sheet(String paper_sheet) {
		this.paper_sheet = paper_sheet;
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public String getBaozhuang() {
		return baozhuang;
	}
	public void setBaozhuang(String baozhuang) {
		this.baozhuang = baozhuang;
	}
	public String getEdit_recommend() {
		return edit_recommend;
	}
	public void setEdit_recommend(String edit_recommend) {
		this.edit_recommend = edit_recommend;
	}
	public String getContent_introduce() {
		return content_introduce;
	}
	public void setContent_introduce(String content_introduce) {
		this.content_introduce = content_introduce;
	}
	public String getWriter_introduce() {
		return writer_introduce;
	}
	public void setWriter_introduce(String writer_introduce) {
		this.writer_introduce = writer_introduce;
	}
	public String getCatelog() {
		return catelog;
	}
	public void setCatelog(String catelog) {
		this.catelog = catelog;
	}
	public String getMedia_comments() {
		return media_comments;
	}
	public void setMedia_comments(String media_comments) {
		this.media_comments = media_comments;
	}
	public String getExcerpt() {
		return excerpt;
	}
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getSales_count() {
		return sales_count;
	}
	public void setSales_count(Integer sales_count) {
		this.sales_count = sales_count;
	}
	public Integer getKucun() {
		return kucun;
	}
	public void setKucun(Integer kucun) {
		this.kucun = kucun;
	}
	public Integer getClick_rate() {
		return click_rate;
	}
	public void setClick_rate(Integer click_rate) {
		this.click_rate = click_rate;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name
				+ ", author=" + author + ", publishing=" + publishing
				+ ", publish_time=" + publish_time + ", putaway_time="
				+ putaway_time + ", print_time=" + print_time
				+ ", fixed_price=" + fixed_price + ", dang_price=" + dang_price
				+ ", which_edtion=" + which_edtion + ", word_number="
				+ word_number + ", total_page=" + total_page + ", kaiben="
				+ kaiben + ", print_count=" + print_count + ", paper_sheet="
				+ paper_sheet + ", isbn=" + isbn + ", baozhuang=" + baozhuang
				+ ", edit_recommend=" + edit_recommend + ", content_introduce="
				+ content_introduce + ", writer_introduce=" + writer_introduce
				+ ", catelog=" + catelog + ", media_comments=" + media_comments
				+ ", excerpt=" + excerpt + ", picture=" + picture
				+ ", sales_count=" + sales_count + ", kucun=" + kucun
				+ ", click_rate=" + click_rate + ", category_id=" + category_id
				+ "]";
	}
    
}
