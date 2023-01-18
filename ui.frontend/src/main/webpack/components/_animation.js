let currentScreen = "desktop"
let baseURL = "/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/animation/Desktop/";
let desktopTag = "00-Main/Main_Desktop"
const imageDigitLength = 5
const initialImage = 0
const scenes = [47, 98, 208]
let sceneLoopAnimTag = ["01-Scene1/Scene01_Desktop", "02-Scene2/Scene02_Desktop"]
const sceneLoopCount = [49, 74]
const sceneImages = {}
const loopSceneImages = {}
const framesPerSecond = 100
const loopFramesPerSecond = 30

let animNum = 0
let animScene = -1
let loopAnimNum = 0
let loopAnimOn = false
let animForward = true
let animInProgress = false
let animInitial = true
let initTextTransform = false
const animHeight = window.innerHeight * (scenes.length)
const frameHeight = (window.innerHeight * (scenes.length)) / (scenes.length + 1)

function updateScreen() {
    if (window.innerWidth <= 800 && currentScreen != "mobile") {
        baseURL = baseURL.replace("Desktop", "Mobile")
        desktopTag = desktopTag.replace("Desktop", "Mobile")
        sceneLoopAnimTag = sceneLoopAnimTag.map(c => {
            c = c.replace("Desktop", "Mobile")
            return c
        })
        currentScreen = "mobile"
        loadSceneImages()
        if (animScene > -1) {
            animScene -= 1
            performAnimation()
        }
    } else if (window.innerWidth > 800 && currentScreen != "desktop") {
        baseURL = baseURL.replace("Mobile", "Desktop")
        desktopTag = desktopTag.replace("Mobile", "Desktop")
        sceneLoopAnimTag = sceneLoopAnimTag = sceneLoopAnimTag.map(c => {
            c = c.replace("Mobile", "Desktop")
            return c
        })
        currentScreen = "desktop"
        loadSceneImages()
        if (animScene > -1) {
            animScene -= 1
            performAnimation()
        }
    }
}

function fillZeroes(num) {
    let n = `${num}`
    while (n.length < imageDigitLength) {
        n = `0${n}`
    }
    return n
}

function loopAnimation() {
    var canvas = document.getElementById("myCanvas2")
    var context = canvas.getContext('2d')
    context.clearRect(0, 0, canvas.width, canvas.height);
    if (loopAnimOn && loopSceneImages[animScene] != undefined) {
        context.drawImage(loopSceneImages[animScene][loopAnimNum], 0, 0, canvas.width, canvas.height)
        loopAnimNum = loopAnimNum + 1
        if (loopAnimNum < loopSceneImages[animScene].length - 1) {
            setTimeout(() => {
                requestAnimationFrame(loopAnimation)
            }, 1000 / loopFramesPerSecond)
        } else {
            loopAnimNum = 0
            requestAnimationFrame(loopAnimation)
        }
    }
}

function runAnimation(runAnim) {
    runAnim = runAnim === false ? false : true
    animInProgress = true
    loopAnimOn = false
    var canvas = document.getElementById("myCanvas")
    var context = canvas.getContext('2d')
    if (sceneImages[animScene] && sceneImages[animScene][animNum])
        context.drawImage(sceneImages[animScene][animNum], 0, 0, canvas.width, canvas.height)
    else {
        animInProgress = false
        return
    }
    if (runAnim) {
        if (animForward) animNum = animNum + 1
        else animNum = animNum - 1
        if ((animForward && animNum < sceneImages[animScene].length - 1) || (!animForward && animNum > 0)) {
            setTimeout(() => {
                requestAnimationFrame(runAnimation)
            }, 1000 / framesPerSecond)
        } else {
            animInProgress = false
            if (!animForward && animScene > 0) {
                animScene -= 1
            } else if (!animForward && animScene == 0) {
                animInitial = true
                animScene -= 1
                return
            }
            loopAnimNum = 0
            loopAnimOn = true
            setTimeout(() => {
                loopAnimation()
            }, 500)
        }
    } else {
        animInProgress = false
    }
}

function loadSceneImages() {
    let lastScene = 0
    scenes.forEach((c, i) => {
        sceneImages[i] = []
        let y = 0
        for (let j = lastScene + 1; j <= c; j++) {
            sceneImages[i][y] = new Image()
            sceneImages[i][y].src = `${baseURL}${desktopTag}${fillZeroes(j)}.jpg`
            y += 1
            lastScene = j
        }
    })
    sceneLoopAnimTag.forEach((c, i) => {
        loopSceneImages[i] = []
        let y = 0
        lastScene = 0
        for (let j = lastScene; j <= sceneLoopCount[i]; j++) {
            loopSceneImages[i][y] = new Image()
            loopSceneImages[i][y].src = `${baseURL}${c}${fillZeroes(j)}.png`
            y += 1
            lastScene = j
        }
    })
}


