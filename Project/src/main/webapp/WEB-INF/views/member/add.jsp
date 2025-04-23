<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
	#label-check {
		font-size: .8rem;
		color: tomato;
	}
	button[disabled] {
		cursor: not-allowed;
		opacity: .5;
	}
	#picPreview {
		margin-top: 5px;
	}
	#picPreview img {
		object-fit: contain;
		width: 120px;
		height: 120px;
		border: 1px solid #999;
		padding: 10px;
	}
</style>

<!-- member > add.jsp -->
<h2>회원 <small>가입하기</small></h2>

<form method="POST" action="/project/member/addok" enctype="multipart/form-data">
<table class="vertical">
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="id" id="id" class="short" required>
			<input type="button" id="btn-check" value=" 중복 검사 ">
			<span id="label-check"></span>
		</td>
	</tr>
	<tr>
		<th>암호</th>
		<td><input type="password" name="pw" id="pw" class="short" required></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="name" id="name" class="short" required></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type="text" name="email" id="email" required></td>
	</tr>
	<tr>
		<th>프로필 사진</th>
		<td>
			<input type="file" name="attach" id="attach" accept="image/*">
			<div id="picPreview"></div>
		</td>
	</tr>
</table>
<div>
	<button class="in" disabled>가입하기</button>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
	$('#btn-check').click(()=>{
		
		//아이디 중복검사
		if ($('#id').val().trim() != '') {
			
			$.ajax({
				type: 'GET',
				url: '/project/member/id/' + $('#id').val(),
				dataType: 'text',
				success: function(result) {
					//alert(result);
					if (result == 1) {
						$('#label-check').text('이미 사용중인 아이디입니다.');
						$('button.in').prop('disabled', true);
					} else {
						$('#label-check').text('사용 가능한 아이디입니다.');
						$('button.in').prop('disabled', false);
					}
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		}
		
	});
	
	//아이디를 수정하면 > 무조건 다시 중복검사를 하게끔
	$('#id').change(()=>{
		$('#label-check').text('아이디를 수정했습니다. 먼저 중복 검사를 실행하세요.');
		$('button.in').prop('disabled', true);
	});
	
	//사진 선택 > 미리보기
	$('#attach').change(evt=>{
		
		const file = evt.target.files;
		
		const img = new Image(); //<img>
		const url = window.URL.createObjectURL(file[0]);
		img.src = url;
		
		$('#picPreview').html('');
		$('#picPreview').append(img);
		
	});
	
</script>











