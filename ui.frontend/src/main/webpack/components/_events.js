window.addEventListener("DOMContentLoaded", () => {
  let className = [
    "col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 listing-div listing-medium-div d-flex mb-3",
    "col-6 col-sm-6 col-md-3 col-lg-3 col-xl-3 listing-div d-flex mb-3",
  ];

  let eventComponent;
  let eventComponents = document.getElementById("eventComponent");
  if (eventComponents) {
    eventComponent = document.getElementById("eventComponent").dataset.api;

    function populateResponse(results) {
      let i = 0;
      if (results.eventCards.length === 0) {
        let errorText = document.querySelector(".eventcards-page-row").dataset;
        document
          .querySelector(".eventcards-page-row")
          .insertAdjacentHTML(
            "beforeend",
            `<div class="empty-message">${errorText.noresults}</div>`
          );
      }
      for (let result of results.eventCards) {
        let listingelement = `<div class="${className[i]}">
		<a href="${result.linkUrl}"`;
		if(result.newTab==true){
			listingelement+= ` target="_blank" `;
		}
		else{
			listingelement+= ` target="_self" `;
		}
		listingelement+= `class="card text-decoration-none software-card-link border-0">
		<div class="small-image">
      <img class="small-image-class rounded-0 card-img-top"src="${result.image}" alt="${result.alt}">
      <img class="calculator-icon"src="${results.imageIcon}" alt="">
    </div>
    <div class="desription-wrapper-div d-flex flex-column">
      <div class="image-description card-body d-flex flex-column p-0">
      <div>
    <h5 class="card-title"><div class="cmp-teaser__content">
    <h3 class="cmp-teaser__title">${result.title}</h3></div></h5>
    <div class="cmp-teaser__description card-text mb-4">
      <p>${result.description}</p>
    </div>
    </div></div>
    <hr class="teaser-horz-line opacity-100 mt-auto align-self-start w-100">
    <button class="acs-btn">${result.linkTitle}<span class="arrow-cont"><img src="/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/button-icons/access_box.svg" alt="">
    </span></button>

    </div>
  </a>
  </div>`;
        let eventCardRow = document.querySelector(".eventcards-page-row");
        if (eventCardRow) {
          eventCardRow.insertAdjacentHTML("beforeend", listingelement);
        }
        if (i < className.length - 1) {
          i = i + 1;
        } else {
          i = 1;
        }
      }
      let resultLabel = document.getElementById("event-hidden-count").dataset;
      let totalCount = results.totalEvents + " " + resultLabel.count;
      document.querySelector(".result-numbers").textContent = totalCount;
    }

    const STANDARD_HEADERS = {
      "Content-Type": "application/json",
      "X-XSS-Protection": "1; mode=block",
      "X-Frame-Options": "directive",
      "X-Content-Type-Options": "nosniff",
      "Content-Security-Policy": "default-src 'self'",
      "Referrer-Policy": "no-referrer",
    };

    fetch(eventComponent, {
      headers: STANDARD_HEADERS,
      method: "GET",
      redirect: "follow",
    })
      .then((response) => response.json())
      .then((results) => {
        populateResponse(results);
      })
      .catch((error) => error);
  }

  document.querySelectorAll("#eventFilter").forEach((el) =>
    el.addEventListener("click", function () {
      let filter = "";
      document.querySelector(".result-numbers").innerHTML = "";
      document.querySelector(".eventcards-page-row").innerHTML = "";
      document
        .querySelectorAll(".filter-list-items .form-check-input:checked")
        .forEach((element) => {
          if (filter == "") {
            filter = element.defaultValue;
          } else {
            filter = filter + "," + element.defaultValue;
          }
        });

      const STANDARD_HEADERS = {
        "Content-Type": "application/json",
        "X-XSS-Protection": "1; mode=block",
        "X-Frame-Options": "directive",
        "X-Content-Type-Options": "nosniff",
        "Content-Security-Policy": "default-src 'self'",
        "Referrer-Policy": "no-referrer",
      };
      fetch(eventComponent + (filter ? "?eventType=" + filter : ""), {
        headers: STANDARD_HEADERS,
        method: "GET",
        redirect: "follow",
      })
        .then((response) => response.json())
        .then((results) => {
          populateResponse(results);
        })
        .catch((error) => error);
    })
  );

  // clearing checkboxes on clicking clear all button
  document.querySelectorAll("#clearEventFilter").forEach((el) =>
    el.addEventListener("click", function () {
      let clist = document.querySelectorAll("input[type=checkbox]");
      for (const element of clist) {
        element.checked = false;
      }
      document.querySelector("#eventFilter").click();
      document.getElementById("eventFilter").disabled = true;
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
        document.getElementById("eventFilter").disabled = false;
      } else {
        document.getElementById("eventFilter").disabled = true;
      }
    });
  });
});
