/**
 * data.js
 */
const myMembers = [
	{ id: 'user01', name: '홍길동', phone: '010-1111-2222', point: 90 }, // new Object();
	{ id: 'user02', name: '박석민', phone: '010-2341-2321', point: 95 },
	{ id: 'user03', name: '김시후', phone: '010-4567-7896', point: 120 }
]; // new Array();

const json = `[{"id":1,"first_name":"Hermon","last_name":"Santo","email":"hsanto0@clickbank.net","gender":"Male","salary":3400},
{"id":2,"first_name":"Hadria","last_name":"Sumsion","email":"hsumsion1@oracle.com","gender":"Female","salary":5390},
{"id":3,"first_name":"Papagena","last_name":"Saylor","email":"psaylor2@webs.com","gender":"Female","salary":6985},
{"id":4,"first_name":"Neille","last_name":"Zimek","email":"nzimek3@springer.com","gender":"Female","salary":7351},
{"id":5,"first_name":"Kendell","last_name":"Kaiser","email":"kkaiser4@earthlink.net","gender":"Male","salary":6864},
{"id":6,"first_name":"Hugh","last_name":"Still","email":"hstill5@a8.net","gender":"Male","salary":6496},
{"id":7,"first_name":"Basilio","last_name":"Kliemchen","email":"bkliemchen6@mashable.com","gender":"Male","salary":4947},
{"id":8,"first_name":"Gussie","last_name":"Tallowin","email":"gtallowin7@chronoengine.com","gender":"Female","salary":4284},
{"id":9,"first_name":"Killy","last_name":"Houlridge","email":"khoulridge8@cbslocal.com","gender":"Male","salary":5283},
{"id":10,"first_name":"Karlotta","last_name":"Haith","email":"khaith9@soundcloud.com","gender":"Female","salary":5144},
{"id":11,"first_name":"Mureil","last_name":"Toun","email":"mtouna@tinyurl.com","gender":"Female","salary":6500},
{"id":12,"first_name":"Harp","last_name":"Byatt","email":"hbyattb@foxnews.com","gender":"Male","salary":3233},
{"id":13,"first_name":"Felita","last_name":"Filppetti","email":"ffilppettic@simplemachines.org","gender":"Female","salary":3963},
{"id":14,"first_name":"Chan","last_name":"Attew","email":"cattewd@discovery.com","gender":"Male","salary":3661},
{"id":15,"first_name":"Charo","last_name":"Keme","email":"ckemee@tinypic.com","gender":"Female","salary":6989}]`;

const employees = JSON.parse(json);