function loadInitialImage() {
    var canvas = document.getElementById("myCanvas")
    var context = canvas.getContext('2d')
    context.clearRect(0, 0, canvas.width, canvas.height);
    sceneImages[0][0].onload = () => {
        context.drawImage(sceneImages[0][0], 0, 0, canvas.width, canvas.height)
    }
    context.drawImage(sceneImages[0][0], 0, 0, canvas.width, canvas.height)
    requestAnimationFrame(makeInitialContentActive)
}

function makeInitialContentActive(active) {
    if (active) {
        document.querySelector(".textContent1 div").classList.remove("inactive")
        document.querySelector(".textContent1 p").classList.remove("inactive")
        document.querySelector(".textContent1 div").classList.add("active")
        setTimeout(() => {
            document.querySelector(".textContent1 p").classList.add("active")
        }, 200)
    } else {
        setTimeout(() => {
            document.querySelector(".textContent1 div").classList.remove("active")
            document.querySelector(".textContent1 p").classList.remove("active")
            document.querySelector(".textContent1 div").classList.add("inactive")
            document.querySelector(".textContent1 p").classList.add("inactive")
        }, 300)
    }
}

function getScene(top) {
    let height = frameHeight
    top = Math.abs(top)
    if (top === 0) return -1
    else if (top > (height * scenes.length)) return scenes.length - 1
    else {
        for (let i in scenes) {
            if (top < (height * (parseInt(i) + 1))) return i
        }
    }
}

function resetTextAnimation() {
    const last = document.querySelector(".canvas_end").getBoundingClientRect()
    document.querySelectorAll('.dynContent').forEach((c, i) => {
        c.style.opacity = 0
        c.style.zIndex = 1
        setTimeout(() => {
            if (i == 2) {
                if (last < 0) c.style.transform = `translateY(15px)`
                else if (animScene < 2 && toAnimScene < 2) c.style.transform = `translateY(-30px)`

            } else {
                if (i < animScene) {
                    c.style.transform = `translateY(15px)`
                } else {
                    c.style.transform = `translateY(-30px)`
                }
            }
        }, 100)
    })
}

let progressPercent = 0
function textAnimation() {
    let el = document.querySelector(`.textContentWrap${parseInt(animScene) + 2}`)
    el.style.zIndex = 2
    if (el && animScene != -1) {
        if (progressPercent > 90) {
            el.style.opacity = 0
            el.style.transform = `translateY(15)`
        } else if (progressPercent > 80) {
            el.style.opacity = 0.25
            el.style.transform = `translateY(10)`
        } else if (progressPercent > 70) {
            el.style.opacity = 0.5
            el.style.transform = `translateY(5)`
        } else if (progressPercent > 60) {
            el.style.opacity = 1
            el.style.transform = `translateY(0)`
        } else if (progressPercent > 50) {
            el.style.opacity = 1
            el.style.transform = `translateY(-5px)`
        } else if (progressPercent > 40) {
            el.style.opacity = 1
            el.style.transform = `translateY(-8px)`
        } else if (progressPercent > 30) {
            el.style.opacity = 1
            el.style.transform = `translateY(-10px)`
        } else if (progressPercent > 20) {
            el.style.opacity = 1
            el.style.transform = `translateY(-15px)`
        } else if (progressPercent > 10) {
            el.style.opacity = 0.9
            el.style.transform = `translateY(-20px)`
        } else if (progressPercent > 0) {
            el.style.opacity = 0.8
            el.style.transform = `translateY(-25px)`
        } else {
            el.style.opacity = 0.5
            el.style.transform = `translateY(-30px)`
        }
    }
}

