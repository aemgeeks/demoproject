window.addEventListener("DOMContentLoaded", () => {
  let dynamicPage = "";

  let relatedComponent;
  let relatedComponents = document.querySelectorAll("#relatedComponent")[0];
  if (relatedComponents) {
    relatedComponent = relatedComponents.dataset;
    let currentPage = relatedComponent.currentpage;
    let currentPageQueryParam =
      currentPage !== undefined ? "&currentPage=" + currentPage : "";
    let tagQueryParam =
      relatedComponent.tag !== undefined
        ? "&param1=" + encodeURIComponent(relatedComponent.tag)
        : "";

    if (relatedComponent.listingtype == "webinars") {
      dynamicPage =
        "/content/dam/myproject/kcenter/" +
        relatedComponent.pagelanguage +
        "/webinars";
    } else if (relatedComponent.listingtype == "projects") {
      if (relatedComponent.pagelanguage == "es") {
        dynamicPage =
          "/content/myproject/es-mx/construction/steel-fiber-concrete-reinforcement/dramix-solutions/proyectos";
      } else {
        dynamicPage =
          "/content/myproject/en-us/construction/steel-fiber-concrete-reinforcement/dramix-solutions/projects";
      }
    }

    function populateResponse(results) {
      let downloadProjectItem = document.querySelector(
        ".download-project-item"
      );
      if (downloadProjectItem) {
        downloadProjectItem.removeAttribute("href");
      }

      for (let result of results.assetsVO) {
        let relatedelement = `<div class="col-sm-12 col-md-3 col-lg-3 col-xl-3 listing-div d-flex mb-3">
    <a href="${
      result.assetPath
    }.html" class="card text-decoration-none software-card-link border-0 learnmore-related-project" data-uuid="${
          result.uuid
        }">
      <div class="small-image">
      <img class="small-image-class rounded-0 card-img-top"src="${
        result.imgPath
      }" alt="${result.alt}">
      <img class="calculator-icon"src="${
        result.assetRenditionImgPath48
      }" alt="${result.alt}">
    </div>
    <div class="desription-wrapper-div d-flex flex-column">
      <div class="image-description card-body d-flex flex-column p-0">
      <div>
    <h5 class="card-title"><div class="cmp-teaser__content">
    <h3 class="cmp-teaser__title">${
      result.videoTitle || result.title
    }</h3></div></h5>
    <div class="cmp-teaser__description card-text mb-4">
      <p>${result.videoDescription || result.description}</p>
    </div>
    </div></div>
    <hr class="teaser-horz-line opacity-100 mt-auto align-self-start w-100">
    <div class="button no-btn-grey mt-auto align-self-start">
              <div class="btn cmp-button rounded-0" href="#" data-cmp-clickable="">
                <img src="/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/button-icons/White-arrow-icon.svg" alt="Button Icon"
                  class="cmp-button__icon arrow-left">
                <span class="cmp-button__text">${
                  relatedComponent.buttonlabel
                }</span>
                <img src="/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/button-icons/White-arrow-icon.svg" alt="Button Icon"
                  class="cmp-button__icon arrow-right">
              </div>
            </div>

    </div>
  </a>
  </div>`;
        let relatedCardRow = document.querySelectorAll(".related-page-row")[0];
        relatedCardRow.insertAdjacentHTML("beforeend", relatedelement);
      }

      let addToDownloadButtonP = document.querySelectorAll(
        ".add-to-download-buttons"
      );
      if (addToDownloadButtonP) {
        addToDownloadButtonP.forEach((el) =>
          el.addEventListener("click", function () {
            addProject();
            addToDownload(el);
          })
        );
      }
    }

    const STANDARD_HEADERS = {
      "Content-Type": "application/json",
      "X-XSS-Protection": "1; mode=block",
      "X-Frame-Options": "directive",
      "X-Content-Type-Options": "nosniff",
      "Content-Security-Policy": "default-src 'self'",
      "Referrer-Policy": "no-referrer",
    };
    fetch(
      "/content/myproject/servicespath/searchAsset.assets.json?" +
        "assetpath=" +
        dynamicPage +
        "&orderBy=mostRecent" +
        "&type=relatedCards" +
        "&offset=1&pageSize=" +
        relatedComponent.pagesize +
        currentPageQueryParam +
        tagQueryParam,
      {
        headers: STANDARD_HEADERS,
        method: "GET",
        redirect: "follow",
      }
    )
      .then((response) => response.json())
      .then((results) => {
        populateResponse(results);
      })
      .catch((error) => error);
  }

  function properAddToDownload(resultsForDownload1) {
    if (window.localStorage.getItem("results") == null) {
      window.localStorage.setItem(
        "results",
        JSON.stringify(resultsForDownload1)
      );
    } else {
      let localStorageResults = JSON.parse(
        window.localStorage.getItem("results")
      );

      for (let i = 0; i < resultsForDownload1.length; i++) {
        let singlefileArray = localStorageResults.filter(
          (x) => x.uuid == resultsForDownload1[i].uuid
        );

        if (singlefileArray.length) {
        } else {
          localStorageResults.push(resultsForDownload1[i]);
        }
      }
      window.localStorage.setItem(
        "results",
        JSON.stringify(localStorageResults)
      );
    }
  }

  function addProject() {
    let data = document.querySelector(".add-to-download-buttons").dataset;
    let uuid = data.uuid;
    let image = data.assetpath;
    let assetRenditionImgPath48 = data.projecticon;
    let title = document.querySelector(".project-title-download").innerText;
    let pdfPath = data.pdfpath;
    let projectJSON = [
      {
        title: title,
        imgPath: image,
        uuid: uuid,
        assetPath: pdfPath,
        assetRenditionImgPath48: assetRenditionImgPath48,
      }
    ];
    properAddToDownload(projectJSON);
  }
});
