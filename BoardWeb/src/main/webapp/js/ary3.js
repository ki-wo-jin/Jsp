/**
 * ary3.js
 */
let sum =
	[10, 20, 30, 40, 50].reduce(function(acc, ele, idx, ary) {
		console.log(acc, ele);
		if(ele > acc) return ele;
	}, 0);
console.log('최대값: ', sum);

['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'].reduce(function(acc, ele){
	let li = document.createElement('li');
	li.innerHTML = ele;
	acc.appendChild(li);
	
	return acc;
}, document.getElementById('fruit'));