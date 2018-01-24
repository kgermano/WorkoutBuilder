$(document).ready(function() {
  $('#exercise').click(function() {

    $.ajax({
      url: `https://wger.de/api/v2/exercise/?language=2&status=2&muscles=6`,
      type: 'GET',
      data: {
        format: 'json'
      },
      success: function(response) {
        $('.showExercise').text(`${response.main.exercise}%`);

      },
      error: function() {
        $('#errors').text("There was an error processing your request. Please try again.")
      }
    });
  });
});