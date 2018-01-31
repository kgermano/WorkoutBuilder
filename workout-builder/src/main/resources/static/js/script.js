
$(document).ready(function(){
    $("#submit").click(function(){
        doSearch();
});});


function doSearch(){
    var workout = $('#exercises :selected').val();
    console.log(workout);
  $.ajax({

    headers: {
          Accept : "text/html",

          },

    url: "https://wger.de/api/v2/exercise/?language=2&status=2&muscles=" + workout,

    type: 'GET',

    contentType: "application/json",

    success: function(result) {

        console.log(result);
        $("#results").html(result);

      },

    error: function(e) {
       alert("something went wrong" + e);
      },

    });



}

