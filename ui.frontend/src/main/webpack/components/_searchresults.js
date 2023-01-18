/*-------------------------------------------------*\
   Javascript sheet for the Search Results
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

    
   - Search Results Page   
   - Search Results page pagination
   - Search box auto suggestion
   - Search box cards show
  
\*-------------------------------------------------*/

import Mark from "mark.js";

/*--------------------------------------------------------------------------*\
      Search 
\*--------------------------------------------------------------------------*/
let numberOfAssetsPerPage = 15;
const element = document.querySelector(".pagination ul");
window.searchPagination = (totalPages, page, dataFilter) => {
  let liTag = "";
  let active;
  let beforePage = page - 1;
  let afterPage = page + 1;
  let disFun;
  if (page) {
    if (page == 1) disFun = "disabled";
    else disFun = "";
    //show the next button if the page value is greater than 1
    liTag += `<li class="btn prev button_action ${disFun}" id ="prev_btn" onclick="searchPagination(${totalPages}, ${
      page - 1
    },${dataFilter});addOrRemove(this);pageNavigationS(${
      page - 1
    },${dataFilter});addDisable(this,${page - 1},1)">
 <span> <img class="pagination-arrow left-arrow-pagination"
 src="/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/pagination-icons/right.svg" 
 alt=""></span></li>`;
  }

  if (page > 2) {
    //if page value is less than 2 then add 1 after the previous button

    liTag += `<li class="first numb button_action" onclick="searchPagination(${totalPages}, 1,${dataFilter});pageNavigationS(1,${dataFilter});addOrRemove(this);addDisable(this,1,${totalPages})"><span>1</span></li>`;
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
    liTag += `<li class="numb ${active}" onclick="searchPagination(${totalPages}, 
    ${plength},${dataFilter});pageNavigationS(${plength},${dataFilter});addOrRemove(this);addDisable(this,${plength},${totalPages})"><span>${plength}</span></li>`;
  }

  if (page < totalPages - 1) {
    //if page value is less than totalPage value by -1 then show the last li or page
    if (page < totalPages - 2) {
      //if page value is less than totalPage value by -2 then add this (...) before the last li or page
      liTag += `<li class="dots text-center"><span>...</span></li>`;
    }
    liTag += `<li class="last numb" onclick="searchPagination(${totalPages},
     ${totalPages},${dataFilter});pageNavigationS(${totalPages},${dataFilter});addOrRemove(this);addDisable(this,${totalPages},${totalPages})"><span>${totalPages}</span></li>`;
  }

  if (page) {
    //show the next button if the page value is less than totalPage(20)
    liTag += `<li class="btn next" id ="nxt_btn" onclick="searchPagination(${totalPages}, 
    ${page + 1},${dataFilter});pageNavigationS(${
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

window.addEventListener("DOMContentLoaded", () => {
  /*--------------------------------------------------------------------------*\
	    Search inputBox Drodown 
	  \*--------------------------------------------------------------------------*/

  let page = 1;
  const searchListresshow = document.querySelectorAll(".searchresshow");

  let nodata;
  let searchText = document.querySelector(".search-text");
  if (searchText) {
    nodata = searchText.dataset.nodata;
  }

  function resultShow(e) {
    // getting data from language
    const language = document.documentElement.lang.toLowerCase();

    //getting data from url
    let fetchRes = fetch(
      `/content/myproject/servicespath/suggestionData.autosuggest.json?term=${e}` +
        `&rp=/content/myproject/${language}` +
        `/construction/steel-fiber-concrete-reinforcement/dramix-solutions`
    );
    fetchRes
      .then((res) => res.json())
      .then((d) => {
        SearchResultFunc(d);
      });
    //filter and combin
    let list = "";
    let SearchResultFunc = (res) => {
      let List = res.map((r) => {
        list += `<li class="clicklist-items" id="clicklistid" onclick='SearchFun(this)'>${r}</li>`;
      });

      if (list.length > 2) {
        document
          .querySelectorAll(".searchProduct-show")
          .forEach(function (element) {
            element.style.display = "block";
          });
        searchListresshow.forEach(function (element) {
          element.innerHTML = "<ul class='list-items'>" + list + "</ul>";
        });
      } else {
        searchListresshow.forEach(function (element) {
          element.innerHTML = `<ul class='list-items'>` + nodata + `</ul>`;
        });
      }
    };
  }

  const searchInputRes = document.getElementById("search_inputbox");
  if (searchInputRes) {
    searchInputRes.addEventListener("input", () => {
      let resultencode = encodeURIComponent(searchInputRes.value.trim());
      if (resultencode.length == "") {
        document.querySelector(".searchProduct-show ").style.display = "none";
      }
      if (resultencode.length > 2) {
        resultShow(resultencode);
      }
    });
  }
  window.SearchFun = (s) => {
    searchInputRes.empty = s.innerHTML;
    const searchForm = document.querySelectorAll(".search_input_box");
    searchForm.forEach(function (element) {
      element.value = searchInputRes.empty;
    });

    if (searchInputRes.empty == "") {
      document
        .querySelectorAll(".searchProduct-show")
        .forEach(function (element) {
          element.style.display = "block";
        });
    } else {
      document
        .querySelectorAll(".searchProduct-show")
        .forEach(function (element) {
          element.style.display = "none";
        });
    }
  };

  let searchResultClick = document.querySelector(".searchResultClickButton");
  if (searchResultClick) {
    searchResultClick.addEventListener("click", function () {
      while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
      }

      document.querySelector(".searchProduct-show").style.display = "none";
      document.querySelector(".searchresult-numbers").innerHTML = "";
      document.querySelector(".searchcards-page-row").innerHTML = "";

      const searchResInputValue = cleanHTML(
        document.querySelector(".search_input_box").value
      );

      fetchResult(searchResInputValue);

      //  Highlighting Functionality

      const markInstance = new Mark(
        document.querySelector(".searchcards-page-row")
      );
      window.performMark = () => {
        markInstance.unmark({
          done: function () {
            markInstance.mark(searchResInputValue, {
              separateWordSearch: false,
            });
          },
        });
      };
    });
  }
  /*--------------------------------------------------------------------------------------------*\
	      search results cards shows on key enter while click on search box results
	\*---------------------------------------------------------------------------------------------*/

  let input = document.querySelector(".search_input_box");
  if (input) {
    input.addEventListener("keypress", function (event) {
      if (event.key === "Enter") {
        event.preventDefault();
        let serachInput3 = document.querySelector(".search_input_box");
        if (
          serachInput3.value.length != 0 &&
          serachInput3.value != undefined &&
          serachInput3.value != null
        ) {
          searchClickRedirection3(".search_input_box");
        }
      }
    });
  }

  function searchClickRedirection3() {
    document.querySelector(".searchProduct-show").style.display = "none";
    document.querySelector(".searchresult-numbers").innerHTML = "";
    document.querySelector(".searchcards-page-row").innerHTML = "";
    const searchResInputValue = cleanHTML(
      document.querySelector(".search_input_box").value
    );
    fetchResult(searchResInputValue);

    //  Highlighting Functionality

    const markInstance = new Mark(
      document.querySelector(".searchcards-page-row")
    );
    window.performMark = () => {
      markInstance.unmark({
        done: function () {
          markInstance.mark(searchResInputValue, {
            separateWordSearch: false,
          });
        },
      });
    };
  }

  /*--------------------------------------------------------------------------*\
	    Search Results card shows
	\*--------------------------------------------------------------------------*/

  const params = new URLSearchParams(window.location.search);

  if (params.get("qsearch")) {
    fetchResult(params.get("qsearch"));
    document
      .getElementById("search_inputbox")
      .setAttribute("value", params.get("qsearch"));
  }

  function populateSearchResponse(results) {
    let noresults = document.querySelector(".search-text").dataset.noresults;
    window.localStorage.setItem("results", JSON.stringify(results.results));
    let clearEmptyResults = document.querySelector(".searchcards-page-row");
    clearEmptyResults.innerHTML = "";
    let i = 0;

    if (results.results.length === 0) {
      document
        .querySelector(".searchcards-page-row")
        .insertAdjacentHTML(
          "beforeend",
          `<div class="search-empty-message d-flex justify-content-center align-items-center align-self-center w-100">` +
            noresults +
            `</div>`
        );
    }

    for (let result of results.results) {
      let downloadClass = "";
      let dataUUID = "";
      let hrefElement = "";
      if (
        result.contentType == "productdatasheet" ||
        result.contentType == "whitepaper" ||
        result.contentType == "certificate"
      ) {
        downloadClass = "add-to-download-buttons";
        dataUUID = "data-uuid=" + result.uuid;
        hrefElement = "";
      } else {
        hrefElement = "href=" + result.path + ".html";
      }

      let searchtext = document.querySelector(".search-text").dataset;

      let listingelement = `<div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 listing-div d-flex mb-3 pe-md-3 flex-column">
                <a class="card text-decoration-none software-card-link border-0 ${downloadClass}" ${dataUUID} ${hrefElement}>
                <div class="small-image">
                <img class="small-image-class rounded-0 card-img-top" src="${result.url}" alt="${result.alt}">
                <img class="calculator-icon"src="${results.assetRenditionImgPath48}" alt="">
                </div>
                <div class="desription-wrapper-div d-flex flex-column flex-grow-1 flex-shrink-1" >
                  <div class="image-description card-body d-flex flex-column p-0">
                <div>
                <h5 class="card-title"><div class="cmp-teaser__content">
                <h3 class="cmp-teaser__title">${result.title}</h3></div></h5>
                <div class="cmp-teaser__description card-text mb-4">
                <p>${result.description}</hrefElementp>
                </div>
                </div>
                </div>
                <hr class="teaser-horz-line opacity-100 mt-auto align-self-start w-100">`;

      if (
        result.contentType == "sustainability" ||
        result.contentType == "software" ||
        result.contentType == "forms" ||
        result.contentType == "aboutus"
      ) {
        listingelement +=
          `<div class="button no-btn-grey mt-auto align-self-start text-left">
                              <a class="btn cmp-button rounded-0 d-flex"  href="${result.path}.html" data-cmp-clickable=""  >
                                 <img src="/content/dam/myproject/button-icons/Dark-Arrow.svg" alt="Button Icon" class="cmp-button__icon arrow-left">
                                 <span class="cmp-button__text">` +
          searchtext.learnmore +
          `</span>
                                 <img src="/content/dam/myproject/button-icons/Dark-Arrow.svg" alt="Button Icon" class="cmp-button__icon arrow-right">
                              </a>
                      </div>`;
      }
      if (result.contentType == "projects") {
        listingelement +=
          `<div class="button no-btn-grey mt-auto align-self-start text-left">
                              <a class="btn cmp-button rounded-0 d-flex"  href="${result.path}.html" data-cmp-clickable=""  >
                                 <img src="/content/dam/myproject/button-icons/Dark-Arrow.svg" alt="Button Icon" class="cmp-button__icon arrow-left">
                                 <span class="cmp-button__text">` +
          searchtext.readmore +
          `</span>
                                 <img src="/content/dam/myproject/button-icons/Dark-Arrow.svg" alt="Button Icon" class="cmp-button__icon arrow-right">
                              </a>
                      </div>`;
      }
      if (
        result.contentType == "experttalks" ||
        result.contentType == "webinars"
      ) {
        listingelement +=
          `<div class="button no-btn-grey mt-auto align-self-start text-left">
                              <a class="btn cmp-button rounded-0 d-flex" href="${result.path}.html" data-cmp-clickable=""  >
                                 <img src="/content/dam/myproject/button-icons/Dark-Arrow.svg" alt="Button Icon" class="cmp-button__icon arrow-left">
                                 <span class="cmp-button__text">` +
          searchtext.watchvideo +
          `</span>
                                 <img src="/content/dam/myproject/button-icons/Dark-Arrow.svg" alt="Button Icon" class="cmp-button__icon arrow-right">
                              </a>
                      </div>`;
      }
      if (
        result.contentType == "productdatasheet" ||
        result.contentType == "whitepaper" ||
        result.contentType == "certificate"
      ) {
        listingelement +=
          `<button class="dwn-btn d-flex text-left"  data-uuid="${result.uuid}">` +
          searchtext.addtodownload +
          `<span class="arrow-cont"><img src="/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/button-icons/box_blue.svg" alt=""></span></button>`;
      }
      listingelement += `</div>
                  </a>
                </div>`;

      let resultCardRow = document.querySelector(".searchcards-page-row");
      if (resultCardRow) {
        resultCardRow.append(...cleanHTML(listingelement, true));
      }

      let resultLabel = document.getElementById("result-hidden-count").dataset;
      let totalCount = results.totalMatches + " " + resultLabel.count;
      document.querySelector(".searchresult-numbers").textContent = totalCount;

      document
        .querySelector("#search_inputbox")
        .setAttribute("data-inputresultscount", results.totalMatches);

      
    }
    let addToDownloadButtonS = document.querySelectorAll(
      ".add-to-download-buttons"
    );

    if (addToDownloadButtonS) {
      addToDownloadButtonS.forEach((el) =>
        el.addEventListener("click", function () { 
          addToDownload(el);
        })
      );
    }
  }
  let totalPages;
  function fetchResult(qsearch) {
    // getting data from language
    const language = document.documentElement.lang.toLowerCase();
    let lang = language.split("-");
    let lang2 = lang[0];
    const STANDARD_HEADERS = {
      "Content-Type": "application/json",
      "X-XSS-Protection": "1; mode=block",
      "X-Frame-Options": "directive",
      "X-Content-Type-Options": "nosniff",
      "Content-Security-Policy": "default-src 'self'",
      "Referrer-Policy": "no-referrer",
    };

    fetch(
      `/content/myproject/servicespath/searchData.results.json?q=${qsearch}&` +
        `offset=` +
        page +
        `&rootpath=/content/myproject/${language}/construction/steel-fiber-concrete-reinforcement/dramix-solutions&assetpath=/content/dam/myproject/kcenter/${lang2}`,

      {
        headers: STANDARD_HEADERS,
        method: "GET",
        redirect: "follow",
      }
    )
      .then((response) => response.json())
      .then((results) => {
        if (results.totalMatches > numberOfAssetsPerPage) {
          totalPages = Math.ceil(results.totalMatches / numberOfAssetsPerPage);
          document.querySelector(".cmp-pagination-hide").style.display =
            "block";
          document.querySelector(".pagination ul").innerHTML = searchPagination(
            totalPages,
            page,
            0
          );
        } else {
          document.querySelector(".cmp-pagination-hide").style.display = "none";
        }
        populateSearchResponse(results);
        performMark();
      })

      .catch((error) => error);
  }

  /*--------------------------------------------------------------------------*\
	    Search Filter
	\*--------------------------------------------------------------------------*/

  document.querySelectorAll("#searchresFilter").forEach((el) =>
    el.addEventListener("click", function () {
      // getting data from language
      const language = document.documentElement.lang.toLowerCase();
      let lang = language.split("-");
      let lang2 = lang[0];
      const qsearch = encodeURIComponent(
        document.querySelector(".search_input_box").value
      );
      let filter = "";
      let dataFilter0 = "";
      document.querySelector(".searchresult-numbers").innerHTML = "";
      document.querySelector(".searchcards-page-row").innerHTML = "";
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
      const STANDARD_HEADERS = {
        "Content-Type": "application/json",
        "X-XSS-Protection": "1; mode=block",
        "X-Frame-Options": "directive",
        "X-Content-Type-Options": "nosniff",
        "Content-Security-Policy": "default-src 'self'",
        "Referrer-Policy": "no-referrer",
      };
      fetch(
        `/content/myproject/servicespath/searchData.results.json?q=${qsearch}&` +
          `offset=` +
          page +
          `&rootpath=/content/myproject/${language}/construction/steel-fiber-concrete-reinforcement/dramix-solutions&assetpath=/content/dam/myproject/kcenter/${lang2}` +
          (filter ? "&param1=" + filter : ""),
        {
          headers: STANDARD_HEADERS,
          method: "GET",
          redirect: "follow",
        }
      )
        .then((response) => response.json())
        .then((results) => {
          document.querySelector(".pagination ul").innerHTML = "";
          if (results.totalMatches > numberOfAssetsPerPage) {
            if (results.hitCount > numberOfAssetsPerPage) {
              totalPages = Math.ceil(
                results.totalMatches / numberOfAssetsPerPage
              );

              document.querySelector(".cmp-pagination-hide").style.display =
                "block";
              document.querySelector(".pagination ul").innerHTML =
                searchPagination(totalPages, page, 0);
            }
            if (clearSearch) {
              if (results.totalMatches > numberOfAssetsPerPage) {
                totalPages = Math.ceil(
                  results.totalMatches / numberOfAssetsPerPage
                );

                document.querySelector(".cmp-pagination-hide").style.display =
                  "block";
                document.querySelector(".pagination ul").innerHTML =
                  searchPagination(totalPages, page, 0);
              }
              clearSearch = false;
            }
          } else {
            document.querySelector(".cmp-pagination-hide").style.display =
              "none";
          }
          populateSearchResponse(results);
        })
        .catch((error) => error);
    })
  );

  // clearing checkboxes on clicking clear all button
  let clearSearch = false;
  document.querySelectorAll("#clearSearchFilter").forEach((el) =>
    el.addEventListener("click", function () {
      let clist = document.querySelectorAll("input[type=checkbox]");
      for (const element of clist) {
        element.checked = false;
      }
      document.querySelector("#searchresFilter").click();
      document.getElementById("searchresFilter").disabled = true;
      clearSearch = true;
    })
  );

  const imageTypes = document.querySelectorAll(".form-check-input-event");
  let choices = [];
  imageTypes.forEach((imageType) => {
    imageType.addEventListener("change", () => {
      imageType.checked
        ? choices.push(imageType.value)
        : choices.splice(choices.indexOf(imageType.value), 1);
      if (choices.length != 0) {
        document.getElementById("searchresFilter").disabled = false;
      } else {
        document.getElementById("searchresFilter").disabled = true;
      }
    });
  });

  window.pageNavigationS = (page, dataFilter) => {
    // getting data from language
    const language = document.documentElement.lang.toLowerCase();
    let lang = language.split("-");
    let lang2 = lang[0];
    const qsearch = encodeURIComponent(
      document.querySelector(".search_input_box").value
    );
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
        `/content/myproject/servicespath/searchData.results.json?q=${qsearch}&` +
          `offset=` +
          page +
          `&rootpath=/content/myproject/${language}/construction/steel-fiber-concrete-reinforcement/dramix-solutions&assetpath=/content/dam/myproject/kcenter/${lang2}`,

        {
          headers: STANDARD_HEADERS,
          method: "GET",
          redirect: "follow",
        }
      )
        .then((response) => response.json())
        .then((results) => {
          populateSearchResponse(results);
          pageScrollS("searchResultComponent");
        })

        .catch((error) => error);
    } else if (dataFilter == 1) {
      fetch(
        `/content/myproject/servicespath/searchData.results.json?q=${qsearch}&` +
          `offset=` +
          page +
          `&rootpath=/content/myproject/${language}/construction/steel-fiber-concrete-reinforcement/dramix-solutions&assetpath=/content/dam/myproject/kcenter/${lang2}` +
          (filter ? "&param1=" + filter : ""),
        {
          headers: STANDARD_HEADERS,
          method: "GET",
          redirect: "follow",
        }
      )
        .then((response) => response.json())
        .then((results) => {
          populateSearchResponse(results);
          pageScrollS("searchResultComponent");
        })
        .catch((error) => error);
    }
  };
  window.pageScrollS = (paginationScrollId) => {
    let scrollDiv = document.getElementById(paginationScrollId).offsetTop - 50;
    window.scrollTo({
      top: scrollDiv,
      behavior: "smooth",
    });
  };
});
