/*-------------------------------------------------*\
   Javascript sheet for the Component Analytics
   
   Table of Contents
   If you conduct a Search on the page, type in the 
   section below that you would like to jump to.

   -- Pageload JSON
   -- Filter Interacted
   -- customlinksInteracted
   -- Global Serach
   -- FAQ Serach
   -- TCO Calculator and Dramix Pro Form
   -- FAQ Interaction

   
   
\*-------------------------------------------------*/

let dataLayerEnabled = null;
let dataLayer = null;

/**
 * Method to Get the AEM Adobe Object.
 * @returns {Objct} AEM Object
 */
export function getAdobeDataObject() {
  return window.adobeDataLayer.getState(adobeDataLayer[0].eventInfo.path);
}

export const isDataLayerEnabled = () => {
  if (dataLayerEnabled === null) {
    dataLayerEnabled = document.body.hasAttribute(
      "data-cmp-data-layer-enabled"
    );
  }
  return dataLayerEnabled;
};
export const getDataLayer = () => {
  if (dataLayer === null) {
    dataLayer = isDataLayerEnabled()
      ? (window.adobeDataLayer = window.adobeDataLayer || [])
      : undefined;
  }
  return dataLayer;
};

export const generateDataLayerId = async (prefix, idData, separator = "-") => {
  const msgUint8 = new TextEncoder().encode(idData); // encode as (utf-8) Uint8Array
  const hashBuffer = await crypto.subtle.digest("SHA-256", msgUint8); // hash the message
  const hashArray = Array.from(new Uint8Array(hashBuffer)); // convert buffer to byte array
  const hashHex = hashArray
    .map((b) => b.toString(16).padStart(2, "0"))
    .join(""); // convert bytes to hex string
  return prefix + separator + hashHex.substring(0, 10);
};

// https://github.com/adobe/adobe-client-data-layer/wiki#push
export const pushData = (data) => {
  if (isDataLayerEnabled()) {
    getDataLayer().push(data);
  }
};

// https://github.com/adobe/adobe-client-data-layer/wiki#push
export const pushEvent = (eventName, eventInfo, extraData) => {
  if (isDataLayerEnabled()) {
    getDataLayer().push({
      event: eventName,
      eventInfo: eventInfo,
      ...extraData,
    });
  }
};

// https://github.com/adobe/adobe-client-data-layer/wiki#getstate
export const getState = (reference) => {
  if (isDataLayerEnabled()) {
    return getDataLayer().getState(reference);
  }
  return null;
};

// https://github.com/adobe/adobe-client-data-layer/wiki#addeventlistener
export const addEventListener = (eventName, handler) => {
  if (isDataLayerEnabled()) {
    getDataLayer().addEventListener(eventName, handler);
  }
};

