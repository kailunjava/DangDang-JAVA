<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
<HEAD>
<TITLE>发现孩子(蒙台梭利儿童教育经典原著) - 图书 - 当当网</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../product_files/dangdang.css" type=text/css rel=Stylesheet>
<LINK href="../product_files/book.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function addProduct(img, productId) {
		$("#buy").css("display", "none");
		$("#cartInfo_" + productId)
				.html(
						'<img align="bottom" src="../images/load.gif" width="14" height="14" style="display:inline" align="bottom"/>&nbsp;购买中...');
		$
				.getJSON(
						"../cart/addItem.action",
						{
							id : productId,
							time : (new Date()).getTime()
						},
						function(json) {
							console.log(JSON.parse(json));
							console.log(json.count);
							if (json.count == 0) {
								//没有添加成功
								$("#buy").css("display", "block");
								$("#cartInfo_" + productId)
										.html(
												'<img align="bottom" src="../images/wrong.gif" width="14" height="14" style="display:inline" align="bottom"/>&nbsp;<span style="color:red">购买失败</span>');
							} else {
								//添加成功
								$("#cartInfo_" + productId)
										.html(
												'<img align="bottom" src="../images/right.gif" width="14" height="14" style="display:inline" align="bottom"/>&nbsp;购买成功');
								var timeId = setTimeout(function() {
									clearTimeout(timeId);
									$("#buy").css("display", "block");
									$("#cartInfo_" + productId).html("");
								}, 2000);
							}
						});
	}
</script>
</HEAD>
<BODY>
	<!-- 头部开始 -->
	<%@include file="../common/head1.jsp"%>
	<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 10; POSITION: absolute"></DIV>
	<DIV id=div_shield></DIV>
	<DIV id=main>
		<DIV class=mainsearch></DIV>
		<DIV class=wrap>
			<!--left start-->
			<!--left end-->
			<DIV class=right>
				<DIV class=right_wai>
					<DIV class=shuming>
						<DIV class=shuming_left>
							<SPAN class=black000><A name=top_bk></A>
							<s:property value="product.product_name" /></SPAN>
						</DIV>
						<DIV class=book_case>
							<SPAN class=seriesname>丛书名： <s:property
									value="product.product_name" /></SPAN>
						</DIV>
						<DIV class=empty_box></DIV>
					</DIV>
					<DIV class=book_left>
						<DIV class=book_pic>
							<A
								href="javascript:ImgBtnChgPrd_Click(this,'http://img39.ddimg.cn/93/5/20867709-1_o.jpg')"
								name=bigpicture_bk><IMG id=img_show_prd
								src="../productImages/<s:property value="product.picture"/>"></A>
						</DIV>
						<INPUT id=hid_largepictureurl type=hidden>
					</DIV>
					<DIV class=book_right>
						<DIV id=author_>
							作 者：
							<s:property value="product.author" />
						</DIV>
						<DIV id=publisher_>
							出 版 社：
							<s:property value="product.publishing" />
						</DIV>
						<UL>
							<LI>出版时间： <s:date name="product.publish_time "
									format="yyyy-MM-dd" /></LI>
							<LI>字 数： <s:property value="product.word_number" /></LI>
							<LI>版 次： <s:property value="product.which_edtion" /></LI>
							<LI>页 数： <s:property value="product.total_page" /></LI>
							<LI>印刷时间： <s:date name="product.print_time"
									format="yyyy-MM-dd" /></LI>
							<LI>开 本： <s:property value="product.kaiben" />开
							</LI>
							<LI>印 次： <s:property value="product.print_count" /></LI>
							<LI>纸 张： <s:property value="product.paper_sheet" />胶版纸
							</LI>
							<LI>I S B N ： <s:property value="product.isbn" /></LI>
							<LI>包 装： <s:property value="product.baozhuang" /></LI>
						</UL>
						<DIV id=__categroy_bk>
							所属分类： <A class=blue12a
								href="http://product.dangdang.com/category.ashx?code=01.00.00.00.00.00"
								target=_blank><s:property value="product.category.categoryName"/></A><!--  &gt;&gt; <A class=blue12a
								href="http://product.dangdang.com/category.ashx?code=01.30.00.00.00.00"
								target=_blank>社会科学</A> &gt;&gt; <A class=blue12a
								href="http://product.dangdang.com/category.ashx?code=01.30.07.00.00.00"
								target=_blank>教育</A> &gt;&gt; <A class=blue12a
								href="http://product.dangdang.com/category.ashx?code=01.30.07.04.00.00"
								target=_blank>各级教育</A> -->
						</DIV>
						<DIV class=jiage>
							<SPAN class=gray87>定价：<SPAN class=del id=originalPriceTag>￥<s:property
										value="product.fixed_price" /></SPAN></SPAN> <br/><SPAN class=redc30>当当价：￥<B><s:property
										value="product.dang_price" /></B></SPAN><br/> 节省：￥
							<s:property value="product.fixed_price - product.dang_price " />
							<DIV class=pd_buy_num>
								<DIV class=clear></DIV>
							</DIV>
							<DIV class=goumai>
								<!--  <A title=购买
									onclick="addProduct(this,<s:property value="product.id"/>)"
									name=purchase_book> <IMG id="buy"
									src="../product_files/booksale.gif"><span
									id="cartInfo_<s:property value="product.id"/>"></span></A>-->
									<a href="
							  <s:url action='addCartItem' namespace='/cartAction'>
			                     <s:param name='id'><s:property value='product.id'/></s:param>
		                      </s:url>
							"> 
							<img src='../images/buttom_goumai.gif' /> </a>
								<!--  <A id=favor title=收藏 href="#" name=wishlist_book>
<IMG id=imgfavor src="../product_files/bookz_save.gif"></A>
-->
							</DIV>

						</DIV>
					</DIV>
					<DIV id=dvTPUrls></DIV>
					<DIV id=__zhinengbiaozhu_bk>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							编辑推荐
						</H2>
						<DIV class=zhengwen>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<s:property value="product.edit_recommend" />
						</DIV>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							内容简介
						</H2>
						<DIV class=zhengwen>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<s:property value="product.content_introduce" />
						</DIV>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							作者简介
						</H2>
						<DIV class=zhengwen>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<%-- <s:property value="product.author" /> --%>
							<s:property value="product.writer_introduce" />
						</DIV>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							目录
						</H2>
						<DIV class=zhengwen>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<s:property value="product.catelog" />
						</DIV>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							媒体评论
						</H2>
						<DIV class=zhengwen>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<s:property value="product.media_comments" />
						</DIV>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							书摘插图
						</H2>
						<DIV class=zhengwen>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<s:property value="product.excerpt" />
						</DIV>
					</DIV>
					<A name=review_point></A>
				</DIV>
			</DIV>
			<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
			<DIV id=tag_box_pay
				style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
			<DIV id=div_shield></DIV>
			<!--页尾 开始 -->
			<DIV class=public_footer_add_s></DIV>
			<!--09.3.10new-->
			<!--页尾 end -->
			<!--页尾开始 -->
			<%@include file="../common/foot.jsp"%>
			<!--页尾结束 -->
</BODY>
</HTML>

