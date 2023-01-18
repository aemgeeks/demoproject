/*-------------------------------------------------*\
   Javascript sheet for the Search Header
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

    
   - Megamenu Search Box open and background overlay
   - Megamenu Search autocompletion suggestion box
   - Megamenu Search Box close and remove background overlay
  
\*-------------------------------------------------*/

/*-------------------------------------------*\
    Search box open and background overlay
\*-------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  // Get the button
  let searchHandler = document.querySelectorAll(".cmp-search-nav");

  if (searchHandler) {
    searchHandler.forEach((searchTop) => {
      searchTop.addEventListener("click", function () {
        searchHover();
      });
    });
  }

  function searchHover() {
    const searchChangeTopbar = document.querySelector(".cmp-primary-search");
    const searchChangeNavbar = document.querySelector(".cmp-secondary-search");
    const searchChangeSection = document.getElementById("searchSection");
    const searchbgChangeb = document.getElementById("headerMobileHamburger");

    if (searchChangeTopbar) {
      searchChangeTopbar.classList.add("cmp-search-bg-change-top");
      searchChangeTopbar.style.visibility = "unset";
    }

    if (searchChangeNavbar) {
      searchChangeNavbar.classList.add("cmp-search-change-navbar");
      searchChangeNavbar.style.visibility = "unset";
    }

    if (searchChangeSection) {
      searchChangeSection.style.display = "block";
      searchChangeSection.style.top = "100%";
    }

    if (searchbgChangeb) {
      const newItem = document.createElement("div");
      newItem.id = "navBgdropback";
      newItem.className = "background-dropback-menu";
      searchbgChangeb.appendChild(newItem);
    }
  }
});

/*-----------------------------------------------------------------*\
      search autocompletion suggestion box implemention 
\*------------------------------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  const searchListshow = document.querySelectorAll(".proshow");

  function show(e) {
    // getting data from language
    const language = document.documentElement.lang.toLowerCase();

    let nodata;
    let searchText = document.querySelector(".search-text");
    if (searchText) {
      nodata = searchText.dataset.nodata;
    }

    //getting data from url
    let fetchRes = fetch(
      `/content/myproject/servicespath/suggestionData.autosuggest.json?term=${e}` +
        `&rp=/content/myproject/${language}` +
        `/construction/steel-fiber-concrete-reinforcement/dramix-solutions`
    );

    fetchRes
      .then((res) => res.json())
      .then((d) => {
        SearchFunc(d);
      });
    //filter and combin
    let list = "";
    let SearchFunc = (res) => {
      let List = res.map((r) => {
        list += `<li class="Click-list" id="clicklistid" onclick='searchFunction(this)'>${r}</li>`;
      });

      if (list.length > 3) {
        document.querySelectorAll(".product-show").forEach(function (element) {
          element.style.display = "block";
        });
        searchListshow.forEach(function (element) {
          element.innerHTML = "<ul>" + list + "</ul>";
        });
      } else {
        searchListshow.forEach(function (element) {
          element.innerHTML = `<ul>` + nodata + `</ul>`;
        });
      }
    };
  }

  const searchInputId = document.querySelectorAll(".search-form");

  if (searchInputId) {
    searchInputId.forEach(function (element) {
      element.addEventListener(`input`, function () {
        const ev = element.value.trim();
        if (ev.length > 2) {
          show(ev);
        }
      });
    });
  }

  window.searchFunction = (s) => {
    searchInputId.empty = s.innerHTML;
    const searchForm = document.querySelectorAll(".search-form");
    searchForm.forEach(function (element) {
      element.value = searchInputId.empty;
    });

    if (searchInputId.empty == "") {
      document.querySelectorAll(".product-show").forEach(function (element) {
        element.style.display = "block";
      });
    } else {
      document.querySelectorAll(".product-show").forEach(function (element) {
        element.style.display = "none";
      });
    }
  };

  /*--------------------------------------------------------------------------------------------*\
        search autocompletion suggestion box implemention redirection for desktop and mobile view
  \*---------------------------------------------------------------------------------------------*/

  const searchClick = document.querySelectorAll(".searchClick");

  if (searchClick) {
    searchClick.forEach(function (element) {
      element.addEventListener("click", function () {
        let sibling = element.nextElementSibling;
        let serachInput1 = document.querySelector(".search-desktop");
        if (
          serachInput1.value.length != 0 &&
          serachInput1.value != undefined &&
          serachInput1.value != null
        ) {
          if (sibling.classList.contains("search-desktop")) {
            searchClickRedirection1(".search-desktop");
          } else if (sibling.classList.contains("search-resmobile")) {
            searchClickRedirection1(".search-resmobile");
          }
        }

        let serachInput4 = document.querySelector(".search-resmobile");
        if (
          serachInput4.value.length != 0 &&
          serachInput4.value != undefined &&
          serachInput4.value != null
        ) {
           if (sibling.classList.contains("search-resmobile")) {
            searchClickRedirection1(".search-resmobile");
          }
        }

      });
    });
  }

  function searchClickRedirection1(className) {
    const searchInputValue = encodeURIComponent(
      document.querySelector(className).value
    );

    const searchURl = document.getElementById("searhresultPageUrl").dataset.searhresultpageurl;

    const url = new URL(window.location);
    url.searchParams.set("key", searchInputValue);

    window.location =
      searchURl + ".html?qsearch=" + searchInputValue;
  }

  let input = document.querySelectorAll(".search-result");
  input.forEach(function (element) {
    element.addEventListener("keypress", function (event) {
      if (event.key === "Enter" || event.keyCode === 13 ) {
        event.preventDefault();
        let serachInput2 = document.querySelector(".search-desktop");        
        if (
          serachInput2.value.length != 0 &&
          serachInput2.value != undefined &&
          serachInput2.value != null
        ) {         
          if (element.classList.contains("search-desktop")) {
            searchClickRedirection1(".search-desktop");
          } 

        }

        let serachInput3 = document.querySelector(".search-resmobile");        
        if (
          serachInput3.value.length != 0 &&
          serachInput3.value != undefined &&
          serachInput3.value != null
        ) {         
          if (element.classList.contains("search-resmobile")) {
            searchClickRedirection1(".search-resmobile");
          }
        }

      }      
    });
  });
});

