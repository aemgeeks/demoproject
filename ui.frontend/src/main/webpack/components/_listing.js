/*-------------------------------------------------*\
   Javascript sheet for the Component Add to download For homepage
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

   - Pagination Component
   - Disable the left and right arrow of pagination buttons
   - Add active class on left and right arrow
   - Loading the listing content
   - Navigation of listing pages through pagination buttons
   
\*-------------------------------------------------*/
/*-------------------------------------------*\
       Pagination Component
\*-------------------------------------------*/

let numberOfAssetsPerPage = 15;
const element = document.querySelector(".pagination ul");
let filter = "";
window.createPagination = (totalPages, page, dataFilter) => {
  let liTag = "";
  let active;
  let beforePage = page - 1;
  let afterPage = page + 1;
  let disFun;
  if (page) {
    if (page == 1) disFun = "disabled";
    else disFun = "";
    //show the next button if the page value is greater than 1
    liTag += `<li class="btn prev button_action ${disFun}" id ="prev_btn" onclick="createPagination(totalPages, ${
      page - 1
    },${dataFilter});addOrRemove(this);pageNavigation(${
      page - 1
    },${dataFilter});addDisable(this,${page - 1},1)">
 <span> <img class="pagination-arrow left-arrow-pagination"
 src="/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/pagination-icons/right.svg" 
 alt=""></span></li>`;
  }

  if (page > 2) {
    //if page value is less than 2 then add 1 after the previous button

    liTag += `<li class="first numb button_action" onclick="createPagination(totalPages, 1,${dataFilter});pageNavigation(1,${dataFilter});addOrRemove(this);addDisable(this,1,${totalPages})"><span>1</span></li>`;
    if (page > 3) {
      //if page value is greater than 3 then add this (...) after the first li or page
      liTag += `<li class="dots"><span>...</span></li>`;
    }
  }

  // how many pages or li show before the current li
  if (page == totalPages) {
    beforePage = beforePage - 0;
  } else if (page == totalPages - 0) {
    beforePage = beforePage - 0;
  }
  // how many pages or li show after the current li
  if (page == 1) {
    afterPage = afterPage + 0;
  } else if (page == 2) {
    afterPage = afterPage + 0;
  }

  for (let plength = beforePage; plength <= afterPage; plength++) {
    if (plength > totalPages) {
      //if plength is greater than totalPage length then continue
      continue;
    }
    if (plength == 0) {
      //if plength is 0 than add +1 in plength value
      plength = plength + 1;
    }
    if (page == plength) {
      //if page is equal to plength than assign active string in the active variable
      active = "active";
    } else {
      //else leave empty to the active variable
      active = "";
    }
    liTag += `<li class="numb ${active}" onclick="createPagination(totalPages, 
    ${plength},${dataFilter});pageNavigation(${plength},${dataFilter});addOrRemove(this);addDisable(this,${plength},${totalPages})"><span>${plength}</span></li>`;
  }

  if (page < totalPages - 1) {
    //if page value is less than totalPage value by -1 then show the last li or page
    if (page < totalPages - 2) {
      //if page value is less than totalPage value by -2 then add this (...) before the last li or page
      liTag += `<li class="dots"><span>...</span></li>`;
    }
    liTag += `<li class="last numb" onclick="createPagination(totalPages,
     ${totalPages},${dataFilter});pageNavigation(${totalPages},${dataFilter});addOrRemove(this);addDisable(this,${totalPages},${totalPages})"><span>${totalPages}</span></li>`;
  }

  if (page) {
    //show the next button if the page value is less than totalPage(20)
    liTag += `<li class="btn next" id ="nxt_btn" onclick="createPagination(totalPages, 
    ${page + 1},${dataFilter});pageNavigation(${
      page + 1
    },${dataFilter});addOrRemove(this);addDisable(this,${
      page + 1
    },${totalPages})"><span> <img class="pagination-arrow right-arrow-pagination"
     src="/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/pagination-icons/right.svg" 
     alt="">
    </span></li>`;
  }

  element.innerHTML = liTag; //add li tag inside ul tag
  return liTag; //reurn the li tag
};

/*-------------------------------------------*\
       Disable the left and right arrow of pagination buttons
\*-------------------------------------------*/

