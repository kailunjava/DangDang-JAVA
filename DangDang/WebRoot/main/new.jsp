<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--新上架图书A开始-->
	<s:iterator value="neww" var="n">
	<div class="second_d_wai">
		<div class="img">
			<a href="<s:url action='detail' namespace='/mainAction'>
			<s:param name='product.id'><s:property value='id'/></s:param>
		</s:url>"><img
					src="../productImages/<s:property value="#n.picture"/>" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="<s:url action='detail' namespace='/mainAction'>
			<s:param name='product.id'><s:property value='id'/></s:param>
		</s:url>" ><s:property value="#n.product_name"/></a>
		</div>
		<div class="price">
			定价：￥<s:property value="#n.fixed_price "/>
		</div>
		<div class="price">
			当当价：￥<s:property value="#n.dang_price "/>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</s:iterator>
	<!--新上架图书A结束-->

</div>
<div class="clear"></div>