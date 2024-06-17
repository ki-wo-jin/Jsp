/**
 * dom1.js
 */
document.getElementById('fruit').style.display = 'none';

document.querySelector('table.table tr:nth-of-type(5)').setAttribute('align', 'center');

// 페이지 로딩하면서 회원3명 출력
// console.log(myMembers);

for (let mem of myMembers) {
	document.getElementById('memberList').appendChild(addRow(mem));
}

// 추가버튼 클릭이벤트 등록
document.getElementById('addBtn').addEventListener('click', addMemberFnc);
document.getElementById('modBtn').addEventListener('click', modMemberFnc);
document.getElementById('delBtn').addEventListener('click', removeMemberFnc);

//힌트
document.querySelector('tbody input[type = "checkbox"]').addEventListener('change', allCheckFnc);
// this => 1.이벤트(이벤트 대상) 2.함수(window) 3.

// 전체선택
function allCheckFnc() {
	console.log(this.checked);
	let targetTr = document.querySelectorAll('#memberList tr');
	for (let tr of targetTr) {
		if (this.checked) {
			tr.children[5].children[0].checked = true;
		} else {
			tr.children[5].children[0].checked = false;
		}
	}
}

//function allCheckFnc(){
// tbody의 하위에 있는 모든 input[type="checkbox"]의 속성을 변경
//	console.log(this.checked);
//let checkVal = this.checked;
//	document.querySelectorAll('tbody#memberList tr')//
//	.forEach(item => item.children[5].children[0].checked = this.checked);
//}

// 선택삭제
function removeMemberFnc() {
	let targetTr = document.querySelectorAll('#memberList tr');
	for (let tr of targetTr) {
		if (tr.children[5].children[0].checked) {
			tr.remove();


		}

	}
}

function addMemberFnc() {
	const id = document.getElementById('mid').value;
	const name = document.getElementById('mname').value;
	const phone = document.getElementById('mphone').value;
	const point = document.getElementById('mpoint').value;

	if (!id || !name || !phone || !point) {
		alert('필수값을 입력');
		return;
	}

	document.getElementById('memberList').appendChild(addRow({ id, name, phone, point }));

	document.getElementById('mid').value = "";
	document.getElementById('mname').value = "";
	document.getElementById('mphone').value = "";
	document.getElementById('mpoint').value = "";

}   // end of addMemberFnc()

// 수정
function modMemberFnc() {
	let modTr = document.querySelectorAll('#memberList tr');
	// 입력화면의 회원아이디 값을 가져와서 mid변수 저장
	let mid = document.getElementById('mid').value;
	let mname = document.getElementById('mname').value;
	let mphone = document.getElementById('mphone').value;
	let mpoint = document.getElementById('mpoint').value;

	for (let tr of modTr) {
		if (tr.children[0].innerHTML == mid) {
			tr.children[1].innerHTML = mname;
			tr.children[2].innerHTML = mphone;
			tr.children[3].innerHTML = mpoint;
		}
	}

}

function addRow(member = { id, name, phone, point }) {
	// tr > td * 4
	const tr = document.createElement('tr');
	tr.addEventListener('click', showDetailFnc);

	for (let prop in member) {
		const td = document.createElement('td');
		td.innerHTML = member[prop];
		tr.appendChild(td);
	}
	// 삭제버튼 생성

	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	btn.setAttribute('class', 'btn btn-warning');
	btn.addEventListener('click', removeTrElement);

	// 체크박스 생성
	td = document.createElement('td');
	btn = document.createElement('input');
	btn.setAttribute('type', 'checkBox');
	btn.addEventListener('click', allchenking);
	td.appendChild(btn);
	tr.appendChild(td);

	return tr;

	// 이벤트 핸들러
	function removeTrElement(e) {
		console.log('btn', e);
		e.stopPropagation();// 상위요소로 이벤트전파 차단
		this.parentElement.parentElement.remove();

	}

	function showDetailFnc(e) {
		console.log('tr', e);

		document.getElementById('mid').value = this.children[0].innerText;
		document.getElementById('mname').value = this.children[1].innerText;
		document.getElementById('mphone').value = this.children[2].innerText;
		document.getElementById('mpoint').value = this.children[3].innerText;
	}

} // end of addRow()

function allchenking() {
	let targetTr = document.querySelectorAll('#memberList tr');
	let checkTr = document.querySelector('tbody input[type="checkbox"]');
	let cnt = 0;

	for (let tr of targetTr) {
		if (tr.children[5].children[0].checked) {
			cnt++;
		}

	}

	if (targetTr.length == cnt) {
		checkTr.checked = true;
	} else {
		checkTr.checked = false;
	}
}
