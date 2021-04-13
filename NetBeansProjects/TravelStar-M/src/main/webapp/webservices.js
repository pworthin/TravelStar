/*
 * Dev. notes:
 * 
 * Weatherapi.com: Please see https://www.weatherapi.com/api-explorer.aspx for
 * further API options
 * 
 * ipgeolocation: See more options at https://app.abstractapi.com/dashboard
 * 
 * 
 */


var apiKeys =  [{ "url":"http://api.weatherapi.com/v1/current.json?key=22eb9e09cab14127b48193900211303&q=" , "key": null }, +
{ "url":"https://ipgeolocation.abstractapi.com/v1?api_key=" , "key":"1a796fdf9fe945d1a379a3240ac2b8b6" }, +
{ "url":"https://api.mapbox.com/geocoding/v5/mapbox.places/" , "key":"pk.eyJ1IjoiY3JpbXNvbmFuZ2VsNDY5NyIsImEiOiJja2NoeTZlNjMxNmUzMnJtMmxwMHd5eGc3In0.R6hhkueEwNF-MSQFvWMjgQ" } ];


function getLocation() {
fetch(apiKeys[1].url + apiKeys[1].key)
        .then(res => res.json())
        .then(data => JSON.stringify(data.longitude, data.latitude));
        


}