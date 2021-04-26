var page = document.querySelector("#banner"); // object that we go to modify

console.log(localStorage.getItem('FlightID'));// log to know the id of the flight selected

let str = "ws/flight/flightInfo/" + localStorage.getItem('FlightID'); // the path to get information about the flight

function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function callDone(result){
	//using _.
	var templateExample = _.template($('#flightsToDisplay').html());
	
    //getting all information 
    let departure = templateExample({
        "attribute":JSON.stringify(result.departureAirport)
    });
    
    let arrival = templateExample({
        "attribute":JSON.stringify(result.destination)
    });
    
    let price = templateExample({
        "attribute":JSON.stringify(result.pricePerPassenger)
    });
    
    let seats = templateExample({
        "attribute":JSON.stringify(result.availableSeats)
    });
    
    let title = templateExample({
        "attribute":JSON.stringify(result.flightTitle)
    });
    
    let img = templateExample({
        "attribute":JSON.stringify(result.flightImg)
    });

    let aircraft = templateExample({
        "attribute":JSON.stringify(result.aircraft)
    });

    let typeOfFlight = templateExample({
        "attribute":JSON.stringify(result.typeOfFlight)
    });

    let duration = templateExample({
        "attribute":JSON.stringify(result.duration)
    });

    let departureDate = templateExample({
        "attribute":JSON.stringify(result.departureDate)
    });

    let arrivalDate = templateExample({
        "attribute":JSON.stringify(result.arrivalDate)
    });

    let flightDescription = templateExample({
        "attribute":JSON.stringify(result.flightDescription)
    });

    let tmp = document.createElement("p");//tempary element to set correctly information		
}

// getServerData(str,callDone);