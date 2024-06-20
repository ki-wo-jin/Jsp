/**
 * replyService.js
 * 목록, 단건, 등록, 삭제
 */

const svc = {
	// 목록
	replyList(bno = 1, successCall) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'replyListJson.do?bno=' + bno);
		xhtp.send();
		xhtp.onload = successCall;
	},
	// 단건조회
	getReply() {

	},
	// 등록
	addReply(rvo = {replyer, reply, bno}, successCall) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('post', 'addReply.do');
		xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhtp.send('bno=' + rvo.bno + '&reply=' + rvo.reply + '&replyer=' + rvo.replyer);
		xhtp.onload = successCall;

	},
	// 삭제
	removeReply(rno = 1, successCall) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'removeReply.do?rno=' + rno);
		xhtp.send();
		xhtp.onload = successCall;
	
	}
}