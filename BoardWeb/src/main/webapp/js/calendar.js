/**
 * calendar.js
 */
document.querySelectorAll('.container-fluid h3') // NodeList
	.forEach(item => item.remove());

document.querySelectorAll('.container-fluid table.table') // NodeList
	.forEach(item => item.remove());

document.getElementById('fruit').remove();

// 달력을 첫째날 계산하는 함수, 마지막날 계산 함수
function getFirstDay(month = 6) { // 1일의 위치를 지정하기 위해서 공란의 갯수를 반환
	switch (month) {
		case 5:
			return 4;
		case 7:
			return 2;
	}
	return 7;
}

function getLastDate(month = 6) { // 월의 마지막날을 반환하는 함수
	switch (month) {
		case 5:
		case 7:
			return 31;
	}
	return 30;
}

function makeCalendar(month = 6) {
	document.getElementById('show').innerHTML = '';
	
	// table 생성 border = "2"
	let tbl = document.createElement('table');
	tbl.setAttribute('class', 'table');
	tbl.setAttribute('border', '2');
	

	let thd = document.createElement('thead');
	let tbd = document.createElement('tbody');

	// thead 하위요소
	let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
	let tr = document.createElement('tr');
	days.forEach(day => {
		let td = document.createElement('th');
		td.innerHTML = day;
		tr.appendChild(td);
	})
	thd.appendChild(tr);

	// tbody 하위요소
	tr = document.createElement('tr');
	// 빈날짜
	for (let i = 1; i < getFirstDay(month); i++) {
		let td = document.createElement('th');
		tr.appendChild(td);
	}
	// 날짜 출력
	for (let d = 1; d <= getLastDate(month); d++) {
		let td = document.createElement('th');
		td.innerHTML = d;
		tr.appendChild(td);

		if ((d + getFirstDay(month) - 1) % 7 == 0) { // 7일마다 줄바꿈
			tbd.appendChild(tr);
			tr = document.createElement('tr');
		}
		// 토요일은 배경색은 파란색
		if ((d + getFirstDay(month) - 1) % 7 == 0) { // 7일
			td.style.background = "blue";
			td.style.color = "white";
		}

		if ((d + getFirstDay(month) - 2) % 7 == 0) { // 7일
			td.style.background = "red";
			td.style.color = "white";
		}

		// 일요일은 배경색을 빨간색

	}
	tbd.appendChild(tr);

	tbl.appendChild(thd);
	tbl.appendChild(tbd);

	document.getElementById('show').appendChild(tbl);
}

document.getElementById('selectMonth').addEventListener('change', selectMonthFnc);

function selectMonthFnc() {
	makeCalendar(parseInt(this.value));
}
