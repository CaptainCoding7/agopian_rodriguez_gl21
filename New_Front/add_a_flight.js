function putServerData(url, data, success){

    $.ajax({
		type: 'PUT',	
        url: url, 
		data: data,
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}


function callDone(result){
	
		
}
		

var newFlight;

$(document).ready(function() {
	
	
	$("#butAddFlight").click(function(event) {
		
    event.preventDefault()

		console.log("create flight");
    let userID = JSON.parse(localStorage.getItem('userID'));

    // saving the image in file system server
    let photo = document.getElementById("image-file").files[0];
    alert(photo);
    const dateNow = Date.now().toString();

    //fetch("images/flightPhoto"+dateNow, {method: "POST", body: formData});
    fetch('images', { // Your POST endpoint
      method: 'POST',
      headers: {
        // Content-Type may need to be completely **omitted**
        // or you may need something
        "Content-Type": "You will perhaps need to define a content-type here"
      },
      body: photo // This is your file object
    }).then(
      response => response.json() // if the response is a JSON object
    ).then(
      success => alert(success) // Handle the success response object
    ).catch(
      error => alert(error) // Handle the error response object
    );

    console.log(dateNow);


		newFlight = {
			flightTitle : $("#flightTitle").val(),
			flightDescription : $("#flightDescr").val(),
			departureAirdrome : $("#depAirdrome").val(),
			destinationAirdrome : $("#destAirdrome").val(),
      departureDate : $("#depDate").val(),
      arrivalDate : $("#arrDate").val(),
			pricePerPassenger : $("#price").val(),
			aircraftModel :  $("#aircraftModel").val(),
      typeOfFlight : $("#typeOfFlight").val(),
      availableSeats : $("#seatNumber").val(),
      flightImg : "images/flightPhoto"+dateNow,
      pilotID : userID
		};
    
		putServerData("ws/pilot/addflight",JSON.stringify(newFlight),callDone);
		//putServerData("ws/pilot/addflight/1",JSON.stringify(newFlight),callDone);
		
	});
});




/********************************************************************************************* */


function processData(allText) {
    var record_num = 5;  // or however many elements there are in each row
    var allTextLines = allText.split(/\r\n|\n/);
    var entries = allTextLines[0].split(',');
    var lines = [];

    var headings = entries.splice(0,record_num);
    while (entries.length>0) {
        var tarr = [];
        for (var j=0; j<record_num; j++) {
            tarr.push(headings[j]+":"+entries.shift());
        }
        lines.push(tarr);
    }
    // alert(lines);
}






