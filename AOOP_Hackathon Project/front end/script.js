const cities = [
    "New Delhi",
    "Mumbai",
    "Bengaluru",
    "Kolkata",
    "Chennai",
    "Hyderabad",
    "Pune",
    "Ahmedabad",
    "Jaipur",
    "Surat",
    "Kanpur",
    "Nagpur",
    "Lucknow",
    "Visakhapatnam",
    "Patna",
    "Vadodara",
    "Indore",
    "Bhopal",
    "Cochin",
    "Agra",
    "Udaipur",
    "Jodhpur",
    "Mangalore",
    "Nashik",
    "Aurangabad"
];

function showSuggestions(input) {
    const suggestions = document.getElementById("suggestions");
    suggestions.innerHTML = '';
    if (input.length === 0) {
        suggestions.style.display = 'none';
        return;
    }

    const filteredCities = cities.filter(city => city.toLowerCase().includes(input.toLowerCase()));
    
    if (filteredCities.length > 0) {
        filteredCities.forEach(city => {
            const li = document.createElement("li");
            li.textContent = city;
            li.onclick = () => {
                document.getElementById("city-input").value = city;
                suggestions.innerHTML = '';
                suggestions.style.display = 'none';
            };
            suggestions.appendChild(li);
        });
        suggestions.style.display = 'block';
    } else {
        suggestions.style.display = 'none';
    }
}

async function getWeather() {
    const city = document.getElementById("city-input").value;
    const apiKey = 'YOUR_API_KEY'; // Replace with your OpenWeatherMap API key
    const weatherInfo = document.getElementById("weather-info");

    if (!city) {
        weatherInfo.innerHTML = 'Please enter a city name.';
        return;
    }

    try {
        const response = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`);
        const data = await response.json();

        if (data.cod === 200) {
            const { main, weather } = data;
            weatherInfo.innerHTML = `
                <h2>Weather in ${city}</h2>
                <p>Temperature: ${main.temp} °C</p>
                <p>Humidity: ${main.humidity}%</p>
                <p>Condition: ${weather[0].description}</p>
            `;
        } else {
            weatherInfo.innerHTML = 'City not found. Please try again.';
        }
    } catch (error) {
        weatherInfo.innerHTML = 'Error fetching weather data.';
        console.error(error);
    }
}
