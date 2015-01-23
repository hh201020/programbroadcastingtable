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
	