function parallax_animation() {
    const wrapper = document.querySelector('.canvas_wrapper')
    const wrapperTop = wrapper.getBoundingClientRect().top
    let totHeight = (Math.abs(wrapperTop) + window.innerHeight) - wrapper.getBoundingClientRect().height
    if (wrapper.getBoundingClientRect().height - 200 < (window.innerHeight + Math.abs(wrapperTop)) && totHeight < window.innerHeight + 200) {
        wrapper.querySelectorAll(".canvas").forEach(c => {
            c.style.position = "fixed"
            c.style.top = `-${(totHeight / 3)}px`
            c.style.bottom = "initial"
            const last = document.querySelector(".canvas_end").getBoundingClientRect()
            if (totHeight > window.innerHeight) c.style.opacity = 1
            else c.style.opacity = ((last.top - (window.innerHeight / 5)) / window.innerHeight)
        })
        requestAnimationFrame(parallax_animation)
    }
}

let progressActive = true
function wheelScroll(ev) {
    const wrapper = document.querySelector('.canvas_wrapper')
    const wrapperTop = wrapper.getBoundingClientRect().top
    const last = document.querySelector(".canvas_end").getBoundingClientRect()
    if (wrapper.getBoundingClientRect().height < (window.innerHeight + Math.abs(wrapperTop)) && last.top >= 50) {
        parallax_animation()
        resetTextAnimation()
    } else if (wrapperTop >= 0 || last.top < 0) {
        animCompleted = false
        wrapper.querySelectorAll(".canvas").forEach(c => {
            c.style.position = "relative"
            c.style.top = "0"
            c.style.bottom = "initial"
            c.style.opacity = last.top < 0 ? 0 : 1
        })
    } else {
        wrapper.querySelectorAll(".canvas").forEach(c => {
            c.style.position = "fixed"
            c.style.top = `0px`
            c.style.bottom = "initial"
            c.style.opacity = 1
        })
        if (wrapperTop == 0) {

        } else {
            document.querySelector(".progress_wrap").classList.add("progress_wrap_show")
            if (!progressActive) progressAnim()
            else progressActive = true
        }
    }

}

let toAnimScene = -1
let progressAnimScene = 1
let progressCurrentPercent = 0

function progressAnim() {
    const wrapper = document.querySelector('.canvas_wrapper')
    const wrapperTop = wrapper.getBoundingClientRect().top
    const last = document.querySelector(".canvas_end").getBoundingClientRect()
    let animscene = getScene(wrapperTop)
    let stopAnim = false
    if (animscene == -1) progressPercent = 0
    else {
        let h = frameHeight
        let v = h * (parseInt(animscene))
        let calc = Math.round(((Math.abs(wrapperTop) - v) / h) * 100).toFixed(0)
        if ((progressPercent > 90 && calc == 0) && (progressAnimScene == toAnimScene))
            progressPercent = 99
        else progressPercent = calc
    }
    if (toAnimScene > progressAnimScene) {
        if (progressCurrentPercent == 100) {
            progressCurrentPercent = 0
            progressAnimScene = toAnimScene == -1 ? -1 : parseInt(toAnimScene)
            stopAnim = true
        } else {
            progressCurrentPercent = 100
        }
    } else if (toAnimScene < progressAnimScene) {
        if (progressCurrentPercent == 0) {
            progressCurrentPercent = 100
            progressAnimScene = toAnimScene == -1 ? -1 : parseInt(toAnimScene)
            stopAnim = true
        } else {
            progressCurrentPercent = 0
        }
    } else if (progressCurrentPercent != progressPercent) {
        progressCurrentPercent = progressPercent
    }
    if (progressAnimScene != -1)
        progressBar(progressCurrentPercent, 100, progressAnimScene == -1 ? 1 : (progressAnimScene + 1), stopAnim)
    if (wrapperTop < 0 && last.top > (window.innerHeight / 2)) {
        setTimeout(() => {
            progressAnim()
        }, 200)
    } else {
        progressActive = false
        progressAnimScene = 1
        progressCurrentPercent = 0
    }
    if (wrapperTop >= 0 || last.top < (window.innerHeight - (window.innerHeight / 4))) {
        document.querySelector(".progress_wrap").classList.remove("progress_wrap_show")
        progressAnimScene = wrapperTop >= 0 ? 0 : scenes.length - 1
        progressCurrentPercent = wrapperTop >= 0 ? 0 : 100
    } else {
        document.querySelector(".progress_wrap").classList.add("progress_wrap_show")
    }
    let c = (document.body.getBoundingClientRect().height / window.innerHeight)
    document.querySelector(".progress_wrap").style.top = `${((window.scrollY + (c * 25)) / c)}px`
}

