

$(document).ready(function(){
    $("#btn").click(function(){
        doSearch();
});});


function doSearch(){
    var workout = $('#description :selected').val();
    console.log(workout);
  $.ajax({

    headers: {
          Authorization: "Token qfcoeixhdrrkmyxu",
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
                                                                          },
*/

    url: "https://healthfinder.gov/Search.json?api_key=qfcoeixhdrrkmyxu&CategoryID=17",

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

