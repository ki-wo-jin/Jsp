/**
 * ary1.js
 * forEach, filter, map, reduce
 */

const numAry = [23, 17, 6, 41, 30, 12];
let result = 0;

let evenSum = function(ele, idx, ary) {
	console.log(ele, idx, ary);
	if(ele % 2 == 0) {
		result += ele;
	}
}; 


let oddSum = function(ele, idx, ary) {
	if(idx % 2 == 0){
		result += ele;
	}
}


// 35보다 작은 값들의 합을 저장
let less35 = function(ele, idx, ary) {
	if(ele < 35){
		result += ele;
	}
};


numAry.forEach(evenSum)// 매개값으로 함수
console.log('짝수합은 ', result);
result = 0;

numAry.forEach(oddSum)// 매개값으로 함수
console.log('홀수번째의 값은 ', result);
result = 0;

numAry.forEach(less35)
console.log('35보다 작은 값의 합 ', result)
result = 0;

const dupAry = [10, 27, 32, 55, 27, 10];
const ary = []; // indexOf(10) => 인덱스 값을 반환, -1을 반환

dupAry.forEach(function(ele){
	if(ary.indexOf(ele) == -1){
	ary.push(ele)
	}
});
console.log(ary);
