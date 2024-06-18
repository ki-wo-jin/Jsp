/**
 * ary2.js
 * 
 */
console.log(employees);

let result = [23, 45, 22, 39, 10, 56].filter(function(item, idx, ary) {
	if (item % 2 == 0) {
		return true;
	}
});

//console.log(result);

//employees.forEach(console.log);

// 급여가 5000이 넘는 여자만 필터링
let over5000 = [];
let over5000Sum = 0;
let filterFnc = emp => emp.gender == 'Female' && emp.salary > 5000;

filterFnc = function(emp) {
	return emp.gender == 'Female' && emp.salary > 5000;
}

employees.filter(function(emp,idx){
	return emp.gender == 'Female' && emp.salary > 5000;
	}).forEach(function(emp) {
		over5000Sum += emp.salary;
	});

// over5000 = employees.filter(emp => emp.gender == 'Female' && emp.slary > 5000);

console.log('조건만족사람급여합 ', over5000Sum);

// [A,A,A] -> [A',A',A']
employees.map(function(ele, idx, ary){
	const obj = {}
	obj.name = ele.first_name + '-' + ele.last_name;
	obj.no = ele.id;
	obj.salary = ele.salary;
	return obj;
	}).forEach(console.log);

