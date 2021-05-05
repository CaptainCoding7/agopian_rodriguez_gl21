console.log(localStorage.getItem('FlightID'));// log to know the id of the flight selected
console.log(localStorage.getItem('pilotID'));// log to know the id of the flight selected

var user;
var pilotInfos;

let str = "ws/flight/flightInfo/" + localStorage.getItem('FlightID'); // the path to get information about the flight



function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function userCalldone(result){
	
	var templateExample = _.template($('#flightInfos').html());
	let userDisplay = templateExample({
        "attribute":JSON.stringify(result)
    });
	console.log(userDisplay);
	let tmp = document.createElement("p");//tempary element to set correctly information
    //for the img
	tmp.innerHTML = userDisplay;
    let Display = document.getElementById("Pilot_Info");
    Display.innerHTML = tmp.textContent.replace(/[ "']+/g, "");

}

function pilotInfosCalldone(result){
	
    pilotInfos = JSON.stringify(result);
	console.log(pilotInfos);
}




function callDone(result){
	//using _.
	var templateExample = _.template($('#flightInfos').html());
	
    //getting all information 
    let departure = templateExample({
        "attribute":JSON.stringify(result.departureAirdrome)
    });

	let pilot = templateExample({
        "attribute":JSON.stringify(result.pilotID)
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
    Display.src = tmp.textContent.replace(/[ "']+/g, "");

    //for the title
	tmp.innerHTML = title;
    Display = document.getElementById("title");
    Display.textContent = tmp.textContent.replace(/[ "']+/g, "");

    //for the type of flight
    tmp.innerHTML = typeOfFlight;
    Display = document.getElementById("typeOfFlight");
    Display.textContent = tmp.textContent.replace(/[ "']+/g, "");

    // for the number of seat
    tmp.innerHTML = seats;
    Display = document.getElementById("numberOfSeat");
    Display.textContent = tmp.textContent.replace(/[ "']+/g, "");

    // for the duration
    tmp.innerHTML = duration;
    Display = document.getElementById("Duration");
    Display.textContent = tmp.textContent.replace(/[ "']+/g, "");

    // for the Departure Date
    tmp.innerHTML = departureDate;
    Display = document.getElementById("Departure_Date");
    Display.textContent = tmp.textContent.replace(/[ "']+/g, "");

    // for the Departure Place
    tmp.innerHTML = departure;
    Display = document.getElementById("Departure_Place");
    Display.textContent = tmp.textContent.replace(/[ "']+/g, "");

    // for the Arrival Place
    tmp.innerHTML = arrival;
    Display = document.getElementById("Arrival_Place");
    Display.textContent = tmp.textContent.replace(/[ "']+/g, "");

    // for the Description
    tmp.innerHTML = flightDescription;
    Display = document.getElementById("Description");
    Display.textContent = tmp.textContent.replace(/[ "']+/g, "");

    // for the Aircraft Information
    tmp.innerHTML = aircraft;
    Display = document.getElementById("Aircraft_Info");
    Display.textContent = tmp.textContent.replace(/[ "']+/g, "");

    // for the Pilot Information
    tmp.innerHTML = pilot;
    Display = document.getElementById("Pilot_Info");

	
	tmp.innerHTML = price;
	Display = document.getElementById("price");
	Display.textContent = tmp.textContent.replace(/[ "']+/g, "");

}

$(document).ready(function() {

	var pilotID=localStorage.getItem('pilotID')
	let path = "ws/user/getuserinfo/"+ pilotID ;
	getServerData(path,userCalldone);
	console.log(user);
	
	path = "ws/pilot/pilotInfos/1";//+pilotID;
	getServerData(path,pilotInfosCalldone);
	
	getServerData(str,callDone);
});


