/*-------------------------------------------------*\
   jQuery sheet for the Solution Component Parallax For homepage
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

   - Solution Component Parallax
   
\*-------------------------------------------------*/
/*-------------------------------------------*\
       Solution Component Parallax
\*-------------------------------------------*/

import * as JQuery from "jquery";
const $ = JQuery.default;

(function ($) {
  /** change value here to adjust parallax level */
  let parallax = -0.5;

  let $bg_images = $(".image-bg-div");
  let offset_tops = [];
  if ($bg_images) {
    $bg_images.each(function (i, el) {
      offset_tops.push($(el).offset().top);
    });
  }

  $(window).scroll(function () {
    let dy = $(this).scrollTop();
    if ($bg_images) {
      $bg_images.each(function (i, el) {
        let ot = offset_tops[i];
        $(el).css("background-position", "50% " + (dy - ot) * parallax + "px");
      });
    }
  });
})($);



