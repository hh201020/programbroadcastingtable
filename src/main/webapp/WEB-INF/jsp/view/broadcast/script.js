     var time = new Date().getTime();
     $(document.body).bind("mousemove keypress", function(e) {
         time = new Date().getTime();
     });

     function refresh01() {
         if(new Date().getTime() - time >= 5000) {
             window.location.reload(true);
         }
         else 
             setTimeout(refresh01, 1000);
     }
     setTimeout(refresh01, 1000);
     
     function refresh02() {


             var elements = window.document.querySelectorAll(".myClass");
             
             for (var i in elements)
             {
         		var dtToday = new Date();
         		if(elements[i].innerHTML > dtToday.getTime()){
	         		elements[i].style.color = "#00FF00";
	         		elements[i].style.backgroundColor = "#00FF00";
	         		if(i>1){
	         		elements[i-1].style.color = "#FF0000";
	         		elements[i-1].style.backgroundColor = "#FF0000";
	         		}
	         		break;
	             }
         		if(i= elements.length-1){
             		if(elements[i].innerHTML < dtToday.getTime()){
    	         		elements[i].style.color = "#FF0000";
    	         		elements[i].style.backgroundColor = "#FF0000";
    	             }
         		 }
             }
             var elements02 = window.document.querySelectorAll(".myClass02");
             
             for (var i in elements02)
             {
         		var dtToday02 = new Date();
         		if(elements02[i].innerHTML > dtToday02.getTime()){
	         		elements02[i].style.color = "#00FF00";
	         		elements02[i].style.backgroundColor = "#00FF00";
	         		if(i>1){
	         		elements02[i-1].style.color = "#FF0000";
	         		elements02[i-1].style.backgroundColor = "#FF0000";}
	         		break;
	             }
         		if(i= elements02.length-1){
             		if(elements02[i].innerHTML < dtToday02.getTime()){
    	         		elements02[i].style.color = "#FF0000";
    	         		elements02[i].style.backgroundColor = "#FF0000";
    	             }
         		 }
             }
             var elements03 = window.document.querySelectorAll(".myClass03");
             
             for (var i in elements03)
             {
         		var dtToday03 = new Date();
         		if(elements03[i].innerHTML > dtToday03.getTime()){
	         		elements03[i].style.color = "#00FF00";
	         		elements03[i].style.backgroundColor = "#00FF00";
	         		if(i>1){
	         		elements03[i-1].style.color = "#FF0000";
	         		elements03[i-1].style.backgroundColor = "#FF0000";}
	         		break;
	             }
         		if(i= elements03.length-1){
             		if(elements03[i].innerHTML < dtToday03.getTime()){
    	         		elements03[i].style.color = "#FF0000";
    	         		elements03[i].style.backgroundColor = "#FF0000";
    	             }
         		 }
             }
             var elements04 = window.document.querySelectorAll(".myClass04");

             for (var i in elements04)
             {
         		var dtToday04 = new Date();

         		if(elements04[i].innerHTML > dtToday04.getTime()){
	         		elements04[i].style.color = "#00FF00";
	         		elements04[i].style.backgroundColor = "#00FF00";
	         		if(i>1){
	         		elements04[i-1].style.color = "#FF0000";
	         		elements04[i-1].style.backgroundColor = "#FF0000";}
	         		break;
	             }
         		if(i= elements04.length-1){
             		if(elements04[i].innerHTML < dtToday04.getTime()){
    	         		elements04[i].style.color = "#FF0000";
    	         		elements04[i].style.backgroundColor = "#FF0000";
    	             }
         		 }
             }
     }
     setTimeout(refresh02, 50);
