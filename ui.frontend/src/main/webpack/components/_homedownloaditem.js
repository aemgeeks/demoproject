/*-------------------------------------------------*\
   Javascript sheet for the Component downlaod home item For homepage
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

   - Home Download Item JSON
   
   
\*-------------------------------------------------*/
/*-------------------------------------------*\
       Home Download Item JSON
\*-------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  let homePageButton = document.querySelectorAll(".download-clicks");
  if (homePageButton) {
    homePageButton.forEach((el) =>
      el.addEventListener("click", function () {
        if (el.hasAttribute("data-assetpath")) {
          el.removeAttribute("target");
          el.removeAttribute("href");
          let assetPath = el.dataset.assetpath;
          let uuid = "Dra787cReinforce";
          el.setAttribute("data-uuid", uuid);
          let titleElement = document.querySelectorAll(".cmp-teaser__title");
          let imageElement = document.querySelectorAll(".cmp-image__image");
          let title = titleElement[titleElement.length - 2].innerText;
          let image = imageElement[imageElement.length - 2].src;
          let homeJSON = [
            {
              title: title,
              imgPath: image,
              uuid: uuid,
              assetPath: assetPath,
            },
          ];
          window.localStorage.setItem("results", JSON.stringify(homeJSON));
          addToDownload(el);
        }
      })
    );
  }
});
