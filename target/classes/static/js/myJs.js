$(document).ready(function(){
    var menuSelected = 0;
    var NumberOfItemsShower = $(".listcart");
    var listOfSelectedMenu = new Array(); 

    $(".addCartBtn").click(function(){
        menuSelected++;

        var backgroundImageLocation = $(this).parent().parent().attr("data-setbg");
        var menuName = $(this).parent().children(".menuName").text();
        var menuPrice = $(this).parent().children(".menuPrice").text();
         
        
        NumberOfItemsShower.text(menuSelected);
        var menuName = $(this).attr('name');
        listOfSelectedMenu.push(menuName);
        console.log(backgroundImageLocation +" "+menuName+" "+menuPrice);
     });
    
    
});