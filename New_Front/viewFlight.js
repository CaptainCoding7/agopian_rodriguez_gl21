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
    //for the img
	tmp.innerHTML = img;
    let Display = document.getElementById("Flight-Picture");
    Display.src = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");

    //for the title
	tmp.innerHTML = title;
    Display = document.getElementById("title");
    Display.textContent = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");

    //for the type of flight
    tmp.innerHTML = typeOfFlight;
    Display = document.getElementById("typeOfFlight");
    Display.textContent = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");

    // for the number of seat
    tmp.innerHTML = seat;
    Display = document.getElementById("numberOfSeat");
    Display.textContent = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");

    // for the duration
    tmp.innerHTML = duration;
    Display = document.getElementById("Duration");
    Display.textContent = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");

    // for the Departure Date
    tmp.innerHTML = departureDate;
    Display = document.getElementById("Departure_Date");
    Display.textContent = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");

    // for the Departure Place
    tmp.innerHTML = departurePlace;
    Display = document.getElementById("Departure_Place");
    Display.textContent = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");

    // for the Arrival Place
    tmp.innerHTML = arrival;
    Display = document.getElementById("Arrival_Place");
    Display.textContent = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");

    // for the Description
    tmp.innerHTML = flightDescription;
    Display = document.getElementById("Description");
    Display.textContent = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");

    // for the Aircraft Information
    tmp.innerHTML = aircraft;
    Display = document.getElementById("Aircraft_Info");
    Display.textContent = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");

    // for the Pilot Information
    tmp.innerHTML = pilot;
    Display = document.getElementById("Pilot_Info");
    Display.textContent = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");

}

getServerData(str,callDone);