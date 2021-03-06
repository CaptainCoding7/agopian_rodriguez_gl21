
if(localStorage.getItem('userID')!=null){
	let userID = JSON.parse(localStorage.getItem('userID'));
	console.log(userID+" is logged.")
	document.getElementById("logSpace").innerHTML = "<a href='myspace.html'>My Space</a>";
	document.getElementById("signLogout").innerHTML = "<a href='home.html' onclick='logOut()'>Log out</a>";

}
else{
	
	let userInfo = JSON.parse(localStorage.getItem('userID'));		

 	document.getElementById("logSpace").innerHTML = "<a href='Log-in.html'>Log in</a>";
	document.getElementById("signLogout").innerHTML = "<a href='Sign-in.html'>Sign in</a>";
	console.log("No logged user");

}

function logOut(){
	
	console.log("logout");
	localStorage.removeItem('userID');    
	localStorage.removeItem('isApilot');    
	document.location.href = "home.html";                                                                                                                                                            

}
	
	
function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function postServerData(url, data, success){

    $.ajax({
		type: 'POST',	
        url: url,
		data: data,
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}

function putServerData(url, data, success){

    $.ajax({
		type: 'PUT',	
        url: url, 
		data: data,
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}

function deleteServerData(url, success){

    $.ajax({
		type: 'DELETE',	
        url: url, 
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}

function callDone(result){
	
	var templateExample = _.template($('#flightsToDisplay').html());
	
	for (let i = 0; i < result.length; i++) {
		let id = templateExample({
			"attribute":JSON.stringify(result[i].flightID)
		});
		
	
		let departure = templateExample({
			"attribute":JSON.stringify(result[i].departureAirdrome)
		});
		
		let arrival = templateExample({
			"attribute":JSON.stringify(result[i].destinationAirdrome)
		});
		
		let price = templateExample({
			"attribute":JSON.stringify(result[i].pricePerPassenger)
		});
		
		let seats = templateExample({
			"attribute":JSON.stringify(result[i].availableSeats)
		});
		
		let title = templateExample({
			"attribute":JSON.stringify(result[i].flightTitle)
		});
		
		let img = templateExample({
			"attribute":JSON.stringify(result[i].flightImg)
		});
		
		let pilot = templateExample({
			"attribute":JSON.stringify(result[i].pilotID)
		});

		let tmp = document.createElement("p");//tempary element
		
		

		// Display the element in the page
		let newFlight = document.createElement("li"); //creation of the element to insert in the list
		newFlight.className = "display"
		tmp.innerHTML = id;
		newFlight.id = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "");
		newFlight.onclick = function(){
			localStorage.setItem('pilotID',JSON.stringify(result[i].pilotID));			
			localStorage.setItem('FlightID',this.id);
			console.log("This.id : " + this.id , "localStorage : " + localStorage.getItem('FlightID'));
			document.location.href = "ViewFlight.html";
		}
		
		let imgDisplay = document.createElement("img");
		imgDisplay.className = "img-journey";
		tmp.innerHTML = img;
		console.log("test");
		console.log(tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, ""));
		imgDisplay.src = tmp.textContent.replace(/[^a-zA-Z0-9.\/]/g, "") ;
		imgDisplay.alt = "Image Of the Travel";
		newFlight.appendChild(imgDisplay);
		
		let displayPrice = document.createElement("p"); // display the price of the flight
		displayPrice.innerHTML = price + " &euro; per passenger";
		displayPrice.innerHTML = displayPrice.textContent;
		newFlight.appendChild(displayPrice);//insertion in the tag
		
		let titleDisplay = document.createElement("h1");
		titleDisplay.innerHTML = title;
		titleDisplay.innerHTML = titleDisplay.textContent;
		newFlight.appendChild(titleDisplay);//insertion in the tag
		
		let journey = document.createElement("p");
		tmp.innerHTML = "Departure : " + departure
		journey.innerHTML = tmp.textContent + "<br>";
		tmp.innerHTML = "Arrival : " + arrival;
		journey.innerHTML += tmp.textContent;
		newFlight.appendChild(journey);//insertion in the tag
		
		let seatDisplay = document.createElement("p");
		seatDisplay.innerHTML = "Nb of places : " + seats;
		seatDisplay.innerHTML = seatDisplay.textContent;
		newFlight.appendChild(seatDisplay);//insertion in the tag

		document.querySelector("#list-result").appendChild(newFlight);//insert the new flight in the list		
	}
	document.querySelector("#results").style.display = 	"grid";
	
}


$(function(){
	function viewFlight(event){

		let searchBar = document.querySelector("#departure");
		let destination;
		if($("#departure").val() == "")
		{
			searchBar.style.border = "2px solid red"; 
			return false;
		}

		if($("#destination").val() == "")
		{
			destination="All";
		}
		else{
			destination=$("#destination").val();
		}

		searchBar.style.border = "initial";
		let results = document.querySelector("#list-result");
		results.innerHTML = "";

		console.log(destination);

		var data = {
			departure : $("#departure").val(),
			plane : $("#plane").val(),
			price : $("#price").val(),
			destination : destination,
			seats : parseInt($("#nbOfSeats").val()),
			depDate : $("#date").val()
		}
			
		var dataJson = JSON.stringify(data);
		
		postServerData("ws/flight/flightsList",dataJson,callDone);
	}

	// Display the results of the research
	$("#butFlightsList").click(viewFlight);

	$("#SearchFlightBar").keydown(function(event){
		if(event.key == "Enter")
		{
			viewFlight();
			return false;
		}
	});
	
	
});

	/*///////////////////////////////////////////////////////

	$("#butFlightInfo").click(function(){
		getServerData("ws/flight/flightInfo/2",callDone);
	});

	$("#butAddFlight").click(function(){
		var data = {
	        id: 1
	    };
		putServerData("ws/flight/addflight",JSON.stringify(data),callDone);
	});

	$("#butDeleteFlight").click(function(){

		deleteServerData("ws/flight/deleteflight/1",callDone);
	});
*/




////////////////////////////////////////  PASSENGER  /////////////////


		/*

*/

	$("#butInfoUser").click(function(){				

		getServerData("ws/user/getuserinfo/11",callDone);

	});

