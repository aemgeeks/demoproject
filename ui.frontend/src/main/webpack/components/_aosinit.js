/*-------------------------------------------------*\
   Javascript sheet for the AOS Animation For All 
   Page
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

   - Initating AOS Animation
   - project-dramix-container
   
\*-------------------------------------------------*/
/*-------------------------------------------*\
            Initating AOS Animation
\*-------------------------------------------*/
import AOS from 'aos';

window.addEventListener("DOMContentLoaded", () => {

    const projectdramixcontainer = document.querySelector(".teaser-scroll-up");
    if (projectdramixcontainer) {
        projectdramixcontainer.setAttribute('data-aos', 'fade-up');
        projectdramixcontainer.setAttribute('data-aos-duration', '2000');
    }

    AOS?.init({
        initClassName: "aos-init",
        startEvent: "DOMContentLoaded",
    });
});
