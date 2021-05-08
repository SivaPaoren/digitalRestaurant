$(document).ready(function(){
    var menuSelected = 0;
    var NumberOfItemsShower = $(".listcart");

    $(".addCartBtn").click(function(){
        menuSelected++;
        NumberOfItemsShower.text(menuSelected);
        //console.log($(this).attr('name'));
    });
});