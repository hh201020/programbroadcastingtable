<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ attribute name="htmlTitle" type="java.lang.String"
	rtexprvalue="true" required="true"%>
<%@ attribute name="bodyTitle" type="java.lang.String"
	rtexprvalue="true" required="true"%>
<%@ attribute name="headContent" fragment="true" required="false"%>
<%@ attribute name="navigationContent" fragment="true" required="true"%>
<%@ include file="/WEB-INF/jsp/base.jspf"%>
<!DOCTYPE html>
<html>
<!-- <meta http-equiv="refresh" content="50" > -->
<head>
<title>NTDTV :: <c:out
		value="${fn:trim(htmlTitle)}" /></title>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<c:url value="/resource/stylesheet/main.css" />" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.0.0/moment.min.js"></script>
<script type="text/javascript" lang="javascript">
	var postInvisibleForm = function(url, fields) {
		var form = $('<form id="mapForm" method="post"></form>').attr({
			action : url,
			style : 'display: none;'
		});
		for ( var key in fields) {
			if (fields.hasOwnProperty(key))
				form.append($('<input type="hidden">').attr({
					name : key,
					value : fields[key]
				}));
		}
		$('body').append(form);
		form.submit();
	};
	var newChat = function() {
		postInvisibleForm('<c:url value="/chat/new" />', {});
	};
</script>
<jsp:invoke fragment="headContent" />
</head>
<body>
    <div align="center">
	<br>
	<br>
	<h1 align="center">
		<font size="6"> NTDTV BROADCASTING TABLE
		</font>
	</h1>
	</br>
	<script type="text/javascript">
		document
				.write(
						'<h2 align="center"> <font size="3">Current Time : <span id="date-time">',
						new Date().toString(), '<\/span>.<\/font><\/h2>')
		if (document.getElementById)
			onload = function() {
				setInterval(
						"document.getElementById ('date-time').firstChild.data = new Date().toString()",
						50)
			}
	</script>
	<table border="0" id="bodyTable">
		<tbody>
			<tr>
				<td class="sidebarCell"><jsp:invoke
						fragment="navigationContent" /></td>
				<td class="contentCell">
					<h2>
						<c:out value="${fn:trim(bodyTitle)}" />
					</h2> <jsp:doBody />
				</td>
			</tr>
		</tbody>
	</table>
	</div>
</body>
</html>
