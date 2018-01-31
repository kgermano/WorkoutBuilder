
$(document).ready(function(){
$("#search").click(function(){

doSearch()

})})
function doSearch(){
var workout = $('#exercises :selected').val()

  $.ajax({

    url: "https://wger.de/api/v2/exercise/?language=2&status=2&muscles=" + workout,

    type: 'GET',

    data: {
            format: 'json'
          },


      contentType: "application/json",

      dataType: "json",
      data: {workout : "workout"},

      success: function(result) {

      console.log('Success', result);
      },

      error: function(e) {
       alert("something went wrong" + e);
      },

    });



}

function displayResults(result) {
 var showDiv = document.getElementById("resultsDiv");
}
