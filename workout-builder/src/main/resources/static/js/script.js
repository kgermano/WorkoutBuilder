
$(document).ready(function(){
    $("#submit").click(function(){
        doSearch();
});});


function doSearch(){
    var workout = $('#exercises :selected').val();
    console.log(workout);
  $.ajax({

    headers: {
          Authorization: "Token aab0e79768a9c56e77f299314621f66d847987e1",
          Accept : "application/json",

          },

        /*  description: {
                                 "type": "string",
                                 "required": true,
                                 "read_only": false,
                                 "label": "Description"
                                                                          },
                    name: {
                                 "type": "string",
                                 "required": true,
                                 "read_only": false,
                                 "label": "Name",
                                 "max_length": 200
                                                                          }, */


    url: "https://wger.de/api/v2/exercise/?language=2&status=2&muscles=" + workout,

    type: 'GET',

    contentType: "application/json",

    success: function(result) {
        var json = "<h4>Your Workout</h4><pre>"
                            + JSON.stringify(result) + "</pre>";

                        $('#results').html(json);


      },

    error: function(e) {
       alert("something went wrong" + e);
      },

    });



}