// https://github.com/adobe/adobe-client-data-layer/wiki#removeeventlistener
export const removeEventListener = (eventName, handler) => {
  if (isDataLayerEnabled()) {
    getDataLayer().removeEventListener(eventName, handler);
  }
};
window.addEventListener("DOMContentLoaded", () => {
  function dataLayer2(loadJSON) {
    window.dataLayer = window.dataLayer || [];
    window.dataLayer.push(loadJSON);
  }

  const getDeviceType = () => {
    const ua = navigator.userAgent;
    if (/(tablet|ipad|playbook|silk)|(android(?!.*mobi))/i.test(ua)) {
      return "tablet";
    }
    if (
      /Mobile|iP(hone|od)|Android|BlackBerry|IEMobile|Kindle|Silk-Accelerated|(hpw|web)OS|Opera M(obi|ini)/.test(
        ua
      )
    ) {
      return "mobile";
    }
    return "desktop";
  };

  let bredCrumb = document.querySelectorAll(".breadcrumb-item");
  let breadCrubValues = [];
  for (let i = 0; i < bredCrumb.length; i++) {
    let breadCrub = bredCrumb[i].dataset.cmpDataLayer;
    var breadCrubJSON = JSON.parse(breadCrub);
    let firstValues = Object.values(breadCrubJSON);
    let secondValues = firstValues[0];
    let thirdValue = Object.values(secondValues);
    breadCrubValues.push(thirdValue[2]);
  }
  let level0;
  let level1;
  let level3;
  let level4;

  for (let i = 0; i < breadCrubValues.length; i++) {
    level0 = breadCrubValues[i];
    level1 = breadCrubValues[(i += 1)];
    level3 = breadCrubValues[(i += 1)];
    level4 = breadCrubValues[(i += 1)];
  }
  let vistorType = checkFirstVisit();
  breadCrubValues;
  function checkFirstVisit() {
    if (localStorage.getItem("was_visited")) {
      return "Returning";
    }
    localStorage.setItem("was_visited", 1);
    return "New";
  }

  function faqDataPush(
    serachTerm,
    SearchResults,
    searchCategory,
    pageCategory1,
    currentpagepath,
    title,
    GlobalSerach
  ) {
    let loadJSON = {
      event: "searchResults",
      data: {
        SearchResults: SearchResults,
        SearchTerm: serachTerm,
        pageCategory: pageCategory1,
        pageName: title,
        pageUrl: currentpagepath,
        searchCategory: searchCategory,
        userSentiments: "",
      },
    };
    if (GlobalSerach) window.localStorage.removeItem("GlobalSerach");
    if (isDataLayerEnabled()) {
      dataLayer2(loadJSON);
    }
  }

  function formDataPush(
    event,
    formId,
    formName,
    formAction,
    formErrorMessages,
    formStatus,
    title,
    getcurrentpagepath,
    pageCategory1
  ) {
    let loadJSON = {
      event: event,
      data: {
        formId: formId,
        formName: formName,
        formErrorMessages: formErrorMessages,
        formAction: formAction,
        formStatus: formStatus,
        pageName: title,
        pageUrl: getcurrentpagepath,
        pageCategory: pageCategory1,
      },
    };

    if (isDataLayerEnabled()) {
      dataLayer2(loadJSON);
    }
  }

  function downloadDataPush(
    eventLoad1,
    formId,
    formName,
    formAction,
    formErrorMessages,
    formStatus,
    downloadAction,
    documentNames,
    documenentsLangs,
    documentCategory,
    title,
    getcurrentpagepath,
    titleC
  ) {
    let loadJSON = {
      event: eventLoad1,
      data: {
        formId: formId,
        formName: formName,
        formAction: formAction,
        formErrorMessages: formErrorMessages,
        formStatus: formStatus,
        downloadAction: downloadAction,
        documentName: documentNames,
        documentLanguage: documenentsLangs,
        documentCategory: documentCategory,
        pageName: title,
        pageUrl: getcurrentpagepath,
        pageCategory: titleC,
      },
    };

    if (isDataLayerEnabled()) {
      dataLayer2(loadJSON);
    }
  }

  const Tracker = () => {
    let dataLayer = getDataLayer();
    let parmater = document.getElementById("analyticsData").dataset;
    const language = document.documentElement.lang.toLowerCase();
    let bredCrumbs = document.querySelectorAll(".breadcrumb-item");
    let pageCategory1;
    if (bredCrumbs.length == 0) pageCategory1 = "Home";
    else pageCategory1 = parmater.title;
    let country;
    if (language.includes("es-mx")) {
      country = "mx";
    } else if (language.includes("en-us")) {
      country = "us";
    }

    let deviceType = getDeviceType();
    const perfData = window.performance.timing;
    const pageLoadTime = perfData.navigationStart - perfData.loadEventEnd;

    /*-------------------------------------------*\
      Pageload JSON
  \*-------------------------------------------*/

    let loadJSON = {
      event: "PageLoad",
      data: {
        pageName: parmater.title,
        pageTitle: parmater.title,
        pageUrl: parmater.getcurrentpagepath,
        pageCategory: pageCategory1,
        hostName: parmater.getdomainname,
        referringURL: parmater.getprevpage,
        breadCrumbs: breadCrubValues,
        pageType: parmater.getpagetype,
        siteCountry: country,
        siteLanguage: language,
        deviceOS: parmater.getdeviceos,
        deviceType: deviceType,
        environmentType: parmater.getenv,
        prevPage: parmater.getprevpage,
        visitorType: vistorType,
        pageLoadTime: pageLoadTime,
        contentHierarchy: {
          level1: level0,
          level2: level1,
          level3: level3,
          level4: level4,
        },
      },
    };
    if (isDataLayerEnabled()) {
      dataLayer2(loadJSON);
    }

    /*-------------------------------------------*\
      Filter Interacted
  \*-------------------------------------------*/

    let formCheckBoxs = document.querySelectorAll(".form-check-input-listing");
    let filterValue = "";
    let filterCategory = "";
    if (formCheckBoxs) {
      formCheckBoxs.forEach((checkBox) => {
        checkBox.addEventListener("change", function () {
          let check = checkBox.checked;
          const [first, second, third] = checkBox.value.split("/");
          if (!filterCategory.includes(second)) {
            filterCategory += second + ",";
          }
          if (check) {
            filterValue += second + ":" + third + ",";
          } else {
            if (filterValue.includes(second + ":" + third + ",")) {
              filterValue = filterValue.replace(second + ":" + third + ",", "");
            }
            if (!filterValue.includes(second)) {
              filterCategory = filterCategory.replace(second + ",", "");
            }
          }
          let pageCategory = "Toolbox - " + parmater.title;
          let s = filterCategory;
          let filterCategory1 = s.slice(0, s.lastIndexOf(","));
          let sf = filterValue;
          let filterValue1 = sf.slice(0, sf.lastIndexOf(","));
          let loadJSON = {
            event: "FilterInteracted",
            data: {
              filterCategory: filterCategory1,
              filterType: "Side offcanvas",
              filterValues: filterValue1,
              pageCategory: pageCategory1,
              pageName: parmater.title,
              pageUrl: parmater.getcurrentpagepath,
            },
          };
          if (isDataLayerEnabled()) {
            dataLayer2(loadJSON);
          }
        });
      });
    }

    /*-------------------------------------------*\
      customlinksInteracted
\*-------------------------------------------*/

    let socialLinks = document.querySelectorAll(".social_icons_click");
    if (socialLinks) {
      socialLinks.forEach((el) =>
        el.addEventListener("click", function () {
          let eventCategoryValue = el.dataset.value;
          let eventLabelValue = eventCategoryValue.split("-");
          eventCategoryValue = eventCategoryValue.replace("-", " ");
          let eventLabel1 = eventLabelValue[0];
          let loadJSON = {
            event: "customlinksInteracted",
            data: {
              eventAction: "Click",
              eventCategory: eventCategoryValue,
              eventLabel: eventLabel1,
              pageCategory: pageCategory1,
              pageName: parmater.title,
              pageUrl: parmater.getcurrentpagepath,
            },
          };
          if (isDataLayerEnabled()) {
            dataLayer2(loadJSON);
          }
        })
      );
    }

    /*-------------------------------------------*\
      Global Serach
\*-------------------------------------------*/

    let serachInputs = document.querySelectorAll(".search-global-analytics");
    if (serachInputs) {
      serachInputs.forEach((el) =>
        el.addEventListener("keypress", function (ev) {
          if (ev.key === "Enter" || ev.keyCode === 13) {
            window.localStorage.setItem("GlobalSerach", true);
          }
        })
      );
    }

    let serachClick = document.querySelectorAll(".header-search-analytics");
    if (serachClick) {
      serachClick.forEach((el) =>
        el.addEventListener("click", function () {
          window.localStorage.setItem("GlobalSerach", true);
        })
      );
    }

    if (window.localStorage.getItem("GlobalSerach")) {
      setTimeout(function () {
        let resultInput = document.querySelector("#search_inputbox");
        let searchCategory = resultInput.dataset.serachtype;
        let searchResults = resultInput.dataset.inputresultscount;
        let serachTerm = resultInput.value;
        faqDataPush(
          serachTerm,
          searchResults,
          searchCategory,
          pageCategory1,
          parmater.getcurrentpagepath,
          parmater.title,
          window.localStorage.getItem("GlobalSerach")
        );
      }, 2000);
    }

    let resultInputs = document.querySelectorAll("#search_inputbox");
    if (resultInputs) {
      resultInputs.forEach((el) =>
        el.addEventListener("keypress", function (events) {
          if (events.key === "Enter" || events.keyCode === 13) {
            setTimeout(function () {
              let resultDataset = el.dataset;
              let serachTerm = el.value;
              let SearchResults = resultDataset.inputresultscount;
              let searchCategory = resultDataset.serachtype;
              events.preventDefault();
              faqDataPush(
                serachTerm,
                SearchResults,
                searchCategory,
                pageCategory1,
                parmater.getcurrentpagepath,
                parmater.title
              );
            }, 1500);
          }
        })
      );
    }
    let searchResultClick = document.querySelectorAll(
      ".result-click-analytics"
    );
    if (searchResultClick) {
      searchResultClick.forEach((el) =>
        el.addEventListener("click", function (events) {
          setTimeout(function () {
            let resultInput = document.querySelector("#search_inputbox");
            let searchCategory = resultInput.dataset.serachtype;
            let searchResults = resultInput.dataset.inputresultscount;
            let serachTerm = resultInput.value;
            events.preventDefault();
            faqDataPush(
              serachTerm,
              searchResults,
              searchCategory,
              pageCategory1,
              parmater.getcurrentpagepath,
              parmater.title
            );
          }, 1500);
        })
      );
    }

    /*-------------------------------------------*\
      FAQ Serach
\*-------------------------------------------*/

    let faqSerachClick = document.querySelectorAll("#searchClick");
    if (faqSerachClick) {
      faqSerachClick.forEach((el) =>
        el.addEventListener("click", function (events) {
          setTimeout(function () {
            let faqDataset = document.querySelector(".faq-input-box").dataset;
            let serachTerm = document.querySelector(".faq-input-box").value;
            let SearchResults = faqDataset.inputresult;
            let searchCategory = faqDataset.serachtype;
            faqDataPush(
              serachTerm,
              SearchResults,
              searchCategory,
              pageCategory1,
              parmater.getcurrentpagepath,
              parmater.title
            );
          }, 1500);
        })
      );
    }
    let faqSerachInput = document.querySelectorAll(".faq-input-box");
    if (faqSerachInput) {
      faqSerachInput.forEach((el) =>
        el.addEventListener("keypress", function (events) {
          if (events.key === "Enter" || events.keyCode === 13) {
            setTimeout(function () {
              let faqDataset = el.dataset;
              let serachTerm = el.value;
              let SearchResults = faqDataset.inputresult;
              let searchCategory = faqDataset.serachtype;
              events.preventDefault();
              faqDataPush(
                serachTerm,
                SearchResults,
                searchCategory,
                pageCategory1,
                parmater.getcurrentpagepath,
                parmater.title
              );
            }, 1500);
          }
        })
      );
    }

    /*-------------------------------------------*\
      Request Form
\*-------------------------------------------*/

    let requestFormClick = document.querySelectorAll(".request-click");
    if (requestFormClick) {
      requestFormClick.forEach((el) =>
        el.addEventListener("click", function (event) {
          window.localStorage.setItem("requestForm", true);
        })
      );
    }

    if (window.localStorage.getItem("requestForm")) {
      setTimeout(function () {
        let el = document.querySelector(".request-click");
        let requestDataset = el.dataset;
        let formAction = requestDataset.formaction;
        let formId = requestDataset.formid;
        let formName = requestDataset.formid;
        let eventLoad = "formLoaded";
        let formErrorMessages = "";
        let formStatus = "";
        window.localStorage.removeItem("requestForm");
        formDataPush(
          eventLoad,
          formId,
          formName,
          formAction,
          formErrorMessages,
          formStatus,
          parmater.title,
          parmater.getcurrentpagepath,
          pageCategory1,
          true,
          "requestForm"
        );
      }, 1500);
    }

    let requestFormButton = document.querySelectorAll(".request-button-click");
    if (requestFormButton) {
      requestFormButton.forEach((el) =>
        el.addEventListener("click", function (ts) {
          setTimeout(function () {
            let requestDataset = el.dataset;
            let formAction = requestDataset.formaction;
            let formId = requestDataset.formid;
            let formName = requestDataset.formid;
            let eventLoad = "formSubmit";
            let requestformPage = document.querySelector("#requestform");
            let formStatus;
            let formErrorMessages;
            let checkValid =
              requestformPage.classList.contains("was-validated");

            if (checkValid) {
              formStatus = "Form Error";
              formErrorMessages =
                "Please complete the mandatory fields in the correct format.";
            }
            formDataPush(
              eventLoad,
              formId,
              formName,
              formAction,
              formErrorMessages,
              formStatus,
              parmater.title,
              parmater.getcurrentpagepath,
              pageCategory1,
              true
            );
          }, 1500);
        })
      );
    }

    /*-------------------------------------------*\
      Download Form
\*-------------------------------------------*/
    let downloadCartContent;
    let downloadFormClick = document.querySelectorAll(".button-down");
    if (downloadFormClick) {
      downloadFormClick.forEach((el) =>
        el.addEventListener("click", function (events) {
          window.localStorage.setItem("downloadForm", true);
        })
      );
    }

    if (window.localStorage.getItem("downloadForm")) {
      setTimeout(function () {
        let elementsAll = document.querySelectorAll(".button-down");
        let el = elementsAll[elementsAll.length - 1];
        let formAction = el.dataset.formaction;
        let formId = el.dataset.id;
        let formName = el.dataset.id;
        let eventLoad = "formLoaded";
        let eventLoad1 = "downloadCart";
        let formErrorMessages = "";
        let formStatus = "";
        let downloadAction = "Download Viewed";
        window.localStorage.removeItem("downloadForm");
        formDataPush(
          eventLoad,
          formId,
          formName,
          formAction,
          formErrorMessages,
          formStatus,
          parmater.title,
          parmater.getcurrentpagepath,
          pageCategory1
        );

        /*-------------------------------------------*\
      Download Cart Interaction
   \*-------------------------------------------*/

        let documentNames = "";
        let documenentsLangs = "";
        let documentCategory = "";
        let DownloadContentDataD = JSON.parse(
          window.localStorage.getItem("downloadContent_")
        );

        for (let item of DownloadContentDataD) {
          documentNames += item.title + ",";
          documenentsLangs += item.language + ",";
          if (item.assetPath.includes("whitepaper")) {
            documentCategory += "Whitepaper ,";
          } else if (item.assetPath.includes("productdatasheet")) {
            documentCategory += "Productdatasheet ,";
          } else if (item.assetPath.includes("certificate")) {
            documentCategory += "Certificate ,";
          }
        }
        documentNames = documentNames.slice(0, documentNames.lastIndexOf(","));
        documenentsLangs = documenentsLangs.slice(
          0,
          documenentsLangs.lastIndexOf(",")
        );
        documentCategory = documentCategory.slice(
          0,
          documentCategory.lastIndexOf(",")
        );

        downloadDataPush(
          eventLoad1,
          formId,
          formName,
          formAction,
          formErrorMessages,
          formStatus,
          downloadAction,
          documentNames,
          documenentsLangs,
          documentCategory,
          parmater.title,
          parmater.getcurrentpagepath,
          pageCategory1
        );
      }, 1500);
    }

    let downloadFormButton = document.querySelectorAll(".click_download");
    if (downloadFormButton) {
      downloadFormButton.forEach((el) =>
        el.addEventListener("click", function (es) {
          let requestDataset = el.dataset;
          let formAction = "";
          let formId = "";
          let formName = "";
          let eventLoad = "formSubmit";
          let requestformPage = "";
          let formStatus = "";
          let formErrorMessages = "";
          let checkValid;
          setTimeout(function () {
            if (parmater.getcurrentpagepath.includes("downloads")) {
              formAction = requestDataset.formaction;
              formId = requestDataset.formid;
              formName = requestDataset.formid;
              eventLoad = "formSubmit";
              requestformPage = document.querySelector("#downloadform");
              formStatus;
              formErrorMessages;
              checkValid = requestformPage.classList.contains("was-validated");
              if (checkValid) {
                formStatus = "Form Error";
                formErrorMessages =
                  "Please complete the mandatory fields in the correct format.";
              }
            } else if (parmater.getcurrentpagepath.includes("Dramix-Pro")) {
              formAction = requestDataset.formactiond;
              formId = requestDataset.formidd;
              formName = requestDataset.formidd;
              eventLoad = "formSubmit";
              requestformPage = document.querySelector("#downloadform");
              formStatus = "";
              formErrorMessages = "";
              checkValid = requestformPage.classList.contains("was-validated");
              if (checkValid) {
                formStatus = "Form Error";
                formErrorMessages =
                  "Please complete the mandatory fields in the correct format.";
              }
            }
            //  window.localStorage.removeItem("formstatus");
            formDataPush(
              eventLoad,
              formId,
              formName,
              formAction,
              formErrorMessages,
              formStatus,
              parmater.title,
              parmater.getcurrentpagepath,
              pageCategory1
            );
          }, 1500);
        })
      );
    }

    function downloadSubmitCart() {
      let eventLoad1 = "downloadSubmit";
      let formId = "downloadForm";
      let formName = "downloadForm";
      let formAction = "Form Submitted";
      let formErrorMessages = "";
      let formStatus = "Form Success";
      let downloadAction = "Download Successfully";
      let documentNames = "";
      let documenentsLangs = "";
      let documentCategory = "";
      let DownloadContentDataD = JSON.parse(
        window.localStorage.getItem("downloadContent")
      );

      for (let item of DownloadContentDataD) {
        documentNames += item.title + ",";
        documenentsLangs += item.language + ",";
        if (item.assetPath.includes("whitepaper")) {
          documentCategory += "Whitepaper ,";
        } else if (item.assetPath.includes("productdatasheet")) {
          documentCategory += "Productdatasheet ,";
        } else if (item.assetPath.includes("certificate")) {
          documentCategory += "Certificate ,";
        }
      }
      documentNames = documentNames.slice(0, documentNames.lastIndexOf(","));
      documenentsLangs = documenentsLangs.slice(
        0,
        documenentsLangs.lastIndexOf(",")
      );
      documentCategory = documentCategory.slice(
        0,
        documentCategory.lastIndexOf(",")
      );

      downloadDataPush(
        eventLoad1,
        formId,
        formName,
        formAction,
        formErrorMessages,
        formStatus,
        downloadAction,
        documentNames,
        documenentsLangs,
        documentCategory,
        parmater.title,
        parmater.getcurrentpagepath,
        pageCategory1
      );
      window.localStorage.removeItem("downloadContent");
    }
    /*-------------------------------------------*\
      Contact us Form
\*-------------------------------------------*/

    let contactusFormClick = document.querySelectorAll(".click-contact");
    if (contactusFormClick) {
      contactusFormClick.forEach((el) =>
        el.addEventListener("click", function (ts) {
          if (el.innerHTML == "Contact Us")
            window.localStorage.setItem("contactusForm", true);
        })
      );
    }

    if (window.localStorage.getItem("contactusForm")) {
      setTimeout(function () {
        let elementsAll = document.querySelectorAll(".click-contact");
        let el = elementsAll[elementsAll.length - 1];
        let requestDataset = el.dataset;
        let formAction = requestDataset.formaction;
        let formId = requestDataset.formid;
        let formName = requestDataset.formid;
        let eventLoad = "formLoaded";
        let formErrorMessages = "faqSearchClick";
        let formStatus = "";
        window.localStorage.removeItem("contactusForm");
        formDataPush(
          eventLoad,
          formId,
          formName,
          formAction,
          formErrorMessages,
          formStatus,
          parmater.title,
          parmater.getcurrentpagepath,
          pageCategory1
        );
      }, 1500);
    }

    let contactusFormButton = document.querySelectorAll(".contactus-click");
    if (contactusFormButton) {
      contactusFormButton.forEach((el) =>
        el.addEventListener("click", function (ts) {
          let requestDataset = el.dataset;
          let formAction = "";
          let formId = "";
          let formName = "";
          let eventLoad = "formSubmit";
          let requestformPage = "";
          let formStatus = "";
          let formErrorMessages = "";
          let checkValid = "";
          setTimeout(function () {
            if (parmater.getcurrentpagepath.includes("contact-us")) {
              formAction = requestDataset.formaction;
              formId = requestDataset.formid;
              formName = requestDataset.formid;
              eventLoad = "formSubmit";
              requestformPage = document.querySelector("#contactform");
              formStatus = "";
              formErrorMessages = "";
              checkValid = requestformPage.classList.contains("was-validated");
              if (checkValid) {
                formStatus = "Form Error";
                formErrorMessages =
                  "Please complete the mandatory fields in the correct format.";
              }
            } else if (parmater.getcurrentpagepath.includes("TCO-Calculator")) {
              formAction = requestDataset.formactiontco;
              formId = requestDataset.formidtco;
              formName = requestDataset.formidtco;
              eventLoad = "formSubmit";
              requestformPage = document.querySelector("#contactform");
              formStatus = "";
              formErrorMessages = "";
              checkValid = requestformPage.classList.contains("was-validated");
              if (checkValid) {
                formStatus = "Form Error";
                formErrorMessages =
                  "Please complete the mandatory fields in the correct format.";
              }
            }
            window.localStorage.removeItem("formstatus");
            formDataPush(
              eventLoad,
              formId,
              formName,
              formAction,
              formErrorMessages,
              formStatus,
              parmater.title,
              parmater.getcurrentpagepath,
              pageCategory1
            );
          }, 1500);
        })
      );
    }

    /*-------------------------------------------*\
      TCO Calculator and Dramix Pro Form
\*-------------------------------------------*/

    let softwaretoolClick = document.querySelectorAll(".click-software-tools");
    if (softwaretoolClick) {
      softwaretoolClick.forEach((el) =>
        el.addEventListener("click", function () {
          window.localStorage.setItem("dualforms", true);
        })
      );
    }

    if (window.localStorage.getItem("dualforms")) {
      setTimeout(function () {
        let pagePath =
          document.getElementById("analyticsData").dataset.getcurrentpagepath;
        if (pagePath.includes("TCO-Calculator")) {
          let formAction = "Form Viewed";
          let formId = " costSavingCalculatorForm";
          let formName = " costSavingCalculatorForm";
          let eventLoad = "formLoaded";
          let formErrorMessages = "";
          let formStatus = "";

          formDataPush(
            eventLoad,
            formId,
            formName,
            formAction,
            formErrorMessages,
            formStatus,
            parmater.title,
            parmater.getcurrentpagepath,
            pageCategory1
          );
        } else if (pagePath.includes("Dramix-Pro")) {
          let formAction = "Form Viewed";
          let formId = "DramixProSuiteForm";
          let formName = "DramixProSuiteForm";
          let eventLoad = "formLoaded";
          let formErrorMessages = "";
          let formStatus = "";

          formDataPush(
            eventLoad,
            formId,
            formName,
            formAction,
            formErrorMessages,
            formStatus,
            parmater.title,
            parmater.getcurrentpagepath,
            pageCategory1
          );
        }
        window.localStorage.removeItem("dualforms");
      }, 1500);
    }

    /*-------------------------------------------*\
      FAQ Interaction
  \*-------------------------------------------*/

    window.faqInteract = function (el) {
      let buttonElement = document.querySelector("#" + el.id).lastElementChild;

      let faqNames = buttonElement.getAttribute("aria-question");
      let buttonClass = buttonElement.classList.contains("collapsed");
      let userSentiments;
      if (buttonClass) userSentiments = 0;
      else userSentiments = 1;
      let loadJSON = {
        event: "FAQInteracted",
        data: {
          FaqName: faqNames,
          pageName: parmater.title,
          pageUrl: parmater.getcurrentpagepath,
          userSentiments: userSentiments,
        },
      };
      if (isDataLayerEnabled()) {
        dataLayer2(loadJSON);
      }
    };

    if (window.localStorage.getItem("formstatus") != null) {
      let formAction = "";
      let formId = "";
      let formName = "";
      let eventLoad = "";
      let formStatus = "";
      let formErrorMessages = "";

      if (window.localStorage.getItem("formtype") == "contact") {
        if (window.localStorage.getItem("formstatus") == "success") {
          formAction = "Form Submitted";
          formId = "contactUsForm";
          formName = "contactUsForm";
          eventLoad = "formSubmit";
          formStatus = "Form Success";
          formErrorMessages = "";
        } else if (window.localStorage.getItem("formstatus") == "fail") {
          formAction = "Form Submitted";
          formId = "contactUsForm";
          formName = "contactUsForm";
          eventLoad = "formSubmit";
          formStatus = "Form Error";
          formErrorMessages =
            "Please complete the mandatory fields in the correct format.";
        }
        window.localStorage.removeItem("formstatus");
        formDataPush(
          eventLoad,
          formId,
          formName,
          formAction,
          formErrorMessages,
          formStatus,
          parmater.title,
          parmater.getcurrentpagepath,
          pageCategory1
        );
      } else if (window.localStorage.getItem("formtype") == "tco") {
        if (window.localStorage.getItem("formstatus") == "success") {
          formAction = "Form Submitted";
          formId = "costSavingCalculatorForm";
          formName = " costSavingCalculatorForm";
          eventLoad = "formSubmit";
          formStatus = "Form Success";
          formErrorMessages = "";
        } else if (window.localStorage.getItem("formstatus") == "fail") {
          formAction = "Form Submitted";
          formId = "costSavingCalculatorForm";
          formName = "costSavingCalculatorForm";
          eventLoad = "formSubmit";
          formStatus = "Form Error";
          formErrorMessages =
            "Please complete the mandatory fields in the correct format.";
        }
        window.localStorage.removeItem("formstatus");
        formDataPush(
          eventLoad,
          formId,
          formName,
          formAction,
          formErrorMessages,
          formStatus,
          parmater.title,
          parmater.getcurrentpagepath,
          pageCategory1
        );
      }

      if (window.localStorage.getItem("formtype") == "requestform") {
        formAction = "Form Submitted";
        formId = "requestquoteForm";
        formName = "requestquoteForm";
        eventLoad = "formSubmit";
        formStatus;
        formErrorMessages;
        if (window.localStorage.getItem("formstatus") == "success") {
          formStatus = "Form Success";
          formErrorMessages = "";
        } else if (window.localStorage.getItem("formstatus") == "fail") {
          formStatus = "Form Error";
          formErrorMessages =
            "Please complete the mandatory fields in the correct format.";
        }
        window.localStorage.removeItem("formstatus");
        formDataPush(
          eventLoad,
          formId,
          formName,
          formAction,
          formErrorMessages,
          formStatus,
          parmater.title,
          parmater.getcurrentpagepath,
          pageCategory1,
          true
        );
      }

      if (window.localStorage.getItem("formtype") == "download") {
        formAction = "Form submitted";
        formId = "DownloadForm";
        formName = "DownloadForm";
        eventLoad = "formSubmit";
        if (window.localStorage.getItem("formstatus") == "success") {
          formStatus = "Form Success";
          formErrorMessages = "";
        } else if (window.localStorage.getItem("formstatus") == "fail") {
          formStatus = "Form Error";
          formErrorMessages =
            "Please complete the mandatory fields in the correct format.";
        }
        downloadSubmitCart();
        window.localStorage.removeItem("formstatus");
        formDataPush(
          eventLoad,
          formId,
          formName,
          formAction,
          formErrorMessages,
          formStatus,
          parmater.title,
          parmater.getcurrentpagepath,
          pageCategory1
        );
      } else if (window.localStorage.getItem("formtype") == "dramixPro") {
        formAction = "Form submitted";
        formId = "DramixProSuiteForm";
        formName = "DramixProSuiteForm";
        eventLoad = "formSubmit";
        if (window.localStorage.getItem("formstatus") == "success") {
          formStatus = "Form Success";
          formErrorMessages = "";
        } else if (window.localStorage.getItem("formstatus") == "fail") {
          formStatus = "Form Error";
          formErrorMessages =
            "Please complete the mandatory fields in the correct format.";
        }
        window.localStorage.removeItem("formstatus");
        formDataPush(
          eventLoad,
          formId,
          formName,
          formAction,
          formErrorMessages,
          formStatus,
          parmater.title,
          parmater.getcurrentpagepath,
          pageCategory1
        );
      }
    }
  };

  Tracker();
});
