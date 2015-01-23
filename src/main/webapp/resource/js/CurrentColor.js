	var RED = "#AA22EE";
	var ORANGE = "#FF8822";
	
	var elements00;
	var elementsProgram00;
	var currentDate00;
	var dtToday; 
	var elements;
	var elementsProgram01;
	var currentDate01;
	var elements02;
	var elementsProgram02;
	var currentDate02;
	var elements03;
	var elementsProgram03;
	var currentDate03;
	var elements04;
	var elementsProgram04;
	var currentDate04;
	var datetimes00;
	
	var programRefreshTime;
/* 	function refresh00() {

		datetimes00 = window.document.querySelectorAll(".currentDate00");
		var str;
		for ( var i in datetimes00) {
			str = datetimes00[i].innerHTML;
			datetimes00[i].innerHTML = str.substring(10);
		}
	}
	setTimeout(refresh00, 50); */

	function refresh02() {
		elements00 = window.document.querySelectorAll(".myClass00");
		elementsProgram00 = window.document
				.querySelectorAll(".programName00");
		currentDate00 = window.document.querySelectorAll(".currentDate00");
		dtToday = new Date();


		
		for ( var i in elements00) {
			if (elements00[i].innerHTML > dtToday.getTime()) {
				elementsProgram00[i].style.backgroundColor = ORANGE;
				elements00[i].style.color = ORANGE;
				elements00[i].style.backgroundColor = ORANGE;
				currentDate00[i].style.backgroundColor = ORANGE;
				if (i > 1) {
					elementsProgram00[i - 1].style.backgroundColor = RED;
					elements00[i - 1].style.color = RED;
					elements00[i - 1].style.backgroundColor = RED;
					currentDate00[i - 1].style.backgroundColor = RED;
				}
				break;
			}
			if (i = elements00.length - 1) {
				if (elements00[i].innerHTML < dtToday.getTime()) {
					elements00[i].style.color = "#FF0000";
					elements00[i].style.backgroundColor = "#FF0000";
				}
			}
		}
		
		programRefreshTime = elements00[2].innerHTML
		
		elements = window.document.querySelectorAll(".myClass");
		elementsProgram01 = window.document
				.querySelectorAll(".programName01");
		currentDate01 = window.document.querySelectorAll(".currentDate");

		for ( var i in elements) {
			if (elements[i].innerHTML > dtToday.getTime()) {
				elementsProgram01[i].style.backgroundColor = ORANGE;
				elements[i].style.color = ORANGE;
				elements[i].style.backgroundColor = ORANGE;
				currentDate01[i].style.backgroundColor = ORANGE;
				if (i > 1) {
					elementsProgram01[i - 1].style.backgroundColor = RED;
					elements[i - 1].style.color = RED;
					elements[i - 1].style.backgroundColor = RED;
					currentDate01[i - 1].style.backgroundColor = RED;
				}
				break;
			}
			if (i = elements.length - 1) {
				if (elements[i].innerHTML < dtToday.getTime()) {
					elements[i].style.color = "#FF0000";
					elements[i].style.backgroundColor = "#FF0000";
				}
			}
		}
		elements02 = window.document.querySelectorAll(".myClass02");
		elementsProgram02 = window.document
				.querySelectorAll(".programName02");
		currentDate02 = window.document.querySelectorAll(".currentDate02");
		for ( var i in elements02) {
			if (elements02[i].innerHTML > dtToday.getTime()) {
				elementsProgram02[i].style.backgroundColor = ORANGE;
				elements02[i].style.color = ORANGE;
				elements02[i].style.backgroundColor = ORANGE;
				currentDate02[i].style.backgroundColor = ORANGE;
				if (i > 1) {
					elementsProgram02[i - 1].style.backgroundColor = RED;
					elements02[i - 1].style.color = RED;
					elements02[i - 1].style.backgroundColor = RED;
					currentDate02[i - 1].style.backgroundColor = RED;
				}
				break;
			}
			if (i = elements02.length - 1) {
				if (elements02[i].innerHTML < dtToday.getTime()) {
					elements02[i].style.color = "#FF0000";
					elements02[i].style.backgroundColor = "#FF0000";
				}
			}
		}
		elements03 = window.document.querySelectorAll(".myClass03");
		elementsProgram03 = window.document
				.querySelectorAll(".programName03");
		currentDate03 = window.document.querySelectorAll(".currentDate03");
		for ( var i in elements03) {
			if (elements03[i].innerHTML > dtToday.getTime()) {
				elementsProgram03[i].style.backgroundColor = ORANGE;
				elements03[i].style.color = ORANGE;
				elements03[i].style.backgroundColor = ORANGE;
				currentDate03[i].style.backgroundColor = ORANGE;
				if (i > 1) {
					elementsProgram03[i - 1].style.backgroundColor = RED;
					elements03[i - 1].style.color = RED;
					elements03[i - 1].style.backgroundColor = RED;
					currentDate03[i - 1].style.backgroundColor = RED;
				}
				break;
			}
			if (i = elements03.length - 1) {
				if (elements03[i].innerHTML < dtToday.getTime()) {
					elements03[i].style.color = "#FF0000";
					elements03[i].style.backgroundColor = "#FF0000";
				}
			}
		}
		elements04 = window.document.querySelectorAll(".myClass04");
		elementsProgram04 = window.document
				.querySelectorAll(".programName04");
		currentDate04 = window.document.querySelectorAll(".currentDate04");
		for ( var i in elements04) {
			if (elements04[i].innerHTML > dtToday.getTime()) {
				elementsProgram04[i].style.backgroundColor = ORANGE;
				elements04[i].style.color = ORANGE;
				elements04[i].style.backgroundColor = ORANGE;
				currentDate04[i].style.backgroundColor = ORANGE;
				if (i > 1) {
					elementsProgram04[i - 1].style.backgroundColor = RED;
					elements04[i - 1].style.color = RED;
					elements04[i - 1].style.backgroundColor = RED;
					currentDate04[i - 1].style.backgroundColor = RED;
				}
				break;
			}
			if (i = elements04.length - 1) {
				if (elements04[i].innerHTML < dtToday.getTime()) {
					elements04[i].style.color = "#FF0000";
					elements04[i].style.backgroundColor = "#FF0000";
				}
			}
		}
	}
	setTimeout(refresh02, 50);
