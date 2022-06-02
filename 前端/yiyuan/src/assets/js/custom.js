$(document).ready(function() {
  "use strict";
    var video_data;
    var video_frame;
    var top_bar;
    var nav_bar;
    var secondary_bar;
    //===============Mobile nav Function============
	var menu = $("#menu");
    menu.on('click', function() {
        if ($(window).width() <= 767) {
            $('.navigation').slideToggle('normal');
        }
		return false;
    })
   $('.navigation>ul> li >a').on('click', function() { 
        if ($(window).width() <= 767) {
            $('.navigation>ul> li').removeClass('on');
            $('.navigation>ul> li> ul').slideUp('normal');
            if ($(this).next().next('ul').is(':hidden') == true) {
                $(this).parent('li').addClass('on');
                $(this).next().next('ul').slideDown('normal');
            }
        }
		//return false;
    });
	 $('.sub-menu >a').on('click', function() { 
        if ($(window).width() <= 767) {
            $('.sub-menu').removeClass('on');
            $('.sub-menu> ul').slideUp('normal');
            if ($(this).next().next('ul').is(':hidden') == true) {
                $(this).parent('li').addClass('on');
                $(this).next().next('ul').slideDown('normal');
            }
        }
		//return false;
    });
	
	/* ---------------------
	 Owl Slider
	 /* --------------------- */
	var testimonial = $("#testimonial");
	testimonial.owlCarousel({
		autoPlay : 5000, //Set AutoPlay to 3 seconds
		items : 1,
		itemsDesktop : [1170, 1],
		itemsDesktopSmall : [1024, 1],
		itemsTabletSmall : [768, 1],
		itemsMobile : [480, 1],
		navigation : false,
		pagination : false,
		transitionStyle : "fade"

	});
	//==============
	
	var team_carousel = $("#team-carousel");
	team_carousel.owlCarousel({
		autoPlay : 5000,
		items : 4,
		itemsDesktop : [1170, 3],
		itemsDesktopSmall : [1024, 3],
		itemsTabletSmall : [768, 2],
		itemsMobile : [480, 1],
		navigation : true,
		pagination : false,
		navigationText : ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"]
		
	})
	//===========
	
	var services_block = $("#services-block");
	if (services_block.length) {

		services_block.owlCarousel({
			items : 1,
			itemsDesktop : [1199, 1],
			itemsDesktopSmall : [979, 1],
			itemsTablet : [768, 1],
			itemsMobile : [600, 1],
			navigation : true,
			pagination : false,
			navigationText : ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"]

		});

	}
	//=======================
	
	var blog_carousel = $("#blog-carousel");
	if (blog_carousel.length) {
		blog_carousel.owlCarousel({
			items : 1,
			itemsDesktop : [1199, 1],
			itemsDesktopSmall : [979, 1],
			itemsTablet : [768, 1],
			itemsMobile : [600, 1],
			navigation : true,
			pagination : false,
			navigationText : ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"]

		});

	}
	//==========================================
	//===============Accordion Function============
	$(".accordion-title").on('click',function() {
		$(this).next().slideToggle("easeOut"), $(this).toggleClass("active"), $("accordion-title").toggleClass("active"), $(".accordion-content").not($(this).next()).slideUp("easeIn"), $(".accordion-title").not($(this)).removeClass("active")
	}), $(".accordion-content").addClass("defualt-hidden");
	//==========================================
	//===============Video Function============
	var video_btn = $("#video-btn");
	video_btn.on('click', function() {
		var video_data = $(this).next().attr('data-video');
		var video_frame = $(this).after("<iframe src='' class='video_frame'>  </iframe>");
		$('.video_frame').attr('src', video_data);
		$(this).hide();
		return false;
	});
	//==========================================
	//===============counter Function========
	var counter = $(".counter");
	if (counter.length) {
		counter.appear(function() {
			$(".counter").each(function() {
				var e = $(this),
				    a = e.attr("data-count");
				$({
					countNum : e.text()
				}).animate({
					countNum : a
				}, {
					duration : 8e3,
					easing : "linear",
					step : function() {
						e.text(Math.floor(this.countNum))
					},
					complete : function() {
						e.text(this.countNum)
					}
				})
			})
		})
	}
	//==========================================
	//===============Datepicker Function========
	var datepicker_js = $(".datepicker");
	if (datepicker_js.length) {
		datepicker_js.datepicker();
	}

	//==========================================
	//===============Fancylight box Function========
	var gallery = $("#gallery");
	if (gallery.length) {
		gallery.fancybox({
			openEffect : 'elastic',
			closeEffect : 'elastic',

			helpers : {
				media : {}
			}
		});
		 $(".fancy-media").fancybox({
    width: 620, // or whatever
    height: 420,
    type: "iframe",
    iframe : {
      preload: false
    }
  });

	}
	//===============header Function============
	var top_bar = $('#top-bar').height();
	var nav_bar = $('.nav-wrap').height();
	var secondary_bar = $('.secondary-header').height();
	var $headerOne = $('.header-1');
	var $headerTwo = $('.header-2');
	if ($('.header-style').hasClass('fix-header')) {
		$('body').addClass('p-top');
	}
	$(window).scroll(function() {
		if ($headerTwo.hasClass('fix-header')) {

			if ($(window).scrollTop() >= secondary_bar) {
				$headerTwo.addClass('fix');

			} else {
				$headerTwo.removeClass('fix');
			}

		}

		if ($headerOne.hasClass('fix-header')) {
			if ($(window).scrollTop() >= top_bar) {
				$headerOne.addClass('fix');
			} else {
				$headerOne.removeClass('fix');
			}
		}

	});


});

	$(window).load(function() {
		//===============Loader Function========
		$("#preloader").fadeOut();
		//==========================================
		//===============Doctors filter Function========
		var isotope_js = $("#gallery");
		if (isotope_js.length) {
			// init Isotope
			var $grid = $('.isotope').isotope({
				itemSelector : '.item	',
				percentPosition : true,
				layoutMode : 'fitRows',
				fitRows : {
					gutter : 0
				}
			});
			// filter items on button click
			$('.filter-button-group').on('click', 'a', function() {
				var filterValue = $(this).attr('data-filter');
				$grid.isotope({
					filter : filterValue
				});
				var text_value = $(this).text();
				$('.doctor-specialist span').text(text_value);
			});
		}
		if ($('.masonry').length) {
			// init Isotope
			var $grid = $('.masonry').isotope({
				itemSelector : '.item	',
				percentPosition : true,
				layoutMode : 'fitRows',
				fitRows : {
					gutter : 0
				}
			});
		}
		 //Swicher Style
		$("body").append('<div id="style-switcher"></div>');
		$("#style-switcher").load("theme-option/swicher.html")
	}) 
	