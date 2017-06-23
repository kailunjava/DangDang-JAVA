<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<!--1级分类开始-->
		<s:iterator value="category" var="c1">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>				 						              		          		            
		    [<a href="
		    <s:url action='booklist' namespace='/bookAction'>
			<s:param name='c.id'><s:property value='#c1.id'/></s:param>
			<s:param name='c1.id'><s:property value='#c1.id'/></s:param>
			
            </s:url>
		"><s:property value='#c1.category_name'/></a>]<br/>		             		            	             	              
				</h3>				
				<ul class="ul_left_list">
				 <s:iterator value="#c1.categorys" var="c2">		              
		               <li>
		    <a href="
		    <s:url action='booklist' namespace='/bookAction'>			
		    <s:param name='c.id'><s:property value='#c2.parent_id'/></s:param>
			 <s:param name='c1.id'><s:property value='#c2.id'/></s:param>
            </s:url>
		      "><s:property value='#c2.category_name'/></a></li>		              
	              </s:iterator>	                
				</ul>				
				<div class="empty_left">
				</div>
			</div>           
			<div class="more2">
			</div>
			</s:iterator> 			
		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
