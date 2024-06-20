/**
 * reply.js
 */
// 댓글 -> li 생성
function makeRow(reply = {}) {
	let fields = ['replyNo', 'reply', 'replyer', 'replyDate'];
	let li = document.createElement('li');
	fields.forEach(field => {
		let span = document.createElement('span');
		span.innerHTML = reply[field];
		if(field == 'reply'){
			width = '4';
		} else if(field == 'replyDate'){
			width = '3';
		} else {
			width = '2';
		}
		
		span.setAttribute('class', 'col-sm-' + width);
		li.appendChild(span);
	})
	return li;
}

function cloneRow(reply = {}) {
	let template = document.querySelector('div.content > ul > li:nth-of-type(3)').cloneNode(true);
	template.style.display = 'block';
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
	template.querySelector('span:nth-of-type(5)').setAttribute('rNo', reply.replyNo);
	return template;
}

const listAjax = new XMLHttpRequest();
listAjax.open('get', 'replyListJson.do?bno=' + bno);
listAjax.send();
listAjax.onload = function(){
	let data = JSON.parse(listAjax.responseText)
	console.log(data);
	data.forEach(reply => {
		//document.querySelector('div.content>ul').appendChild(makeRow(reply));
		document.querySelector('div.content>ul').appendChild(cloneRow(reply));
	});
}

// 한건삭제
function deleteRow(e) {
	let rNo = e.target.parentNode.getAttribute('rNo'); 
	
	const delReply = new XMLHttpRequest();
	delReply.open('get', 'removeReply.do?rNo=' + rNo);
	delReply.send();
	delReply.onload = function() {
		let result = JSON.parse(delReply.responseText);
		if (result.retCode == 'OK') {
			e.target.parentNode.parentNode.remove();
			alert('정상삭제');
		}
	}
}
