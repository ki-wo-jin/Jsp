/**
 * reply.js
 */
svc.replyList(bno, replyListFnc);

// 댓글등록 이벤트
document.getElementById('addReply').addEventListener('click', addReplyFnc);

// 등록실행함수 bno,
function addReplyFnc() {
	if(!replyer){
		alert('로그인하세요!!');
		return;
	}
	
	let reply = document.getElementById('reply').value;
	if(!reply){
		alert('댓글을 등록하세요!!');
		return;
	}
	
	svc.addReply({replyer, reply, bno }, addReplyCallback);
} // end of addReplyFnc()

function addReplyCallback(){
	console.log(this.responseText);
	// 화면에 댓글정보목록에 추가
	let result = JSON.parse(this.responseText);
	if (result.retCode == 'OK') {
		alert('등록성공!!');
		let li = cloneRow(result.retVal);
		document.querySelector('div.content > ul').appendChild(li);
		document.getElementById('reply').value = '';
	} else {
		alert('실패=> ' + result.retVal);
	}
}

// replyList의 매개값으로 사용될 함수 
function replyListFnc(){
	let data = JSON.parse(this.responseText);
	console.log(data);
	data.forEach(reply => {
		let li = cloneRow(reply);
		document.querySelector('div.content > ul').appendChild(li);
	});
	
}

// 댓글정보 -> li 생성
function cloneRow(reply = {}) {
	let template = document.querySelector('div.content > ul > li:nth-of-type(3)').cloneNode(true);
	template.style.display = 'block';
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
	template.querySelector('span:nth-of-type(5)').setAttribute('rno', reply.replyNo);
	return template;
}

// 한건삭제
function deleteRow(e) {
	let rno = e.target.parentNode.getAttribute('rno'); 
	
	svc.removeReply(rno, deleteReplyFnc);
	// remveReply메소드의 매개값으로 전달될 함수, 화면에서 한건지우기
	
	function deleteReplyFnc(){
		let result = JSON.parse(this.responseText);
		if(result.retCode == 'OK') {
			alert(result.retMsg);
			e.target.parentNode.parentNode.remove();
		} else {
			alert('Error=>' + result.retMsg);
		}
		
	}
	
}

