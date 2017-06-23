
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			window.onload=function(){
				var js_address =document.getElementById("address");
				js_address.onchange=function(){
					<s:iterator value='addresses'>
						if(js_address.value == <s:property value='id'/>){
							document.getElementById("mobile").value="<s:property value='mobile'/>";
							document.getElementById("fullAddress").value="<s:property value='full_address'/>";
							document.getElementById("receiveName").value="<s:property value='receive_name'/>";
							document.getElementById("phone").value="<s:property value='phone'/>";
							document.getElementById("postalCode").value="<s:property value='postal_code'/>";
						}
					</s:iterator>
					if(js_address.value == -1){
					        document.getElementById("mobile").value=null;
							document.getElementById("fullAddress").value=null;
							document.getElementById("receiveName").value=null;
							document.getElementById("phone").value=null;
							document.getElementById("postalCode").value=null;
					}
					if(js_address.value == -2){
					       window.location.href="../order/address_form_two.jsp";
					}
				};
				
				var js_form = document.getElementById('f');
				js_form.onsubmit=function(){
					if(js_address.value == -1){
						alert("请选择地址,才能确认订单");
						return false;
					}if(js_address.value == -2){
						alert("请添加新地址");
						return false;
					}
					var js_inputs = js_form.getElementsByTagName('input');
					for(var i in js_inputs){
						if(js_inputs[i].value.length <=0){
							console.log(js_input[i]);
							alert("请选择地址");
							return false;
						}
							
					}
					return true;
				};
			};
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address">
					<option value="-1">
						请选择地址
					</option>
				<s:iterator value="addresses">
					
					<option value="<s:property value='id'/>">
						<s:property value='receive_name'/>
						<s:property value='full_address'/>
					</option>
				</s:iterator>
				<option value="-2">
						添加新地址
					</option>
				</select>
			</p>
			<form name="ctl00" method="post" 
			action="${pageContext.request.contextPath }/orderAction/addOrder"
			 id="f">
				<input type="hidden" name="id" id="addressId" />

				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" readonly="readonly" class="text_input" name="address.receive_name"
								id="receiveName" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" readonly="readonly" name="address.full_address" class="text_input"
								id="fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" readonly="readonly" class="text_input" name="address.postal_code"
								id="postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" readonly="readonly" class="text_input" name="address.phone"
								id="phone" />
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<input type="text" readonly="readonly" class="text_input" name="address.mobile"
								id="mobile" />
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<a href="../order/order_info.jsp"><input id="btnClientRegister" class="button_1" name="submit"
					type="button" value="取消" /></a>
			
				<input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

