import Mark from "mark.js";

window.addEventListener("DOMContentLoaded", () => {
  let faqComponent = document.querySelectorAll("#faqComponent")[0]?.dataset;

  if (faqComponent) {
    function populateFaqResponse(results) {
      if (results.assetsVO.length === 0) {
        let errorText = document.querySelector("#faqAccordion").dataset;
        document
          .querySelector(".faq-accordion")
          .insertAdjacentHTML(
            "beforeend",
            `<div class="empty-message">${errorText.errortext}</div>`
          );
      }

      for (let result of results.assetsVO) {
        let accordionfilter = `<div class="accordion-item">
            <h2 class="accordion-header faq-button-click" id="heading-${result.uuid}">
                <button class="accordion-button collapsed " type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapse-${result.uuid}" aria-expanded="true"
                    aria-controls="heading-${result.uuid}" aria-question="${result.faqQuestion}">
                    <p class="faq-question-head">
                    ${result.faqQuestion}
                    </p> 
                </button>
            </h2>
            <div id="collapse-${result.uuid}" aria-question="${result.faqQuestion}"
                class="accordion-collapse collapse" aria-labelledby="heading-${result.uuid}"
                data-bs-parent="#faqAccordion">
                <div class="accordion-body">
                    <span class="accordion-text"> <p> ${result.faqAnswer} </p> </span>

                </div>
            </div>
        </div>`;
        let eventCardRow = document.querySelector(".faq-accordion");
        if (eventCardRow) {
          eventCardRow.insertAdjacentHTML("beforeend", accordionfilter);
        }
      }
      let resultLabel = document.getElementById("faq-hidden-count").dataset;
      let totalCount = results.totalAssets + " " + resultLabel.count;
      document.querySelector(".faq-result-numbers").textContent = totalCount;

      document
        .querySelector("#faqSuggestions")
        .setAttribute("data-inputresult", results.totalAssets);
	  

	  // Faq Analytics button
		let faqButtonClick = document.querySelectorAll(
			".faq-button-click"
		  );
		  if (faqButtonClick) {
			faqButtonClick.forEach((el) =>
			  el.addEventListener("click", function () {
				faqInteract(el);
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
        "assetpath=/content/dam/myproject/content-fragments/" +
        faqComponent.pagelanguage +
        "&offset=1",
      {
        headers: STANDARD_HEADERS,
        method: "GET",
        redirect: "follow",
      }
    )
      .then((response) => response.json())
      .then((results) => {
        populateFaqResponse(results);
      })
      .catch((error) => error);

    document.querySelectorAll("#faqFilter").forEach((el) =>
      el.addEventListener("click", function () {
        let filter = "";
        document.querySelector(".faq-result-numbers").innerHTML = "";
        document.querySelector(".faq-accordion").innerHTML = "";
        document
          .querySelectorAll(".filter-list-items .form-check-input:checked")
          .forEach((element) => {
            if (filter == "") {
              filter = element.defaultValue;
            } else {
              filter = filter + "," + element.defaultValue;
            }
          });

        fetch(
          "/content/myproject/servicespath/searchAsset.assets.json?" +
            "assetpath=/content/dam/myproject/content-fragments/" +
            faqComponent.pagelanguage +
            (filter ? "&param1=" + filter : ""),
          {
            headers: STANDARD_HEADERS,
            method: "GET",
            redirect: "follow",
          }
        )
          .then((response) => response.json())
          .then((results) => {
            populateFaqResponse(results);
          })
          .catch((error) => error);
      })
    );

    // clearing checkboxes on clicking clear all button
    document.querySelectorAll("#clearFaqFilter").forEach((el) =>
      el.addEventListener("click", function () {
        let clist = document.querySelectorAll("input[type=checkbox]");
        for (const element of clist) {
          element.checked = false;
        }
        document.querySelector("#faqFilter").click();
        document.getElementById("faqFilter").disabled = true;
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
          document.getElementById("faqFilter").disabled = false;
        } else {
          document.getElementById("faqFilter").disabled = true;
        }
      });
    });

    // search func

    window.searchFaqClick = () => {
      document.querySelector(".faq-product-show").style.display = "none";
      document.querySelector(".faq-result-numbers").innerHTML = "";
      document.querySelector(".faq-accordion").innerHTML = "";
      const searchInputValue = cleanHTML(
        document.querySelector(".serach_input_box").value
      );
      fetch(
        "/content/myproject/servicespath/searchAsset.assets.json?" +
          "assetpath=/content/dam/myproject/content-fragments/" +
          faqComponent.pagelanguage +
          "&searchkey=" +
          searchInputValue +
          "&offset=1",
        {
          headers: STANDARD_HEADERS,
          method: "GET",
          redirect: "follow",
        }
      )
        .then((response) => response.json())
        .then((results) => {
          populateFaqResponse(results);
          performMark();
        })
        .catch((error) => error);

      //  Highlighting Functionality

      const markInstance = new Mark(document.querySelector(".faq-accordion"));
      window.performMark = () => {
        markInstance.unmark({
          done: function () {
            markInstance.mark(searchInputValue, {
              separateWordSearch: false,
            });
          },
        });
      };
    };

    // search on enter button functionality

    let input = document.querySelector(".faq-input-box");
    input.addEventListener("keypress", function (event) {
      if (event.key === "Enter") {
        document.querySelector(".faq-product-show").style.display = "none";
        document.querySelector(".faq-result-numbers").innerHTML = "";
        document.querySelector(".faq-accordion").innerHTML = "";
        const searchInputValue = encodeURIComponent(
          document.querySelector(".serach_input_box").value
        );
        fetch(
          "/content/myproject/servicespath/searchAsset.assets.json?" +
            "assetpath=/content/dam/myproject/content-fragments/" +
            faqComponent.pagelanguage +
            "&searchkey=" +
            searchInputValue +
            "&offset=1",
          {
            headers: STANDARD_HEADERS,
            method: "GET",
            redirect: "follow",
          }
        )
          .then((response) => response.json())
          .then((results) => {
            populateFaqResponse(results);
            performMark();
          })
          .catch((error) => error);

        //  Highlighting Functionality

        const markInstance = new Mark(document.querySelector(".faq-accordion"));
        window.performMark = () => {
          markInstance.unmark({
            done: function () {
              markInstance.mark(searchInputValue, {
                separateWordSearch: false,
              });
            },
          });
        };
      }
    });

    // suggestion func

    const faqListresshow = document.querySelectorAll(".proshow");

    function resultShow(e) {
      let nodata = document.querySelector("#faqComponent").dataset.nosuggestion;

      //getting data from url
      fetch(
        `/content/myproject/servicespath/suggestionData.autosuggest.json?term=${e}&rp=/content/dam/myproject/content-fragments/` +
          faqComponent.pagelanguage,
        {
          headers: STANDARD_HEADERS,
          method: "GET",
          redirect: "follow",
        }
      )
        .then((res) => res.json())
        .then((d) => {
          faqResultDisplay(d);
        });

      //filter and combin

      let list = "";
      let faqResultDisplay = (res) => {
        let List = res.map((r) => {
          list += `<li class="Click-list" id="clicklistid" onclick='FaqFun(this)'>${r}</li>`;
        });

        if (list.length > 2) {
          document
            .querySelectorAll(".faq-product-show")
            .forEach(function (element) {
              element.style.display = "block";
            });

          faqListresshow.forEach(function (element) {
            element.innerHTML = "<ul>" + list + "</ul>";
          });
        } else {
          faqListresshow.forEach(function (element) {
            element.innerHTML =
              `<ul class="faqclicklistshow">` + nodata + `</ul>`;
          });
        }
      };
    }

    const faqInputRes = document.getElementById("faqSuggestions");
    faqInputRes.addEventListener("input", () => {
      let resultencode = encodeURIComponent(faqInputRes.value.trim());
      if (resultencode.length > 2) {
        resultShow(resultencode);
      }
    });

    window.FaqFun = (s) => {
      faqInputRes.empty = s.innerHTML;
      const faqForm = document.querySelectorAll(".faq-input-box");
      faqForm.forEach(function (element) {
        element.value = faqInputRes.empty;
      });

      if (faqInputRes.empty == "") {
        document
          .querySelectorAll(".faq-product-show")
          .forEach(function (element) {
            element.style.display = "block";
          });
      } else {
        document
          .querySelectorAll(".faq-product-show")
          .forEach(function (element) {
            element.style.display = "none";
          });
      }
    };
  }
});

/*--------------------------------------------------------------------------*\
     search input click ouside dropdown disappear
\*--------------------------------------------------------------------------*/

window.addEventListener("DOMContentLoaded", () => {
  const ignoreFaqClickoutsideElement =
    document.querySelector(".faq-product-show");
  if (ignoreFaqClickoutsideElement) {
    document.addEventListener("mouseup", function (event) {
      const isFaqClickoutsideElement = ignoreFaqClickoutsideElement.contains(
        event.target
      );
      if (!isFaqClickoutsideElement) {
        ignoreFaqClickoutsideElement.style.display = "none";
      }
    });
  }
});
