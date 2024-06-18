/**
 * obj1.js
 */
document.getElementById('dom').remove();

// 등록이벤트
document.getElementById('EmpAddBtn').addEventListener('click', EmpAddBtnFnc);

function EmpAddBtnFnc() {
	const employee = {
		id: document.getElementById('empNo').value,
		first_name: document.getElementById('empName').value,
		email: document.getElementById('empMail').value,
		salary: document.getElementById('empSalary').value,
	}
	// 목록에 추가하기
	//document.querySelector('#list').appendChild(obj.makeRow(employee));
	obj.showList([employee]);
}

const obj = {
	data: '',
	fields: ['id', 'first_name', 'email', 'salary'],
	showList: function(ary = []) {
		ary.forEach((emp, idx) => {
			if (idx < 3) {
				document.querySelector('#list').appendChild(this.makeRow(emp));
			}
		});
	},
	makeRow(emp = { id, first_name, email, salary }) {
		let tr = document.createElement('tr');
		this.fields.forEach(field => {
			let td = document.createElement('td');
			td.innerText = emp[field];
			tr.appendChild(td);
		});
		return tr;
	}
}

obj.showList(employees);

const person = {
	name: "홍길동",
	age: 20
}

person.height = 167.8;
person.showInfo = function() {
	return person.name + '-' + person.age + '-' + person.height;
}

let prop = 'age';
console.log(person.prop);
console.log(person[prop]);
console.log(person.showInfo());

const today = new Date();
today.getFullYear();

// 2024-06-19
Date.prototype.format = function() {
	let yy = this.getFullYear();
	let mon = '0' + this.getMonth() + 1;
	let dd = this.getDate();
	
	return yy + '-' + mon + '-' + dd;
}
console.log(today.format());