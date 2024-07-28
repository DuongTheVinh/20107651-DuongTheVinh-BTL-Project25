let scrollAmount = 0;

function scrollCarousel(direction) {
    const carousel = document.querySelector('.carousel');
    const carouselWidth = carousel.scrollWidth - carousel.clientWidth;
    if (direction === 1 && scrollAmount < carouselWidth) {
        scrollAmount += 200; // Adjust scroll amount based on your design
    } else if (direction === -1 && scrollAmount > 0) {
        scrollAmount -= 200;
    }
    carousel.style.transform = `translateX(-${scrollAmount}px)`;
}
