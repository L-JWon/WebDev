<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 600px;
}
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script type="text/javascript">
$(function() {
	$('#tabs').tabs()
	$('#idBtn1').click(function() {
		let name=$('#email_name').val(); //이름 입력했을 때 입력값을 읽어와라
		if(name.trim()==="")
		{
			$('#email_name').focus();
			$('#id_result1').text("이름을 입력하세요");
			return;
		}
		let email=$('#email').val();
		if(email.trim==="")
		{
			$('#email').focus();
			$('#id_result1').text("이메일을 입력하세요");
			return;
		}
		
		
		$.ajax({
			type:'post',
			url:'idfind_ok.jsp',
			data:{"name":name,"email":email}, // 전송되는 곳이 idfind_ok.jsp로 결과값을 출력해놓고
			success:function(result) //여기서 그 결과값을 받아 읽어온다!! 
			{
				$('#id_result1').text(result);
			}
		})
	}) //이메일 버튼을 눌렀을 때
	
	
	$('#idBtn2').click(function() {
		//1.이름 입력여부
		let name=$('#tel_name').val();
		if(name.trim()==="")
		{
			$('#tel_name').focus();
			$('#id_result2').text("이름을 입력하세요");
			return;
		}
		//2.전화번호 입력 여부
		let tel=$('#tel').val();
		if(tel.trim()==="")
		{
			$('#tel').focus();
			$('#id_result2').text("전화번호를 입력하세요");
			return;
		}
		//3.ajax를 이용해서 이름과 전화번호를 전송 => ok에서 결과값을 출력하고
		$.ajax({
			type:'post',
			url:'telfind_ok.jsp',
			data:{"name":name,"tel":tel},
			success:function(result)
			{
				$('#id_result2').text(result);//4. 그 출력된 결과물을 다시 읽어온다
			}
		})
		
	})
})
</script>
</head>
<body>
   <div class="container">
     <h1 class="text-center">아이디 찾기</h1>
     <div class="row">
       <div id="tabs">
		  <ul>
		    <li><a href="#tabs-1">이메일로 찾기</a></li>
		    <li><a href="#tabs-2">전화번호로 찾기</a></li>
		  </ul>
		  <div id="tabs-1">
		   <table class="table">
		     <tr>
		       <th width="30%" class="text-center">이름</th>
		       <td width="70%">
		         <input type="text" id="email_name" class="input-sm" size=20>
		       </td>
		      </tr>
		      <tr>
		       <th width="30%" class="text-center">이메일</th>
		       <td width="70%">
		         <input type="text" id="email" class="input-sm" size=35>
		       </td>
		     </tr>
		      <tr>
		       <td colspan="2" class="text-center">
		         <input type="button" value="아이디 찾기" id="idBtn1" class="btn btn-sm btn-primary">
		       </td>
		     </tr>
		      <tr>
		       <td colspan="2" class="text-center">
		          <h3 id="id_result1" style="color:red"></h3>
		       </td>
		     </tr>
		   </table>
		  </div>
		  <div id="tabs-2">
		    <table class="table">
		     <tr>
		       <th width="30%" class="text-center">이름</th>
		       <td width="70%">
		         <input type="text" id="tel_name" class="input-sm" size=20>
		       </td>
		      </tr>
		      <tr>
		       <th width="30%" class="text-center">전화번호</th>
		       <td width="70%">
		         <input type="text" id="tel" class="input-sm" size=35>
		       </td>
		     </tr>
		      <tr>
		       <td colspan="2" class="text-center">
		         <input type="button" value="아이디 찾기" id="idBtn2" class="btn btn-sm btn-primary">
		       </td>
		     </tr>
		      <tr>
		       <td colspan="2" class="text-center">
		          <h3 id="id_result2" style="color:red"></h3>
		       </td>
		     </tr>
		   </table>
		  </div>
	   </div>
     </div>
   </div>
</body>
</html>