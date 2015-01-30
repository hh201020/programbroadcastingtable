/**
 * jBeep
 * 
 * Play WAV beeps easily in javascript!
 * Tested on all popular browsers and works perfectly, including IE6.
 * 
 * @date 10-19-2012
 * @license MIT
 * @author Everton (www.ultraduz.com.br)
 * @version 1.0
 * @params soundFile The .WAV sound path
 */
function jBeep(soundFile){
	
	if (!soundFile) soundFile = "resource/sounds/harp.mp3";
	
	var soundElem, bodyElem, isHTML5;
	
	isHTML5 = true;
	try {
		if (typeof document.createElement("audio").play=="undefined") isHTML5 = false;
	}
	catch (ex){
		isHTML5 = false;
	}	

	bodyElem = document.getElementsByTagName("body")[0];	
	if (!bodyElem) bodyElem = document.getElementsByTagName("html")[0];
	
	soundElem = document.getElementById("jBeep");		
	if (soundElem) bodyElem.removeChild(soundElem);

	if (isHTML5) {

		soundElem = document.createElement("audio");
		soundElem.setAttribute("id", "jBeep");
		soundElem.setAttribute("src", soundFile);
		soundElem.play();

	}
	else if(navigator.userAgent.toLowerCase().indexOf("msie")>-1){		
		
		soundElem = document.createElement("bgsound");
		soundElem.setAttribute("id", "jBeep");
		soundElem.setAttribute("loop", 1);
		soundElem.setAttribute("src", soundFile);

		bodyElem.appendChild(soundElem);

	}
	else {
		
		var paramElem;
		
		soundElem = document.createElement("object");
		soundElem.setAttribute("id", "jBeep");
		soundElem.setAttribute("type", "audio/wav");
		soundElem.setAttribute("style", "display:none;");
		soundElem.setAttribute("data", soundFile);
		
		paramElem = document.createElement("param");
		paramElem.setAttribute("name", "autostart");
		paramElem.setAttribute("value", "false");
		
		soundElem.appendChild(paramElem);
		bodyElem.appendChild(soundElem);
		
		try {
			soundElem.Play();
		}
		catch (ex) {
			soundElem.object.Play();
		}
		
	}
	
}

var RED = "#AA22EE";
var ORANGE = "#FF8822";

var elements00;
var elementsProgram00;
var currentDate00;
var dtToday; 
var elements;
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

function refresh03() {
	elements00 = window.document.querySelectorAll(".myClass00");
	elementsProgram00 = window.document
			.querySelectorAll(".programName00");
	currentDate00 = window.document.querySelectorAll(".currentDate00");
	dtToday = new Date();

	for ( var i in elements00) {
		if (elements00[i].innerHTML > dtToday.getTime()) {
			var contentChanged = window.document.getElementById('ifContentChanged');
			if(contentChanged.innerHTML == "true")
				jBeep();
			break;
		}
	}
}

setTimeout(refresh03, 50);