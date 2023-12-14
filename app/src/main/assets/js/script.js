function setImageResourceId(imageName) {
    let card = document.querySelector(".card");
    console.log("Image: " + imageName);
    card.src = 'file:///android_res/drawable/' + imageName + '.png';
}

function openSortedCardsPage() {
    window.location.href = "file:///android_asset/lista.html";
}

function displaySortedCards() {
    var sortedCardResourceIdsJson = Android.getAllSortedCards();

    var sortedCardResourceIds = JSON.parse(sortedCardResourceIdsJson);

    var navElement = document.getElementById("sortedCardsNav");

    navElement.innerHTML = "";

    var list = document.createElement("ul");

    for (var i = 0; i < sortedCardResourceIds.length; i++) {
        var cardResourceId = sortedCardResourceIds[i];

        var listItem = document.createElement("li");

        var cardImg = document.createElement("img");

        cardImg.src = 'file:///android_res/drawable/' + cardResourceId + '.png';

        cardImg.className = "sorted-card";

        listItem.appendChild(cardImg);

        list.appendChild(listItem);
    }

    navElement.appendChild(list);
}
displaySortedCards();