/*--------------------------------------------------------------------------*\
      close search on click outside the element and remove background overlay
\*--------------------------------------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  const ignoreClickOnMeElement = document.getElementById("searchSection");
  const searchleaveElement = document.querySelector(".cmp-primary-search");
  const searchleaveElement1 = document.querySelector(".cmp-secondary-search");

  document.addEventListener("mouseup", function (event) {
    if (ignoreClickOnMeElement) {
      const isClickInsideElement = ignoreClickOnMeElement.contains(
        event.target
      );
      if (!isClickInsideElement) {
        ignoreClickOnMeElement.style.display = "none";
        searchleaveElement.classList.remove("cmp-search-bg-change-top");
        searchleaveElement.style.zIndex = "";
        searchleaveElement1.classList.remove("cmp-search-change-navbar");
        searchleaveElement1.style.zIndex = "";
        const searchleaveElement2 = document.getElementById("navBgdropback");
        if (searchleaveElement2) {
          searchleaveElement2.remove();
        }
      }
    }
  });
});

/*--------------------------------------------------------------------------*\
     search input field clear
\*--------------------------------------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  window.clearFields = () => {
    document.getElementById("search_inputbox").value = "";
    document.querySelector(".searchProduct-show").style.display = "none";
  };
});

/*--------------------------------------------------------------------------*\
     search input field clear and close outside click
\*--------------------------------------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  const ignoreClickoutsideElement = document.querySelector(
    ".searchProduct-show"
  );
  if (ignoreClickoutsideElement) {
    document.addEventListener("mouseup", function (event) {
      const isClickoutsideElement = ignoreClickoutsideElement.contains(
        event.target
      );
      if (!isClickoutsideElement) {
        ignoreClickoutsideElement.style.display = "none";
      }
    });
  }
});
