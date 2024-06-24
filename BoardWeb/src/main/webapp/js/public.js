/**
 * public.js
 */
let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=nF%2FB0HZdlfv7eCMMHebVFcKad8xwBd48Ug1LKJJ3y7%2B0RD4DTeWlEdVZWJgk2sSH6Yt15OT4CP7JfJ565mtX0w%3D%3D'

// 센터정보생성
document.getElementById('centerDB').addEventListener('click', createCenterInfo);

function createCenterInfo() {
	// 1. open API 호출
	// 2. 컨트롤 호출 DB입력
	fetch(url)
		.then(result => result.json())
		.then(result => {
			let centers = result.data; // [{},{},{},...] => [{"id":"hong"},{:}...]
			return fetch('centerInfo.do', {
				method: 'post', // 전달되는 값이 body영역에 저장
				headers: { 'Content-Type': "application/json" }, // 키=값&키=값
				body: JSON.stringify(centers) // 객체 -> json문자열			
			})
		})
		.then(result => result.json()) // {"txnCnt": 3}
		.then(result => {
			console.log(result);
			if (result.txnCnt > 0) {
				alert(result.txnCnt + '건 처리 성공');
			} else {
				alert('실패');
			}
		})
		.catch(err => console.log(err));
}

const target = document.querySelector('#centerList'); // 하위목록
const fields = [];

fetch(url)
	.then(result => result.json()) // [{"id:1, "center.."},{},{}] -> [{},{}]
	.then(result => {
		console.log(result.data);
		result.data.forEach(center => {
			target.appendChild(makeRow(center));
			if (fields.indexOf(center.sido) == -1) {
				fields.push(center.sido);
			}
		});
		makeSido();
	})
	.catch(err => console.log(err));



// 3 sido
function makeSido() {
	fields.forEach(fields => {
		let op = document.createElement('option');
		op.innerHTML = fields;
		document.getElementById('changeSido').appendChild(op);
	})

}


// sido 바꾸기 이벤트
document.getElementById('changeSido').addEventListener('change', changeSidoFnc);

function changeSidoFnc() {
	let dosi = this.value; // 도시선택의 값
	target.innerHTML = "";

	fetch(url)
		.then(result => result.json()) // [{"id:1, "center.."},{},{}] -> [{},{}]
		.then(result => {
			//console.log(result.data);
			result.data.forEach(center => {
				if (center.sido.includes(dosi)) {
					target.appendChild(makeRow(center));
				}
			});
		});


}


// 2 주소 검색	
document.getElementById('findBtn').addEventListener('click', searchListFnc);
// 버튼 이벤트
function searchListFnc() {
	let key = document.getElementById('search').value;
	target.innerHTML = "";

	fetch(url)
		.then(result => result.json()) // [{"id:1, "center.."},{},{}] -> [{},{}]
		.then(result => {
			//console.log(result.data);
			result.data.forEach(center => {
				if (center.address.includes(key)) {
					target.appendChild(makeRow(center));
				}
			});
		});


}



// 1 목록 출력
function makeRow(center = {}) {
	let template = document.querySelector('table.table > thead > tr').cloneNode(true);
	template.querySelector('th:nth-of-type(1)').innerHTML = center.id;
	template.querySelector('th:nth-of-type(2)').innerHTML = center.centerName;
	template.querySelector('th:nth-of-type(3)').innerHTML = center.phoneNumber;
	template.querySelector('th:nth-of-type(4)').innerHTML = center.address;
	template.addEventListener('click', function() {
		//location.href = "map.do?lat=" + center.lat + "&lng=" + center.lng;
		window.open("map.do?lat=" + center.lat + "&lng=" + center.lng + "&name=" + center.centerName);
	});

	return template;
}

