/*-------------------------------------------------*\
   Javascript sheet for the Megamenu Navigation
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

  
   - Megamenu Toolboox on hover and solution on hover  
   - Megamenu Sticky
   - Language Dropdown
   - Mobile Menu Accordion
   - Submenu Image change on hover  
   
\*-------------------------------------------------*/

/*-------------------------------------------*\
    Megamenu Onhover
\*-------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  // ******* Megamenu onhover********//
  const targetToolbox = document.querySelectorAll(".dropdown-hover-menu");

  if (targetToolbox) {
    targetToolbox.forEach((box) => {
      box.addEventListener("mouseover", mtOver, false);
      box.addEventListener("mouseout", mtOut, false);
    });
  }

  function mtOver() {
    const bgChangeTopbar = document.getElementById("cmp-bg-change");
    const bgChangeNavbar = document.getElementById("cmp-bg-navbar");
    const bgChangeb = document.getElementById("headerMobileHamburger");

    if (bgChangeTopbar) {
      bgChangeTopbar.classList.add("cmp-bg-change-top");
      bgChangeTopbar.style.visibility = "unset";
    }

    if (bgChangeNavbar) {
      bgChangeNavbar.classList.add("cmp-bg-change-navbar");
      bgChangeNavbar.style.visibility = "unset";
    }

    if (bgChangeb) {
      const newItem = document.createElement("div");
      newItem.id = "navBgdropback";
      newItem.className = "background-dropback-menu";
      bgChangeb.appendChild(newItem);
    }
  }

  function mtOut() {
    const someElement = document.getElementById("cmp-bg-change");
    const someElement1 = document.getElementById("cmp-bg-navbar");
    const someElement2 = document.getElementById("navBgdropback");

    if (someElement) {
      someElement.classList.remove("cmp-bg-change-top");
      someElement.style.zIndex = "";
    }

    if (someElement1) {
      someElement1.classList.remove("cmp-bg-change-navbar");
      someElement1.style.zIndex = "";
    }

    if (someElement2) {
      someElement2.remove();
    }
  }
});

/*-------------------------------------------*\
    Megamenu Sticky Header
\*-------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  const header = document.getElementById("cmp-bg-navbar");

  const addClassHeader = () => {
    if (header) {
      header.classList.add("cmp-sticky");
    }
  };

  const removeClassHeader = () => {
    if (header) {
      header.classList.remove("cmp-sticky");
    }
  };

  window.addEventListener("scroll", function () {
    let getScrollposition = window.scrollY;
    if (getScrollposition > 0) {
      addClassHeader();
    } else {
      removeClassHeader();
    }
  });
});

/*-------------------------------------------*\
    Language Dropdown Background
\*-------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  // ******* Language ********//

  const languageDropdown = document.querySelectorAll("#cmp-language");

  if (languageDropdown) {
    languageDropdown.forEach((box) => {
      box.addEventListener("mouseover", mtOver, false);
      box.addEventListener("mouseout", mtOut, false);
    });
  }

  function mtOver() {
    const bgChangeb = document.getElementById("cmp-language-nav");
    if (bgChangeb) {
      const newItem = document.createElement("div");
      newItem.id = "bgdropback";
      newItem.className = "background-dropback";
      bgChangeb.appendChild(newItem);
    }
  }

  function mtOut() {
    const someElement2 = document.getElementById("bgdropback");
    if (someElement2) {
      someElement2.remove();
    }
  }
});


/*-------------------------------------------*\
    Mobile Menu Accordion
\*-------------------------------------------*/


let mbAccordion = document.querySelectorAll(".dropdown-toggle-m");
let mbMenuClass = document.querySelectorAll(".dropdown-hover");
let mbMenuAccordion = document.querySelectorAll(".dropdown-toggle-show");

if (mbAccordion) {
  if (window.innerWidth < 768) {
    if (mbAccordion) {
      mbAccordion.forEach((accordion) => {
        accordion.setAttribute("data-bs-toggle", "dropdown");
      });
    }

    if (mbMenuClass) {
      mbMenuClass.forEach((menuclass) => {
        menuclass.classList.add("mb-disable-hover");
      });
    }

    
  } else {
    if (mbAccordion) {
      mbAccordion.forEach((accordion) => {
        accordion.removeAttribute("data-bs-toggle", "dropdown");
      });
    }
    if (mbMenuClass) {
      mbMenuClass.forEach((menuclass) => {
        menuclass.classList.remove("mb-disable-hover");
      });
    }
    
  }
}

/*-------------------------------------------*\
    Submenu Image change on hover
\*-------------------------------------------*/


window.addEventListener("DOMContentLoaded", () => {
  let imagechange = document.querySelectorAll(".submenu-link");
  if(imagechange){
    imagechange.forEach((el) =>
    el.addEventListener("mouseenter", function (event) {
      let imagedwn =  el.dataset.image;
      document.querySelector(".img-fluid").src = imagedwn;
    })
    );
  }

  let imagetoolbox = document.querySelector(".menu-toolbox");
  if(imagetoolbox){
    imagechange.forEach((el) => 
      el.addEventListener("mouseleave", function (event) {
        let imgdwn = imagetoolbox.dataset.subsectionimage;
        document.querySelector(".img-fluid").src = imgdwn;        
      })
    )
    imagetoolbox.addEventListener("mouseenter", function (event){
      let imgdwn = imagetoolbox.dataset.subsectionimage;
      document.querySelector(".img-fluid").src = imgdwn;
    })
  }
});
