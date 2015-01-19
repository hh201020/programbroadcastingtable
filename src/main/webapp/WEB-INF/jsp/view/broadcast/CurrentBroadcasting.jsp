<%@ include file="/WEB-INF/jsp/base.jspf"%>
<%--@elvariable id="tickets" type="java.util.List<com.wrox.site.Ticket>"--%>
<template:basic htmlTitle="${listTitle}" bodyTitle="${listTitle}">

	<c:choose>
		<c:when test="${fn:length(tickets01) == 0}">
			<i>No Program</i>
		</c:when>
		<c:otherwise>

			<table>
				<tr>
					<td>
						<table class="maintable00">
							<tr>
								<td class="helpHed">TIME</td>
								<td class="helpHed"></td>
								<td class="helpHed"></td>
							</tr>
							<c:forEach items="${tickets01}" var="ticket01">
								<tr style="border-bottom:1pt solid white;">
									<td class="currentDate00">${ticket01.startTime}</td>
									<td class="myClass00">${ticket01.startAtGMT}</td>
									<td class="programName00"><c:out
											value="" /> <br /></td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td>
						<table class="maintable">
							<tr>
								<td class="helpHed">NY 美东</td>
								<td class="helpHed"></td>
								<td class="helpHed"></td>
							</tr>
							<c:forEach items="${tickets01}" var="ticket01">
								<tr style="border-bottom:1pt solid white;">
									<td class="programName01"><c:out
											value="${ticket01.programName}" /> <br /></td>
									<td class="currentDate">${ticket01.tvProgramCode}</td>
									<td class="myClass">${ticket01.startAtGMT}</td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td>
						<table class="maintable">
							<tr>
								<td class="helpHed">LA 美西</td>
								<td class="helpHed"></td>
								<td class="helpHed"></td>
							</tr>
							<c:forEach items="${tickets02}" var="ticket02">
								<tr style="border-bottom:1pt solid white;">
									<td class="programName02"><c:out
											value="${ticket02.programName}" /><br /></td>
									<td class="currentDate02">${ticket02.tvProgramCode}</td>
									<td class="myClass02">${ticket02.startAtGMT}</td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td>
						<table class="maintable">
							<tr>
								<td class="helpHed">CN 大陆</td>
								<td class="helpHed"></td>
								<td class="helpHed"></td>
							</tr>
							<c:forEach items="${tickets03}" var="ticket03">
								<tr style="border-bottom:1pt solid white;">
									<td class="programName03"><c:out
											value="${ticket03.programName}" /><br /></td>
									<td class="currentDate03">${ticket03.tvProgramCode}</td>
									<td class="myClass03">${ticket03.startAtGMT}</td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td>
						<table class="maintable">
							<tr>
								<td class="helpHed">EU 欧洲</td>
								<td class="helpHed"></td>
								<td class="helpHed"></td>
							</tr>
							<c:forEach items="${tickets04}" var="ticket04">
								<tr style="border-bottom:1pt solid white;">
									<td class="programName04"><c:out
											value="${ticket04.programName}" /><br /></td>
									<td class="currentDate04">${ticket04.tvProgramCode}</td>
									<td class="myClass04">${ticket04.startAtGMT}</td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
</template:basic>

<script>
	var RED = "#AA22EE";
	var ORANGE = "#FF8822";

	var time = new Date().getTime();
	$(document.body).bind("mousemove keypress", function(e) {
		time = new Date().getTime();
	});

	function refresh01() {
		if (new Date().getTime() - time >= 5000) {
			window.location.reload(true);
		} else
			setTimeout(refresh01, 1000);
	}

	setTimeout(refresh01, 1000);
	
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

</script>
