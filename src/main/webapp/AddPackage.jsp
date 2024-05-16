<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Package</title>

<style>
	body {
	    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	    margin: 0;
	    padding: 0;
	    background-color: #f8f8f8;
	}
	
	div{
		padding: 10px;
	}
	
	.btn{
            display: inline-block;
            margin-top: 1rem;
            background: #ffa500;;
            color: #fff;
            padding: .8rem 3rem;
            border: .2rem solid #ffa500;;
            cursor: pointer;
            font-size: 1.7rem;
        }
        
	
	header {
	    background-color: #333;
	    color: #fff;
	    padding: 20px;
	    text-align: center;
	}
	
	form {
	    max-width: 500px;
	    margin: 20px auto;
	    padding: 30px;
	    border: 1px solid #ddd;
	    border-radius: 10px;
	    background-color: #fff;
	    box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
	}
	
	section {
	    margin-bottom: 30px;
	}
	
	label {
	    display: block;
	    margin-bottom: 10px;
	    color: #666;
	    font-weight: bold;
	}
	
	input[type="text"],
	input[type="number"],
	select {
	    width: calc(100% - 22px);
	    padding: 12px;
	    margin-top: 5px;
	    border: 1px solid #ccc;
	    border-radius: 6px;
	    box-sizing: border-box;
	    font-size: 16px;
	    background-color: #f9f9f9;
	}
	
	select {
	    width: 100%;
	}
	
	button {
	    background-color: #4CAF50;
	    color: white;
	    padding: 14px 24px;
	    border: none;
	    border-radius: 6px;
	    cursor: pointer;
	    font-size: 16px;
	    transition: background-color 0.3s ease;
	}
	
	button:hover {
	    background-color: #45a049;
	}
	
	.room-type {
	    display: flex;
	    flex-wrap: wrap;
	}
	
	.room-type input[type="checkbox"] {
	    display: none;
	}
	
	.room-type label {
	    display: inline-block;
	    margin-right: 20px;
	    margin-bottom: 10px;
	    padding: 10px 20px;
	    font-size: 16px;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    cursor: pointer;
	    transition: background-color 0.3s ease;
	}
	
	.room-type label:hover {
	    background-color: #f0f0f0;
	}
	
	.room-type input[type="checkbox"]:checked + label {
	    background-color: #4CAF50;
	    color: white;
	    border-color: #4CAF50;
	}

		


		
</style>

</head>

<body>
    <header>
        <h1>Add Tour Package</h1>
    </header>

    <form id="addPackageForm" action="AddPackage" method=post>
        <!-- Location Section -->
        <section>
            <h2>Location</h2>
            <div>
                <label for="fromLocation">From:</label>
                <input type="text" id="fromLocation" name="fromLocation" required>
            </div>
            <div>
                <label for="toLocation">To:</label>
                <input type="text" id="toLocation" name="toLocation" required>
            </div>
        </section>

        <!-- Stay Section -->
        <section>
            <h2>Stay</h2>
            <div>
                <label for="hotelName">Hotel Name:</label>
                <input type="text" id="hotelName" name="hotelName" required>
            </div>
            <div>
                <label for="hotelLocation">Hotel Location:</label>
                <input type="text" id="hotelLocation" name="hotelLocation" required>
            </div>
            <div>
                <label for="nearbyLandmark">Nearby Landmark:</label>
                <input type="text" id="nearbyLandmark" name="nearbyLandmark">
            </div>
            <div>
                <section>
				    <h2>Type of Rooms</h2>
				    <div class="room-type">
				        <input type="checkbox" id="singleRoom" name="roomType" value="Single">
				        <label for="singleRoom">Single</label>
				
				        <input type="checkbox" id="doubleBedRoom" name="roomType" value="Double Bed">
				        <label for="doubleBedRoom">Double Bed</label>
				
				        <input type="checkbox" id="acRoom" name="roomType" value="A/C">
				        <label for="acRoom">A/C</label>
				
				        <input type="checkbox" id="nonAcRoom" name="roomType" value="Non-AC">
				        <label for="nonAcRoom">Non-AC</label>
				
				        <input type="checkbox" id="deluxeRoom" name="roomType" value="Deluxe">
				        <label for="deluxeRoom">Deluxe</label>
				
				        <input type="checkbox" id="premiumRoom" name="roomType" value="Premium">
				        <label for="premiumRoom">Premium</label>
				    </div>
				</section>
				

            </div>
            <div>
                <label for="numRooms">Number of Rooms:</label>
                <input type="number" id="numRooms" name="numRooms" required>
            </div>
            <div>
                <label for="petFriendly">Pet Friendly:</label>
                <input type="checkbox" id="petFriendly" name="petFriendly" value="petFriendly">
            </div>
            <div>
                <label for="roomPrices">Room Prices:</label>
                <input type="text" id="roomPrices" name="roomPrices">
            </div>
            <div>
                <label for="foodChoice">Food Choice:</label>
                <select id="foodChoice" name="foodChoice">
                    <option value="veg">Vegetarian</option>
                    <option value="non-veg">Non-Vegetarian</option>
                </select>
            </div>
        </section>

        <!-- Travel Mode Section -->
        <section>
            <h2>Travel Mode</h2>
            <div>
                <label for="travelMode">Mode of Travel:</label>
                <input type="text" id="travelMode" name="travelMode" required>
            </div>
        </section>

        <!-- Duration and Price Section -->
        <section>
            <h2>Duration and Price</h2>
            <div>
                <label for="duration">Duration (Days/Nights):</label>
                <input type="text" id="duration" name="duration" required>
            </div>
            <div>
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" required>
            </div>
        </section>

        <!-- Submit Button -->
        <input type="submit" class="btn" value = "Add Package" />
    </form>

</body>
</html>