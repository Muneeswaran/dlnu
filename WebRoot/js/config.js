// JavaScript Document

//Dropdown hover

            jQuery(document).ready(function(){
        
$('.menu li').hover(function () {
    $(this).find(".sub-menu").slideDown("medium");
    },
	function(){
	    $(this).find(".sub-menu").slideUp("fast");
	});
		            });


//slider
$(document).ready(function(){
	$('#slider').plusSlider({
			sliderEasing: 'easeInOutExpo', // Anything other than 'linear' and 'swing' requires the easing plugin
			fullWidth: true,
			sliderType: 'fader' // Choose whether the carousel is a 'slider' or a 'fader'
		});
});





