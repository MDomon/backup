$(function(){
    /* 
    $("h1").click(function(){
        $("p").fadeOut();
    });
    
    $("div").click(function(){
        $(".hosi").css("color","blue");
    });
    
    
    $(".boxA").click(function(){
        $(".boxB").hide();
    });
    
    
    $(".BOX").hover(
        function(){
            $(".boxA").fadeIn();
        },
        function(){
            $(".boxA").fadeOut();
        }
    );
    
    
    
    if($("p").css("color","black")){
       
        $("p").click(function(){
        $(this).css("color","red");
        });
       
   } 
    
    
    if($("p").css("color","red")){
       
        $("p").click(function(){
        $(this).css("color","black");
        });
       
   }
   */
    
    /*
    $("p").toggle(
        function(){
            $(this).css("color","red");
        },
        function(){
            $(this).css("color","black");
        }
    )
    */
    
    
    //スイッチONOFF
    var color = "black";
    
    $("p").click(function(){
        if(color == "black"){
            color = "red";
            $(this).css("color","red");
        }else if(color == "red"){
            color = "black";
            $(this).css("color","black");
        }
    });
    
    
    
/*
    var color = "black";
    
    $("p").click(function() {
    switch (color) {
      case "black":
         color = "red";
         $(this).css("color","red");
         break;
      case "red":
         color = "black";
         $(this).css("color","black");
         break;
        }
    });
 */
}); 