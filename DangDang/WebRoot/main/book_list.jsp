<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript" src="../js/prototype-1.6.0.3.js">
		</script>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		
		<s:iterator value="c" var="c1">
		
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href="<s:url action='main' namespace='/mainAction'></s:url>">当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong><s:property value="#c1.category_name" /></strong> </font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										&middot;<a href="
		                             <s:url action='booklist' namespace='/bookAction'>
			                           <s:param name='c.id'><s:property value='#c1.id'/></s:param>
			                           <s:param name='c1.id'><s:property value='#c1.id'/></s:param>			
                                         </s:url>
		                            "><s:property value="#c1.category_name" />&nbsp;
										(<s:property value="#c1.count" />)</a>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<s:iterator value="#c1.categorys" var="c2">
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
							<a href="<s:url action='booklist' namespace='/bookAction'>			
		                    <s:param name='c.id'><s:property value='#c2.parent_id'/></s:param>
			                <s:param name='c1.id'><s:property value='#c2.id'/></s:param>
                            </s:url>"><s:property value="#c2.category_name"/>&nbsp;
										(<s:property value="#c2.count"/>)</a>
									</div>
								</div>
							</li>
						    
							<div class="clear"></div>
							</s:iterator>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
						</s:iterator>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="
									<s:url action='booklist' namespace='/bookAction'>
			                        <s:param name='pageNow'><s:property value='1'/></s:param>
			                        <s:param name='pageCount'><s:property value='pageCount'/></s:param>
			                        <s:param name='c.id'><s:property value='c.id'/></s:param>
			                        <s:param name='c1.id'><s:property value='c1.id'/></s:param>
                                    </s:url>
									">
								<s:if test="pageNow<=1"><img src='../images/page_up_gray.gif' /></s:if>
								<s:else><img src='../images/page_up.gif' /></s:else>
								</a>
							</div>
	
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="
									<s:url action='booklist' namespace='/bookAction'>
			                        <s:param name='pageNow'><s:property value='pageNow-1'/></s:param>
			                        <s:param name='pageCount'><s:property value='pageCount'/></s:param>
			                        <s:param name='c.id'><s:property value='c.id'/></s:param>
			                        <s:param name='c1.id'><s:property value='c1.id'/></s:param>
                                    </s:url>
									">
								<s:if test="pageNow<=1"><img src='../images/page_up_gray.gif' /></s:if>
								<s:else><img src='../images/page_up.gif' /></s:else>
								</a>
							</div>
				
							<div class='list_r_title_text3b'>
								第<s:property value="pageNow"/>页/共<s:property value="pageCount"/>页
							</div>
							
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="
									<s:url action='booklist' namespace='/bookAction'>
			                        <s:param name='pageNow'><s:property value='pageNow+1'/></s:param>
			                        <s:param name='pageCount'><s:property value='pageCount'/></s:param>
			                        <s:param name='c.id'><s:property value='c.id'/></s:param>
			                        <s:param name='c1.id'><s:property value='c1.id'/></s:param>
                                    </s:url>
									">
								<s:if test="pageNow>=pageCount"><img src='../images/page_down_gray.gif' /></s:if>
								<s:else><img src='../images/page_down_mouseover.gif' /></s:else>
								 </a>
							</div>
			
							<div class='list_r_title_text3a'>
							<a name=link_page_next
									href="
									<s:url action='booklist' namespace='/bookAction'>
			                        <s:param name='pageNow'><s:property value='pageCount'/></s:param>
			                        <s:param name='pageCount'><s:property value='pageCount'/></s:param>
			                        <s:param name='c.id'><s:property value='c.id'/></s:param>
			                        <s:param name='c1.id'><s:property value='c1.id'/></s:param>
                                    </s:url>
									">
								<s:if test="pageNow>=pageCount"><img src='../images/page_down_gray.gif' /></s:if>
								<s:else><img src='../images/page_down_mouseover.gif' /></s:else>							
								</a>
							</div>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<s:iterator value="fen1" var="p">
						<div class="list_r_line"></div>
						<div class="clear"></div>

						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href="<s:url action='detail' namespace='/mainAction'>
			                      <s:param name='product.id'><s:property value='id'/></s:param>
		                          </s:url>">
								<img src="../productImages/<s:property value="picture"/>" /> </a> </span>
							<h2>
								<a name="link_prd_name" href="<s:url action='detail' namespace='/mainAction'>
			                      <s:param name='product.id'><s:property value='id'/></s:param>
		                          </s:url>"><s:property value="product_name"/></a>
							</h2>
							<h3>
								顾客评分：100
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name='作者'><s:property value="author"/></a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'><s:property value="publishing"/></a>
							</h4>
							<h4>
								出版时间：<s:property value=" publish_time"/>
							</h4>
							<h5>
								内容简介：<s:property value="content_introduce"/>
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥<s:property value="fixed_price"/></span>
								<span class="red">￥<s:property value="dang_price"/></span>
								节省：￥<s:property value="fixed_price-dang_price"/>
							</h6>
							<span class="list_r_list_button"> 
							<a href="
							  <s:url action='addCartItem' namespace='/cartAction'>
			                     <s:param name='id'><s:property value='id'/></s:param>
		                      </s:url>
							"> 
							<img src='../images/buttom_goumai.gif' /> </a>
							<span id="cartinfo"></span>
						</div>
						<div class="clear"></div>
               			</s:iterator>						
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
