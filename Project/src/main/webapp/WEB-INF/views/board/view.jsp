<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<style>
	
	#listComment {}
	
	#addComment {}
	
	#listComment td:nth-child(1), 
	#addComment td:nth-child(1) { width: 618px; }
	
	#listComment td:nth-child(2), 
	#addComment td:nth-child(2) { width: 150px; }
	
	#listComment .commentContent div:nth-child(2) {
		font-size: .8rem;
		text-align: right;
		margin-right: 5px;
		color: #777;
	}	
	
	.fa-pen-to-square:hover, .fa-trash-can:hover {
		color: cornflowerblue;
		cursor: pointer;
	}
	
	.editCommentRow {
		background-color: #EFEFEF;
	}
	
</style>

<!-- board > view.jsp -->
<h2>게시판 <small>상세보기</small></h2>

<table class="vertical">
	<tr>
		<th>제목</th>
		<td>${bdto.subject}</td>
	</tr>
	<tr style="height: 300px;">
		<th>내용</th>
		<%-- <td><c:out value="${bdto.content}" /></td> --%>
		<td>${bdto.content}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${bdto.name}(${bdto.id})</td>
	</tr>
	<tr>
		<th>날짜</th>
		<td>${bdto.regdate}</td>
	</tr>
	<tr>
		<th>읽음</th>
		<td>${bdto.readcount}</td>
	</tr>
</table>

<!-- 댓글쓰기 -->
<table id="addComment">
	<tr>
		<td><input type="text" name="content" class="full" required></td>
		<td><button type="button" class="comment" id="btnAddComent">댓글 쓰기</button></td>
	</tr>
</table>

<!-- 댓글보기 -->
<table id="listComment">
	<tbody>
	
		<!-- 
		<tr>
			<td class="commentContent">
				<div>댓글 내용입니다.</div>
				<div>2024-04-25 11:25:00</div>
			</td>
			<td class="commentInfo">
				<div>
					<div>홍길동(hong)</div>
					<div>
						<i class="fa-solid fa-pen-to-square"></i>
						<i class="fa-solid fa-trash-can"></i>
					</div>				
				</div>
			</td>
		</tr> 
		-->
		
	</tbody>
</table>

<div id="loader" style="text-align: center; display: none;">
	<img src="/project/resources/images/loader.gif">
</div>

<div>
	<input type="button" value="댓글 더보기" class="full" id="btnMoreComment" onclick="moreComment();">
</div>

<div>
	<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
	<c:if test="${principal.username == bdto.id || pageContext.request.isUserInRole('ROLE_ADMIN')}">
	<button class="edit" type="button" onclick="location.href='/project/board/edit?seq=${bdto.seq}&id=${bdto.id}';">수정하기</button>
	<button class="del" type="button" onclick="location.href='/project/board/del?seq=${bdto.seq}&id=${bdto.id}';">삭제하기</button>
	</c:if>
	</sec:authorize>
	
	<button class="back" type="button" onclick="location.href='/project/board/list?search=${search}&column=${column}&word=${word}&page=${page}';">돌아가기</button>
</div>

<script>
	
	//댓글 쓰기
	<sec:authorize access="isAuthenticated()">
	$('#btnAddComent').click(()=>{
		
		$.ajax({
			type: 'POST',
			url: '/project/comment',
			contentType: 'application/json',
			data: JSON.stringify({
				content: $('input[name=content]').val(),
				id: '<sec:authentication property="principal.username" />',
				bseq: '${bdto.seq}'
			}),
			dataType: 'json',
			success: function(result) {
				
				//마무리 > 뒤에
				clist();
				$('input[name=content]').val('');
				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
			
		});
		
	});
	</sec:authorize>
	
	
	function clist(offset) {
			
		//GET > QueryString
		$.ajax({
			type: 'GET',
			url: '/project/comment?bseq=${bdto.seq}&offset=' + offset,
			/* 
			contentType: 'application/json',
			data: JSON.stringify({
				bseq: '${bdto.seq}'
			}), 
			*/
			dataType: 'json',
			success: function(result) {
				
				//console.log(result);
				
				//댓글 목록 출력
				if (result.length > 0) {
				
					//$('#listComment tbody').html('');
					
					$(result).each((index,item)=>{
						
						$('#listComment tbody').append(`
							
							<tr>
								<td class="commentContent">
									<div>\${item.content}</div>
									<div>\${item.regdate}</div>
								</td>
								<td class="commentInfo">
									<div>
										<div>\${item.name}(\${item.id})</div>
										<div>
											<i class="fa-solid fa-pen-to-square" onclick="edit(\${item.seq});"></i>
											<i class="fa-solid fa-trash-can" onclick="del(\${item.seq});"></i>
										</div>				
									</div>
								</td>
							</tr>
								
						`);
						
					});
					
				
				} else {
					
					$('#btnMoreComment').prop('disabled', true);
					$('#btnMoreComment').val('더 이상 댓글이 없습니다.');
					
					/* 
					$('#listComment tbody').append(`
						<tr>
							<td colspan="2">댓글이 없습니다.</td>
						</tr>
					`); 
					*/
					
				}
				
				$('#loader').hide();
				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
				$('#loader').hide();
			}
		});
		
	}
	
	
	function del(seq) {
		
		//alert(seq); //삭제할 댓글 번호
		
		if (confirm('delete?')) {
			
			$.ajax({
				type: 'DELETE',
				url: '/project/comment/' + seq,
				dataType: 'json',
				success: function(result) {
					
					if (result == 1) {
						
						clist();
						
					} else {
						alert('failed');
					}
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
				
			});
			
		}
		
	}
	
	function edit(seq) {
		
		$('.editCommentRow').remove();
		
		let temp = $(event.target).parents('tr').find('.commentContent > div:nth-child(1)').text();
		//alert(temp);
		
		let txt = `
			<tr class="editCommentRow">
				<td><input type="text" name="content" class="full" required value="\${temp}"></td>
				<td>
					<input type="button" value="쓰기" onclick="editComment(\${seq});">
					<input type="button" value="닫기" onclick="$(event.target).parents('tr').remove();">
				</td>
			</tr>
		`;
		
		//$(event.target).parents('tr').css('background', 'gold');
		$(event.target).parents('tr').after(txt);
		
	}
	
	function editComment(seq) {
		//alert(seq);
		
		$.ajax({
			type: 'PUT',
			url: '/project/comment/' + seq,
			contentType: 'application/json',
			data: JSON.stringify({
				content: $('.editCommentRow input[name=content]').val()
			}),
			dataType: 'json',
			success: function(result) {
				
				if (result == 1) {
					
					clist();
					
				} else {
					alert('failed');
				}
				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
			
		});
		
	}

	let offset = 0;
	
	clist(offset);
	
	function moreComment() {
		
		$('#loader').show();
		
		setTimeout(()=>{
			offset += 5;
			clist(offset);
		}, 1000);		
		
	}
	
</script>