window.addDisable = (e, pageNumberD, totaPagesD) => {
  if (e.classList.contains("numb")) {
    if (e.classList.contains("numb")) {
      if (pageNumberD == 1)
        document.getElementById("prev_btn").classList.add("disabled");
      else if (pageNumberD == totaPagesD)
        document.getElementById("nxt_btn").classList.add("disabled");
    }
  } else {
    if (e.classList.contains("prev")) {
      if (pageNumberD == 1)
        document.getElementById("prev_btn").classList.add("disabled");
    } else if (e.classList.contains("next")) {
      if (pageNumberD == totaPagesD)
        document.getElementById("nxt_btn").classList.add("disabled");
    }
  }
};

/*-------------------------------------------*\
       Add active class on left and right arrow
\*-------------------------------------------*/

window.addOrRemove = (btnAction) => {
  let btnId;
  if (btnAction.id == "" || btnAction.id == null) {
    if (
      document.getElementById("prev_btn") &&
      document.getElementById("nxt_btn")
    ) {
      document.getElementById("prev_btn").classList.add("active");
      document.getElementById("nxt_btn").classList.add("active");
    } else if (document.getElementById("prev_btn")) {
      document.getElementById("prev_btn").classList.add("active");
    } else if (document.getElementById("nxt_btn")) {
      document.getElementById("nxt_btn").classList.add("active");
    }
  } else {
    if (btnAction.id == "nxt_btn") {
      btnId = "prev_btn";
    } else if (btnAction.id == "prev_btn") {
      btnId = "nxt_btn";
    }
    if (document.getElementById(btnId).classList.contains("active")) {
      document.getElementById(btnId).classList.remove("active");
    } else {
      document.getElementById(btnId).classList.add("active");
    }
  }
};

