/*-------------------------------------------------*\
   Javascript sheet for the Language Selector
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

  
   - Language placeholder change
   
\*-------------------------------------------------*/


/*-------------------------------------------*\
    Language placeholder change
\*-------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {

  let en = "English";
  let es = "Español";

  if (document.documentElement.lang.toLowerCase().includes("en")) {

    document.querySelectorAll(".language-append").forEach((el) => {
      el.innerText = en;
    }
    );

  }
  else if (document.documentElement.lang.toLowerCase().includes("es")) {

    document.querySelectorAll(".language-append").forEach((el) => {
      el.innerText = es;
    }
    );

  }
  else {

    document.querySelectorAll(".language-append").forEach((el) => {
      el.innerText = en;
    }
    );
    
  }

  let langButton = document.querySelectorAll(".language-selection");

  if (langButton) {
    langButton.forEach((el) =>
      el.addEventListener("click", function () {
        el.classList.add("selected");
      })
    );
  }

});
