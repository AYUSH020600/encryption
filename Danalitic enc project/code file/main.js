const selected = document.querySelector(".selected");
const optionsContainer = document.querySelector(".optionscontainer");

const optionsList = document.querySelectorAll(".option");

selected.addEventListener("click", () => { optionsContainer.classList.toggle("active");
});

