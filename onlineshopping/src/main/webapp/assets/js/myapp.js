
$(function(){
	
	switch(menu){
	
	case 'About us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
		
	default:
		$('#menu').addClass('active');
	    $('#a_'+menu).addClass('active');
	    break;
}
});



//// Get the container element
//var btnContainer = document.getElementById("navbarResponsive");
//
//// Get all buttons with class="btn" inside the container
//var btns = btnContainer.getElementsByClassName("menu");
//
//// Loop through the buttons and add the active class to the current/clicked button
//for (var i = 0; i < btns.length; i++) {
//  btns[i].addEventListener("click", function() {
//    var current = document.getElementsByClassName("active");
//    current[0].className = current[0].className.replace(" active", "");
//    this.className += " active";
//  });
//}