/**
 * ajax3.js
 */
const xthp = new XMLHttpRequest();
xthp.open('get', 'membersAjax.do');
xthp.send();
xthp.onload = function() {
	console.log(xthp);
	let data = JSON.parse(xthp.responseText);
	data.forEach(user => {
		document.getElementById('list').appendChild(makeRow(user));
	});
}
// json 문자열의 필드이름을 활용
const fields = ['userId', 'userName', 'userPw', 'responsibility', 'image'];
function makeRow(obj = {}) {
	let tr = document.createElement('tr');
	tr.setAttribute('id', obj.userId); // <tr id='user01' ...>
	tr.addEventListener('dblclick', function(e){
		document.getElementById('myModal').style.display = 'block';
		
		// 선택된 사용자의 이름, 비번을 모달에 출력
		console.log(e, this);
		document.getElementById('modify_id').value = this.children[0].innerHTML;
		document.getElementById('modify_name').value = this.children[1].innerHTML;
		document.getElementById('modify_pass').value = this.children[2].innerHTML;
	})
	fields.forEach(fields => {
		let td = document.createElement('td');
		let img = document.createElement("img");
		if(fields == "image"){
			if(obj.image != "undefined"){
				img.setAttribute("src", `images/${obj.image}`);
				img.setAttribute("width", "50px");
				td.appendChild(img);
			} else {
				td.innerHTML = "";
			}
		}else{
			td.innerHTML = obj[fields];

		}
		tr.appendChild(td);
	})
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('deleteId', obj.userId);
	btn.addEventListener('click', removeMemberFnc);
	btn.setAttribute('class', "btn btn-danger")
	btn.innerHTML = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;
}

// 삭제 이벤트 
function removeMemberFnc(e) {
	let did = this.getAttribute('deleteId'); // user04
	let tr = document.getElementById(did); // document.getElemtById('user04');
	
	const delAjax = new XMLHttpRequest();
	delAjax.open('get', 'removeIdAjax.do?id=' + did);
	delAjax.send();
	delAjax.onload = function() {
		let result = JSON.parse(delAjax.responseText);
		if (result.retCode == 'Delete') {
			alert('정상삭제');
			tr.remove();
		} else {
			
		}
	}
}

// id 삭제 이벤트
document.getElementById('removeBtn').addEventListener('click', function() {
	let id = document.getElementById('uid').value;

	const removeAjax = new XMLHttpRequest();
	removeAjax.open('get', 'removeIdAjax.do?id=' + id);
	removeAjax.send();
	removeAjax.onload = function() {
		let result = JSON.parse(removeAjax.responseText);
		if (result.retCode == 'Delete') {
			alert('삭제하였습니다.');
			// 행 전체 선택 -> 행 하나하나의 1번째 td의 값과 삭제한 id값이 같으면 행 삭제
			document.querySelectorAll('#list > tr').forEach(ele => {
				if (ele.childNodes[0].innerText == id) {
					ele.remove();
				}

			});

		} else {
			alert('삭제하는 중 오류가 발생하였습니다.');
		}
	}
});
// 수정이벤트
document.getElementById('modBtn').addEventListener('click', function(){
	let id = document.getElementById('modify_id').value;
	let name = document.getElementById('modify_name').value;
	let pass = document.getElementById('modify_pass').value;
	
	// ajax 생성
	const modAjax = new XMLHttpRequest();
	modAjax.open('get', 'editIdAjax.do?id=' + id + '&name=' + name + '&pw=' + pass);
	modAjax.send();
	modAjax.onload = function() {		
		let result = JSON.parse(modAjax.responseText);
		if(result.retCode == 'SUCCESS'){
			// 수정이 안됐으면 화면수정X
			let targetTr = document.getElementById(id);
			targetTr.children[1].innerHTML = name;
			targetTr.children[2].innerHTML = pass;

			// 모달창 닫기
			document.getElementById('myModal').style.display = 'none';
			
		} else {
			alert("실패");
		}
	}
	
	// 정상적으로 정보가 업데이트되면 화면 수정
	
});


// 등록이벤트.
document.getElementById('addBtn').addEventListener('click', function() {
	const formData = new FormData(); // form-data처리.
	const fileField = document.querySelector('#myPic');

	formData.append("id", document.getElementById('uid').value);
	formData.append("pw", document.getElementById('upw').value);
	formData.append("name", document.getElementById('uname').value);
	formData.append("myImage", fileField.files[0]);
	
	upload(formData);
})

// fetch 파일 업로드
async function upload(formData) {
	try {
		const response = await fetch("signUp.do", {
			method: "PUT",
			body: formData,
		});
		const result = await response.json();
		console.log("성공:", result);
	} catch (error) {
		console.error("실패:", error);
	}
} // end of upload(formData).



// id 체크 이벤트
document.getElementById('uid').addEventListener('change', function() {
	let checkId = this.value;

	const checkAjax = new XMLHttpRequest();
	checkAjax.open('get', 'checkIdAjax.do?id=' + checkId);
	checkAjax.send();
	checkAjax.onload = function() {
		let result = JSON.parse(checkAjax.responseText);
		if (result.retCode == 'Exist') {
			alert('이미 존재하는 아이디입니다.');
			document.querySelector('#addBtn').disabled = true;
		} else {
			alert('등록가능한 아이디입니다.');
			document.querySelector('#addBtn').disabled = false;
		}
	}
});