const carousel = document.querySelector('.carousel');
const slides = carousel.querySelector('.slides');

let slideWidth = 0;
let slideIndex = 0;

function startCarousel() {
  slideWidth = carousel.offsetWidth;
  setInterval(nextSlide, 3000); // Change slide every 3 seconds
}

function nextSlide() {
  slideIndex = (slideIndex + 1) % slides.children.length;
  slides.style.transform = `translateX(-${slideWidth * slideIndex}px)`;
}

window.addEventListener('load', startCarousel);