/*-------------------------------------------*\
       Loading the listing content
\*-------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  let page = 1;
  let orderBy = "mostRecent";
  let dynamicPage = "";
  let className = [
    "col-12 listing-top-div listing-div  d-flex first-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-3 col-xl-3 listing-div d-flex mb-3 second-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-3 col-xl-3 listing-div d-flex mb-3 third-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-3 col-xl-3 listing-div d-flex mb-3 fourth-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-3 col-xl-3 listing-div d-flex mb-3 fifth-listing-div",
    "col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 listing-div d-flex mb-3 sixth-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-6 col-xl-6 listing-div listing-medium-div d-flex mb-3 seventh-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-3 col-xl-3 listing-div d-flex mb-3 eighth-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-3 col-xl-3 listing-div d-flex mb-3 ninth-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-3 col-xl-3 listing-div d-flex mb-3 tenth-listing-div",
    "col-12 col-sm-12 col-md-12 col-lg-3 col-xl-3 listing-div d-flex mb-3 eleventh-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-3 col-xl-3 listing-div d-flex mb-3 twelfth-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-6 col-xl-6 listing-div d-flex listing-medium-div mb-3 thirteenth-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-3 col-xl-3 listing-div d-flex mb-3 fourteenth-listing-div",
    "col-6 col-sm-6 col-md-6 col-lg-3 col-xl-3 listing-div d-flex mb-3 fifteenth-listing-div",
  ];

  let listingPageData1 = document.getElementById("listingPageData");

  if (listingPageData1) {
    let listingPageData = listingPageData1.dataset;
    if (listingPageData.listingtype == "certificate") {
      dynamicPage =
        "/content/dam/myproject/kcenter/" +
        listingPageData.pagelanguage +
        "/certificate";
    } else if (listingPageData.listingtype == "whitepaper") {
      dynamicPage =
        "/content/dam/myproject/kcenter/" +
        listingPageData.pagelanguage +
        "/whitepaper";
    } else if (listingPageData.listingtype == "webinars") {
      dynamicPage =
        "/content/dam/myproject/kcenter/" +
        listingPageData.pagelanguage +
        "/webinars";
    } else if (listingPageData.listingtype == "productdatasheet") {
      dynamicPage =
        "/content/dam/myproject/kcenter/" +
        listingPageData.pagelanguage +
        "/productdatasheet";
    } else if (listingPageData.listingtype == "projects") {
      if (listingPageData.pagelanguage == "es") {
        dynamicPage =
          "/content/myproject/es-mx/construction/steel-fiber-concrete-reinforcement/dramix-solutions/proyectos";
      } else {
        dynamicPage =
          "/content/myproject/en-us/construction/steel-fiber-concrete-reinforcement/dramix-solutions/projects";
      }
    }

    window.populateResponse = (results) => {
      // its clears the previous appeneded results
      if (
        listingPageData.listingtype == "whitepaper" ||
        listingPageData.listingtype == "certificate" ||
        listingPageData.listingtype == "productdatasheet"
      )
        window.localStorage.setItem(
          "results",
          JSON.stringify(results.assetsVO)
        );
      else {
        window.localStorage.removeItem("results");
      }
      let clearEmptyResults = document.querySelector(".listing-page-row");
      clearEmptyResults.innerHTML = "";
      let i = 0;
      if (results.assetsVO.length === 0) {
        let emptyMessage = document.querySelector(
          ".listing-pagination"
        ).dataset;
        document
          .querySelector(".listing-page-row")
          .insertAdjacentHTML(
            "beforeend",
            `<div class="empty-message">${emptyMessage.emptymessage}</div>`
          );
      }

      for (let result of results.assetsVO) {
        let downloadClass = "";
        let herfElement = "";
        if (
          listingPageData.listingtype == "productdatasheet" ||
          listingPageData.listingtype == "whitepaper" ||
          listingPageData.listingtype == "certificate"
        ) {
          downloadClass = "add-to-download-buttons";
          herfElement = "";
        }
        if (
          listingPageData.listingtype == "webinars" ||
          listingPageData.listingtype == "projects"
        ) {
          downloadClass = "";
          herfElement = "href=" + result.assetPath + ".html";
        }

        let listingelement = `<div class="${className[i]}">
            <a class="card text-decoration-none software-card-link border-0 learnmore-project ${downloadClass}" data-uuid="${
          result.uuid
        }"  ${herfElement}>
            <div class="small-image">
               <img class="small-image-class rounded-0 card-img-top"src="${
                 result.imgPath
               }" alt="${result.altText}">
               <img class="calculator-icon"src="${
                 result.assetRenditionImgPath48
               }" alt="${result.altText}">
            </div>
            <div class="desription-wrapper-div d-flex flex-column">
            <div class="image-description card-body d-flex flex-column p-0">
               <div>
                  <h5 class="card-title">
                     <div class="cmp-teaser__content">
                        <h3 class="cmp-teaser__title">${
                          result.certificateTitle ||
                          result.whitepaperTitle ||
                          result.title ||
                          result.videoTitle
                        }</h3>
                     </div>
                  </h5>
                  <div class="cmp-teaser__description card-text mb-4">
                     <p>${
                       result.certificateDescription ||
                       result.whitepaperDescription ||
                       result.description ||
                       result.videoDescription
                     }</p>
                  </div>
               </div>
            </div>
            `;
        if (listingPageData.listingtype == "productdatasheet") {
          listingelement +=
            `<div class="row product-details-row pt-4">
               <div class="right-col-products">
                  <div class="product-details-div">
                     <div class="head-text-products material-head">
                        ` +
            listingPageData.materiallabel +
            `
                     </div>
                     <div class="body-text-products material-body">
                        ${result.material}
                     </div>
                  </div>
               </div>
               <div class="left-col-products">
                  <div class="product-details-div">
                     <div class="head-text-products fiber-aspect-head">
                     ` +
            listingPageData.fiberaspectlabel +
            `
                     </div>
                     <div class="body-text-products fiber-aspect-body">
                        ${result.aspectRatio}
                     </div>
                  </div>
               </div>
               <div class="right-col-products">
                  <div class="product-details-div">
                     <div class="head-text-products format-head">
                     ` +
            listingPageData.formatlabel +
            `
                     </div>
                     <div class="body-text-products format-body">
                        ${result.format}
                     </div>
                  </div>
                  <div class="product-details-div">
                     <div class="head-text-products language-head">
                     ` +
            listingPageData.languagelabel +
            `
                     </div>
                     <div class="body-text-products language-body">
                        ${result.language}
                     </div>
                  </div>
               </div>
               <div class="left-col-products">
                  <div class="product-details-div">
                     <div class="head-text-products fiber-length-head">
                     ` +
            listingPageData.fiberlengthlabel +
            `
                     </div>
                     <div class="body-text-products fiber-length-body">
                        ${result.length}
                     </div>
                  </div>
               </div>
            </div>`;
        }
        listingelement += `<hr class="teaser-horz-line opacity-100 mt-auto align-self-start w-100">`;
        if (
          listingPageData.listingtype == "webinars" ||
          listingPageData.listingtype == "projects"
        ) {
          listingelement +=
            `<div class="button no-btn-grey mt-auto align-self-start">
                    <div class="btn cmp-button rounded-0 " data-cmp-clickable="" data-uuid="${result.uuid}">
                       <img src="/content/dam/myproject/button-icons/Dark-Arrow.svg" alt="Button Icon" class="cmp-button__icon arrow-left">
                       <span class="cmp-button__text">` +
            listingPageData.buttonlabel +
            `</span>
                       <img src="/content/dam/myproject/button-icons/Dark-Arrow.svg" alt="Button Icon" class="cmp-button__icon arrow-right">
                    </div>
                 </div>`;
        }

        if (
          listingPageData.listingtype == "productdatasheet" ||
          listingPageData.listingtype == "whitepaper" ||
          listingPageData.listingtype == "certificate"
        ) {
          listingelement +=
            `<button class="dwn-btn d-flex" data-uuid="${result.uuid}">` +
            listingPageData.buttonlabel +
            `<span class="arrow-cont"><img src="/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/button-icons/box_blue.svg" alt=""></span></button>`;
        }
        listingelement += `</div>
        </a>
      </div>`;
        let listingCardRow = document.querySelector(".listing-page-row");
        if (listingCardRow) {
          listingCardRow.insertAdjacentHTML("beforeend", listingelement);
        }
        if (i < className.length - 1) {
          i = i + 1;
        } else {
          i = 0;
        }
      }
      let resultLabel = document.getElementById("input-hidden-count").dataset;
      let totalCount = results.totalAssets + " " + resultLabel.count;
      document.querySelector(".result-numbers").textContent = totalCount;
      let pagePath = document.querySelector("#analyticsData");
      if (pagePath) {
        let currentPagePath = pagePath.dataset.getcurrentpagepath;
        if (
          currentPagePath.includes("projects") ||
          currentPagePath.includes("proyectos")
        ) {
          document
            .querySelector(".listing-page-row")
            .classList.add("projects-container");
        } else if (
          currentPagePath.includes("expert-talks") ||
          currentPagePath.includes("platicas-con-expertos")
        ) {
          document
            .querySelector(".listing-page-row")
            .classList.add("expert-talks-container");
        }
      }
      let addToDownloadButtonsL = document.querySelectorAll(
        ".add-to-download-buttons"
      );
      if (addToDownloadButtonsL) {
        addToDownloadButtonsL.forEach((el) =>
          el.addEventListener("click", function () {
            addToDownload(el);
          })
        );
      }
    };

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
        "&orderBy=" +
        orderBy +
        "&offset=" +
        page,
      {
        headers: STANDARD_HEADERS,
        method: "GET",
        redirect: "follow",
      }
    )
      .then((response) => response.json())
      .then((results) => {
        if (results.totalAssets > numberOfAssetsPerPage) {
          totalPages = Math.ceil(results.totalAssets / numberOfAssetsPerPage);
          document.querySelector(".pagination ul").innerHTML = createPagination(
            totalPages,
            page,
            0
          );
        }
        populateResponse(results);
      })
      .catch((error) => error);
  }

  document.querySelectorAll("#selectFilter").forEach((el) =>
    el.addEventListener("click", function () {
      filter = "";
      let dataFilter0 = "";
      document.querySelector(".result-numbers").innerHTML = "";
      document.querySelector(".listing-page-row").innerHTML = "";
      document
        .querySelectorAll(".filter-list-items .form-check-input:checked")
        .forEach((element) => {
          if (filter == "") {
            filter = element.defaultValue;
          } else {
            filter = filter + "," + element.defaultValue;
          }
        });
      if (filter != "") dataFilter0 = 1;
      else dataFilter0 = 0;

      let listingPageDatas = document.getElementById("listingPageData");

      if (listingPageDatas) {
        let listingPageData = listingPageDatas.dataset;
        if (listingPageData.listingtype == "certificate") {
          dynamicPage =
            "/content/dam/myproject/kcenter/" +
            listingPageData.pagelanguage +
            "/certificate";
        } else if (listingPageData.listingtype == "whitepaper") {
          dynamicPage =
            "/content/dam/myproject/kcenter/" +
            listingPageData.pagelanguage +
            "/whitepaper";
        } else if (listingPageData.listingtype == "webinars") {
          dynamicPage =
            "/content/dam/myproject/kcenter/" +
            listingPageData.pagelanguage +
            "/webinars";
        } else if (listingPageData.listingtype == "productdatasheet") {
          dynamicPage =
            "/content/dam/myproject/kcenter/" +
            listingPageData.pagelanguage +
            "/productdatasheet";
        } else if (listingPageData.listingtype == "projects") {
          if (listingPageData.pagelanguage == "es") {
            dynamicPage =
              "/content/myproject/es-mx/construction/steel-fiber-concrete-reinforcement/dramix-solutions/proyectos";
          } else {
            dynamicPage =
              "/content/myproject/en-us/construction/steel-fiber-concrete-reinforcement/dramix-solutions/projects";
          }
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
          (filter ? "&param1=" + filter : "") +
          "&orderBy=" +
          orderBy +
          "&offset=" +
          page,
        {
          headers: STANDARD_HEADERS,
          method: "GET",
          redirect: "follow",
        }
      )
        .then((response) => response.json())
        .then((results) => {
          document.querySelector(".pagination ul").innerHTML = "";
          populateResponse(results);
          if (results.totalAssets > numberOfAssetsPerPage) {
            totalPages = Math.ceil(results.totalAssets / numberOfAssetsPerPage);
            document.querySelector(".pagination ul").innerHTML =
              createPagination(totalPages, page, dataFilter0);
          }
        })
        .catch((error) => error);
    })
  );

  // clearing checkboxes on clicking clear all button
  document.querySelectorAll("#clearFilter").forEach((el) =>
    el.addEventListener("click", function () {
      let clist = document.querySelectorAll("input[type=checkbox]");
      for (const element of clist) {
        element.checked = false;
      }
      document.querySelector("#selectFilter").click();
      document.getElementById("selectFilter").disabled = true;
    })
  );

  const imageTypes = document.querySelectorAll(".form-check-input-listing");
  let choices = [];
  imageTypes.forEach((imageType) => {
    imageType.addEventListener("change", () => {
      imageType.checked
        ? choices.push(imageType.value)
        : choices.splice(choices.indexOf(imageType.value), 1);
      if (choices.length != 0) {
        document.getElementById("selectFilter").disabled = false;
      } else {
        document.getElementById("selectFilter").disabled = true;
      }
    });
  });

  /*-------------------------------------------*\
       Navigation of listing pages through pagination buttons
\*-------------------------------------------*/

  window.pageNavigation = (page, dataFilter) => {
    const STANDARD_HEADERS = {
      "Content-Type": "application/json",
      "X-XSS-Protection": "1; mode=block",
      "X-Frame-Options": "directive",
      "X-Content-Type-Options": "nosniff",
      "Content-Security-Policy": "default-src 'self'",
      "Referrer-Policy": "no-referrer",
    };

    if (dataFilter == 0) {
      fetch(
        "/content/myproject/servicespath/searchAsset.assets.json?" +
          "assetpath=" +
          dynamicPage +
          "&orderBy=" +
          orderBy +
          "&offset=" +
          page,
        {
          headers: STANDARD_HEADERS,
          method: "GET",
          redirect: "follow",
        }
      )
        .then((response) => response.json())
        .then((results) => {
          populateResponse(results);
          pageScroll("pagination_scroll");
        })
        .catch((error) => error);
    } else if (dataFilter == 1) {
      fetch(
        "/content/myproject/servicespath/searchAsset.assets.json?" +
          "assetpath=" +
          dynamicPage +
          (filter ? "&param1=" + filter : "") +
          "&orderBy=" +
          orderBy +
          "&offset=" +
          page,
        {
          headers: STANDARD_HEADERS,
          method: "GET",
          redirect: "follow",
        }
      )
        .then((response) => response.json())
        .then((results) => {
          populateResponse(results);
          pageScroll("pagination_scroll");
        })
        .catch((error) => error);
    }
  };

  window.pageScroll = (paginationScrollId) => {
    let scrollDiv = document.getElementById(paginationScrollId).offsetTop - 50;
    window.scrollTo({
      top: scrollDiv,
      behavior: "smooth",
    });
  };
});
