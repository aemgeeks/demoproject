/*-------------------------------------------------*\
   Javascript sheet for the Component Add to Download
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

   - Add to download functionality
   - Add to download button
   - Append the items in the download section
   - Delete the item
   
\*-------------------------------------------------*/

/*-------------------------------------------*\
      Add to download functionality
\*-------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  let DownloadContent = [];
  const downloadLiElement = document.querySelector(".download-li ul");
  if (downloadLiElement) {
    window.onpageshow = function (event) {
      let spans = document.querySelectorAll(".span_timeout");
      for (let i = 0; i < spans.length; i++) {
        spans[i].classList.remove("d-md-block");
        spans[i].classList.add("d-none");
      }

      if (window.localStorage.getItem("downloadContent_") !== null) {
        DownloadContent = JSON.parse(
          window.localStorage.getItem("downloadContent_")
        );
        if (DownloadContent != null && DownloadContent != undefined)
          appendDownloadData(DownloadContent);

        document.querySelector(".cmp-button").disabled = false;
        if (
          document
            .querySelector(".download-button-c")
            .classList.contains("anchor_tag_download")
        )
          document
            .querySelector(".download-button-c")
            .classList.remove("anchor_tag_download");
      } else {
        removeDotOnFolder();
      }

      /*-------------------------------------------*\
      Add to download button
  \*-------------------------------------------*/

      window.addToDownload = function (el) {
        let assetResults = JSON.parse(window.localStorage.getItem("results"));

        let uuid = el.dataset.uuid;

        let filteredHomes = assetResults.filter((x) => x.uuid == uuid);
        let getItem = DownloadContent.filter(
          (x) => x.uuid == filteredHomes[0].uuid
        );
        let tooltipMessage = document.querySelectorAll(".span_timeout");
        if (getItem.length) {
          for (let i = 0; i < tooltipMessage.length; i++) {
            tooltipMessage[i].innerText =
              tooltipMessage[i].dataset.existingfile;
            tooltipMessage[i].classList.remove("d-none");
            tooltipMessage[i].style.display = "block";
          }
          timeOut();
        } else {
          DownloadContent.push(filteredHomes[0]);
          for (let i = 0; i < tooltipMessage.length; i++) {
            tooltipMessage[i].innerText =
              tooltipMessage[i].dataset.validationmessage;
            tooltipMessage[i].classList.remove("d-none");
            tooltipMessage[i].style.display = "block";
          }

          appendDownloadData(DownloadContent);
          timeOut();
          if (
            DownloadContent.length == 1 &&
            DownloadContent != null &&
            DownloadContent != undefined
          ) {
            document.querySelector(".addToDownload").click();
            document.querySelector(".cmp-button").disabled = false;
            if (
              document
                .querySelector(".download-button-c")
                .classList.contains("anchor_tag_download")
            )
              document
                .querySelector(".download-button-c")
                .classList.remove("anchor_tag_download");
          }
        }
        window.localStorage.setItem(
          "downloadContent_",
          JSON.stringify(DownloadContent)
        );
      };
      let mobileDownloadButton = document.querySelector(".mobile-download");
      mobileDownloadButton.addEventListener(
        "click",
        function () {
          document.querySelector(".addToDownload").click();
        },
        false
      );

      function timeOut() {
        setTimeout(function () {
          let spans = document.querySelectorAll(".span_timeout");
          for (let i = 0; i < spans.length; i++) {
            spans[i].classList.remove("d-md-block");
            spans[i].classList.add("d-none");
          }
        }, 1500);
      }

      /*-------------------------------------------*\
      Append the items in the download section
    \*-------------------------------------------*/

      function appendDownloadData(DownloadContents) {
        let downloadLiTag = "";
        let projectTitle;
        let prjectDescription;
        let assetPath;
        let uuid;
        let listingPageData;
        let assetRenditionImgPath48;
        while (downloadLiElement.hasChildNodes()) {
          downloadLiElement.removeChild(downloadLiElement.firstChild);
        }

        let siteLanguage;
        if (document.querySelector(".language-append").innerHTML == "Español")
          siteLanguage = "Español";
        else if (
          document.querySelector(".language-append").innerHTML == "English"
        )
          siteLanguage = "English";

        for (let i = DownloadContents.length - 1; i >= 0; i--) {
          if (DownloadContents[i].assetPath.includes("whitepaper")) {
            if (siteLanguage == "English") listingPageData = "Whitepaper";
            else listingPageData = "Guías informativas";

            projectTitle = DownloadContents[i].title;
            prjectDescription = DownloadContents[i].description;
            uuid = DownloadContents[i].uuid;
            assetRenditionImgPath48 =
              DownloadContents[i].assetRenditionImgPath48;
            if ("path" in DownloadContents[i])
              imgPath = DownloadContents[i].url;
            else if ("assetPath" in DownloadContents[i])
              imgPath = DownloadContents[i].imgPath;
          } else if (
            DownloadContents[i].assetPath.includes("productdatasheet")
          ) {
            if (siteLanguage == "English")
              listingPageData = "Product datasheet";
            else listingPageData = "Fichas técnicas";
            projectTitle = DownloadContents[i].title;
            prjectDescription = DownloadContents[i].description;
            uuid = DownloadContents[i].uuid;
            assetRenditionImgPath48 =
              DownloadContents[i].assetRenditionImgPath48;
            if ("path" in DownloadContents[i])
              imgPath = DownloadContents[i].url;
            else if ("assetPath" in DownloadContents[i])
              imgPath = DownloadContents[i].imgPath;
          } else if (DownloadContents[i].assetPath.includes("certificate")) {
            if (siteLanguage == "English") listingPageData = "Certificate";
            else listingPageData = "Certificado";
            projectTitle = DownloadContents[i].title;
            prjectDescription = DownloadContents[i].description;
            uuid = DownloadContents[i].uuid;
            assetRenditionImgPath48 =
              DownloadContents[i].assetRenditionImgPath48;
            if ("path" in DownloadContents[i])
              imgPath = DownloadContents[i].url;
            else if ("assetPath" in DownloadContents[i])
              imgPath = DownloadContents[i].imgPath;
          } else if (
            DownloadContents[i].assetPath.includes("projects") ||
            DownloadContents[i].assetPath.includes("proyectos")
          ) {
            if (siteLanguage == "English") listingPageData = "Project";
            else listingPageData = "Proyectos";
            projectTitle = DownloadContents[i].title;
            imgPath = DownloadContents[i].imgPath;
            uuid = DownloadContents[i].uuid;
            assetRenditionImgPath48 =
              DownloadContents[i].assetRenditionImgPath48;
            if ("path" in DownloadContents[i])
              imgPath = DownloadContents[i].url;
            else if ("assetPath" in DownloadContents[i])
              imgPath = DownloadContents[i].imgPath;
          } else if (DownloadContents[i].assetPath.includes("Brochure")) {
            if (siteLanguage == "English") listingPageData = "Brochure";
            else listingPageData = "Folleto";
            projectTitle = DownloadContents[i].title;
            imgPath = DownloadContents[i].imgPath;
            uuid = DownloadContents[i].uuid;
          }

          let hideElementClass = "";
          if (
            DownloadContents[i].assetRenditionImgPath48 == undefined ||
            DownloadContents[i].assetRenditionImgPath48 == null
          )
            hideElementClass = "d-none";
          downloadLiTag += `<li id='${uuid}'> 
      <div class="product-divs mb-3">
       <div class="img-div-download"> 
        <img class="thumbnail-image" src="${imgPath}" alt="document">
         <img class="image-small-icon position-absolute ${hideElementClass}" src="${assetRenditionImgPath48}" alt="edit">
         </div>
         <div class="text-download p-3">
             <div class="text-download-head"> 
             ${listingPageData} 
            </div> 
            <div class="text-download-text">
              ${projectTitle}
            </div>
        </div>
        <a class="delete_item" data-uuid="${uuid}">
         <img class="trash-icon-div" src="/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/Trash.svg" alt="trash">
     </a></div>  </li>`;
        }
        setTimeout(function () {
          downloadLiElement.append(...cleanHTML(downloadLiTag, true));

          // Scroll top for every added item

          let scrollTopElement = document.getElementById("scroll_top");
          scrollTopElement.scrollIntoView({
            block: "start",
            behavior: "smooth",
          });

          // shows the dot-icon

          let spanElements = document.querySelectorAll(".cmp-dot");
          for (let i = 0; i < spanElements.length; i++) {
            spanElements[i].classList.remove("d-none");
            spanElements[i].classList.add("d-block");
          }
          deleteItem();
        }, 50);
      }

      /*-------------------------------------------*\
      Delete the item
\*-------------------------------------------*/

      window.deleteItem = () => {
        document.querySelectorAll(".delete_item").forEach((el) =>
          el.addEventListener("click", function () {
            let uuid = el.dataset.uuid;

            DownloadContent = JSON.parse(
              window.localStorage.getItem("downloadContent_")
            );

            for (let i = 0; i < DownloadContent.length; i++) {
              if (uuid == DownloadContent[i].uuid) {
                DownloadContent.splice(i, 1);
                document.getElementById(uuid).remove();
              }
            }
            if (
              DownloadContent.length != 0 &&
              DownloadContent != null &&
              DownloadContent != undefined
            ) {
              window.localStorage.setItem(
                "downloadContent_",
                JSON.stringify(DownloadContent)
              );
              document.querySelector(".cmp-button").disabled = false;
              if (
                document
                  .querySelector(".download-button-c")
                  .classList.contains("anchor_tag_download")
              )
                document
                  .querySelector(".download-button-c")
                  .classList.remove("anchor_tag_download");
            } else {
              window.localStorage.removeItem("downloadContent_");
              document.querySelector(".cmp-button").disabled = true;
              document
                .querySelector(".download-button-c")
                .classList.add("anchor_tag_download");

              // hide the file-dot icon
              let spanElements = document.querySelectorAll(".cmp-dot");
              for (let i = 0; i < spanElements.length; i++) {
                spanElements[i].classList.remove("d-block");
                spanElements[i].classList.add("d-none");
              }
              // empty message
              let DownloadEmptyMessage1 =
                document.querySelector(".download-li").dataset;
              downloadLiElement.insertAdjacentHTML(
                "beforeend",
                `<div class="empty-message">${DownloadEmptyMessage1.emptymessage}</div>`
              );
            }
          })
        );
      };
    };

    window.removeDotOnFolder = function () {
      let spanElements = document.querySelectorAll(".cmp-dot");
      if (window.localStorage.getItem("downloadContent_") !== null) {
        for (let i = 0; i < spanElements.length; i++) {
          spanElements[i].classList.remove("d-none");
          spanElements[i].classList.add("d-block");
        }
      } else {
        for (let i = 0; i < spanElements.length; i++) {
          spanElements[i].classList.add("d-none");
          spanElements[i].classList.remove("d-block");
        }
        downloadLiElement.innerHTML = "";
        document.querySelector(".cmp-button").disabled = true;
        document
          .querySelector(".download-button-c")
          .classList.add("anchor_tag_download");
        let DownloadEmptyMessage =
          document.querySelector(".download-li").dataset;
        downloadLiElement.insertAdjacentHTML(
          "beforeend",
          `<div class="empty-message">${DownloadEmptyMessage.emptymessage}</div>`
        );
      }
    };
  }
});
