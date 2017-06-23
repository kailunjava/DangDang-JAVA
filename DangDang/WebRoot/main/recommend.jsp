<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!-- target='_blank' -->
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	 <s:iterator value="recommend" var="r">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href="<s:url action='detail' namespace='/mainAction'>
			<s:param name='product.id'><s:property value='id'/></s:param>
		</s:url>" ><img src='../productImages/<s:property value="#r.picture"/>' width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href="<s:url action='detail' namespace='/mainAction'>
			<s:param name='product.id'><s:property value='id'/></s:param>
		</s:url>"  title='输赢'><s:property value="#r.product_name"/></a>
				</h3>
				<h4>
					作者：<s:property value="#r.author"/> 著
					<br />
					出版社：<s:property value="#r.publishing"/>&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：<s:property value="#r.publish_time "/>
				</h4>
				<h5>
					简介:<s:property value="#r.content_introduce "/>
				</h5>
				<h6>
					定价：￥<s:property value="#r.fixed_price "/>&nbsp;&nbsp;
					当当价：￥<s:property value="#r.dang_price "/>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
  </s:iterator>
		
	</div>
</div>
