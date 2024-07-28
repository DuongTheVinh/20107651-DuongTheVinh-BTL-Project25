document.addEventListener('DOMContentLoaded', function () {
    // Tăng giảm số lượng
    document.querySelectorAll('.quantity button').forEach(button => {
        button.addEventListener('click', function () {
            var productId = this.parentElement.querySelector('input').getAttribute('data-product-id');
            var quantityInput = this.parentElement.querySelector('input');
            var quantity = parseInt(quantityInput.value);
            var delta = this.classList.contains('increment') ? 1 : -1;
            var newQuantity = Math.max(1, quantity + delta);

            quantityInput.value = newQuantity;

            updateCart(productId, newQuantity);
        });
    });

    // Xóa sản phẩm
    document.querySelectorAll('.remove-item').forEach(button => {
        button.addEventListener('click', function() {
            var productId = this.getAttribute('data-product-id');
            removeFromCart(productId);
        });
    });
});

function updateCart(productId, quantity) {
    fetch('/update-cart', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: `productId=${productId}&quantity=${quantity}`
    })
    .then(response => response.text())
    .then(totalAmount => {
        document.querySelector('.total-amount').innerText = totalAmount + ' đ';
    })
    .catch(error => console.error('Error:', error));
}

function removeFromCart(productId) {
    fetch('/remove-from-cart', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: `productId=${productId}`
    })
    .then(response => response.text())
    .then(totalAmount => {
        document.getElementById(`item-${productId}`).remove();
        document.querySelector('.total-amount').innerText = totalAmount + ' đ';
    })
    .catch(error => console.error('Error:', error));
}
