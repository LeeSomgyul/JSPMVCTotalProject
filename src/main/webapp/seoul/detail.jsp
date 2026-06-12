<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
   margin-top: 50px;
}
.row {
   margin: 0px auto;
   width: 900px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td colspan="2" class="text-center">
						<img 
							src="${vo.poster }"
							style="width: 750px;height: 300px;"
							onerror="this.src='no.png'"
						>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<h3>${vo.title }</h3>
					</td>
				</tr>
				<tr>
					<td width=10%>주소</td>
					<td width=90%>${vo.address }</td>
				</tr>
				<tr>
					<td colspan="2">${vo.msg }</td>
				</tr>
				<tr>
					<td colspan="2" class="text-right">
						<a href="list.do?tno=${tno }" class="btn btn-sm btn-primary">목록</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>