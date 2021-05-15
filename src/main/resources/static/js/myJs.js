$(document).ready(function(){
    var menuSelected = 0;
    var NumberOfItemsShower = $(".listcart");
    var listOfSelectedMenu = new Array(); 
    //Menu object to store menu details for the carts
    function Menu(Name,Price,Location){
        this.Name = Name;
        this.Price = Price;
        this.Location = Location;
    }
    //on the click of addcart button this code below will run
    $(".addCartBtn").click(function(){
        menuSelected++;

        var backgroundImageLocation = $(this).parent().parent().attr("data-setbg");
        var menuName = $(this).parent().children(".menuName").text();
        var menuPrice = $(this).parent().children(".menuPrice").text();
         
        var menuDetails =  new Menu(menuName,menuPrice,backgroundImageLocation);

        NumberOfItemsShower.text(menuSelected);
        listOfSelectedMenu.push(menuDetails);

        

        console.log(menuDetails.Location + menuDetails.Name+" "+menuDetails.Price);
 });



    
    
    
});