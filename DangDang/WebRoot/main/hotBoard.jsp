<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
		<div class="book_r_border2" id="__XinShuReMai">
			<div class="book_r_b2_1x" id="new_bang">
				<h2 class="t_xsrm">
							新书热卖榜
				</h2>
				  <div id="NewProduct_1_o_t" onmouseover="">	
				  <s:iterator value="hotborad" var="h">	
				  <a href="
				  <s:url action='detail' namespace='/mainAction'>
			<s:param name='product.id'><s:property value='id'/></s:param>
		</s:url>
		" ><s:property value="#h.product_name"/></a><br/>	
				  </s:iterator>	
						<!--  <h3 class="second">-->
					
				<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
				<!--</h3>-->
			 </div>
		</div>
	</div>