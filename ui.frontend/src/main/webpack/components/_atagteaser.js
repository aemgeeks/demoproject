const aTagAdder = document.querySelectorAll(".a-tag-teaser .cmp-teaser")
aTagAdder.forEach(c => {
    const buttonClick = c.querySelector(".download-clicks")
    if(buttonClick) {
      let cloneButton = buttonClick.cloneNode(true)
      cloneButton.className = "extra"
      cloneButton.innerHTML = ""
      c.parentElement.insertAdjacentElement("afterbegin", cloneButton)
      cloneButton.insertAdjacentElement("afterbegin", c)
    }
  })