function performAnimation() {
    let c = animScene
    if (toAnimScene < c || (toAnimScene == c && c == -1)) {
        if (!animForward && animInProgress) return requestAnimationFrame(performAnimation)
        resetTextAnimation()
        animForward = false
        if (animScene == -1 && c == -1) {
            return loadInitialImage()
        } else {
            if (!animInProgress)
                animNum = sceneImages[c].length - 1
            runAnimation()
        }
    } else if (toAnimScene > c) {
        if (animForward && animInProgress) return requestAnimationFrame(performAnimation)
        resetTextAnimation()
        animForward = true
        c = c + 1
        if (animScene == -1 && c == 0) {
            animScene = c
            if (!animInProgress)
                animNum = 0
            makeInitialContentActive(false)
            runAnimation()
        } else {
            animScene = c
            if (!animInProgress)
                animNum = 0
            runAnimation()
        }
    } else {
        wheelScroll(undefined)
        return
    }
    requestAnimationFrame(performAnimation)
}

function calcAnimation() {
    const wrapper = document.querySelector(".canvas_wrapper")
    const wrapperTop = wrapper.getBoundingClientRect().top
    const last_canvas = document.querySelector(".canvas_end").getBoundingClientRect()
    if (wrapperTop > 0) toAnimScene = -1
    else toAnimScene = getScene(wrapperTop)
    if (wrapperTop == 0) wheelScroll(undefined)
    if (toAnimScene != animScene) {
        performAnimation()
    } else if (toAnimScene == animScene && !animInProgress) {
        if (!initTextTransform) {
            initTextTransform = true
            resetTextAnimation()
        }
        if (Math.abs(wrapperTop) < (frameHeight * scenes.length)) textAnimation()
    }
    if (wrapperTop < (window.innerHeight / 2) && last_canvas.top > (window.innerHeight + 10)) {
        document.querySelector('.go_down').style.opacity = 1
    } else {
        document.querySelector('.go_down').style.opacity = 0
    }
}

function setFrame() {
    const windowHeight = window.innerHeight
    const wrapper = document.querySelector('.canvas_wrapper')
    wrapper.style.height = `${animHeight}px`
    wrapper.querySelectorAll("canvas").forEach(c => {
        c.style.height = `${windowHeight}px`
    })
}

function progressBar(progressVal, totalPercentageVal = 100, scene, stopAnim = false) {
    var strokeVal = (1.6 * 100) / totalPercentageVal
    var x = document.querySelector('.progress-circle-prog')
    if (stopAnim) {
        x.style.transition = "stroke-dasharray 0s linear 0s"
    } else {
        x.style.transition = "stroke-dasharray 0.2s linear 0s"
    }
    x.style.strokeDasharray = progressVal * (strokeVal) + ' 999'
    var el = document.querySelector('.progress-text')
    var from = document.querySelector('.progress-text').getAttribute('data-progress')
    document.querySelector('.progress-text').setAttribute('data-progress', scene)
    var start = new Date().getTime()

    setTimeout(function () {
        var now = (new Date().getTime()) - start
        var progress = now / 700
        el.innerHTML = `${scene}`
        if (progress < 1) setTimeout(arguments.callee, 10)
    }, 10)

}

function go_down_action() {
    const rect = document.querySelector(".go_down_button_text")
    rect.classList.add("animate")
    setTimeout(() => {
        rect.classList.remove("animate")
    }, 600)
    let scrollTo = window.scrollY + document.querySelector(".canvas_wrapper").getBoundingClientRect().top + ((frameHeight * (parseInt(toAnimScene) + 1)) + (frameHeight / 2))
    if(toAnimScene == 2) {
        scrollTo = window.scrollY + document.querySelector(".canvas_end").getBoundingClientRect().top
    }
    window.scrollTo({
        top: scrollTo,
        behavior: 'smooth',
    })
}

if (document.querySelector(".canvas_wrapper") != undefined) {
    updateScreen()
    loadSceneImages()
    setInterval(calcAnimation, 200)
    window.onresize = () => {
        updateScreen()
        setFrame()
    }

    progressBar(10, 200, 1, false);
    loadInitialImage()
    setFrame()
    document.body.addEventListener("wheel", wheelScroll)
    document.body.addEventListener("touchmove", wheelScroll)
    wheelScroll(undefined)
    progressAnim()

    document.querySelector('.go_down').addEventListener("mouseenter", () => {
        setTimeout(() => {
            document.querySelector(".go_down_button_text").classList.add("animate")
        }, 200)
        setTimeout(() => {
            document.querySelector(".go_down_button_text").classList.remove("animate")
        }, 700)
    })
    document.querySelector('.go_down').addEventListener("click", go_down_action)
}