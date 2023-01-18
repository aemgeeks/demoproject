/*-------------------------------------------------*\
   Javascript sheet for the Solution Component Parallax For homepage
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

   - Boostrap Slider show next panel
   
\*-------------------------------------------------*/
/*-------------------------------------------*\
       Boostrap Slider show next panel
\*-------------------------------------------*/
let slides = document.querySelectorAll('.teasercards .carousel .carousel-item');

if (slides) {
    slides.forEach((el) => {
        // number of slides per carousel-item
        const minPerSlide = slides.length;
        let next = el.nextElementSibling;
        for (let i = 1; i < minPerSlide; i++) {
            if (!next) {
                // wrap carousel by using first child
                next = slides[0];
            }
            let cloneChild = next.cloneNode(true);
            el.appendChild(cloneChild.children[0]);
            next = next.nextElementSibling;
        }
    });
}