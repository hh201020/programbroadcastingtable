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
								<td class="helpHed">NY 美东</td>
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
								<td class="helpHed">美西</td>
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
								<td class="helpHed">CN 大陆</td>
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
	
	<tt id="ifContentChanged" style="color: #333333">${ifContentChanged}</tt>
</template:basic>

<script src="<c:url value="/resource/js/CurrentColor.js" />"></script>
<script src="<c:url value="/resource/js/jBeep.js" />"></script>
